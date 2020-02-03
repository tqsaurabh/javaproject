package com.DBLayer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.Pojo.AddPizza;
import com.Pojo.User;

public class DaoLayer {
	public static void setValues(PreparedStatement statement, Object... values) throws SQLException {
		for (int i = 0; i < values.length; i++) 
		{
			statement.setObject(i + 1, values[i]);
		}
	}

	public static Map<String, String> chklogin(User lib) throws SQLException, ClassNotFoundException {

		Map<String, String> mapobject = new HashMap<String, String>();

		ResultSet status = null;

		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_user_GETALL);

		status = ps.executeQuery();

		while (status.next())
		{
			if (status.getString(6).equals(lib.getUname()) && status.getString(4).equals(lib.getPassword())) {
				mapobject.put("status", "user");
				break;
			} else if ("admin@gmail.com".equals(lib.getUname()) && "admin123".equals(lib.getPassword())) {
				mapobject.put("status", "admin");
				break;
			} else {
				mapobject.put("status", "Error");
			}
		}
	
	    try { ps.close(); } catch (Exception e) { /* ignored */ }
	    try { con.close(); } catch (Exception e) { /* ignored */ }
		return mapobject;

	}

	public static Map<String, String> createReg(User lb) throws ClassNotFoundException, SQLException {
		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_user_INSERT);

		String uname = lb.getUname();
		String gender = lb.getGender();
		String Password = lb.getPassword();
		long mobileno = lb.getMobileno();
		String email = lb.getEmail();
		String address = lb.getAddress();
		Object[] parameter = {uname,gender,Password,mobileno,email,address};

		setValues(ps, parameter);

		status = ps.executeUpdate();

		if (status == 1) {

			mp.put("Msg", "successfully");

		} else {
			mp.put("Msg", "Error");
		}
		
	    try { ps.close(); } catch (Exception e) { /* ignored */ }
	    try { con.close(); } catch (Exception e) { /* ignored */ }
		return mp;

	}

	
	public static Map<String, String> addpizza(AddPizza lib) throws SQLException, ClassNotFoundException {

		Map<String, String> mapobject = new HashMap<String, String>();

		int status = 0;

		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_user_ADDALL);

		 int id=lib.getId();
		 String categories=lib.getCategories();
		 String pizzaname=lib.getPizzaname();
		 String price=lib.getPrice();
		 String addphoto=lib.getAddphoto();
		
		 Object[] parameter = {categories,pizzaname,price,addphoto};

		 setValues(ps, parameter);

		status = ps.executeUpdate();

		if (status == 1) {

			mapobject.put("Msg", "successfully");

		} else {
			mapobject.put("Msg", "Error");
		}
		
		
	    try { ps.close(); } catch (Exception e) { /* ignored */ }
	    try { con.close(); } catch (Exception e) { /* ignored */ }
		return mapobject;


	}

	public static ArrayList<AddPizza> getDriveListFromDb() throws SQLException, ClassNotFoundException {
		ArrayList<AddPizza> list = new ArrayList<>();
		Connection con = DBCon.getConnection();
		PreparedStatement ps1 = con.prepareStatement(constantdb.STR_pizza_GETALL);

		ResultSet resultSet = null;

		resultSet = ps1.executeQuery();
		while (resultSet.next()) {
			AddPizza u = new AddPizza();
			u.setId(resultSet.getInt(1));
			u.setCategories(resultSet.getString(2));
			u.setPizzaname(resultSet.getString(3));
			u.setPrice(resultSet.getString(4));
			u.setAddphoto(resultSet.getString(5));

			list.add(u);
		}
		try { resultSet.close(); } catch (Exception e) { /* ignored */ }
	    try { ps1.close(); } catch (Exception e) { /* ignored */ }
	    try { con.close(); } catch (Exception e) { /* ignored */ }
		return list;

	}

	public static Map<String, String> deletePizza(AddPizza lib) throws Exception {
		System.out.println("in  delete method ");

		Map<String, String> mp = new HashMap<>();

		int status = 0;
		Connection con = DBCon.getConnection();
		PreparedStatement ps = con.prepareStatement(constantdb.STR_deletepizza_DELETE);

		ps.setObject(1, lib.getId());

		status = ps.executeUpdate();

		if (status == 1) {

			mp.put("Msg", " Delete successfully");

		} else {
			mp.put("Msg", "Error");
		}

		
	    try { ps.close(); } catch (Exception e) { /* ignored */ }
	    try { con.close(); } catch (Exception e) { /* ignored */ }
		return mp;

	}

		public static Map<String, String> update(AddPizza lib) {
		Map<String, String> mapobject = new HashMap<String, String>();

		int status = 0;
		try {
			Connection con = DBCon.getConnection();
			PreparedStatement ps = con.prepareStatement(constantdb.STR_updatepizza_UPDATE);

			ps.setInt(5,lib.getId());
			ps.setString(1, lib.getCategories());
			ps.setString(2, lib.getPizzaname());
			ps.setString(3, lib.getPrice());
			ps.setString(4, lib.getAddphoto());
		
			status = ps.executeUpdate();
			if (status == 1) {

				mapobject.put("status", "updated successfully");
			} else {

				mapobject.put("status", "Error");
			}
			 try { ps.close(); } catch (Exception e) { /* ignored */ }
			    try { con.close(); } catch (Exception e) { /* ignored */ }
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return mapobject;
		
		

	}


}