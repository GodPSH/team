<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 등록</h2>
	<form  action="register.do" method="post">
	<table border="1">
		<tbody>
			<tr>
				<th>제목</th>
				<td><input type="text" name="subject"></td>
			</tr>
			<tr height="300">
				<th>내용</th>
				<td><textarea name="content"></textarea></td>
			</tr>
		</tbody>
	</table>
	<button>저장</button>
	</form>
</body>
</html>