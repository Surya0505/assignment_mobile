package com.cg.mms.presentation;

import java.util.ArrayList;
import java.util.List;

import com.cg.mms.exceptions.MMSException;
import com.cg.mms.model.Mobiles;
import com.cg.mms.service.MobileService;
import com.cg.mms.service.MobileServiceImpl;

public class SelectAllMobiles {

	public static void main(String[] args) {
		
		
		//Mobiles mobiles=new Mobiles();
		List<Mobiles> list=new ArrayList<>();
		
		MobileService service=new MobileServiceImpl();
		
		try {
			list=service.selectAllMobiles();
			System.out.println("mobile_id"+"   "+"mobile name"+"         "+"price"+"        "+"quantity");
			
			for(Mobiles mobiles:list)
			{
				System.out.println(mobiles.getMobileId()+"        "+mobiles.getName()+"       "+mobiles.getPrice()+"          "+mobiles.getQuantity());
			}
			
		} catch (MMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
