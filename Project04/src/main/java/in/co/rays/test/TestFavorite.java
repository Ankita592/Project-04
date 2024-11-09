package in.co.rays.test;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.FavoriteBean;
import in.co.rays.bean.MarksheetBean;
import in.co.rays.model.FavoriteListModel;
import in.co.rays.model.MarksheetModel;

public class TestFavorite {

	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testDelete();
		//testUpdate();
		testFindByPk();
		 //testSearch();
		
				
	}
	
	public static void testAdd() throws Exception
	{
		FavoriteBean bean = new FavoriteBean();
		bean.setId(2);
		bean.setProduct_name("Cream");
		bean.setAdd_date(new Date());
		bean.setCustomer_username("Ektaa");
		bean.setNotes("Good");
		
		FavoriteListModel model = new FavoriteListModel();
		model.add(bean);
		
		
		
	}
	
	public static void testUpdate() throws Exception
	{
		
		FavoriteListModel model = new FavoriteListModel();

		FavoriteBean bean = model.findByPk(1);
	    bean.setNotes("Poor");
        bean.setId(2);
		model.update(bean);
		
		
	}
	
	
	
	public static void testDelete() throws Exception {
		FavoriteListModel model = new FavoriteListModel();
		model.delete(2);
	}
	
	
	public static void testFindByPk() throws Exception {

	    FavoriteListModel model = new FavoriteListModel();

		FavoriteBean bean = model.findByPk(1);

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.println("\t"+bean.getProduct_name());
			System.out.println("\t"+bean.getAdd_date());
			System.out.println("\t"+bean.getCustomer_username());
			System.out.println("\t"+bean.getNotes());
			
			
			
			
			
		} else {
			System.out.println("id not found");
		}
	}
	
	public static void testSearch() throws Exception {

		FavoriteBean bean = new FavoriteBean();
		FavoriteListModel model = new FavoriteListModel();
		// bean.setName("b");

		

		List list = model.search(bean, 1, 10);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			bean = (FavoriteBean) it.next();
			System.out.print(bean.getId());
			System.out.println(bean.getProduct_name());
			System.out.println(bean.getAdd_date());
			System.out.println(bean.getCustomer_username());
			System.out.println(bean.getNotes());
			
			
			
		}
	}
	
	
	
	
	
	
	
}
