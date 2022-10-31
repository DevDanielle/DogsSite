<!doctype html>
<html lang="en">
<%@ include file="/WEB-INF/layouts/include.jsp" %>
<%@ include file="/WEB-INF/layouts/head.jsp" %>
<body id="demo-body">
	<div class="container-fluid border">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
 			<a class="navbar-brand" href="<%=request.getContextPath() %>/finalproject">Pupperonis LLC</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
   			<span class="navbar-toggler-icon"></span>
 			</button>
 			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
   				<div class="navbar-nav">
     			<a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
     			<a class="nav-item nav-link" href="#">About Us</a>
     			<a class="nav-item nav-link" href="#">Gallery</a>
   				</div>
 			</div>
		</nav>
		
	</div> 
	<div class="container border mt-2">
		<h1> All The Goodest Puppers </h1>
		<a href="<%=request.getContextPath() %>/finalproject/addEditDogs" class="btn btn-success">Add Your Dog</a>
		<%@ include file="/WEB-INF/layouts/message.jsp" %>
		<table class="table table-hover table-striped table-bordered mt-2">
			<tr>
				<th>Action</th>
				<th>ID</th> 
				<th>Breed</th>
				<th>Name</th>
			</tr>
			<tbody id="tbody">
			
				<c:if test="${empty dogsList}">
					<tr>
						<td colspan="4">
							No data found
						</td>
					</tr>
				</c:if>
				<c:if test="${not empty dogsList}">
					<c:forEach var="dogs" items="${dogsList}">
						<tr>
							<td>
								<a class="no-decor" href="<%=request.getContextPath() %>/finalproject/addEditDogs?id=${dogs.id}">
									<i id="edit_${dogs.id}" class="fas fa-pencil-alt dark-yellow" aria-hidden="true"></i>
								</a>
								<a class="no-decor" href="<%=request.getContextPath() %>/finalproject/deleteDogs?id=${dogs.id}">
									<i id="delete_${user.id}" class="fa fa-times red ml-1" aria-hidden="true"></i>
								</a>
							</td>
							<td>${dogs.id}</td>
							<td>${dogs.breed}</td> <!-- similar to user.getFirstName()-->
							<td>${dogs.name}</td>
						</tr> 
					</c:forEach>
				</c:if>
			</tbody>	
		</table>
	
	</div>
	<div>
	Dogs Are Life, LLC &copy; 2020
	</div>
	<script>
		window.addEventListener("DOMContentLoaded", function() {
			
			
		});
	
	</script>
</body>
</html>