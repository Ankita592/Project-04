package in.co.rays.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import in.co.rays.bean.FavoriteBean;
import in.co.rays.bean.MarksheetBean;
import in.co.rays.bean.StudentBean;
import in.co.rays.exception.DuplicateRecordException;
import in.co.rays.util.JDBCDataSource;

public class FavoriteListModel {
	
	public static Integer nextPk() throws Exception
	{
		int pk=0;
		Connection conn = JDBCDataSource.getConnection();
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from st_favoritelist");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next())
		{
			pk = rs.getInt(1);
		}
		
		JDBCDataSource.closeConnection(conn);
		return pk+1;
				
	}
	
	
	public void add(FavoriteBean bean) throws Exception
	{
		
		int pk = nextPk();

		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement("insert into st_favoritelist values(?, ?, ?, ?, ?)");

		pstmt.setLong(1, pk);
		pstmt.setString(2, bean.getProduct_name());
		pstmt.setDate(3, new java.sql.Date(bean.getAdd_date().getTime()));
		pstmt.setString(4, bean.getCustomer_username());
		pstmt.setString(5, bean.getNotes());

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data inserted => " + i);

		
		
		
	}
	
	
public static void update(FavoriteBean bean) throws Exception
	
	
	{
		
		Connection conn = JDBCDataSource.getConnection();

		PreparedStatement pstmt = conn.prepareStatement(
				"update st_favoritelist set product_name = ?, add_date = ?, customer_username = ?, notes = ? where id = ?");

		pstmt.setString(1, bean.getProduct_name());
		pstmt.setDate(2, new java.sql.Date(bean.getAdd_date().getTime()));
		pstmt.setString(3, bean.getCustomer_username());
		pstmt.setString(4, bean.getNotes());
		pstmt.setLong(5, bean.getId());
		
		

		int i = pstmt.executeUpdate();

		JDBCDataSource.closeConnection(conn);

		System.out.println("data updated => " + i);

	}


public void delete(long id) throws Exception {

	Connection conn = JDBCDataSource.getConnection();

	PreparedStatement pstmt = conn.prepareStatement("delete from st_favoritelist where id = ?");

	pstmt.setLong(1, id);

	int i = pstmt.executeUpdate();

	JDBCDataSource.closeConnection(conn);

	System.out.println("data deleted => " + i);
	
	
	
	
}


	
public FavoriteBean findByPk(long id) throws Exception {

	Connection conn = JDBCDataSource.getConnection();

	PreparedStatement pstmt = conn.prepareStatement("select * from st_favoritelist  where id = ?");

	pstmt.setLong(1, id);

	ResultSet rs = pstmt.executeQuery();

	FavoriteBean bean = null;

	while (rs.next()) {
		bean = new FavoriteBean();
		bean.setId(rs.getLong(1));
		bean.setProduct_name(rs.getString(2));
		bean.setAdd_date(rs.getDate(3));
		bean.setCustomer_username(rs.getString(4));
		bean.setNotes(rs.getString(5));
		
		
	}
	JDBCDataSource.closeConnection(conn);
	return bean;
}
	

public List list() throws Exception {
	return search(null, 0, 0);
}




public List search(FavoriteBean bean, int pageNo, int pageSize) throws Exception {

	Connection conn = JDBCDataSource.getConnection();

	StringBuffer sql = new StringBuffer("select * from st_favoritelist where 1=1");

	if (bean != null) {
		if (bean.getProduct_name()!= null && bean.getProduct_name().length() > 0) {
			sql.append(" and product_name like '" + bean.getProduct_name() + "%'");
		}
		
		
		if (bean != null) {
			if (bean.getCustomer_username()!= null && bean.getCustomer_username().length() > 0) {
				sql.append(" and customer_username like '" + bean.getCustomer_username() + "%'");
			}
			
		}	
			
		
		if (bean.getId() > 0) {
			sql.append(" and id = " + bean.getId());
		}
		
		
	}

	if (pageSize > 0) {
		pageNo = (pageNo - 1) * pageSize;
		sql.append(" limit " + pageNo + ", " + pageSize);
	}

	System.out.println("sql ==>> " + sql.toString());

	PreparedStatement pstmt = conn.prepareStatement(sql.toString());

	ResultSet rs = pstmt.executeQuery();

	List list = new ArrayList();

	while (rs.next()) {
		bean = new FavoriteBean();
		bean.setId(rs.getLong(1));
		bean.setProduct_name(rs.getString(2));
		bean.setAdd_date(rs.getDate(3));
		bean.setCustomer_username(rs.getString(4));
		bean.setNotes(rs.getString(5));
		
		
		list.add(bean);
	}
	JDBCDataSource.closeConnection(conn);
	return list;

}
}
	
	
	
	
	
	
	
	
	
	
	


