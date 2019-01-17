package com.cg.mms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.management.Query;

import com.cg.mms.exceptions.MMSException;
import com.cg.mms.model.Mobiles;
import com.cg.mms.model.PurchaseDetails;
import com.cg.mms.utility.JdbcUtility;

public class MobileDaoImpl implements MobileDao {

	Connection connection = null;
	Statement state = null;
	PreparedStatement statement = null;
	ResultSet resultSet = null;

	@Override
	public void createTable() throws MMSException {

		connection = JdbcUtility.getConnection();

		try {

			state = connection.createStatement();
			state.executeQuery(QueryMapper.createQuery);
		} catch (SQLException e) {
			throw new MMSException("statement not created");
		} finally {

			try {
				state.close();
			} catch (SQLException e) {
				throw new MMSException("Statement not closed");

			}

			try {
				connection.close();
			} catch (SQLException e) {
				throw new MMSException("connection not closed");
			}

		}

	}

	@Override
	public int insertMobileData(Mobiles mobiles) throws MMSException {

		connection = JdbcUtility.getConnection();
		int result = 0;

		try {
			statement = connection.prepareStatement(QueryMapper.insertQuery);
			statement.setInt(1, mobiles.getMobileId());
			statement.setString(2, mobiles.getName());
			statement.setDouble(3, mobiles.getPrice());
			statement.setInt(4, mobiles.getQuantity());
			result = statement.executeUpdate();

		} catch (SQLException e) {
			throw new MMSException("prepare statement not created");
		} finally {

			try {
				statement.close();
			} catch (SQLException e) {
				throw new MMSException("statement not closed");

			}

			try {
				connection.close();
			} catch (SQLException e) {
				throw new MMSException("connection not closed");
			}

		}

		return result;
	}

	@Override
	public int updateMobileQuantity(PurchaseDetails details) throws MMSException {
		connection = JdbcUtility.getConnection();
		boolean result = false;
		// ResultSet resultSet2=null;
		//Mobiles mobiles = new Mobiles();
		// int result1=0;
		try {
			statement = connection.prepareStatement(QueryMapper.checkMobileId);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Integer id = resultSet.getInt("mobile_id");
				if (id.equals(details.getMobile_id())) {

					// statement=connection.prepareStatement(QueryMapper.selectQueryToUpdate);
					// statement.setInt(1, details.getMobile_id());
					// resultSet2=statement.executeQuery();

					// resultSet2.next();
					Integer id2 = resultSet.getInt("mobile_id");
					Integer quantity = resultSet.getInt("quantity");
                         
					if(quantity>0)
					{
					statement = connection.prepareStatement(QueryMapper.updateQuantity);
					statement.setInt(2, id2);
					statement.setInt(1, quantity - 1);
					statement.executeUpdate();
					System.out.println("Updated");

					statement = connection.prepareStatement(QueryMapper.insertPurchaseDetails);
					statement.setString(1, details.getcName());
					statement.setString(2, details.getMailId());
					statement.setLong(3, details.getPhoneNumber());
					statement.setInt(4, details.getMobile_id());
					statement.executeUpdate();

					result = true;
					break;
					}else
					{
						System.out.println("Mobiles have been sold out. We don't have that type of mobiles to sell");
					}

				}

			}

			if (!result) {
				System.out.println("No mobile is present with the given id");
			}
			// if(result) {
			// statement=connection.prepareStatement(QueryMapper.updateQuantity);
			// statement.setInt(2, details.getMobile_id());
			// statement.setInt(1,mobiles.getQuantity()-1 );
			//
			//
			// statement=connection.prepareStatement(QueryMapper.insertPurchaseDetails);
			// statement.setString(1, details.getcName());
			// statement.setString(2, details.getMailId());
			// statement.setLong(3, details.getPhoneNumber());
			// statement.setInt(4, details.getMobile_id());
			// statement.executeUpdate();
			//
			//
			//
			//
			//
			//// resultSet=statement.executeQuery();
			//// while(resultSet.next()) {
			//// Integer mobileId=resultSet.getInt(1);
			//// if(mobileId==details.getMobile_id()) {
			////
			////
			//// }
			//// }
			//
			//
			//
			//
			//
			// }else
			// {
			// System.out.println("Updation can not be performed because ");
			// }

		} catch (SQLException e) {
			throw new MMSException("Prepare statement not created");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e1) {
				throw new MMSException("resultSet not closed");
			}

			try {
				statement.close();
			} catch (SQLException e) {
				throw new MMSException("statement not closed");

			}

			try {
				connection.close();
			} catch (SQLException e) {
				throw new MMSException("connection not closed");
			}

		}

		return 0;
	}

	@Override
	public List<Mobiles> selectAllMobiles() throws MMSException {

		connection = JdbcUtility.getConnection();
		List<Mobiles> list = new ArrayList<>();

		try {
			statement = connection.prepareStatement(QueryMapper.selectAllMobiles);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("mobile_id");
				String name = resultSet.getString("name");
				Double price = resultSet.getDouble("price");
				Integer quantity = resultSet.getInt("quantity");
				Mobiles mobiles = new Mobiles();
				mobiles.setMobileId(id);
				mobiles.setName(name);
				mobiles.setPrice(price);
				mobiles.setQuantity(quantity);
				list.add(mobiles);

			}
		} catch (SQLException e) {

			throw new MMSException("prepare statement not created");
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e1) {
				throw new MMSException("resultSet not closed");
			}

			try {
				statement.close();
			} catch (SQLException e) {
				throw new MMSException("statement not closed");

			}

			try {
				connection.close();
			} catch (SQLException e) {
				throw new MMSException("connection not closed");
			}

		}

		return list;
	}

	@Override
	public int DeleteMobileRow(Integer id) throws MMSException {
		int result = 0;
		connection = JdbcUtility.getConnection();
		//PreparedStatement statement=null;
             
		
		try {
			statement = connection.prepareStatement(QueryMapper.DeleteMobileRow);
			//System.out.println("once");
			statement.setInt(1, id);
			//System.out.println("22222");
			result = statement.executeUpdate();

		}
		/*		
		try {
				state = connection.createStatement();
				System.out.println("once");
		//		statement.setInt(1, id);
				System.out.println("22222");
				result = state.executeUpdate("delete from mobiles_table where mobile_id=" + id);
		}*/catch (SQLException e) {
			throw new MMSException("prepare statement not created"+e);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				throw new MMSException("statement not closed" + e);

			}

			try {
				connection.close();
			} catch (SQLException e) {
				throw new MMSException("connection not closed");
			}

		}

		return result;
	}

	@Override
	public List<Mobiles> mobileBetweenRange(Double range1, Double range2) throws MMSException {
		List<Mobiles> list=new ArrayList<>();
		
		connection=JdbcUtility.getConnection();
		
		try {
			statement=connection.prepareStatement(QueryMapper.selectMobileRange);
			statement.setDouble(1, range1);
			statement.setDouble(2, range2);
			resultSet=statement.executeQuery();
			while(resultSet.next()) {
				
				int id = resultSet.getInt("mobile_id");
				String name = resultSet.getString("name");
				Double price = resultSet.getDouble("price");
				Integer quantity = resultSet.getInt("quantity");
				Mobiles mobiles = new Mobiles();
				mobiles.setMobileId(id);
				mobiles.setName(name);
				mobiles.setPrice(price);
				mobiles.setQuantity(quantity);
				list.add(mobiles);
				
			}
			
			
		} catch (SQLException e) {
			throw new MMSException("prepare statement not created");
		}
		finally {
			try {
				resultSet.close();
			} catch (SQLException e1) {
				throw new MMSException("resultSet not closed");
			}

			try {
				statement.close();
			} catch (SQLException e) {
				throw new MMSException("statement not closed");

			}

			try {
				connection.close();
			} catch (SQLException e) {
				throw new MMSException("connection not closed");
			}

		}

		
		
		
		
		
		return list;
	}

}
