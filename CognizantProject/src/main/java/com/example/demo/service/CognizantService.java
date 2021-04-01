package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cognizant;
import com.example.demo.repository.CognizantRepository;

import repository.IdNotFoundException;

@Service
public class CognizantService {
	
	@Autowired
	private CognizantRepository repository;

	//Logger log = Logger.getLogger(CognizantService.class);
	
	public Cognizant addEmp(Cognizant cog) {
		// TODO Auto-generated method stub
		return  repository.save(cog);
	}

	public List<Cognizant> getEmp() {
		// TODO Auto-generated method stub
		//log.info("Displaying all the employee Details");
		return repository.findAll();
	}

	public Object deleteById(int cId) {
		// TODO Auto-generated method stub
		Optional<Cognizant> op = repository.findById(cId);
		if(op.isPresent()) {
			repository.deleteById(cId);
			return new ResponseEntity<Object>(HttpStatus.OK);
		}
		  
		else {
			return new ResponseEntity<Object>(new IdNotFoundException("Record not found"), HttpStatus.NOT_FOUND);
		}
	}

	public String deleteAll() {
		// TODO Auto-generated method stub
		repository.deleteAll();
		return "All Employees Deleted Successfully!";
	}

	public Object updateEmp(Cognizant cog) {
		Optional<Cognizant> op = repository.findById(cog.getcId());
		if(op.isPresent()) {
			
			return new ResponseEntity<Object>(repository.save(cog),HttpStatus.OK);
		}else {			
			return new ResponseEntity<Object>(new IdNotFoundException("Record not found"), HttpStatus.NOT_FOUND);

		}
		
	}

	public Optional<Cognizant> getById(int cId) {
		return repository.findById(cId);
		// TODO Auto-generated method stub
		/*
		 * Optional<Cognizant> op = repository.findById(cId);
		 * 
		 * 
		 * if(!op.isPresent()) { return new ResponseEntity<Object>(new
		 * IdNotFoundException("Record not found"), HttpStatus.NOT_FOUND); } return new
		 * ResponseEntity<Object>(repository.findById(cId),HttpStatus.OK);
		 */
		 
	}

	public Page<Cognizant> listAll(int pageNum) {
	    int pageSize = 5;
	     
	    Pageable pageable = PageRequest.of(pageNum - 1, pageSize);
	     
	    return repository.findAll(pageable);
	}
	
	
	
	

}
