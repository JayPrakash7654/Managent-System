package com.mvc.bean;
public class AddressBean {
	 
	  String id;
	  String addressline1 ;
	  String addressline2;
	  String city;
	  String pincode;
	  String state;

	  public AddressBean( String addressline1 ,
	  String addressline2,
	  String city,
	  String pincode,
	  String state) 
	  {
	    super();
	    this.addressline1 = addressline1;
	    this.addressline2 = addressline2;
	    this.city = city;
	    this.pincode = pincode;
	    this.state = state;
	    
	  }
	  public AddressBean() {
	    super();
	    // TODO Auto-generated constructor stub
	  }
	  public String getId() {
	    return id;
	  }
	  public void setId(String id) {
	    this.id = id;
	  }
	  
	  public String getaddressline1()  {
	    return addressline1;
	  }
	  public void setaddressline1(String addressline1) {
	    this.addressline1 =addressline1;
	  }
	  
	  public String getaddressline2()  {
		    return addressline2;
		  }
		  public void setaddressline2(String addressline2) {
		    this.addressline2 =addressline2;
		  }
	  public String getcity() 
	  {
		    return city;
	  }
	  public void setcity(String city)
	  {
		    this.city = city;
	  }
	  public String getpincode()
	  {
	    return pincode;
	  }
	  public void setpincode(String pincode) 
	  {
	    this.pincode = pincode;
	  }
	  public String getstate()
	  {
	    return state;
	  }
	  public void setstate(String state) 
	  {
	    this.state = state;
	  }
	  
	}
