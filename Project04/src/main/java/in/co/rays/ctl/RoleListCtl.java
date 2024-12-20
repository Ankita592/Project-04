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
import in.co.rays.bean.UserBean;
import in.co.rays.exception.ApplicationException;
import in.co.rays.model.RoleModel;
import in.co.rays.model.UserModel;
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
		
		bean.setId(DataUtility.getLong(request.getParameter("roleId")));

		bean.setName(DataUtility.getString(request.getParameter("name")));
		
		
		return bean;
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		List<RoleBean> list = null;
		List<RoleBean> next = null;

		int pageNo = 1;
		int pageSize = 10;

		RoleBean bean = (RoleBean) populateBean(request);
		String op = DataUtility.getString(request.getParameter("operation"));
		RoleModel model = new RoleModel();

		try {
			list = model.search(bean, pageNo, pageSize);
			next = model.search(bean, pageNo + 1, pageSize);

			request.setAttribute("nextListSize", next.size());
			ServletUtility.setList(list, request);
			ServletUtility.setPageNo(pageNo, request);
			ServletUtility.setPageSize(pageSize, request);
			ServletUtility.forward(getView(), request, response);
		} catch (ApplicationException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
		
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   
			List list = null; 
			List next = null;
			
			int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
			int pageSize = DataUtility.getInt(request.getParameter("pageSize"));
			pageNo = (pageNo==0) ? 1:pageNo;
			pageSize = (pageSize==0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;
			RoleBean bean = (RoleBean) populateBean(request);
			
			
			String op = request.getParameter("operation");
			RoleModel model = new RoleModel();
		    String[] ids= request.getParameterValues("ids");
			
		    try {
				if (OP_SEARCH.equalsIgnoreCase(op)) {
					pageNo = 1;
				} else if (OP_NEXT.equalsIgnoreCase(op)) {
					System.out.println("pageNo");
					pageNo++;
				} else if (OP_PREVIOUS.equalsIgnoreCase(op) && pageNo > 1) {
					pageNo--;
				} else if (OP_NEW.equalsIgnoreCase(op)) {
					ServletUtility.redirect(ORSView.ROLE_CTL, request, response);
					return;
				} else if (OP_DELETE.equalsIgnoreCase(op)) {
					pageNo = 1;
					if (ids != null && ids.length > 0) {
						for (String id : ids) {
							model.delete(DataUtility.getLong(id));
						}
						ServletUtility.setSuccessMessage("Data is deleted successfully", request);
					} else {
						ServletUtility.setErrorMessage("Select at least one record", request);
					}
				} else if (OP_RESET.equalsIgnoreCase(op) || OP_BACK.equalsIgnoreCase(op)) {
					ServletUtility.redirect(ORSView.ROLE_LIST_CTL, request, response);
					return;
				}

				ServletUtility.setBean(bean, request);
				
				list = model.search(bean, pageNo, pageSize);
				next = model.search(bean, pageNo + 1, pageSize);

				if (!OP_DELETE.equalsIgnoreCase(op) && (list == null || list.size() == 0)) {
					ServletUtility.setErrorMessage("No record found", request);
				}
                       
				request.setAttribute("nextListSize", next.size());
				ServletUtility.setList(list, request);
				ServletUtility.setPageNo(pageNo, request);
				ServletUtility.setPageSize(pageSize, request);
				ServletUtility.forward(getView(), request, response);

			} catch (ApplicationException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		    
	
		    
		    
		    
	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.ROLE_LIST_VIEW;
	}

	
	
	
	
	
	
	
	
	
}
