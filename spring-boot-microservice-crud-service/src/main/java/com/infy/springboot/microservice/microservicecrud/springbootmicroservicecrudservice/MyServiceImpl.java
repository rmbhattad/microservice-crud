package com.infy.springboot.microservice.microservicecrud.springbootmicroservicecrudservice;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	CustomerDetailsRepository dao;
	
	

	@Override
	public List<CustomerDetails> getCustomer() {
		return dao.findAll();
	}
	@Override
	public Optional<CustomerDetails> getCustomerById(int id) {
		return dao.findById(id);
	}
	@Override
	public CustomerDetails addNewCustomer(CustomerDetails custDtls) {
		return dao.save(custDtls);
	}
	@Override
	public CustomerDetails updateEmployee(CustomerDetails custDtls) {
		return dao.save(custDtls);
	}
	@Override
	public void deleteCustomerById(int id) {
		dao.deleteById(id);
	}
	@Override
	public void deleteAllCustomer() {
		dao.deleteAll();
	}
}
