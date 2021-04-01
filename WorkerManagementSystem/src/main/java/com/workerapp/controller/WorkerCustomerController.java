package com.workerapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workerapp.model.Customer;
import com.workerapp.model.Worker;
import com.workerapp.service.WorkerCustomerService;

@RestController
@RequestMapping("/workerManagementSystem/api")
public class WorkerCustomerController {

	@Autowired
	private WorkerCustomerService service;

	// set Worker data
	@PostMapping()
	public ResponseEntity<Object> createWorker(@RequestBody Worker worker) {
		ResponseEntity<Object> res = (ResponseEntity<Object>) service.createWorker(worker);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	// set customer data

	@PostMapping("/addCustomer")
	public ResponseEntity<Object> createCustomer(@RequestBody Customer customer) {
		ResponseEntity<Object> res = (ResponseEntity<Object>) service.createCustomer(customer);
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@GetMapping("/getAllWorkers")
	public Iterable<Worker> getAllWorkers() {
		return service.getAllWorkers();
	}

	@GetMapping("/getAllCustomers")
	public Iterable<Customer> getAllCustomers() {
		return service.getAllCustomers();
	}
	@GetMapping("/getAllWorkersInSortingOrder")
	public Iterable<Worker> SortedOrderWorkers() {
		return service.getAllWorkersSort();
	}
	
	@GetMapping("/getAllWorkersPagination/{pageNo}/{pageSize}")
	public Iterable<Worker> PaginationWorkers(@PathVariable int pageNo, @PathVariable int pageSize) {
		return service.getAllWorkersPage(pageNo,pageSize);
	}
	

}
