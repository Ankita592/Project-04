package in.co.rays.bean;

import java.util.Date;

public class FavoriteBean extends BaseBean {

	
	public String product_name;
	public Date add_date;
	public String customer_username;
	public String notes;
	

@Override
	
	public String getKey()
	{
		return id + "";
	}
	
	@Override
	public String getValue()
	{
		return product_name;
	}
	

	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
	public Date getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Date add_date) {
		this.add_date = add_date;
	}
	public String getCustomer_username() {
		return customer_username;
	}
	public void setCustomer_username(String customer_username) {
		this.customer_username = customer_username;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
	
	
	
	
	
	
	
	
}
