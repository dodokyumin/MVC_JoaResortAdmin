<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.BoardItemServiceImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.BoardItemService"%>
<%@page import="kr.ac.kopo.ctc.kopo44.domain.BoardItem"%>
<%@page import="kr.ac.kopo.ctc.kopo44.service.Pagination"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>리조트 소식 수정 페이지</title>
</head>
  <body background="../bgi.png">
  <center>
	<h1>리조트 수정</h1>
	<%
	String id = request.getParameter("id");

	BoardItemService boardItemService = new BoardItemServiceImpl();
	String cPage = boardItemService.checkcPage(id);

	BoardItem boardItem = boardItemService.readOne(id);
	String newDate = boardItemService.newDate();
	pageContext.setAttribute("newDate", newDate);

	ServletContext context = getServletContext();
	context.setAttribute("boardItem", boardItem);
	%>
	<form action="updateDone.jsp" method="post">
		<table cellspacing=1 width=600 border=1>
			<tr>
				<td width=100px>번호</td>
				<td><input type="text" value="${boardItem.id}" name="id"
					readonly></td>
			</tr>
			<tr>
				<td width=100px>제목</td>
				<td><input type="text" value="${boardItem.title}"
					name="newTitle" pattern='^[가-힣a-zA-Z0-9\s?~!@#$%^&*()/]+$' required></td>
			</tr>
			<tr>
				<td width=100px>일자</td>
				<td><input type="text" value="${newDate}" readonly></td>
			</tr>
			<tr>
				<td width=100px>내용</td>
				<td><textarea style="width: 500px; height: 300px;"
						name="newContent" pattern='^[가-힣a-zA-Z]+$' required readonly>${boardItem.content}</textarea></td>
			</tr>
		</table>
		<c:if test="${boardItem.id != 0}">
			<table cellspacing=1 width=400 border=0>
				<tr>
					<td width="200"></td>
					<td width="100">
							<input type="submit" value="수정">
						</td>
					<td width="100">
							<input type="button" value="취소"
								onclick="location.href='readOne.jsp?id=${boardItem.id}'">
				</tr>
			</table>
		</c:if>
	</form>
		<input type="submit" value="삭제"
			onclick="location.href='deleteOne.jsp?id=${boardItem.id}'">
	</center>
</body>
</html>