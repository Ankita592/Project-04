package in.co.rays.ctl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.RoleBean;
import in.co.rays.model.RoleModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name = "RoleListCtl", urlPatterns = {"/RoleListCtl"})
public class RoleListCtl extends BaseCtl {
	
	public static final String OP_SEARCH = "Search";
    public static final String OP_RESET = "Reset";
    public static final String OP_DELETE = "Delete";
    public static final String OP_EDIT = "Edit";
	

	@Override
	protected void preload(HttpServletRequest request)
	{
		RoleModel roleModel = new RoleModel();
		
		
		try {
			List roleList = roleModel.list();
			request.setAttribute("roleList", roleList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	

	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		RoleBean bean = new RoleBean();
		bean.setName(DataUtility.getString(request.getParameter("name")));
		bean.setId(DataUtility.getLong(request.getParameter("roleId")));

		return bean;
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	
		ServletUtility.forward(getView(), request, response);
		
	}
	

	
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String operation = request.getParameter("operation");
		    
		    if (OP_SEARCH.equals(operation)) {
		        
		        Long roleId = DataUtility.getLong(request.getParameter("roleId"));
		        
		        
		        ServletUtility.forward(getView(), request, response);
		    } else if (OP_RESET.equals(operation)) {
		        // Handle reset operation if necessary
		        ServletUtility.forward(getView(), request, response);
		    } else if(OP_DELETE.equals(operation)) 
		    {
		    	
		    	String[] selectedRoles = request.getParameterValues("selectedRoles");
		    	
		    	if(selectedRoles != null)
		    	{
		    		RoleModel roleModel = new RoleModel();
		    		for(String roleId:selectedRoles)
		    			
		    		{
		    			try {
							roleModel.delete(DataUtility.getLong(roleId));
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
		    		}
		    		
		    		ServletUtility.setSuccessMessage("Selected roles deleted successfully", request);
		    	}
		    	else
		    	{
		    		ServletUtility.setErrorMessage("no roles selected for deletion", request);
		    	}
		    	
		    	ServletUtility.forward(getView(), request, response);
		    }
		    
		    else if(OP_EDIT.equals(operation))
		    	
		    {
		    	Long roleId = DataUtility.getLong(request.getParameter("roleId"));
		    	request.setAttribute("roleId", roleId);
	            ServletUtility.forward(ORSView.ROLE_LIST_VIEW, request, response);
		    }
		    
		    
		    else {
		        
		        ServletUtility.forward(getView(), request, response);
		    }
		}

	
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.ROLE_LIST_VIEW;
	}

	
	
	
	
	
	
	
	
	
}
