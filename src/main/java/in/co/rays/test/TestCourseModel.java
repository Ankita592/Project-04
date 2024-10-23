package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.CourseBean;
import in.co.rays.model.CourseModel;

public class TestCourseModel {
	
	public static void main(String[] args) throws Exception {
		
		testAdd();
		//testUpdate();
		//testDelete();
		//testFindByPk();
		//testFindByName();
		//testSearch();
		
		
	}
	
	
	public static void testAdd() throws Exception
	
	{
		
		CourseBean bean = new CourseBean();
		bean.setName("Architecture");
		bean.setDuration("5 year");
		bean.setDescription("Architecture");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		
		CourseModel model = new CourseModel();
		model.add(bean);
		
	}
	
	
	public static void testUpdate() throws Exception
	
	
	{
		CourseModel model = new CourseModel();
		CourseBean bean = model.findByPk(1);
		bean.setName("CE");
		bean.setDuration("4 years");
		bean.setDescription("CE");
		
		model.update(bean);
		
	}
	
	public static void testDelete() throws Exception
	
	{
		CourseModel model = new CourseModel();
		model.delete(3);
		
		
	}
	
	public static void testFindByPk() throws Exception
	
	{
		CourseModel model = new CourseModel();
		CourseBean bean = model.findByPk(1);
		
		if(bean != null)
		{
		System.out.println(bean.getId());	
		System.out.println("\t" +bean.getName());
		System.out.println("\t"+bean.getDuration());
		System.out.println("\t"+bean.getDescription());
		System.out.println("\t"+bean.getCreatedBy());
		System.out.println("\t"+bean.getModifiedBy());
		System.out.println("\t"+bean.getCreatedDateTime());
		System.out.println("\t"+bean.getModifiedDateTime());
		
		}
		
		else
		{
			System.out.println("id not found");
		}
		
		
		
	}
	
	public static void testFindByName() throws Exception
	
	{
		
		CourseModel model = new CourseModel();
		CourseBean bean = model.findByName("CE");
		
		if(bean != null)
		{
			System.out.println(bean.getId());
			System.out.println("\t" +bean.getName());
			System.out.println("\t"+bean.getDuration());
			System.out.println("\t"+bean.getDescription());
			System.out.println("\t"+bean.getCreatedBy());
			System.out.println("\t"+bean.getModifiedBy());
			System.out.println("\t"+bean.getCreatedDateTime());
			System.out.println("\t"+bean.getModifiedDateTime());
			
			
		}
		
		else
			
		{
			System.out.println("name not found");
			
		}
				
	}
	
	public static void testSearch() throws Exception
	
	
	{
		CourseBean bean = new CourseBean();
		bean.setName("c");
		CourseModel model = new CourseModel();
		List list = model.search(bean, 1, 5);
		Iterator it = list.iterator();
		while(it.hasNext())
			
		{
			
		bean = (CourseBean) it.next();	
		System.out.print(bean.getId());
		System.out.print("\t" + bean.getName());
		System.out.print("\t" + bean.getDuration());
		System.out.print("\t" + bean.getDescription());
		System.out.print("\t" + bean.getCreatedBy());
		System.out.print("\t" + bean.getModifiedBy());
		System.out.print("\t" + bean.getCreatedDateTime());
		System.out.println("\t" + bean.getModifiedDateTime());
			
			
			
		}
		
		
	}
	
	

}
