<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="filmServlet" method="post">
  <input type="hidden" value="update" name="type"/>
  <input type="text" name="id" value="${film.film_id}"><br/>
  <input type="text" name="title" value="${film.title}"><br/>
  <input type="text" name="desc" value="${film.description}"><br/>
  <input type="text" name="language" value="${film.name}"><br/>
  <input type="submit"  value="Change"><br/>
</form>
</body>
</html>