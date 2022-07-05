<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.ac.kopo.ctc.kopo44.replyAdmin.service.ReplyItemServiceImpl"%>
<%@page import="kr.ac.kopo.ctc.kopo44.replyAdmin.service.ReplyItemService"%>
<%@page import="kr.ac.kopo.ctc.kopo44.replyAdmin.domain.ReplyItem"%>
<%@page import="kr.ac.kopo.ctc.kopo44.replyAdmin.service.Pagination"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>후기 전체 삭제 완료</title>
</head>
<body background="../bgi.png">
	<%
	ReplyItemService replyItemService = new ReplyItemServiceImpl();

	Boolean result = replyItemService.replyItemDeleteAll();

	ServletContext context = getServletContext();
	context.setAttribute("result", result);
	%>
	<script>
	if(${result}){
		if (window.confirm("후기 전체 삭제되었습니다.")) {
			window.location.href = "index.jsp";
		}
	} else {
		window.confirm("후기 전체 삭제 실패.")
	}
	
	</script>
</body>
</html>