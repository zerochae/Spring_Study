<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>

<jsp:include page="../topbar.jsp"></jsp:include>

 <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800"> 게시판 ㅋㅋ</h1>
                    <p class="mb-4">DataTables is a third party plugin that is used to generate the demo table below.
                        For more information about DataTables, please visit the <a target="_blank"
                            href="https://datatables.net">official DataTables documentation</a>.</p>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
										<tr>
											<th>글번호</th>
											<th>제목</th>
											<th>작성자</th>
											<th>조회수</th>
										</tr>
                                    </thead>
                                    <tbody>
										<c:forEach var="article" items="${articlePage.content}" varStatus="stat">
												<tr>
													<td>${article.RNUM}</td>
													<td>${article.title}</td>
													<td>${article.writerVO.writerName}</td>
													<td>${article.readCnt}</td>
												</tr>
										</c:forEach>
                                    </tbody>
                                </table>
                            <div class="row">
                            	<div class="col-sm-12 col-md-5">
                                   <div class="dataTables_info" id="dataTable_info" role="status" aria-live="polite">
                                   Showing ${param.currentPage * 10-9 } to ${param.currentPage*10} of ${articlePage.totalPages } entries
                                   </div>
                                </div>
	                            <div class="col-sm-12 col-md-7">
		                            <div class="dataTables_paginate paging_simple_numbers" id="dataTable_paginate">
		                            	<ul class="pagination">
		                            		<li class="paginate_button page-item previous <c:if test='${articlePage.startPage <= 5}'>disabled</c:if>" id="dataTable_previous">
		                            		<a href="/article/listArticle?currentPage=${articlePage.startPage-5}" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">Previous</a>
		                            		</li>
		                            		<c:forEach var="pNo" begin="${articlePage.startPage}" end="${articlePage.endPage}">
		                            		<li class="paginate_button page-item <c:if test='${param.currentPage eq pNo }'>active</c:if>">
		                            		<a href="/article/listArticle?currentPage=${pNo}" aria-controls="dataTable" data-dt-idx="1" tabindex="0" class="page-link">${pNo}</a>
		                            		</li>
		                            		</c:forEach>
		                            		<li class="paginate_button page-item next <c:if test='${articlePage.endPage >= articlePage.totalPages}'>disabled</c:if>" id="dataTable_next">
		                            		<a href="/article/listArticle?currentPage=${articlePage.startPage+5}" aria-controls="dataTable" data-dt-idx="7" tabindex="0" class="page-link">Next</a>
		                            		</li>
		                            		</ul>
		                            	</div>
	                           	 </div>
                            	</div>
                           </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
</body>
</html>