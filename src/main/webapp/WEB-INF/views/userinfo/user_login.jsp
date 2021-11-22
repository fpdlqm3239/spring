<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Spring</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="${pageContext.request.contextPath}/css/user.css" type="text/css">
<script language="JavaScript">
function userLogin() {
	if ( f.userid.value == "" ) {
		alert("아이디를 입력하십시요.");
		f.userid.focus();
		return;
	} 
	if ( f.password.value == "" ) {
		alert("비밀번호를 입력하십시요.");
		f.password.focus();
		return;
	}	
	
	f.action = "${pageContext.request.contextPath}/userinfo/login";
	f.submit();
}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td style="color: red;">${message }</td>			
	</tr>

	<tr>
	  <td width="20"></td>
	  <td>
  	  <!--contents-->
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>회원관리 - 로그인</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <c:choose>
	  	<%-- 비로그인 사용자인 경우 --%>
	  	<c:when test="${empty(loginUserinfo) }">
			  <!-- login Form  -->
			  <form name="f" method="post">
			  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
				  <tr>
					<td width=100 align=center bgcolor="E6ECDE" height="22">사용자 아이디</td>
					<td width=490 bgcolor="ffffff" style="padding-left:10px;">
						<input type="text" style="width:150" name="userid" value="${userid }">
					</td>
				  </tr>
				  <tr>
					<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
					<td width=490 bgcolor="ffffff" style="padding-left:10px;">
						<input type="password" style="width:150" name="password">
					</td>
				  </tr>
			  </table>
			  </form>
			  <br>
			  
			  <table width=590 border=0 cellpadding=0 cellspacing=0>
				  <tr>
					<td align=center>
						<input type="button" value="로그인" onClick="userLogin();"> &nbsp;
					</td>
				  </tr>
			  </table>
	  </c:when>

	  <%-- 로그인 사용자인 경우 --%>
	  <c:otherwise>
		  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
			  <tr>
				<td width=500 align=center bgcolor="E6ECDE" height="22">
					${loginUserinfo.name }님 환영합니다.
				</td>
		  	  </tr>
		  </table>
		  <br>
		  
		  <table width=590 border=0 cellpadding=0 cellspacing=0>
			  <tr>
				<td align=center>
					<button type="button" onclick="location.href='${pageContext.request.contextPath}/userinfo/list';">회원목록</button>
					<button type="button" onclick="location.href='${pageContext.request.contextPath}/userinfo/logout';">로그아웃</button>
					<c:if test="${loginUserinfo.status == 9}">
						<button type="button" onclick="location.href='${pageContext.request.contextPath}/userinfo/join';">회원등록</button>
					</c:if>
				</td>
			  </tr>
		  </table>
	  	</c:otherwise>
	  </c:choose>

	  </td>
	</tr>
</table>  

</body>
</html>