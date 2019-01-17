package com.cg.mms.dao.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.mms.dao.MobileDao;
import com.cg.mms.dao.MobileDaoImpl;
import com.cg.mms.exceptions.MMSException;
import com.cg.mms.model.Mobiles;

public class MobileDaoImplTest {

	MobileDao mobileDao=null;
	
	@Before
	public void setUp() throws Exception {
	mobileDao=new MobileDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
	mobileDao=null;
	}

	@Test
	public void testInsertMobileData() {
		
		Mobiles mobiles=new Mobiles();
		mobiles.setMobileId(1007);
		mobiles.setName("Xiaomi");
		mobiles.setPrice(24000.00);
		mobiles.setQuantity(10);
		
		try {
			int id=mobileDao.insertMobileData(mobiles);
			assertEquals(1, id);
			
		} catch (MMSException e) {
			
			e.printStackTrace();
		}
		
		//fail("Not yet implemented");
	}

	@Test
	public void testMobileBetweenRange() {
		
		double range1=10000;
		double range2=20000;
	   List<Mobiles> list=new ArrayList<>();	
		try {
			list=mobileDao.mobileBetweenRange(range1, range2);
			assertEquals(3, list.size());
		} catch (MMSException e) {
			
			e.printStackTrace();
		}
		
		
		
		//fail("Not yet implemented");
	}

}
