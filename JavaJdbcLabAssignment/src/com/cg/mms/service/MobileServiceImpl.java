package com.cg.mms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import com.cg.mms.dao.MobileDao;
import com.cg.mms.dao.MobileDaoImpl;
import com.cg.mms.exceptions.MMSException;
import com.cg.mms.model.Mobiles;
import com.cg.mms.model.PurchaseDetails;

public class MobileServiceImpl implements MobileService {

	
     MobileDao mobileDao=new MobileDaoImpl();	
	
	@Override
	public void createTable() throws MMSException {
		
		
		mobileDao.createTable();
		
	}

	@Override
	public int insertMobileData(Mobiles mobiles) throws MMSException {
		
		return mobileDao.insertMobileData(mobiles);
	}

	@Override
	public boolean validateFields(PurchaseDetails details) {
		List<String> list=new ArrayList<>();
		boolean resultFlag=false;
		
		if(!checkName(details.getcName())) {
			
			list.add("Name should start with uppercase letters and max length is of 20");
			
		}
		
		if(!checkMailId(details.getMailId())) {
			
			list.add("Mailid should contain @ and start with only characters");
		}
		if(!checkPhoneNumber(details.getPhoneNumber()))
		{
			
			list.add("Phone number should be of 10 digits only and should start with 6|7|8|9");
		}
		if(!checkMobileId(details.getMobile_id())) {
			list.add("Moible id should be of 4 digits only and should contain only digits");
			
		}
		
		if(!list.isEmpty()) {
			
			
			System.out.println(list+"");
		}else
		{
			resultFlag=true;
		}
		
		
		return resultFlag;
		
	}
	public boolean checkName(String name) {
		String regEx="[A-Z]{1}[A-Za-z\\s]{1,19}$";
		
		return Pattern.matches(regEx, name);
		
	}
	public boolean checkMailId(String mailId) {
		
		String regEx="[a-zA-Z]{1}[a-zA-Z0-9._]*@[A-Za-z]*\\.[a-zA-Z]*";
		return Pattern.matches(regEx, mailId);
	}
	public boolean checkPhoneNumber(Long phoneNumber) {
	
		String regEx="[6|7|8|9]{1}[0-9]{9}$";
		return Pattern.matches(regEx, phoneNumber.toString());
	}
	public boolean checkMobileId(Integer mobileId) {
		
		String regEx="[0-9]{4}$";
		
		return Pattern.matches(regEx, mobileId.toString());
		
		
	}

	@Override
	public int updateMobileQuantity(PurchaseDetails details) throws MMSException {
		
		return mobileDao.updateMobileQuantity(details);
	}

	@Override
	public List<Mobiles> selectAllMobiles() throws MMSException {
		
		return mobileDao.selectAllMobiles();
	}

	@Override
	public int DeleteMobileRow(Integer id) throws MMSException {
		
		return mobileDao.DeleteMobileRow(id);
	}

	@Override
	public List<Mobiles> mobileBetweenRange(Double range1, Double range2) throws MMSException {
		// TODO Auto-generated method stub
		return mobileDao.mobileBetweenRange(range1,range2);
	}
	
	

}
