<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- jstl 코어 태그용 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- jstl 포메팅 태그용 -->
<%@ include file="../includes/header.jsp"%>

<!-- <div id="page-wrapper"> 헤더에 있다. -->
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header" id="event"onmouseenter="mouseEnter()" onmouseleave="mouseLeave()">MBC 아카데미 게시판 리스트</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				boardController list
				<button id="regBtn" type="button" class="btn btn-xs pull-right">새
					게시물 등록</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<c:forEach items="${ list }" var="boardlist">
						<!-- 객체를 반복적으로 돌린다. (list객체) -->
						<tr>
							<!-- 1행추가 -->
							<td><c:out value="${ boardlist.bno }"></c:out></td>
							<!-- 1열 -->
							<%-- <td><a class='move'href='/board/get?bno=<c:out value="${ boardlist.bno }"/>'><c:out value="${boardlist.title}" /></a></td> --%>

							<td><a class='move'
								href='<c:out value="${ boardlist.bno }"/>'> <c:out
										value="${ boardlist.title }" /></a></td>

							<!-- 2열 -->
							<td><c:out value="${ boardlist.writer }"></c:out></td>
							<!-- 3열 -->
							<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
									value="${ boardlist.regdate }" /></td>
							<!-- 4열 -->
							<td><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss"
									value="${ boardlist.updateDate }" /></td>
							<!-- 5열 -->
						</tr>
					</c:forEach>
				</table>
				<div class='row'>
					<div class="col-lg-12">

						<form id='searchForm' action="/board/list" method='get'>
							<select name='type'>
								<option value=""
									<c:out value="${pageMaker.pge.type == null?'selected':''}"/>>--</option>
								<option value="T"
									<c:out value="${pageMaker.pge.type eq 'T'?'selected':''}"/>>제목</option>
								<option value="C"
									<c:out value="${pageMaker.pge.type eq 'C'?'selected':''}"/>>내용</option>
								<option value="W"
									<c:out value="${pageMaker.pge.type eq 'W'?'selected':''}"/>>작성자</option>
								<option value="TC"
									<c:out value="${pageMaker.pge.type eq 'TC'?'selected':''}"/>>제목
									or 내용</option>
								<option value="TW"
									<c:out value="${pageMaker.pge.type eq 'TW'?'selected':''}"/>>제목
									or 작성자</option>
								<option value="TWC"
									<c:out value="${pageMaker.pge.type eq 'TWC'?'selected':''}"/>>제목
									or 내용 or 작성자</option>
							</select> <input type='text' name='keyword'
								value='<c:out value="${pageMaker.pge.keyword}"/>' /> <input
								type='hidden' name='pageNum'
								value='<c:out value="${pageMaker.pge.pageNum}"/>' /> <input
								type='hidden' name='amount'
								value='<c:out value="${pageMaker.pge.amount}"/>' />
							<button class='btn btn-default'>Search</button>
						</form>
					</div>
				</div>

				<div class='pull-right'>
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous"><a
								href="${pageMaker.startPage -1}">Previous</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li class="paginate_button  ${pageMaker.pge.pageNum == num ? "active":""} ">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a
								href="${pageMaker.endPage +1 }">Next</a></li>
						</c:if>
					</ul>
				</div>
				<!--  end Pagination -->
			</div>
			<form id='actionForm' action="/board/list" method='get'>
				<input type='hidden' name='pageNum' value='${pageMaker.pge.pageNum}'>
				<input type='hidden' name='amount' value='${pageMaker.pge.amount}'>
				<input type='hidden' name='type' value='${pageMaker.pge.type}'>
				<input type='hidden' name='keyword' value='${pageMaker.pge.keyword}'>
			</form>

			<!-- Modal 요즘 트렌드는 alert대신 modal 쓴다 -->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">알림창</h4>
						</div>
						<div class="modal-body">처리가 완료 되었습니다.</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">Close</button>
							<button type="button" class="btn btn-primary">Save
								changes</button>

						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->


			</div>
			<!-- /.table-responsive -->
		</div>
		<!-- /.panel-body -->
	</div>
	<!-- /.panel -->
</div>
<!-- /.col-lg-6 -->
</div>


<script type="text/javascript">
	$(document).ready(
		function() {
			// 문서의 준비 단계에서의 함수(기능)
			var result = '<c:out value="${result}"/>'; // controller에서 flashAttribute를 통해 1회용으로 넘어오는 값
			checkModal(result);
			history.replaceState({}, null, null); // 뒤로가기 버튼 동작에 대한 값 -> history 초기화 
			
			function checkModal(result) {
				if (result === '' || history.state) { // result값이 null이거나 history.state가 true면
					return;
				}
				if (parseInt(result) > 0) {
					$(".modal-body").html(
							"게시글 " + parseInt(result) + " 번이 등록되었습니다.");
					// modal-body에 값을 변경하는 코드
				}
				$("#myModal").modal("show");
			}

			$("#regBtn").on("click", function() { // 22행의 id="regBtn" 클릭 동작(기능)
				self.location = "/board/register";
			});
			
			var actionForm = $("#actionForm");
			$(".paginate_button a").on("click", function(e){
				e.preventDefault();
				console.log('click');
				actionForm.find("input[name='pageNum']").val($(this).attr("href"));
				actionForm.submit();
			});
			
			$(".move").on("click", function(e){
				e.preventDefault();
				actionForm.append("<input type='hidden' name='bno' value='"+
			$(this).attr("href")+ "'>");
				actionForm.attr("action", "/board/get");
				actionForm.submit();
			});
			
			var searchForm = $("#searchForm");
			$("#searchForm button").on("click",function(e) {
				if (!searchForm.find("option:selected").val()) {
					alert("검색종류를 선택하세요");
					return false;
				}
				if (!searchForm.find("input[name='keyword']").val()) {
					alert("키워드를 입력하세요");
					return false;
				}
				searchForm.find("input[name='pageNum']").val("1");
				e.preventDefault();
				searchForm.submit();
			});
			
		});
	function mouseEnter() {
		  document.getElementById("event").style.color = "red";
		}

		function mouseLeave() {
		  document.getElementById("event").style.color = "black";
		}
</script>



<%@ include file="../includes/footer.jsp"%>
