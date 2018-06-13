<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>削除確認画面</title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
<p>これでよろしいですか？</p>

<form action="deleteResult.html" method="post">
  <fieldset>
    <div>
      <label>ID</label><input type="text" name="id" value="111" readonly>
    </div>
    <div>
      <label>名前</label><input type="text" name="name" value="alice" readonly>
    </div>
    <div>
      <label>TEL</label><input type="text" name="tel" value="19980406" readonly>
    </div>
  </fieldset>
  <div>
    <input type="submit" name="button" value="削除">
    <input type="submit" name="button" value="戻る" onclick="location.href='delete.html'; return false;">
  </div>
</form>
<div>
  <a href="menu.html">メニューに戻る</a>
</div>
</body>
</html>
