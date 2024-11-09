package in.co.rays.ctl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.FavoriteBean;
import in.co.rays.bean.RoleBean;
import in.co.rays.bean.UserBean;
import in.co.rays.exception.ApplicationException;
import in.co.rays.exception.DuplicateRecordException;
import in.co.rays.model.FavoriteListModel;
import in.co.rays.model.UserModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.DataValidator;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;

@WebServlet(name="FavoriteCtl",urlPatterns = "/FavoriteCtl")
public class FavoriteCtl extends BaseCtl {
	
	
	@Override
	protected boolean validate(HttpServletRequest request)
	{
		boolean pass = true;

		if (DataValidator.isNull(request.getParameter("productName"))) {
			request.setAttribute("productName", PropertyReader.getValue("error.require", "productname"));
			pass = false;
		}

		else if (!DataValidator.isName("productName")) {
			request.setAttribute("productName", PropertyReader.getValue("error.require", "productname"));
			pass = false;
		}

		if (DataValidator.isNull(request.getParameter("customerName"))) {
			request.setAttribute("customerName", PropertyReader.getValue("error.require", "customername"));
			pass = false;

		}
		
		else if(!DataValidator.isName("customerName")) {
			request.setAttribute("customerName", PropertyReader.getValue("error.require", "customername"));
			pass = false;
		}
		
		if(DataValidator.isNull(request.getParameter("notes")))
		{
			request.setAttribute("notes", PropertyReader.getValue("error.require","notes"));
			pass=false;
		}
		
	

		if (DataValidator.isNull(request.getParameter("addDate"))) {
			request.setAttribute("addDate", PropertyReader.getValue("error.require", "Date"));
			pass = false;
		} else if (!DataValidator.isDate(request.getParameter("addDate"))) {
			request.setAttribute("addDate", PropertyReader.getValue("error.require", "Date"));
			pass = false;
		}
		
		
		
		
		return pass;

	}

	
	@Override

	protected BaseBean populateBean(HttpServletRequest request) {

		FavoriteBean bean = new FavoriteBean();
		bean.setId(DataUtility.getLong(request.getParameter("id")));
		bean.setProduct_name(DataUtility.getString(request.getParameter("productName")));
		bean.setAdd_date(DataUtility.getDate(request.getParameter("addDate")));
		bean.setCustomer_username(DataUtility.getString(request.getParameter("customerName")));
		bean.setNotes(DataUtility.getString(request.getParameter("notes")));
		
		populateDTO(bean, request);
		return bean;

	}
	
	
	
	

	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String op = DataUtility.getString(request.getParameter("operation"));
		Long id = DataUtility.getLong(request.getParameter("id"));
		FavoriteListModel model = new FavoriteListModel();
		
		if(id>0)
		{
			
			try {
				FavoriteBean bean = model.findByPk(id);
				ServletUtility.setBean(bean, request);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		// TODO Auto-generated method stub
		ServletUtility.forward(getView(), request, response);
	}
	
	
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String op = DataUtility.getString(request.getParameter("operation"));

		FavoriteListModel model = new FavoriteListModel();
		FavoriteBean bean = (FavoriteBean) populateBean(request);
		
		if (OP_SAVE.equalsIgnoreCase(op)) {
			try {
				model.add(bean);
				ServletUtility.setSuccessMessage("Favorite Added Successfully..!!", request);
				ServletUtility.forward(getView(), request, response);
			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage("Favorite already exist", request);
				ServletUtility.forward(getView(), request, response);
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		else if (OP_UPDATE.equalsIgnoreCase(op)) {
			try {
				bean.setId(DataUtility.getLong(request.getParameter("id")));
				System.out.println("id is :"+bean.getId());
				model.update(bean);
				FavoriteBean favoriteBean = model.findByPk(bean.getId());
				ServletUtility.setBean(favoriteBean, request);
				ServletUtility.setSuccessMessage("Favorite updated Successfully..!!", request);
				ServletUtility.forward(getView(), request, response);
			} catch (DuplicateRecordException e) {
				ServletUtility.setBean(bean, request);
				ServletUtility.setErrorMessage("Favorite id already exist", request);
				ServletUtility.forward(getView(), request, response);
			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}	
		else if (OP_CANCEL.equalsIgnoreCase(op)) {
			ServletUtility.redirect(ORSView.FAVORITE_LIST_CTL, request, response);
			return;
		}
		
		
		
		ServletUtility.forward(getView(), request, response);
	}
	
	
	
	
	
	
	
	
	
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.FAVORITE_VIEW;
	}

}
