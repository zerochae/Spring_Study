package kr.or.ddit.util.servie.impl;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.ddit.util.mapper.UtilMapper;
import kr.or.ddit.util.servie.UtilService;
 
@Service
public class UtilServiceImpl implements UtilService {
   private static final Logger logger = 
         LoggerFactory.getLogger(UtilServiceImpl.class);
   
   @Autowired
   UtilMapper utilMapper;
   
   //상품별 판매금액의 합계 목록
   @Override
   public JSONObject cartMoney(){
      List<Map<String,Object>> list = this.utilMapper.cartMoney();
      
      if(list!=null) {
         logger.info("list : " + list.get(0).toString());
      }
      
      //0.리턴할 json객체 생성.........
      JSONObject data = new JSONObject();
      
      //1.cols 배열에 넣기--------------
      //JSON 컬럼 객체
      JSONObject col1 = new JSONObject();
      JSONObject col2 = new JSONObject();
      //JSON 배열 객체
      JSONArray title = new JSONArray();
      col1.put("label", "상품명");
      col1.put("type", "string");
      col2.put("label", "금액");
      col2.put("type", "number");
      //타이틀행에 컬럼 추가
      title.add(col1);
      title.add(col2);
      //JSON객체에 title행을 추가
      data.put("cols", title);   //*******1)
      
      //2.rows 배열에 넣기--------------
      /*
       * 203 866 548
         ye7kt9kp
       */
      JSONArray body = new JSONArray();
      for(Map<String,Object> map:list) {
         JSONObject prodName = new JSONObject();
         prodName.put("v", map.get("PROD_NAME"));   //상품명
         
         JSONObject money = new JSONObject();
         money.put("v", map.get("MONEY"));   //금액(판매가 * 수량)
         
         JSONArray row = new JSONArray();
         row.add(prodName);
         row.add(money);
         
         JSONObject cell = new JSONObject();
         cell.put("c", row);
         body.add(cell);   //레코드 1개 추가
      }
      
      //JSON객체에 title행을 추가
      data.put("rows", body);   //*******2)
      
      return data;
   };
}







