package com.infy.springboot.microservice.microservicecrud.springbootmicroservicecrudservice;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Integer>{

	
}
