package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CollegeBean;
import in.co.rays.model.CollegeModel;

public class TestCollegeModel {

	public static void main(String[] args) throws Exception {
		
		
		 //testAdd();
		 //testUpdate();
		// testDelete();
		// testFindByPk();
		// testFindByName();
		 //testSearch();
	
	
		
	}
	
	public static void testAdd() throws Exception
		
	{
	CollegeBean bean = new CollegeBean();	
	bean.setName("Ekta");
    bean.setAddress("WhiteField");
	bean.setState("Karnataka");	
	bean.setCity("Bangalore");
	bean.setPhoneNo("9898989898");
	bean.setCreatedBy("admin@gmail.com");
	bean.setModifiedBy("admin@gmail.com");
	bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
	bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

	CollegeModel model = new CollegeModel();
	model.add(bean);
	
	}
	
	public static void testUpdate() throws Exception
	
	{
		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.findByPk(1);
		bean.setName("Aggrawal");
		bean.setAddress("indore");
		bean.setState("Madhya Pradesh");
		model.update(bean);
		
		
	}
	
	public static void delete(long id) throws Exception
	
	{
	CollegeModel model = new CollegeModel();	
	model.delete(6);
		
	}
	
	
	public static void testFindByPk() throws Exception
	
	
	{
		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.findByPk(1);
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDateTime());
			System.out.println("\t" + bean.getModifiedDateTime());
		} else {
			System.out.println("id not found");
		}
		
		
	}
	
	
	public static void testFindByName() throws Exception
	{
		CollegeModel model = new CollegeModel();
		CollegeBean bean = model.findByName("Aggrawal");
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDateTime());
			System.out.println("\t" + bean.getModifiedDateTime());
		} else {
			System.out.println("college name not found");
		}
		
		
	}
	
	public static void testSearch() throws Exception
		
	{
		CollegeBean bean = new CollegeBean();
		CollegeModel model = new CollegeModel();
		List  list = model.search(bean, 1, 10);
		Iterator it = list.iterator();
		while(it.hasNext())
			
		{
			bean = (CollegeBean) it.next();
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getName());
			System.out.print("\t" + bean.getAddress());
			System.out.print("\t" + bean.getState());
			System.out.print("\t" + bean.getCity());
			System.out.print("\t" + bean.getPhoneNo());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDateTime());
			System.out.println("\t" + bean.getModifiedDateTime());
			
			
		}
			
			
			

		
		
		
	}
	
}