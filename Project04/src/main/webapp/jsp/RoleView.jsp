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

   <%@ include file="Header.jsp" %>
	<form action="<%=ORSView.ROLE_CTL%>" method="post">
    <jsp:useBean id="bean" class="in.co.rays.bean.RoleBean" scope="request"></jsp:useBean>
    <input type="hidden" name="id" value="<%=bean.getId() %>">

    <div align="center">
        <h1>
            <font color="navy"><% if(bean!=null && bean.getId()>0){ %>Update
            <%} else { %>
            Add<%} %> Role
            
            </font>
            
        </h1>
        
        <input type = "hidden" name="id" value= <%=bean.getId() %>">
        <input type = "hidden" name="createdBy" <%=bean.getCreatedBy() %>">
        <input type = "hidden" name="createdBy" <%=bean.getModifiedBy() %>">
        <input type = "hidden" name="createdDatetime" <%=DataUtility.getTimestamp(bean.getCreatedDateTime()) %>">
         <input type = "hidden" name="modifiedDatetime" <%=DataUtility.getTimestamp(bean.getModifiedDateTime()) %>">
        
        
        
        
        
        
        
        
        
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
                <%
                if(bean!=null && bean.getId()>0){
                
                
                %>
                
                <td align="left" colspan="2"><input type="submit" name="operation" value = "<%=RoleCtl.OP_UPDATE %>">
                <input type = "submit" name="operation" value="<%=RoleCtl.OP_CANCEL%>">
                <%}else{ %>
                
                
                <td>
                    <input type="submit" name="operation" value="<%=RoleCtl.OP_SAVE%>"> 
                    &nbsp; 
                    <input type="submit" name="operation" value="<%=RoleCtl.OP_RESET%>">
                </td>
                
                
                
                
                
                
                
                
                
                <%
                }
                %>
            </tr>
        </table>
    </div>
</form>
<%@include file="Footer.jsp" %>
	
</body>

</html>


