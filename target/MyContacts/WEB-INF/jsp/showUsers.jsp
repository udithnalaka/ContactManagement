<%@include  file="taglib_include.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
        <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
        <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
        <script type="text/javascript" charset="utf8"  src="js/contacts.js"></script>
        <title><spring:message code="App.Title"/> </title>
    </head>
    <body bgcolor="lightyellow" >

     <center>
<table id="tblUserList" >
	<thead>
	<tr bgcolor="lightblue">
		 <th>User Name</th>       <th>Type of Friend</th>     <th>Occupation</th>    <th></th>
	 </tr>
    </thead>
     <tbody>
     <c:if test="${empty userList}">
	 <tr>
		<td colspan="4">No Results found</td>
	 </tr>
     </c:if>
     <c:if test="${! empty userList}">
        <c:forEach var="user" items="${userList}">
         <tr>

            <td><c:out value="${user.user_name}"></c:out></td>
            <td><c:out value="${user.friend_type}"></c:out> </td>
            <td><c:out value="${user.occupation}"></c:out></td>
            <td>
                <a href="editUser.htm?user_id=${user.user_id}">Edit</a>
                <a href="deleteContact.htm?user_id=${user.user_id}">Delete</a>
            </td>
         </tr>
        </c:forEach>
      </c:if>

     </tbody>
</table>
</center>
     
    </body>
    
       
    <script type="text/javascript">
    jQuery(document).ready(function(){
      jQuery('#tblUserList').dataTable({
          "aaSorting": [[0, "desc"]]
      }
      );
    });

    </script>
</html>