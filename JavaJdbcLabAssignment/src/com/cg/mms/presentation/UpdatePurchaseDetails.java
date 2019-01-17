package com.cg.mms.presentation;

import java.util.Scanner;

import com.cg.mms.exceptions.MMSException;
import com.cg.mms.model.PurchaseDetails;
import com.cg.mms.service.MobileService;
import com.cg.mms.service.MobileServiceImpl;

public class UpdatePurchaseDetails {

	public static void main(String[] args) {
		
		
		Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("Enter customer name:");
		String cName=scanner.nextLine();
		
		System.out.println("Enter mail id:");
		String mailId=scanner.nextLine();
		
		System.out.println("Enter phone number:");
		Long phoneNumber=scanner.nextLong();
		
       System.out.println("Enter mobile id:");
       Integer mobileId=scanner.nextInt();
       
       PurchaseDetails details=new PurchaseDetails();
       details.setcName(cName);
       details.setMailId(mailId);
       details.setMobile_id(mobileId);
       details.setPhoneNumber(phoneNumber);
       
       MobileService service=new MobileServiceImpl();
       boolean validateFlag=service.validateFields(details);
       System.out.println(validateFlag);
       
       if(validateFlag) {
    	   
    	   try {
			int Quantity= service.updateMobileQuantity(details);
		} catch (MMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	   
       }
       
    	   
       
       
      
       
	}

}
