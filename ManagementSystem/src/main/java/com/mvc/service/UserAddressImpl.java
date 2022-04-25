package com.mvc.service;

import java.util.List;

import com.mvc.bean.AddressBean;
import com.mvc.dao.UserAddressDaoImpl;

public class UserAddressImpl implements UserAddress  {

	public  UserAddressDaoImpl userdao=new UserAddressDaoImpl();
	@Override
	public void insertUserAddress(AddressBean abean) {
		// TODO Auto-generated method stub
		
		 userdao.insertUserAddress(abean);
	}
	@Override
	public List<AddressBean> ShowAddress(String id) {
		// TODO Auto-generated method stub
		return userdao.ShowAddress(id);
	}
	@Override
	public void UpdateUserAddress(AddressBean bean) {
		// TODO Auto-generated method stub
		userdao.UpdateUserAddress(bean);
	}
	@Override
	public void DeleteUserAddress(String id) {
		// TODO Auto-generated method stub
		userdao.DeleteUserAddress(id);
	}

}
