<%@ include file="./include.jsp"%>
<html>
<head>
	<title>Home Page</title>
	<link rel="stylesheet" type="text/css" href="${context}/resources/css/Styles.css" />
</head>
<body>
<div class ="container">
<header>
<img src='resources/images/b1.jpg' width="100%" height="40%"/>
</header>
<section style="background-image: url('resources/images/BookBoo.jpg')">
<form:form action="./categoryList" method="GET" commandName="customer">

<div align="center">

<h3>Welcome to online Book Store</h3>
  	<form:select path="id">
		 <form:option value="0" label="Please select your username"/>
		 <form:options items="${custList}" itemValue="id" itemLabel="name"/>
	</form:select>
	</br>
	<input type="submit" value="Sign In" > 

	  </div>
  </form:form>
  </section>
 </div>
</body>
</html>
