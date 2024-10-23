package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.RoleBean;
import in.co.rays.bean.UserBean;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name="RoleCtl",urlPatterns = {"/RoleCtl"})
public class RoleCtl extends BaseCtl {

	@Override
	
	protected boolean validate(HttpServletRequest request)
	
	
	{
		boolean pass = true;
		
		
		if(DataValidator.isNull(request.getParameter("name")))
		{
			request.setAttribute("name", PropertyReader.getValue("error.require", "name"));
			pass = false;
		}
		
		else if(!DataValidator.isName("name"))
		{
			request.setAttribute("name", PropertyReader.getValue("error.require", "name"));
			pass = false;
		}
		
		
		if(DataValidator.isNull(request.getParameter("description")))
		{
			request.setAttribute("description", PropertyReader.getValue("error.require", "description"));
			pass = false;
			
		}
		
		return pass;
		
	}
	
	
	@Override
	
	protected BaseBean populateBean(HttpServletRequest request)
	{ 
	
		RoleBean bean = new RoleBean();
		bean.setName(request.getParameter("name"));
		bean.setDescription(request.getParameter("description"));
		populateDTO(bean, request);
		return bean;
		
	}
	
	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletUtility.forward(getView(), request, response);
		
		
	}
	
	
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletUtility.forward(getView(), request, response);
	}
	
	

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.ROLE_VIEW;
	}

}
