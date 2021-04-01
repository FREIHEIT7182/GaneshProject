package com.workerapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.workerapp.model.Customer;
import com.workerapp.model.Worker;
import com.workerapp.repo.CustomerDao;
import com.workerapp.repo.WorkerDAO;
@Service
public class WorkerCustomerService {

	@Autowired
	private WorkerDAO repository;
	
	@Autowired
	private CustomerDao repository1;
	public ResponseEntity<Object> createWorker(Worker worker) {
		
		return new ResponseEntity<Object>(repository.save(worker),HttpStatus.OK);
	}
    
	public ResponseEntity<Object> createCustomer(Customer customer) {
		return new ResponseEntity<Object>(repository1.save(customer),HttpStatus.OK);
	}

	public Iterable<Worker> getAllWorkers() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}
	public Iterable<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return repository1.findAll();
	}

	public Iterable<Worker> getAllWorkersSort() {
		// TODO Auto-generated method stub
		return repository.findAll(Sort.by("yearsOfExperience").descending());
	}

	public Iterable<Worker> getAllWorkersPage(int pageNo, int pageSize) {
		
		Pageable page = PageRequest.of(pageNo, pageSize);
		return repository.findAll(page);
	}
	
	
}
