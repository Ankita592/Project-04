package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.RoleBean;
import in.co.rays.bean.UserBean;
import in.co.rays.exception.ApplicationException;
import in.co.rays.exception.DuplicateRecordException;
import in.co.rays.model.RoleModel;
import in.co.rays.model.UserModel;
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
	   
		String op = DataUtility.getString(request.getParameter("operation"));
		Long id = DataUtility.getLong(request.getParameter("id"));
				
				if (id > 0) {

					RoleModel model = new RoleModel();

					try {
						RoleBean bean = model.findByPk(id);
						ServletUtility.setBean(bean, request);
					} catch (ApplicationException e) {
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}			
				
				
				
		ServletUtility.forward(getView(), request, response);
		
		
	}
	
	
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String op = DataUtility.getString(request.getParameter("operation"));

		// get model
		RoleModel model = new RoleModel();
		RoleBean bean = (RoleBean) populateBean(request);

		if (OP_SAVE.equalsIgnoreCase(op)) {
			try {
				model.add(bean);
				ServletUtility.setSuccessMessage("User Added Successfully..!!", request);
				ServletUtility.forward(getView(), request, response);
				
			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage("login id already exist", request);
				ServletUtility.forward(getView(), request, response);
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (OP_RESET.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.ROLE_CTL, request, response);
			return;
		}

		ServletUtility.forward(getView(), request, response);
	}
		
	
	

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.ROLE_VIEW;
	}

}
