package com.infy.springboot.microservice.microservicecrud.springbootmicroservicecrudservice;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerDetailController {

	@Autowired
	private Environment environment;
	
	@Autowired
	MyService service;

	//
	
	@RequestMapping(value= "/microservice-crud/customerdetails/all", method= RequestMethod.GET)
    public List<CustomerDetails> findAllCustomer() {
        List<CustomerDetails> customerDetails = service.getCustomer();
        return customerDetails;
    }
	
	@GetMapping("/microservice-crud/id/{id}")
	public CustomerDetails retriveCustomerDetails(@PathVariable int id) {
		Optional<CustomerDetails> customerDetails = service.getCustomerById(id);
		return customerDetails.get();
	}
	@RequestMapping(value= "/microservice-crud/add", method= RequestMethod.POST)
    public CustomerDetails createEmployee(@RequestBody CustomerDetails newCustomer) {
        System.out.println(this.getClass().getSimpleName() + " - Create new Customer.");
        return service.addNewCustomer(newCustomer);
    }
	 
	@RequestMapping(value= "/microservice-crud/update/id/{id}", method= RequestMethod.PUT)
	public CustomerDetails updateEmployee(@RequestBody CustomerDetails updCustomer, @PathVariable int id) throws Exception {
		Optional<CustomerDetails> customerDetails =  service.getCustomerById(id) ;
        if (!customerDetails.isPresent())
            throw new Exception("Could not find pk- " + id);
        if(updCustomer.getPhone() == null || updCustomer.getPhone().isEmpty())
        	updCustomer.setPhone(customerDetails.get().getPhone());
        if(updCustomer.getFirstName() == null || updCustomer.getFirstName().isEmpty())
        	updCustomer.setFirstName(customerDetails.get().getFirstName());
        if(updCustomer.getLastName() == null || updCustomer.getLastName().isEmpty())
        	updCustomer.setLastName(customerDetails.get().getLastName());
        if(updCustomer.getEmail() == null || updCustomer.getEmail().isEmpty())
        	updCustomer.setEmail(customerDetails.get().getEmail());
        if(updCustomer.getAddressLine1() == null || updCustomer.getAddressLine1().isEmpty())
        	updCustomer.setAddressLine1(customerDetails.get().getAddressLine1());
        if(updCustomer.getAddressLine2() == null || updCustomer.getAddressLine2().isEmpty())
        	updCustomer.setAddressLine2(customerDetails.get().getAddressLine2());
        if(updCustomer.getAccountNumber() == null || updCustomer.getAccountNumber().isEmpty())
        	updCustomer.setAccountNumber(customerDetails.get().getAccountNumber());
        if(updCustomer.getAccountBalance() == null || updCustomer.getAccountBalance().isEmpty())
        	updCustomer.setAccountBalance(customerDetails.get().getAccountBalance());
        
 
        // Required for the "where" clause in the sql query template.
        updCustomer.setId(id);
        return service.updateEmployee(updCustomer);
	 }
	 
	 @RequestMapping(value= "/microservice-crud/update/balance/id/{id}", method= RequestMethod.PATCH)
	 public CustomerDetails updateBalEmployee(@RequestBody CustomerDetails updCustomer, @PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Update Customer details by pk.");
 
        Optional<CustomerDetails> customerDetails =  service.getCustomerById(id) ;
        if (!customerDetails.isPresent())
            throw new Exception("Could not find pk- " + id);
 
       if(updCustomer.getPhone() == null || updCustomer.getPhone().isEmpty())
    	   updCustomer.setPhone(customerDetails.get().getPhone());
       if(updCustomer.getFirstName() == null || updCustomer.getFirstName().isEmpty())
        	updCustomer.setFirstName(customerDetails.get().getFirstName());
        if(updCustomer.getLastName() == null || updCustomer.getLastName().isEmpty())
        	updCustomer.setLastName(customerDetails.get().getLastName());
        if(updCustomer.getEmail() == null || updCustomer.getEmail().isEmpty())
        	updCustomer.setEmail(customerDetails.get().getEmail());
        if(updCustomer.getAddressLine1() == null || updCustomer.getAddressLine1().isEmpty())
        	updCustomer.setAddressLine1(customerDetails.get().getAddressLine1());
        if(updCustomer.getAddressLine2() == null || updCustomer.getAddressLine2().isEmpty())
        	updCustomer.setAddressLine2(customerDetails.get().getAddressLine2());
        if(updCustomer.getAccountNumber() == null || updCustomer.getAccountNumber().isEmpty())
        	updCustomer.setAccountNumber(customerDetails.get().getAccountNumber());
        if(updCustomer.getAccountBalance() == null || updCustomer.getAccountBalance().isEmpty())
        	updCustomer.setAccountBalance(customerDetails.get().getAccountBalance());
        
 
        // Required for the "where" clause in the sql query template.
        updCustomer.setId(id);
        return service.updateEmployee(updCustomer);
	 }
 
    @RequestMapping(value= "/microservice-crud/delete/id/{id}", method= RequestMethod.DELETE)
    public void deleteCustomerById(@PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Delete a particular customer");
 
        Optional<CustomerDetails> custDetails =  service.getCustomerById(id);
        if(!custDetails.isPresent())
            throw new Exception("Could not find id- " + id);
 
        service.deleteCustomerById(id);
    }
 
    @RequestMapping(value= "/microservice-crud/deleteall", method= RequestMethod.DELETE)
    public void deleteAll() {
        System.out.println(this.getClass().getSimpleName() + " - Delete all employees is invoked.");
        service.deleteAllCustomer();
    }
}
