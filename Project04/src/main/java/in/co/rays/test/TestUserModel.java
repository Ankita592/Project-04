package in.co.rays.test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.rays.bean.UserBean;
import in.co.rays.model.UserModel;

public class TestUserModel {

	public static void main(String[] args) throws Exception {
		
	 //testAdd();	
	//testUpdate();
	//testDelete();
	//testFindByPk();
	//testFindByLogin();
	//testAuthenticate();
	testSearch();
		
		
	}
	
	
	public static void testAdd() throws Exception
	
	
	{
		UserBean bean = new UserBean();
		
		bean.setFirstName("Ankita");
		bean.setLastName("Prajapati");
		bean.setLogin("ankita@gmail.com");
		bean.setPassword("1234");
		bean.setDob(new Date());
		bean.setMobileNo("9998890811");
		bean.setRoleId(2);
		bean.setGender("female");
		bean.setCreatedBy("admin@gmail.com");
		bean.setModifiedBy("admin@gmail.com");
		bean.setCreatedDateTime(new Timestamp(new Date().getTime()));
		bean.setModifiedDateTime(new Timestamp(new Date().getTime()));

		UserModel model = new UserModel();
		model.add(bean);
				
	}
	
	
	
	public static void testUpdate() throws Exception
	
	
	{
		UserModel model = new UserModel();

		UserBean bean = model.findByPk(1);
		bean.setFirstName("Aman");
		bean.setLastName("Gupta");
		bean.setLogin("sawan@gmail.com");
		bean.setPassword("1234");

		model.update(bean);
		
		
		
		
	}
	
	public static void testDelete() throws Exception
	
	{
		UserModel model = new UserModel();
		model.delete(1);
		
		
	}
	
	public static void testFindByPk() throws Exception
	
	{
		UserModel model = new UserModel();
		UserBean bean = model.findByPk(1);
		
		if(bean!=null)
			
			
		{
			
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
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
	
	
	public static void testFindByLogin() throws Exception {

		UserModel model = new UserModel();

		UserBean bean = model.findByLogin("ankita@gmail.com");

		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDateTime());
			System.out.println("\t" + bean.getModifiedDateTime());
		} else {
			System.out.println("login not found");
		}
	}
	
	
	public static void testAuthenticate() throws Exception
	
	{
		
		UserModel model = new UserModel(); 
		UserBean bean     = model.authenticate("ankita@gmail.com","12345");
		if (bean != null) {
			System.out.print(bean.getId());
			System.out.print("\t" + bean.getFirstName());
			System.out.print("\t" + bean.getLastName());
			System.out.print("\t" + bean.getLogin());
			System.out.print("\t" + bean.getPassword());
			System.out.print("\t" + bean.getDob());
			System.out.print("\t" + bean.getMobileNo());
			System.out.print("\t" + bean.getRoleId());
			System.out.print("\t" + bean.getGender());
			System.out.print("\t" + bean.getCreatedBy());
			System.out.print("\t" + bean.getModifiedBy());
			System.out.print("\t" + bean.getCreatedDateTime());
			System.out.println("\t" + bean.getModifiedDateTime());
		} else {
			System.out.println("login & password invalid");
		}
		
	}	
		
	public static void testSearch() throws Exception
		
	{
	UserBean bean = new UserBean();	
	UserModel model = new UserModel();
	List list = model.search(bean, 1, 5);	
	Iterator it = list.iterator();	
		
	while(it.hasNext())
	{
		
		bean = (UserBean) it.next();
		System.out.print(bean.getId());
		System.out.print("\t" + bean.getFirstName());
		System.out.print("\t" + bean.getLastName());
		System.out.print("\t" + bean.getLogin());
		System.out.print("\t" + bean.getPassword());
		System.out.print("\t" + bean.getDob());
		System.out.print("\t" + bean.getMobileNo());
		System.out.print("\t" + bean.getRoleId());
		System.out.print("\t" + bean.getGender());
		System.out.print("\t" + bean.getCreatedBy());
		System.out.print("\t" + bean.getModifiedBy());
		System.out.print("\t" + bean.getCreatedDateTime());
		System.out.println("\t" + bean.getModifiedDateTime());
		
		
		
		
		
		
	}
		
		
		
		
		
	}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	

