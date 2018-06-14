<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<p>これでよろしいですか？</p>

<form:form action="delete" modelAttribute="form">
  <fieldset>
    <div>
      <label>ID</label><form:input path="id" value="${delete.user_id}" readonly="true" />
    </div>
    <div>
      <label>名前</label><form:input path="name" value="${delete.user_name}" readonly="true" />
    </div>
    <div>
      <label>TEL</label><form:input path="name" value="${delete.telephone}" readonly="true" />
    </div>
  </fieldset>
  <div>
    <form:button>削除</form:button>
    <input type="submit" name="button" value="戻る" onclick="location.href='delete'; return false;">
  </div>
</form:form>
<div>
  <a href="menu">メニューに戻る</a>
</div>
</body>
</html>
