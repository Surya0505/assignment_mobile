package com.cg.mms.presentation;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {

		int choice;
		Scanner scanner = null;

		do {
		
		System.out.println("******Mobile Management System*******");

		System.out.println("1.Insert mobile details");
		System.out.println("2.Add purchase details");
		System.out.println("3.View all mobiles");
		System.out.println("4.Delete mobile based on mobile Id");
		System.out.println("5.Search mobiles based on price range");
		System.out.println("0.Exit");
		scanner = new Scanner(System.in);

		System.out.println("Enter  your choice");
		choice = scanner.nextInt();
       
		switch (choice) {
		case 1:
			   InsertMobile mobile=new InsertMobile();
			   mobile.main(null);

			break;
		case 2:
			   UpdatePurchaseDetails details=new UpdatePurchaseDetails();
			   details.main(null);

			break;
		case 3:
			   SelectAllMobiles allMobiles=new SelectAllMobiles();
			   allMobiles.main(null);

			break;
		case 4:
			  DeleteMobileId id=new DeleteMobileId();
			  id.main(null);

			break;
		case 5: 
			    MobileBetweenRange range=new MobileBetweenRange();
			    range.main(null);

			break;
		case 0:
			     System.out.println("You are exited from the mobile management system");
			break;
		default:
			System.out.println("You have entered wrong input");
			System.out.println("please select valid choice");
			break;
		}
		}while(choice!=0);

	}

}
