<%@page import="dto.item"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% item thisItem = (item) session.getAttribute("packItem") ;
	   String urlAdd ="CRUDservlet/add";
	   String urlEdit = "CRUDservlet/edit";	 
	   %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">

</head>
<body>  
<form class="container" action=<%= (thisItem==null)? urlAdd : urlEdit %> method="GET">
  <div class="form-group">
  <label for="exampleInputEmail1">ProductID</label>
    <input type="text" required class="form-control" id="exampleInputEmail1" <%= (thisItem==null)? null : "disabled" %>
				aria-describedby="emailHelp" placeholder="Enter email" name="IDProduct" value=<%= (thisItem==null)? "" : thisItem.getID() %> >
  </div>  
   <h6> <%= (session.getAttribute("Error")==null)? "" : "Error" %></h6>
  <div class="form-group">
    <input type="hidden" required class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email" name="ID" value=<%= (thisItem==null)? "" : thisItem.getID() %> >	
  </div>		
  <div class="form-group">
    <label for="exampleInputPassword1">Name</label>
    <input type="text" class="form-control"
				id="exampleInputPassword1" required placeholder="Password" name="Name" value=<%= (thisItem==null)? "" :thisItem.getName() %>>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Description</label>
    < <textarea class="form-control" required id="exampleFormControlTextarea1" rows="3" name="Description"><%= (thisItem==null)? "":thisItem.getDescription() %></textarea>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Quantity</label>
    <input type="number" class="form-control"
				id="exampleInputPassword1" required placeholder="Quantity" name="Quantity" value=<%= (thisItem==null)? "" : thisItem.getQuantity() %>>
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Price</label>
    <input type="number" step=any class="form-control"
				id="exampleInputPassword1" required placeholder="Price" name="Price" value=<%= (thisItem==null)? "" : thisItem.getPrice() %>>
  </div>
  
   <div class="form-group">
    <label for="exampleInputPassword1">URL</label>
    <input type="text" class="form-control"
				id="exampleInputPassword1" required placeholder="URL" name="URL" value=<%= (thisItem==null)? "" :thisItem.getIMG() %>>
  </div>  
  <button type="submit" class="btn btn-primary">Submit</button> 
</form>

<%session.removeAttribute("packItem");
session.removeAttribute("Error");
%>

</body>  
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
	integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
	crossorigin="anonymous"></script>
</html>  

</body>
</html>