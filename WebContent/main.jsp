<%@page import="dto.item"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String user = (String) session.getAttribute("user");
    ArrayList<item> listItem = (ArrayList<item>) session.getAttribute("listItem");
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>
		Welcome:
		<%=user%></h3>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">ProductID</th>
					<th scope="col">Name</th>
					<th scope="col">Description</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">IMG</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<%
					for (item itemdto : listItem) {
				%>
				<tr>
					<th scope="row"><%=itemdto.getID()%></th>
					<td><%=itemdto.getName()%></td>
					<td><%=itemdto.getDescription()%></td>
					<td><%=itemdto.getQuantity()%></td>
					<td><%=itemdto.getPrice()%></td>
					<td><%=itemdto.getIMG()%></td>
					<td>
						<div>

							<button type="button" class="btn btn-primary">
								<a
									href="/CRUDfilter/formForEdit?ID=<%=itemdto.getID()%>&Name=<%=itemdto.getName()%>
									&Desc=<%=itemdto.getDescription()%>&Quantity=<%=itemdto.getQuantity()%>
									&Price=<%=itemdto.getPrice()%>&IMG=<%=itemdto.getIMG()%>"
									style="color: white;">EDIT</a>
							</button>
							<button type="button" class="btn btn-success">
								<a href="CRUDservlet/delete?ID=<%=itemdto.getID()%>"
									style="color: white;">DELETE</a>

							</button>

						</div>
					</td>
				</tr>

				<%
					}
				%>
			</tbody>
		</table>
		<button type="button" class="btn btn-success">
			<a href="form.jsp" style="color: white;">ADD</a>
		</button>

	</div>

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