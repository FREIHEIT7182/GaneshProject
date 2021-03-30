package com.workerapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.workerapp.model.Customer;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

}
