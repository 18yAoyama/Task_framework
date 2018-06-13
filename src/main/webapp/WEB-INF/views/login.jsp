<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="menu" method="post">
  <fieldset>
    <div>
      <label>ID</label><input type="text" name="id">
    </div>
    <div>
      <label>PASS</label><input type="password" name="pass">
    </div>
  </fieldset>
  <input type="submit" value="ログイン">
</form>
<div>
  <a href="index">TOP画面へ</a>
</div>
</body>
</html>
