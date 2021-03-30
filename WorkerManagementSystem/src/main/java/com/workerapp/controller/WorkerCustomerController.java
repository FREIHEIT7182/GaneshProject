package com.workerapp.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workerapp.model.Customer;
import com.workerapp.model.Worker;
import com.workerapp.service.WorkerCustomerService;
@RestController
@RequestMapping("/workerManagementSystem")
public class WorkerCustomerController {
	
	
	@Autowired
	private WorkerCustomerService service;
	
	
	@PostMapping("/addWorker")
	public ResponseEntity<Object> createWorker(@RequestBody Worker worker ){
		ResponseEntity<Object> res = (ResponseEntity)service.createWorker(worker);
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	//Gani
//@PostMapping("/addCustomer")
//	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer ){
//		ResponseEntity<Object> res = (ResponseEntity)service.createCustomer(customer);
//		return new ResponseEntity<>(res,HttpStatus.OK);
//	}
//	

}
