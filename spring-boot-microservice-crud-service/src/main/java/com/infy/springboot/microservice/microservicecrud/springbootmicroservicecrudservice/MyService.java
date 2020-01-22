package com.infy.springboot.microservice.microservicecrud.springbootmicroservicecrudservice;

import java.util.List;
import java.util.Optional;

public interface MyService {

	public List<CustomerDetails> getCustomer();
	public Optional<CustomerDetails> getCustomerById(int id);
	public CustomerDetails addNewCustomer(CustomerDetails custDtls);
	public CustomerDetails updateEmployee(CustomerDetails custDtls);
	public void deleteCustomerById(int id);
	public void deleteAllCustomer();

}