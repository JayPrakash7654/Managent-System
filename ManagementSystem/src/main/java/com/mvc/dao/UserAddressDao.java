package com.mvc.dao;

import java.util.List;

import com.mvc.bean.AddressBean;

public interface UserAddressDao {

	void insertUserAddress(AddressBean abean);

	List<AddressBean> ShowAddress( String id);
	
	void UpdateUserAddress(AddressBean bean);
	
	void DeleteUserAddress(String id);
}
