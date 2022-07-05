<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@page import="kr.ac.kopo.ctc.kopo44.ResortAdmin.service.ResortItemService"%>
<%@page import="kr.ac.kopo.ctc.kopo44.ResortAdmin.service.ResortItemServiceImpl"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약상황</title>
</head>
<body>
<h1>+30일 예약상황</h1>
	<table cellspacing=1 width=700 border=1>
		<tr style="background-color: grey;">
			<th width=25%>날짜</th>
			<th width=25%>VIP룸</th>
			<th width=25%>일반룸</th>
			<th width=25%>합리적인룸</th>
		</tr>
<%
	ResortItemService resortItemService = new ResortItemServiceImpl();
	ArrayList<String> thirtyDays = resortItemService.thirtyDays();
	
	ServletContext context = getServletContext();
	context.setAttribute("thirtyDays", thirtyDays);
	context.setAttribute("resortItemService", resortItemService);
	
%>
	
		<c:forEach var="day" items="${thirtyDays}">
	
			<tr>
				<td style="text-align: center">${day}</td>
				<c:choose>
					<c:when test="${resortItemService.readOne(day,1).processing == null}">
							<a href='d_02.jsp?strDay=${day}&strRoom=1'> 예약 가능 </a>
					</c:when>
					<c:otherwise>
							<a href='d_02.jsp?strDay=${day}'> 홍길동 </a>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${resortItemService.readOne(day,2).processing == 0}">
							<a href='d_02.jsp?strDay=${day}&strRoom=1'> 예약 가능 </a>
					</c:when>
					<c:otherwise>
							<a href='d_02.jsp?strDay=${day}'> 홍길동 </a>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${resortItemService.readOne(day,3).processing == 0}">
							<a href='d_02.jsp?strDay=${day}&strRoom=1'> 예약 가능 </a>
					</c:when>
					<c:otherwise>
							<a href='d_02.jsp?strDay=${day}'> 홍길동 </a>
					</c:otherwise>
				</c:choose>
			</tr>
	
		</c:forEach>
	</table>
</body>
</html>