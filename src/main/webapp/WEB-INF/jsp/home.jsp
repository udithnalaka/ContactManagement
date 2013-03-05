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

   <h1>My Contacts System</h1>

  <div id="slides">
            <div class="slides_container">
                <div>
                  <img src="<c:url value="/img/1.jpg" /> " alt="1">
                </div>
                <div>
                    <img src="<c:url value="/img/2.jpg" /> " alt="2">
                </div>
                <div>
                    <img src="<c:url value="/img/3.jpg" /> " alt="3">
                </div>
                <div>
                    <img src="<c:url value="/img/4.jpg" /> " alt="4">
                </div>
            </div>
        </div>
  
       
</body>
</html>
