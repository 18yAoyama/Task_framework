<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<p>削除を行うデータのIDを入力してください<br>
<span class="required"></span>は必須です</p>

<form action="deleteConfirm.html" method="post">
  <fieldset>
    <div>
      <label class="required">ID</label><input type="text" name="id">
    </div>
  </fieldset>
  <input type="submit" value="確認">
</form>
<div>
  <a href="menu.html">メニューに戻る</a>
</div>
</body>
</html>
