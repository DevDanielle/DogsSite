<!doctype html>
<html lang="en">
<%@ include file="/WEB-INF/layouts/include.jsp"%>
<%@ include file="/WEB-INF/layouts/head.jsp"%>
<body id="demo-body">
	<div id="demo-main-div" class="container-fluid">
		<div class="row">
			<div class="col-sm-12">
				<h1>${title}</h1>
				<%@ include file="/WEB-INF/layouts/message.jsp"%>
				<%--
The Add/Edit Dog Form
We are using ${pageContext.request.contextPath} to reference the context path.
The order of parsing does not allow us to use <%=request.getContextPath() %>  
--%>
				<form:form method="post" id="userForm" modelAttribute="command"
					action="${pageContext.request.contextPath}/finalproject/addEditDogs">
					<%-- <%=request.getContextPath() %> --%>
					<div class="form-group col-sm-3">
						<%--
The label and input for breed
path="breed" is converted to:
id="breed" name="breed"
in the HTML
--%>
						<label for="breed">Breed</label>
						<form:input class="form-control" path="breed"
							placeholder="Enter Breed" />
						<%--
The label and input for Name
--%>
						<label for="name" class="mt-4">Name</label>
						<form:input class="form-control" path="name"
							placeholder="Enter Name" />
						<%--
Add a hidden input to hold the dog's ID
--%>
						<form:hidden class="form-control" path="id" />
						<%-- <input type="hidden" id="id" name="id" value="${user.id}" /> --%>
						<%--
The submit button. Notice that the type is "button" and not submit. We do
not want to submit the form when the button is clicked. Instead we want to
validate the form (client-side), and then send the form to the server.
--%>
						<button class="btn btn-primary mt-3" type="submit" id="submitBtn">
							Submit</button>
						<button class="btn btn-warning mt-3 ml-1" type="reset"
							id="resetBtn">Reset</button>
					</div>
				</form:form>
			</div>
		</div>
	</div>
<style>
#userForm .form-group {
	padding-left: 0px !important;
}
</style>

</body>
</html>