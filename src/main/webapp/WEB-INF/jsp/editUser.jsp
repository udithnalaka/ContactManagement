<%@include  file="taglib_include.jsp" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
<!--        <script type="text/javascript" charset="utf8" src="http://code.jquery.com/jquery-1.9.1.min.js"></script>-->
        <link rel="stylesheet" href="<c:url value="/css/contacts.css" />" >
        <script type="text/javascript" src=" <c:url value="/js/jquery-1.7.1.min.js" /> "></script>
 <script type="text/javascript" src=" <c:url value="/js/contacts.js" /> "></script>
 <script type="text/javascript" src=" <c:url value="/js/slides.jquery.js" /> "></script>
        <title><spring:message code="App.Title"/> </title>

        <script type="text/javascript">
          $(document).ready(function(){
            $('#user_id').hide();
          });
        </script>
       
    </head>
    <body>
       <jsp:include page="menubar.html" /> <br></br>
        
        
       <table style="border-collapse: collapse;" width="750" align="center" bgcolor="lightyellow" border="1" bordercolor="#006699" height="500">
       <tbody>
          <tr>
              <td align="center"><h3>Edit Contact Form</h3></td>
          </tr>
          <tr valign="top" align="center">
              <td align="center">
              <form:form action="updateUser.htm" method="post" modelAttribute="editUser">
              <table style="border-collapse: collapse;" width="500" border="0" bordercolor="#006699" cellpadding="2" cellspacing="2">
              <tbody>
                  <tr>
                    <td width="150"><form:input id="user_id" path="user_id"  ></form:input></td>
                  </tr>
                  <tr>
                      <td width="100" align="right">Username :</td>
                      <td width="150"><form:input path="user_name" ></form:input></td>
                      <td align="left"><form:errors path="user_name" cssstyle="color:red"></form:errors></td>
                  </tr>
                  <tr>
                      <td width="100" align="right">Type of Friend:</td>
                      <td><form:input path="friend_type"></form:input></td>
                      <td align="left"><form:errors path="friend_type" cssstyle="color:red"></form:errors></td>
                  </tr>
                  <tr>
                      <td width="100" align="right">Occupation:</td>
                      <td><form:input path="occupation"></form:input></td>
                      <td align="left"><form:errors path="occupation" cssstyle="color:red"></form:errors></td>
                  </tr>

                  <tr>
						<td width="100" align="right">Street :</td>
						<td><form:input path="address.street"></form:input></td>
					</tr>
                     <tr>
						<td width="100" align="right">City :</td>
						<td><form:input path="address.city"></form:input></td>
					</tr>
                     <tr>
						<td width="100" align="right">Country :</td>
						<td><form:input path="address.country"></form:input></td>
					</tr>


                  <tr valign="bottom">
                      <td colspan="3" align="center">
                          <input type="submit" name="btnUpdate" value="Update User" >
                          <input value="Delete" onclick="javascript:deleteContact('deleteContact.do?id=${editContact.id}');" type="button">
                          <input value="Back" onclick="javascript:go('viewAllContacts.do');" type="button">
                      </td>
                  </tr>
              </tbody>
              </table>
              </form:form>              
              
              </td>
          </tr>
      </tbody>
      </table>


      
    </body>
</html>
