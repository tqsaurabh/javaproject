package com.DBLayer;

public class constantdb {

	public static final String STR_user_INSERT = ("insert into register(uname,Gender,Password,Mobile,Email,Address)values(?,?,?,?,?,?)");
	public static final String STR_user_GETALL = "select * from register";
	
	
	public static final String STR_user_ADDALL =("insert into addpizza(categories,pizzaname,price,addphoto) values(?,?,?,?)");
	public static final String STR_pizza_GETALL = "select * from addpizza";
	
	
	public static final String STR_deletepizza_DELETE = "Delete from addpizza where id=?";
	
	
	public static final String STR_updatepizza_UPDATE =" update addpizza set categories=?,pizzaname=?,price=?,addphoto=? where id=?";
}
