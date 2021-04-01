package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.model.Cognizant;
import com.example.demo.repository.CognizantRepository;
import com.example.demo.service.CognizantService;

@SpringBootTest
class CognizantProjectApplicationTests {

	@MockBean
	private CognizantRepository repository;
	
	@Autowired
	private CognizantService service;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getEmpsTest() {
		when(repository.findAll()).thenReturn(Stream.of(new Cognizant(108, "ganesh","IT"), new Cognizant(109, "palli","IDM")).collect(Collectors.toList()));
		assertEquals(2, service.getEmp().size());
	}
	
	
	@Test
	public void saveEmpTest() {
		List<Cognizant> list = null;
		Cognizant cog =  new Cognizant(199,"top","IT");
		
		when(repository.save(cog)).thenReturn(cog);
		assertEquals(list, service.addEmp(cog));
	}
}
