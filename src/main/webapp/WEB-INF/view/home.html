<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Subjects and Books</title>

<script type="text/javascript" language="javascript" src="/js/main.js"></script>
<script type="text/javascript" language="javaScript">

function openSubjectform(divIdToOpen){
	hideAllDiv();
	document.getElementById('displayDiv').innerHTML='';
	document.getElementById(divIdToOpen).style.display='block';
}

function postData(formId, formAction){
	document.getElementById(formId).action=formAction;
	document.getElementById(formId).submit();
}
function hideAllDiv(){
	document.getElementById('addSubjectDiv').style.display='none';
	document.getElementById('addBooktDiv').style.display='none';
	document.getElementById('deleteSubjectDiv').style.display='none';
	document.getElementById('deleteBookDiv').style.display='none';
	document.getElementById('searchSubjectDiv').style.display='none';
	document.getElementById('serachBooktDiv').style.display='none';
	document.getElementById('searchSubjectByDurationDiv').style.display='none';

	
}
</script>
<style type="text/css">
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

th {
	border: 1px solid #d6d6c2;
	text-align: center;
	padding: 8px;
}

td {
	border: 1px solid #d6d6c2;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #d6d6c2;
	border-color: black;
}
</style>
</head>
<body>
 
	<center>
		<h2>Subjects and Books</h2>
	</center>
	<form:form id="addEntityForm" action="addSubject" modelAttribute="subjectsAndBooks" method="POST">
		<div class="container">
      <ul class="nav navbar-nav">
      
          <li> <a href="#" onclick="openSubjectform('addSubjectDiv')">Add Subject</a> &nbsp;</li>
          <li><a href="#" onclick="openSubjectform('addBooktDiv')">Add Book</a>&nbsp;</li>
          <li><a href="#" onclick="postData('deleteEntityForm','getAllSubject')">Delete Subject</a>&nbsp; </li>
          <li><a href="#" onclick="postData('deleteEntityForm','getAllBook')">Delete Book</a>&nbsp; </li>
          <li><a href="#" onclick="openSubjectform('searchSubjectDiv')">Search Subject</a>&nbsp; </li>
          <li><a href="#" onclick="openSubjectform('searchSubjectByDurationDiv')">Search Subject by Duration</a>&nbsp; </li>
          <li><a href="#" onclick="openSubjectform('serachBooktDiv')">Search Book by Title</a>&nbsp; </li>
      </ul>
  </div>
	<div id="displayDiv">
		${message} &nbsp;
	</div>
	
	<!-- This section would be used to add new subject and book -->
	
	<div id="addSubjectDiv" style="display: none;">
		<left>
			<h2>Add Subject</h2>
		</left>
		Subtitle: <form:input type="text" path="subject.subtitle"  />
		Duration in Hrs: <form:input type="text" path="subject.durationInHours"  />
		<br><br>&nbsp;
		<button onclick="postData('addEntityForm','addSubject')" >Add Subject</button>
	</div>
	<div id="addBooktDiv" style="display: none; width: 30%;">
		<left>
			<h2>Add Book</h2>
		</left>
		<table>
		<tr><td>Title:</td><td><form:input type="text" path="book.title"  /></td></tr>
		<tr><td>Price:</td><td><form:input type="text" path="book.price"  /></td></tr>
		<tr><td>Volume:</td><td><form:input type="text" path="book.volume"  /></td></tr>
		<tr><td>Date Published:</td><td><form:input type="text" path="book.publishDate"  /></td></tr>
		</table>
		<br/>&nbsp;
		<button onclick="postData('addEntityForm','addBook')" >Add Subject</button>
	</div>
	</form:form>
	
	<!-- Add subject and book  ends here -->
	
	<form:form id="searchEntityForm" action="searchSubject" modelAttribute="subjectsAndBooks" method="POST">
	<!-- This section would be used to search subject and book -->
	
	<div id="searchSubjectDiv" style="display: none;">
		<left>
			<h2>Search any Subject by Title</h2>
		</left>
		Subtitle: <form:input type="text" path="subject.subtitle"  />
		<button onclick="postData('searchEntityForm','searchSubject')" >Search</button>
	</div>
	<div id="searchSubjectByDurationDiv" style="display: none;">
		<left>
			<h2>Search a subject by Duration</h2>
		</left>
		Subtitle: <form:input type="text" path="subject.durationInHours"  />
		<button onclick="postData('searchEntityForm','searchSubjectByDuration')" >Search</button>
	</div>
	<div id="serachBooktDiv" style="display: none;">
		<left>
			<h2>Search book by Title</h2>
		</left>
		
		Title:<form:input type="text" path="book.title"  />
		<button onclick="postData('searchEntityForm','searchBookByTitle')" >Search</button>
	</div>
	
	</form:form>
		<!-- search subject and book ends here-->
	
		<!-- This section would be used to delete subject and book -->
	
	<form:form id="deleteEntityForm" action="deleteBook" modelAttribute="subjectsAndBooks" method="POST">
		<div id="deleteBookDiv">
			<c:if test="${not empty books}">
					<table style="width:50%;">
					<tr style="background-color: #ff9966;">
						<td></td>
						<td>Title</td>
						<td>Price</td>
						<td>Volume</td>
						<td>Publish Date</td>
					</tr>
					<c:forEach items="${ books}" var="indexedBook" varStatus="bookStatus">
						<tr>
							<td><c:choose>
								<c:when test="${indexedBook.bookId != '' }">
									<form:radiobutton path="book.bookId" value="${indexedBook.bookId}" />
								</c:when>
								<c:otherwise>
									${bookStatus.index+1 }
								</c:otherwise>
							</c:choose>
							</td>
							<td> ${indexedBook.title } </td>
							<td>${indexedBook.price }  </td>
							<td> ${indexedBook.volume } </td>
							<td>${indexedBook.publishDate }  </td>
						</tr>
					</c:forEach>
					</table>
				<button onclick="postData('deleteEntityForm','deleteBook')" >Delete</button>
			</c:if>
		</div>
		<div id="deleteSubjectDiv" style="width:50%; ">
			<c:if test="${not empty subjects }">
					<table>
					<tr style="background-color: #ff9966;">
						<td>Items</td>
						<td>Subtitle</td>
						<td>Duration in Hrs</td>
					</tr>
					<c:forEach items="${subjects}" var="indexedSubject" varStatus="subjectStatus">
						<tr style="border: medium; border-color: black; ">
							<td><c:choose>
								<c:when test="${indexedSubject.subjectId != '' }">
									<form:radiobutton path="subject.subjectId" value="${indexedSubject.subjectId }" /> 
								</c:when>
								<c:otherwise>
									${subjectStatus.index+1 }
								</c:otherwise>
							</c:choose>
							</td>
							<td>${indexedSubject.subtitle } </td>
							<td>${indexedSubject.durationInHours } </td> 
						</tr>
					</c:forEach>
					</table>
				<button onclick="postData('deleteEntityForm','deleteSubject')" >Delete</button>
			</c:if>
		</div>	
		<!-- Delete subject and book ends here-->
	</form:form>
</body>
</html>