package com.cg.mms.presentation;

import java.util.Scanner;

import com.cg.mms.exceptions.MMSException;
import com.cg.mms.service.MobileService;
import com.cg.mms.service.MobileServiceImpl;

public class DeleteMobileId {

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("Enter mobile id for the deletion");
		Integer id=scanner.nextInt();
		
		MobileService service =new MobileServiceImpl();
		int result;
		try {
			result = service.DeleteMobileRow(id);
			System.out.println(result+" Deleted");
		} catch (MMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
