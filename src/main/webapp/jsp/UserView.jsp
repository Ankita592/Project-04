<%@page import="in.co.rays.ctl.UserCtl"%>
<%@page import = "java.util.List" %>
<%@page import="in.co.rays.util.HTMLUtility"%>
<%@page import="java.util.HashMap"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.ctl.ORSView"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

</head>

<body>

	<form action="<%=ORSView.USER_CTL%>" method="post">

		<jsp:useBean id="bean" class="in.co.rays.bean.UserBean"
			scope="request"></jsp:useBean>
			
			<% List roleList = (List) request.getAttribute("roleList");
			%>           
			
			

		<div align="center">

			<h1>
				<font color="navy">Add User</font>


			</h1>
			<h3>
				<font color="green"> <%=ServletUtility.getSuccessMessage(request)%>
				</font>

			</h3>

			<h3>

				<font color="red"> <%=ServletUtility.getErrorMessage(request)%>
				</font>

			</h3>
			<input type="hidden" name="id" value="<%=bean.getId()%>"><input
				type="hidden" name="createdBy" value="<%=bean.getCreatedBy()%>">
			<input type="hidden" name="modifiedBy"
				value="<%=bean.getModifiedBy()%>"> <input type="hidden"
				name="createdDatetime"
				value="<%=DataUtility.getTimestamp(bean.getCreatedDateTime())%>">
			<input type="hidden" name="modifiedDatetime"
				value="<%=DataUtility.getTimestamp(bean.getModifiedDateTime())%>">

			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName"
						placeholder="Enter FirstName"
						value="<%=DataUtility.getStringData(bean.getFirstName())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("firstName", request)%></font></td>

				</tr>

				<tr>
					<th>Last Name:</th>
					<td><input type="text" name="lastName"
						placeholder="Enter LastName"
						value="<%=DataUtility.getStringData(bean.getLastName())%>">
					</td>
                   
                   <td style = "position: fixed;"> <font color = "red"> <%=ServletUtility.getErrorMessage("lastName",request) %></font> </td>
                                    
				</tr>

<tr>
					<th>Login Id:</th>
					<td><input type="text" name="login"
						placeholder="Enter Email ID"
						value="<%=DataUtility.getStringData(bean.getLogin())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("login", request)%></font></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type="text" name="password"
						placeholder="Enter Password"
						value="<%=DataUtility.getStringData(bean.getPassword())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("password", request)%></font></td>
				</tr>
				<tr>
					<th>Confirm Password:</th>
					<td><input type="text" name="confirmPassword"
						placeholder="Enter Confirm Password"
						value="<%=DataUtility.getStringData(bean.getConfirmPassword())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("confirmPassword", request)%></font></td>
				</tr>
				<tr>
					<th>DOB:</th>
					<td><input type="text"  name="dob"
						placeholder="Select Date of Birth"
						value="<%=DataUtility.getDateString(bean.getDob())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("dob", request)%></font></td>
				</tr>

				

				<tr>
					<th>Gender:</th>
					<td>
						<%
							HashMap map = new HashMap();
							map.put("male", "male");
							map.put("female", "female");
						%> <%=HTMLUtility.getList("gender", bean.getGender(), map)%>
					</td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("gender", request)%></font></td>
				</tr>
				
			<tr>
					<th>Role:</th>
					<td><%=HTMLUtility.getList("roleId", DataUtility.getStringData(bean.getRoleId()), roleList)%>
					</td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("roleId", request)%></font></td>
				</tr>
				   
				
				
				<tr>
					<th>Mobile No:</th>
					<td><input type="text" name="mobileNo"
						placeholder="Enter Mobile No."
						value="<%=DataUtility.getStringData(bean.getMobileNo())%>"></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("mobileNo", request)%></font></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="operation"
						value="<%=UserCtl.OP_SAVE%>">&nbsp; <input
						type="submit" name="operation"
						value="<%=UserCtl.OP_RESET%>"></td>
				</tr>
			</table>
</div>
	</form>

</body>
</html>


