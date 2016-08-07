<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>新增电影</p>
<form action="filmServlet" method="post">
<input type="hidden" name="type" value="add">
  电影名:<input type="text" name="name"><br/>
  描述:<input type="text" name="desc"><br/>
 语言：<select name="language" >
         <c:if test="${languages!=null}">
            <c:forEach items="${languages}" var="languager">
               <option value = "${languager.language_id}">${languager.name}</option>
            </c:forEach>
         </c:if>
    </select> 
  <input type="submit" value="添加"><br/>
</form>

<br/><br/><br/>

<table>
     <tr>
       <th>编辑</th>
       <th>电影号</th>
       <th>电影名</th>
       <th>描述</th>
       <th>语言</th>
       <th>删除</th>
     </tr>
 <c:if test="${requestScope.films!=null}">
     <c:forEach items = "${requestScope.films}"  var="film" varStatus="status" >
         <tr>
        <td><a href="filmServlet?type=text&film_id=${film.film_id}">编辑电影</a></td>
        <td>${film.film_id}</td>
        <td>${film.title}</td>
        <td>${film.description}</td>
        <td>${film.name}</td>
         <td><a href="filmServlet?type=delete&film_id=${film.film_id}">删除电影</a></td>
       </tr>
       
     </c:forEach>
  </c:if>     
     
</table>


</body>
</html>