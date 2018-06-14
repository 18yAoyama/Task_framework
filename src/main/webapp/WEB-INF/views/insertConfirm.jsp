<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登録確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<c:if test="${not empty msg}">
	<p><span class="err">${msg}</span></p>
</c:if>
<p>これでよろしいですか？</p>

<form:form action="insert" modelAttribute="form">
  <fieldset class="label-110">
    <div>
      <label>名前</label><form:input path="name" value="${fn:escapeXml(insert.name)}" readonly="true" />
    </div>
    <div>
      <label>TEL</label><form:input path="tel" value="${fn:escapeXml(insert.tel)}" readonly="true" />
    </div>
    <div>
      <label>PASS（再入力）</label><form:password path="pass" />
    </div>
  </fieldset>
  <div>
    <form:button>登録</form:button>
    <input type="submit" name="button" value="戻る" onclick="location.href='insert'; return false;">
  </div>
</form:form>
<div>
  <a href="menu">メニューに戻る</a>
</div>
</body>
</html>
