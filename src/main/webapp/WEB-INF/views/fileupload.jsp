<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>上传文件</title>
</head>
<body>
<form action="/request/fileupload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"><br />
    <input type="submit" name="提交">
</form>
</body>
</html>