<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="in.co.rays.ctl.FavoriteListCtl"%>
<%@ page import="in.co.rays.bean.FavoriteBean" %>
<%@page import="java.util.Iterator"%>
<%@ page import="in.co.rays.util.HTMLUtility" %>
<%@page import="in.co.rays.util.DataUtility"%>
<%@page import="in.co.rays.util.ServletUtility"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%@include file="Header.jsp" %>
<form action = "<%=ORSView.FAVORITE_LIST_CTL%>" method="post">
<jsp:useBean id="bean" class = "in.co.rays.bean.FavoriteBean" scope="request"></jsp:useBean>
<input type="hidden" name="id" value="<%=bean.getId() %>">



<div align="center">
<h1>
<font color="navy">Favorite List</font></h1>
<h3><font color="green"><%= ServletUtility.getSuccessMessage(request) %></font></h3>
            <h3><font color="red"><%= ServletUtility.getErrorMessage(request) %></font></h3>
            <%
            
            int pageNo = ServletUtility.getPageNo(request);
			int pageSize = ServletUtility.getPageSize(request);
			int index = ((pageNo - 1) * pageSize) + 1;
			int nextPageSize = DataUtility.getInt(request.getAttribute("nextListSize").toString());
			System.out.println("nextPageSize"+nextPageSize);
			List favoriteList = (List) request.getAttribute("favoriteList");
			List list = ServletUtility.getList(request);
			Iterator it = list.iterator();
			if (list.size() != 0) {
               
            
            %>



                <tr>
					<td style="text-align:center;">
						<label><b>Product Name: :</b></label>
                                      
                <%=HTMLUtility.getList("favoriteId",String.valueOf(bean.getId()), favoriteList)%>&nbsp;
                
                <input type="submit" name="operation"
						value="<%=FavoriteListCtl.OP_SEARCH%>"> &nbsp; <input
						type="submit" name="operation" value="<%=FavoriteListCtl.OP_RESET%>">
                
               </td> 
            </tr>
            
            <br><br>
            <table border="1%" style="width: 100%">
            <tr style = "background-color:lavender; color:black">
            
            <th><input type="checkbox"  id="selectall"
						value="<%=bean.getId()%>"></th>
		    <th>S.No</th>
            <th>Customer Username</th>
            <th>Product Name</th>
            <th>Notes</th>
             <th>Edit</th>
            
            </tr>
            
             <%
					while (it.hasNext()) {
							bean = (FavoriteBean) it.next();
							
							
				%>
            
            <tr align="center">
            <td><input type="checkbox" class="case" name="ids"
						value="<%=bean.getId()%>"></td>
            <td><%=index++ %></td>
			<td><%=bean.getCustomer_username()%>
            <td><%=bean.getProduct_name() %>
            <td><%=bean.getNotes()%>
            <td><a href="<%=ORSView.FAVORITE_CTL%>?id=<%=bean.getId()%>">
				edit</a></td>
						
				</tr>
				<%
					}
             

             
				%>
           
            
                  </table>
          

           
            
             <input type="hidden" name="id" value="<%=bean.getId() %>">
            <input type="hidden" name="pageNo" value="<%=pageNo%>"> <input
				type="hidden" name="pageSize" value="<%=pageSize%>">
				

<br>
<table style="width:100%">
<tr>

<td style="width: 30%"><input type="submit" name="operation"
						value="<%=FavoriteListCtl.OP_PREVIOUS%>"
						<%=(pageNo == 1) ? "disabled" : ""%>></td>
						
<td style="width: 30%"><input type="submit" name="operation"
						value="<%=FavoriteListCtl.OP_NEW%>"></td>
					<td style="width: 25%"><input type="submit" name="operation"
						value="<%=FavoriteListCtl.OP_DELETE%>"></td>

<td style="text-align: right;"><input type="submit"
						name="operation" value="<%=FavoriteListCtl.OP_NEXT%>"
						<%=(nextPageSize != 0) ? "" : "disabled"%>></td>	
						<% } %>				
					


 </table>





</div>
</form>
<%@include file="Footer.jsp" %>
</body>
</html>