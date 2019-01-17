package com.cg.mms.presentation;

import java.util.Arrays;
import java.util.Scanner;

import com.cg.mms.exceptions.MMSException;
import com.cg.mms.model.Mobiles;
import com.cg.mms.service.MobileService;
import com.cg.mms.service.MobileServiceImpl;

public class InsertMobile {

	public static void main(String[] args) {
		
		
	
		MobileService service=new MobileServiceImpl();
	  Scanner scanner=new Scanner(System.in);
	  
	  System.out.println("Enter mobile id");
	  Integer id=scanner.nextInt();
	  scanner.nextLine();
		System.out.println("Enter name of the mobile");
		String name=scanner.nextLine();
		System.out.println("Enter price of the mobile");
		Double price=scanner.nextDouble();
		System.out.println("Enter quantity");
		Integer quantity=scanner.nextInt();
		if(quantity<=0)
		{
			System.out.println("Quantity should be greater than zero");
			
		}else
		{
		
		Mobiles mobiles=new Mobiles();
		mobiles.setMobileId(id);
		mobiles.setName(name);
		mobiles.setPrice(price);
		mobiles.setQuantity(quantity);
		
		try {
			int result=service.insertMobileData(mobiles);
			System.out.println(result+"inserted");
		} catch (MMSException e) {
			System.out.println(e.getMessage());
		}
		
		
		}
		
		
		
		
//		try {
//			service.createTable();
//		} catch (MMSException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
