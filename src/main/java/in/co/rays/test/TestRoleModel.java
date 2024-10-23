package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.RoleBean;
import in.co.rays.model.RoleModel;

public class TestRoleModel {
	
	public static void main(String[] args) throws Exception {
		
		//testAdd();
		//testUpdate();
		//testDelete();
		//testFindByPk();
		//testFindByName();
		//testSearch();
		
	}
	
	public static void testAdd() throws Exception
	
	
	{
		RoleBean bean = new RoleBean();
		bean.setName("kiosk");
		bean.setDescription("kiosk");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		
		RoleModel model = new RoleModel();
		model.add(bean);
		
	}
	
	public static void testUpdate() throws Exception
	
	{
		RoleBean bean = new RoleBean();
		
		bean.setId(2);
		bean.setName("student");
		bean.setDescription("student");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));
		
		RoleModel model = new RoleModel();
		model.update(bean);
		
		
		
	}
	
	
	public static void testDelete() throws Exception
	{
	RoleModel model = new RoleModel();
	model.delete(3);
	
		
	}
	
	public static void testFindByPk() throws Exception
	
	{
		RoleModel model = new RoleModel();
		RoleBean bean = model.findByPk(1);
		
		if(bean!=null)
		{
			System.out.println(bean.getId());
			System.out.println("\t"+bean.getName());
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
		RoleModel model = new RoleModel();
		RoleBean bean = model.findByName("kiosk");
		
		if(bean!=null)
		{
			
			System.out.println(bean.getId());
			System.out.println("\t"+bean.getName());
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
	
	public static void testSearch() throws Exception {

		RoleBean bean = new RoleBean();
		
		RoleModel model = new RoleModel();
		List list = model.search(bean, 1, 5);
		Iterator it = list.iterator();
		
		
		while (it.hasNext()) {

			bean = (RoleBean) it.next();
			System.out.print(bean.getId());
			System.out.println("\t"+bean.getName());
			System.out.println("\t"+bean.getDescription());
			System.out.println("\t"+bean.getCreatedBy());
			System.out.println("\t"+bean.getModifiedBy());
			System.out.println("\t"+bean.getCreatedDateTime());
			System.out.println("\t"+bean.getModifiedDateTime());
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	

}
