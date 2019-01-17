package com.cg.mms.dao;

import java.util.List;

import com.cg.mms.exceptions.MMSException;
import com.cg.mms.model.Mobiles;
import com.cg.mms.model.PurchaseDetails;

public interface MobileDao {

	void createTable() throws MMSException;

	int insertMobileData(Mobiles mobiles) throws MMSException;

	int updateMobileQuantity(PurchaseDetails details) throws MMSException;

	List<Mobiles> selectAllMobiles() throws MMSException;

	int DeleteMobileRow(Integer id) throws MMSException;

	List<Mobiles> mobileBetweenRange(Double range1, Double range2) throws MMSException;

}
