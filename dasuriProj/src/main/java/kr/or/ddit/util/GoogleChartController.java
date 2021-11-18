package kr.or.ddit.util;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.ddit.util.servie.UtilService;

@RestController
public class GoogleChartController {
	
	@Autowired
	UtilService utilService;

	@GetMapping("/chart/chart02_money")
	public JSONObject chart01() {
		return this.utilService.cartMoney();
	}
	
}
