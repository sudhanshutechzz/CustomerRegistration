package com.cg.CustomerRegistration.DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.CustomerRegistration.DTO.CustomerDTO;

import ExceptionPackage.CustomException;

public class CustomerDAOimpljdbc implements CustomerDAO {
	public CustomerDAOimpljdbc() throws CustomException
	{
		PropertyConfigurator.configure("resource/customerlog.properties");	
	}
	Logger log=Logger.getRootLogger();

	
	
	Connection conn=DBconnectionsetup.getinstance().getConnect();
	static Map<Integer,CustomerDTO> empMap=new HashMap<Integer,CustomerDTO>();
	@Override
	public String addCustomer(CustomerDTO c) {
		
		try {
			PreparedStatement stmt=conn.prepareStatement("Insert into customer_registration values(?,?,?,?,?)");
			stmt.setInt(1, c.getCustId());
			stmt.setString(2, c.getName());
			stmt.setLong(3, c.getPhoneNo());
			stmt.setString(4, c.getAddress());
			stmt.setString(5, c.getEmail());
			int res=stmt.executeUpdate();
			
			
		} 
		
		catch (SQLException e) {
			
			throw new CustomException("Enter valid details");
		}
		return "Customer is added";
	}

	@Override
	public String deleteAllCustomer() {
		try {
			PreparedStatement stmt=conn.prepareStatement("delete from customer_registration");
		} catch (SQLException e) {
			
			throw new CustomException("Customer not deleted");
		}
		return "all customer deleted";
		
		
	}

	@Override
	public String modifyCustomerDetails(int id, String name) {
		try {
			PreparedStatement stmt=conn.prepareStatement("update customer_registration set name=? where id=?");
		stmt.setString(1, name);
		stmt.setInt(2, id);
		int res=stmt.executeUpdate();
		
		
		} catch (SQLException e) {
		
			throw new CustomException("not modified");
		}
		return "Customer modified";
	}

	@Override
	public List< CustomerDTO> fetchAllCustomer() {
		PreparedStatement prepStmt=null;
		ResultSet result=null;
		List<CustomerDTO> list;
		try {
			
			prepStmt=conn.prepareStatement("SELECT * FROM customer_registration");
			result = prepStmt.executeQuery();
			int temp;
			while(result.next()) {
				temp=result.getInt(1);
				
				empMap.put(result.getInt(1),new CustomerDTO(result.getInt(1),result.getString(2),result.getLong(3),result.getString(4),result.getString(5)));
			}
			 list=new ArrayList<CustomerDTO>(empMap.values());
			
		}
		catch(SQLException sqe) {
			throw new CustomException("SQLException "+sqe.getMessage());
		}
		return list;
	
	}

	@Override
	public CustomerDTO fetchCustomerDetailsOnName(String name) {
		CustomerDTO cd=null;
		try {
			PreparedStatement prepStmt=conn.prepareStatement("SELECT * FROM customer_registration where name=?");
			prepStmt.setString(1, name);
			ResultSet result = prepStmt.executeQuery();
			int temp;
			while(result.next())
			{temp=result.getInt(1);
		 cd=new CustomerDTO(result.getInt(1),result.getString(2),result.getLong(3),result.getString(4),result.getString(5));
				
			}
		} catch (SQLException e) {
			
			throw new CustomException("Enter valid name");
		}
		return cd;
	}

	@Override
	public String deleteCustomerBasedOnId(int id) {
		try {
			PreparedStatement prepStmt=conn.prepareStatement("delete from customer_registration where id=?");
			prepStmt.setInt(1, id);
			int res=prepStmt.executeUpdate();
			
			
		
		} catch (SQLException e) {
			
			throw new CustomException("Enter valid id");
		}
		return "Customer deleted";
	}

}
