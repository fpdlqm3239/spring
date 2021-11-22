<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<hr>
	<%-- 파일을 입력받아 전달하기 위해 요청방식(mehtod 속성)은 "post"으로 설정하고
	전달형태(enctype 속성)는 "multipart/form-data"로 설정 --%>
	<form action="upload" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td>업로드 이름</td>
			<td><input type="text" name="uploadName"></td>
		</tr>
		<tr>
			<td>업로드 파일</td>
			<td><input type="file" name="uploadFile"></td>
		</tr>
		<tr>
			<td colspan="2"><button type="submit">파일 업로드</button></td>
		</tr>
	</table>
	</form>
</body>
</html>