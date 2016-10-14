
<%@ include file="./include.jsp"%>

<html><head>
<title>Category Page</title>
<link rel="stylesheet" type="text/css" href="${context}/resources/css/Styles.css" />

</head><body>
<div class ="container">
<header>
<img src='resources/images/b1.jpg' width="100%" height="40%"/>
</header>
<section style="background-image: url('resources/images/BookBoo.jpg');">
<h3>Please Select Books Category</h3></br>
<c:forEach var="category" items="${catList}" >
<a href="${context}/displayProductsForm?catId=${category.catId}"><l1>${category.catName}</a></br>
</c:forEach>
</section>
</div>
</body></html>
