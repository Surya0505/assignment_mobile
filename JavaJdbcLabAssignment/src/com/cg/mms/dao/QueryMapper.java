package com.cg.mms.dao;

public interface QueryMapper {

	public static final String createQuery="create table mobiles_table(mobile_id number primary key,name varchar2(20),price number(10,2),quantity number)";

	public static final String insertQuery="insert into mobiles_table values(?,?,?,?)";
	
	public static final String checkMobileId="select * from mobiles_table";
	
	public static final String insertPurchaseDetails="insert into purchase_details values(purchase_id_sequence.nextval,?,?,?,sysdate,?)";
  
//	public static final String selectQueryToUpdate="select * from mobiles_table where mobile_id=?";
	
	public static final String updateQuantity="update mobiles_table set quantity=? where mobile_id=?"; 
	
	public static final String selectAllMobiles="select * from mobiles_table";
	
	public static final String DeleteMobileRow="delete from mobiles_table where mobile_id=?";
	
	public static final String selectMobileRange="select * from mobiles_table where price between ? and ?";
}
