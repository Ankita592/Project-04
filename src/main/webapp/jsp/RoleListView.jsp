<%@ page import="in.co.rays.ctl.ORSView" %>
<%@ page import="in.co.rays.ctl.RoleListCtl" %>
<%@ page import="in.co.rays.bean.RoleBean" %>
<%@ page import="in.co.rays.util.HTMLUtility" %>
<%@ page import="in.co.rays.util.ServletUtility" %>
<%@ page import="in.co.rays.util.DataUtility" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Role List</title>
</head>
<body>
    <form action ="<%= ORSView.ROLE_LIST_CTL %>" method="post">
    
        <jsp:useBean id="bean" class="in.co.rays.bean.RoleBean" scope="request"></jsp:useBean>
        <% 
            List<RoleBean> roleList = (List<RoleBean>) request.getAttribute("roleList");
            
        %>
        <div align="center">
            <h1><font color="navy">Role List</font></h1>
            <h3><font color="green"><%= ServletUtility.getSuccessMessage(request) %></font></h3>
            <h3><font color="red"><%= ServletUtility.getErrorMessage(request) %></font></h3>

            <input type="hidden" name="id" value="<%= bean.getId() %>">
            <input type="hidden" name="createdBy" value="<%= bean.getCreatedBy() %>">
            <input type="hidden" name="modifiedBy" value="<%= bean.getModifiedBy() %>">
            <input type="hidden" name="createdDatetime" value="<%= DataUtility.getTimestamp(bean.getCreatedDateTime()) %>">
            <input type="hidden" name="modifiedDatetime" value="<%= DataUtility.getTimestamp(bean.getModifiedDateTime()) %>">

            <table >
                <tr>
                    <th>Role:</th>
                    <td>
                        <%= HTMLUtility.getList("roleId", DataUtility.getStringData(bean.getId()), roleList) %>
                    </td>
                    <td style="position: fixed;">
                        <font color="red">
                            <%= ServletUtility.getErrorMessage("roleId", request) %>
                        </font>
                    </td>
                </tr>
            </table>

            <input type="submit" name="operation" value="<%= RoleListCtl.OP_SEARCH %>">
            <input type="reset" value="Reset">
            
            <table border = "1" style="margin-top:20px; width:100%">
            <tr>
            <th>Select</th>
            <th>S.No</th>
            <th>Role</th>
            <th>Description</th>
            <th>Edit</th>
            <th>Delete</th>
            </tr>
            
            <%
            
            if(roleList != null && !roleList.isEmpty())
            {
            	int sNo =1;
            for(RoleBean role:roleList)
            {
            
            %>
           
           <tr>
           <td>
           
           <input type="checkbox" name="selectedRoles" value="<%= role.getId() %>">
            
            </td>
                    <td><%= sNo++ %></td> 
                    <td><%= role.getName() %></td>
                    <td><%= role.getDescription() %></td>
                    <td>
                        <a href="<%= ORSView.ROLE_CTL + "?id=" + role.getId() %>">Edit</a>
                    </td>
                    <td>
                        <a href="<%= ORSView.ROLE_CTL + "?id=" + role.getId() %>" >Delete</a>
                    </td>
                </tr>
                <% 
                        }
                    } else {
                        out.println("<tr><td colspan='6'>No roles found.</td></tr>");
                    }
                %>
                
                <input type="hidden" name="operation" value="<%= RoleListCtl.OP_DELETE %>"> 
                
    
      
         </table>      
        </div>
    </form>
</body>
</html>
