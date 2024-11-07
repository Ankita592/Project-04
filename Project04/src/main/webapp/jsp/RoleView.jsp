<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@page import="in.co.rays.ctl.RoleCtl"%>
<%@page import="in.co.rays.ctl.ORSView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<form action="<%=ORSView.ROLE_CTL%>" method="post">
    <jsp:useBean id="bean" class="in.co.rays.bean.RoleBean" scope="request"></jsp:useBean>

    <div align="center">
        <h1>
            <font color="navy">Add Role</font>
        </h1>

        <table>
            <tr>
                <th>Name:</th>
                <td><input type="text" name="name" value="<%=DataUtility.getStringData(bean.getName())%>"></td>
                <td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("name", request)%></font></td>
            </tr>

            <tr>
                <th align="left">Description<span style="color: red">*</span></th>
					<td align="center"><textarea style="width: 173px; resize: none;"
							name="description" rows="3" placeholder="Enter Short description"><%
								if (bean != null && bean.getId() > 0) {
							%><%=DataUtility.getStringData(bean.getDescription())%><%
								}
							%></textarea></td>
					<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("description", request)%></font></td>
            </tr>

            <tr>
                <th></th>
                <td>
                    <input type="submit" name="operation" value="<%=RoleCtl.OP_SAVE%>"> 
                    &nbsp; 
                    <input type="submit" name="operation" value="<%=RoleCtl.OP_RESET%>">
                </td>
            </tr>
        </table>
    </div>
</form>
	
</body>

</html>

