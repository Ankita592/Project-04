<%@ page import="in.co.rays.ctl.ORSView" %>
<%@ page import="in.co.rays.ctl.RoleListCtl" %>
<%@ page import="in.co.rays.bean.RoleBean" %>
<%@page import="java.util.Iterator"%>
<%@ page import="in.co.rays.util.HTMLUtility" %>
<%@ page import="in.co.rays.util.ServletUtility" %>
<%@ page import="in.co.rays.util.DataUtility" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Role List</title>
    <script type="text/javascript"
	src="<%=ORSView.APP_CONTEXT%>/js/checkBox.js">
	
</script>
    
</head>
<body>
     <%@ include file="Header.jsp"%>
     
    <form action ="<%= ORSView.ROLE_LIST_CTL %>" method="post">
    
        <jsp:useBean id="bean" class="in.co.rays.bean.RoleBean" scope="request"></jsp:useBean>
        <input type="hidden" name="id" value="<%=bean.getId() %>">
        
        <div align="center">
            <h1><font color="navy">Role List</font></h1>
            <h3><font color="green"><%= ServletUtility.getSuccessMessage(request) %></font></h3>
            <h3><font color="red"><%= ServletUtility.getErrorMessage(request) %></font></h3>
            
            <%
            
            int pageNo = ServletUtility.getPageNo(request);
			int pageSize = ServletUtility.getPageSize(request);
			int index = ((pageNo - 1) * pageSize) + 1;
			int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());
			System.out.println("nextPageSize"+nextPageSize);
			List roleList = (List) request.getAttribute("roleList");
			List list = ServletUtility.getList(request);
			Iterator it = list.iterator();
			if (list.size() != 0) {
               
            
            %>
            
            
            <input type="hidden" name="id" value="<%=bean.getId() %>">
            <input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
            
            <div align="center">
            <table style="width: 100%">
				<tr>
					<td style="text-align:center;">
						<label><b>Role :</b></label>
                        <%=HTMLUtility.getList("roleId",String.valueOf(bean.getId()), roleList)%>&nbsp;
						
						<input type="submit" name="operation"
						value="<%=RoleListCtl.OP_SEARCH%>"> &nbsp; <input
						type="submit" name="operation" value="<%=RoleListCtl.OP_RESET%>">
					</td>
				</tr>
			</table>
			</div>
			
			<br>

			<table border="1%" style="width: 100%">
				<tr style="background-color: lavender; color: black;">
					<th><input type="checkbox" id="selectall"></th>
					<th>S.No.</th>
					<th>Role</th>
					<th>Description</th>
					<th>Edit</th>
				</tr>
			 
			  <%
					while (it.hasNext()) {
							bean = (RoleBean) it.next();
							
							
				%>
            
            
            
            <tr align="center">
            <td><input type="checkbox" class="case" name="ids"
						value="<%=bean.getId()%>"></td>
						<td><%=index++%></td>

            <td><%=bean.getName() %>
            <td><%=bean.getDescription() %>
            <td><a href="<%=ORSView.ROLE_CTL%>?id=<%=bean.getId()%>">
				edit</a></td>
						
				</tr>
				<%
					}
				%>
			</table>
			
			
			<br>
			
			<table style="width:100%">
			<tr>
					<td style="width: 30%"><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_PREVIOUS%>"
						<%=(pageNo == 1) ? "disabled" : ""%>></td>
					<td style="width: 30%"><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_NEW%>"></td>
					<td style="width: 25%"><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_DELETE%>"></td>
					<td style="text-align: right;"><input type="submit"
						name="operation" value="<%=RoleListCtl.OP_NEXT%>"
						<%=(nextPageSize != 0) ? "" : "disabled"%>></td>
				</tr>
			</table>
			<%
				}
				if (list.size() == 0) {
			%>
			<br>
			<table>
				<tr>
					<td align="right"><input type="submit" name="operation"
						value="<%=RoleListCtl.OP_BACK%>"></td>
				</tr>
			</table>
			<%
				}
			%>
			
			
              
        </div>
    </form>
    <%@include file="Footer.jsp" %>
	
    
</body>
</html>
