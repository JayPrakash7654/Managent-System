package com.mvc.service;

import java.util.List;

import com.mvc.bean.AddressBean;

public interface UserAddress {

	void insertUserAddress(AddressBean abean);
	
	List<AddressBean> ShowAddress(String id);
	 
	void UpdateUserAddress(AddressBean bean);
	
	void DeleteUserAddress(String id);
	
}
