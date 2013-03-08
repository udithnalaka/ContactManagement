<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@include file="taglib_include.jsp" %>
<html>
<head>
 <link rel="stylesheet" href="<c:url value="/css/contacts.css" />" ></link>
 <script type="text/javascript" src=" <c:url value="/js/jquery-1.7.1.min.js" /> "></script>
 <script type="text/javascript" src=" <c:url value="/js/contacts.js" /> "></script>
 <script type="text/javascript" src=" <c:url value="/js/slides.jquery.js" /> "></script>

        <title><spring:message code="App.Title"/> </title>

</head>

<body>

  <jsp:include page="menubar.html" /> <br></br>

  <br><br>

      <div class="maintext">
        <p>
         My Contacts Application allows the user to Save/View Contact details of family and friends.
        </p>

        <p>
         The phase 1 of the application is under development and the main functionality of this
         phase <br>
         is to let the user Add, Edit, Delete and Update Contact Information.
        </p>

        <p>
          Additional features include uploading a profile image of the contact person.<br>
            Also, view the number of contacts according to the contact type by placing the <br>
              cursor on top of the image below.
        </p>
        <p>
         <div id="contactsummary" class="contactsummary"  >
              
        </div>

        <div id="imageholder" class="imageholder"  />
       
        </p>

      </div>
       
</body>
</html>
