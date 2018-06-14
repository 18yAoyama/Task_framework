<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新内容入力画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<c:if test="${not empty msg}">
	<p><span class="err">${msg}</span></p>
</c:if>
<p>１箇所以上の項目を変更してください<br>
※IDは変更できません</p>

<form:form action="updateConfirm" modelAttribute="form">
  <fieldset>
    <div>
      <label>ID</label><form:input path="id" value="${User_info.user_id}" readonly="true" />
    </div>
    <div>
      <label>名前</label><form:input path="name" value="${User_info.user_name}" />
    </div>
    <div>
      <label>TEL</label><form:input path="tel" value="${User_info.telephone}" />
    </div>
    <div>
      <label>PASS</label><form:password path="pass" value="${User_info.password}" />
    </div>
  </fieldset>
  <div>
    <form:button>確認</form:button>
    <input type="submit" name="button" value="戻る" onclick="location.href='update'; return false;">
  </div>
</form:form>
<div>
  <a href="menu">メニューに戻る</a>
</div>
</body>
</html>
