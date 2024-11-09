<%@page import="in.co.rays.ctl.FavoriteCtl"%>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="Header.jsp"%>
<form action = "<%=ORSView.FAVORITE_CTL%>" method="post">
<jsp:useBean id="bean" class = "in.co.rays.bean.FavoriteBean" scope="request"></jsp:useBean>
<input type="hidden" name="id" value="<%=bean.getId() %>">
<div align="center">
<h1>
<font color="navy">
<%
if(bean!=null && bean.getId()>0)
{

%>Update Favorite Item<%
} else {
%> Add FavoriteItem

</font>
<%
}
%>


</h1>

             <h3>
             
             <font color="green"><%=ServletUtility.getSuccessMessage(request)%>
             </font>
             
             </h3>

             <h3>
             
             <font color="red"><%=ServletUtility.getErrorMessage(request)%>
             </font>
             
             </h3>
             






<table>
            <tr>
                <th>Product Name</th>
                <td><input type="text" placeholder="Enter Product Name" name="productName" value="<%=DataUtility.getStringData(bean.getProduct_name())%>"></td>
                <td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("productName", request)%></font></td>
            </tr>
            
                      
            
            <tr>
					<th>Add Date</th>
					<td><input type="date"  name="addDate"
						placeholder="Select Date of Birth"
						value="<%=DataUtility.getDateString(bean.getAdd_date())%>"></td>
						<td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("addDate", request)%></font></td>
						
						</td>
					</tr>
            
            <tr>
                <th>Customer Name</th>
                <td><input type="text" placeholder="Enter Customer Name" name="customerName" value="<%=DataUtility.getStringData(bean.getCustomer_username())%>"></td>
                <td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("customerName", request)%></font></td>
            </tr>
            
            
            
            
            
            <tr>
                <th>Notes</th>
                <td><input type="text" placeholder="Enter notes" name="notes" value="<%=DataUtility.getStringData(bean.getNotes())%>"></td>
                <td style="position: fixed;"><font color="red"> <%=ServletUtility.getErrorMessage("notes", request)%></font></td>
            </tr>
            
            <tr>
            <th></th>
            <%
            if(bean!=null && bean.getId()>0) {
            
            %>
            
            <td align="left" colspan="2"><input type="submit" name="operation" value = "<%=FavoriteCtl.OP_UPDATE %>">
                <input type = "submit" name="operation" value="<%=FavoriteCtl.OP_CANCEL%>">
                <%}else{ %>
             
            
            
            <td>
                    <input type="submit" name="operation" value="<%=FavoriteCtl.OP_SAVE%>"> 
                    &nbsp; 
                    <input type="submit" name="operation" value="<%=FavoriteCtl.OP_RESET%>">
                </td>
            </tr>
            
 <%
                }
                %>

</table>


</div>





</form>
<%@include file="Footer.jsp"%>



</body>
</html>