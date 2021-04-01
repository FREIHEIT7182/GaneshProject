package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Cognizant;

@Repository
public interface CognizantRepository extends JpaRepository<Cognizant, Integer>{

}
