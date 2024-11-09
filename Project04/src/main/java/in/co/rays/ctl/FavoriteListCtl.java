package in.co.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.bean.BaseBean;
import in.co.rays.bean.FavoriteBean;
import in.co.rays.bean.RoleBean;
import in.co.rays.exception.ApplicationException;
import in.co.rays.model.FavoriteListModel;
import in.co.rays.model.RoleModel;
import in.co.rays.util.DataUtility;
import in.co.rays.util.PropertyReader;
import in.co.rays.util.ServletUtility;
@WebServlet(name = "FavoriteListCtl", urlPatterns = {"/FavoriteListCtl"})
public class FavoriteListCtl extends BaseCtl {
	
	
	@Override
	protected void  preload(HttpServletRequest request){
		
		FavoriteListModel model = new FavoriteListModel();
		  

		  try {
		        // Call the non-static method using the model instance
		        List favoriteList = model.list();
		        System.out.println("Favorite list loaded: " + favoriteList.size());
		        request.setAttribute("favoriteList", favoriteList);
		    }
		  
		  catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		
		
		
		
	}
	
	@Override
	protected BaseBean populateBean(HttpServletRequest request) {
		FavoriteBean bean = new FavoriteBean();
		
		bean.setId(DataUtility.getLong(request.getParameter("id")));
        bean.setNotes(DataUtility.getString(request.getParameter("notes")));
		bean.setProduct_name(DataUtility.getString(request.getParameter("productName")));
		bean.setCustomer_username(DataUtility.getString(request.getParameter("customerName")));
		
		return bean;
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		List<FavoriteBean> list = null;
		List<FavoriteBean> next = null;

		int pageNo = 1;
		int pageSize = 10;

		
		String op = DataUtility.getString(request.getParameter("operation"));

		FavoriteBean bean = (FavoriteBean) populateBean(request);
		
		FavoriteListModel model = new FavoriteListModel();

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
	
	@SuppressWarnings("null")
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    List<FavoriteBean> list = null; 
	    List<FavoriteBean> next = null;

	    
	    int pageNo = DataUtility.getInt(request.getParameter("pageNo"));
	    int pageSize = DataUtility.getInt(request.getParameter("pageSize"));
	    
	    
	    pageNo = (pageNo == 0) ? 1 : pageNo;
	    pageSize = (pageSize == 0) ? DataUtility.getInt(PropertyReader.getValue("page.size")) : pageSize;

	    FavoriteBean bean = (FavoriteBean) populateBean(request);

	    String op = request.getParameter("operation");
	    FavoriteListModel model = new FavoriteListModel();
	    String[] ids = request.getParameterValues("ids");

	    try {
	        
	        if (OP_SEARCH.equalsIgnoreCase(op)) {
	            pageNo = 1;  
	            list = model.search(bean, pageNo, pageSize);
	            next = model.search(bean, pageNo + 1, pageSize);

	        
	        } else if (OP_NEW.equalsIgnoreCase(op)) {
	            ServletUtility.redirect(ORSView.FAVORITE_CTL, request, response);
	            return;

	        
	        } else if (OP_RESET.equalsIgnoreCase(op)) {
	            // Redirect to the same page with no filters
	            ServletUtility.redirect(ORSView.FAVORITE_LIST_CTL, request, response);
	            return;

	        
	        } else if (OP_BACK.equalsIgnoreCase(op)) {
	            ServletUtility.redirect(ORSView.FAVORITE_LIST_CTL, request, response);
	            return;

	        
	        } else if (OP_DELETE.equalsIgnoreCase(op)) {
	            if (ids != null) {
	                for (String id : ids) {
	                    model.delete(Long.parseLong(id)); 
	                }
	                
	                ServletUtility.redirect(ORSView.FAVORITE_LIST_CTL, request, response);
	                return;
	            }
	        }

	     
	        request.setAttribute("nextListSize", next.size());
	        ServletUtility.setList(list, request);
	        ServletUtility.setPageNo(pageNo, request);
	        ServletUtility.setPageSize(pageSize, request);
	       ServletUtility.forward(getView(), request, response);
	    } catch (ApplicationException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.FAVORITE_LIST_VIEW;
	}

}
