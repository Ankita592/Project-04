package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.TimetableBean;
import in.co.rays.model.TimetableModel;

public class TestTimetableModel {
	
	public static void main(String[] args) throws Exception {
		
		        //testAdd();
				 //testUpdate();
				// testDelete();
				// testFindByPk();
				testSearch();
		
			
		
	}
	
	public static void testAdd() throws Exception
	{
		
		TimetableBean bean = new TimetableBean();
		bean.setSemester("first");
		bean.setDescription("3rd");
		bean.setExamDate(new Date());
		bean.setExamTime("11:00AM - 12:00PM");
		bean.setCourseId(1);
		bean.setSubjectId(1);
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
        
		TimetableModel model = new TimetableModel();
		model.add(bean);
		
	}
	
	public static void testUpdate() throws Exception
	{
		TimetableModel model = new TimetableModel();
		TimetableBean bean = model.findByPk(1);
		bean.setSemester("3rd");
		bean.setDescription("3rd");
		bean.setExamDate(new Date());
		bean.setExamTime("11:00AM - 12:00PM");
		bean.setExamTime("11:00AM - 12:00PM");
		bean.setCourseId(1);
		bean.setSubjectId(1);

		model.update(bean);
	}
	
	public static void testDelete() throws Exception
	{
		TimetableModel model = new TimetableModel();	
		model.delete(7);
		
		
	}
	
	public static void testFindByPk() throws Exception
	{
		
		TimetableModel model = new TimetableModel();
		TimetableBean bean = model.findByPk(1);
		
		if(bean != null)
		{
			
			System.out.println(bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDateTime());
			System.out.println("\t" + bean.getModifiedDateTime());
								
		}
		
		else
		{
			System.out.println("id not found");
		}
		
		
		
	}
	
	public static void testSearch() throws Exception
	{
		TimetableBean bean = new TimetableBean();
		bean.setCourseName("CE");
		TimetableModel model = new TimetableModel();
		List list = model.search(bean, 1, 5);
		Iterator it = list.iterator();
		
		while(it.hasNext())
		{
			bean = (TimetableBean) it.next();
			
			System.out.println(bean.getId());
			System.out.print("\t" + bean.getSemester());
			System.out.print("\t" + bean.getDescription());
			System.out.print("\t" + bean.getExamDate());
			System.out.print("\t" + bean.getExamTime());
			System.out.print("\t" + bean.getCourseId());
			System.out.print("\t" + bean.getCourseName());
			System.out.print("\t" + bean.getSubjectId());
			System.out.print("\t" + bean.getSubjectName());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDateTime());
			System.out.println("\t" + bean.getModifiedDateTime());
			
			
			
			
			
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

}