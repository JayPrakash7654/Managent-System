package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.bean.AddressBean;
import com.mvc.util.DBConnection;


public class UserAddressDaoImpl implements UserAddressDao {

	@Override
	public void insertUserAddress(AddressBean abean) {
		// TODO Auto-generated method stub
		Connection con = DBConnection.createConnection();
	    

	    String sql="insert into address1(addressline1,addressline2,city,pincode,state,userid)"
	    		+ "VALUES (?,?,?,?,?,(select MAX(id) from webapp.user));";
	    		
	    
	    try {
	 
	      PreparedStatement preparedStatement = con.prepareStatement(sql);
	     
	      
	      preparedStatement.setString(1, abean.getaddressline1());
	      preparedStatement.setString(2, abean.getaddressline2());
	      preparedStatement.setString(3, abean.getcity());
	      preparedStatement.setString(4, abean.getpincode());
	      preparedStatement.setString(5, abean.getstate());

	      
	      preparedStatement.executeUpdate();
	      
	    } 
		
		catch (SQLException e) 
		{
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
		
	}
	
	@Override
	public List<AddressBean> ShowAddress(String id) {
		// TODO Auto-generated method stub
		
		Connection con = null;
	    PreparedStatement statement = null;
	    ResultSet resultSet = null;
	    List<AddressBean> userlist=new ArrayList<AddressBean>();
	    try
	    {
	        con = DBConnection.createConnection();
	        statement = con.prepareStatement("select * from address1 where user_id=?");
	        statement.setString(1, id);
	        resultSet = statement.executeQuery();
	       
	        while(resultSet.next())
	        {
	        	
				AddressBean abean=new AddressBean();
				abean.setId(resultSet.getString("id"));
				abean.setaddressline1(resultSet.getString("addressline1"));
	            abean.setaddressline2(resultSet.getString("addressline2"));
	            abean.setcity(resultSet.getString("city"));
	            abean.setpincode(resultSet.getString("pincode"));
	            abean.setstate(resultSet.getString("state"));
	            userlist.add(abean);
	            
	        }
	        
	        con.close();  
        }catch(Exception e){e.printStackTrace();}  
	    return userlist;
	}
	
	@Override
	public void UpdateUserAddress(AddressBean bean) {
		// TODO Auto-generated method stub
		
		  try{  
	    	  Connection con = DBConnection.createConnection(); 
	          PreparedStatement ps=con.prepareStatement(  
	                       "update address1 set addressline1=?,addressline2=?,city=?,pincode=?,state=? where id=?"); 
	         
	          ps.setString(1, bean.getaddressline1());
	          ps.setString(2, bean.getaddressline2());
	          ps.setString(3, bean.getcity());
	          ps.setString(4, bean.getpincode());
	          ps.setString(5, bean.getstate());
	          ps.setString(6,bean.getId());
	          ps.executeUpdate(); 
	          
	          con.close();
	      }
	      catch(Exception ex){ex.printStackTrace();}
		
	}

	@Override
	public void DeleteUserAddress(String id) {
		// TODO Auto-generated method stub
		try{  
	    	  Connection con = DBConnection.createConnection();
	          PreparedStatement ps=con.prepareStatement("delete from address1 where id=?");
	          ps.setString(1, id);
	          ps.executeUpdate(); 
	          con.close(); 
		}
		catch(Exception ex){ex.printStackTrace();}
	}

}
