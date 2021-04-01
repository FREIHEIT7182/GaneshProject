package com.example.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Cognizant;
import com.example.demo.repository.CognizantRepository;
import com.example.demo.service.CognizantService;

@RestController
@RequestMapping("/api/cog")
public class CognizantController {

	@Autowired
	private CognizantService service;
	
	
	static Logger log = Logger.getLogger(CognizantController.class.getName());
	
	
	
	@Autowired
	CognizantRepository cr;

	@PostMapping("/addEmp")
	public Cognizant addEmployees(@RequestBody Cognizant cog) {
	log.info("Get all Employees"+cog);
		return service.addEmp(cog);
	}
	
	@GetMapping("/getEmpById/{cId}")
	public Optional<Cognizant> getById(@PathVariable Integer cId) {
		/*
		 * ResponseEntity<Object> res = (ResponseEntity<Object>)service.getById(cId);
		 * return new ResponseEntity<>(res,HttpStatus.OK);
		 */
		return service.getById(cId);
	}
	
	@GetMapping("/getEmp")
	public List<Cognizant> getEmployee() {
		log.info("Get all Employees");
		return service.getEmp();
	}
	@DeleteMapping("/deleteById/{cId}")
	public Object deleteById(@PathVariable int cId) {
		log.info("Employee Deleted"+cId);
		 return new ResponseEntity<Object>(service.deleteById(cId),HttpStatus.OK);
	}
	@DeleteMapping("/deleteAll")
	public String deleteAllEmps() {
		return service.deleteAll();
	}
	
	@PutMapping("/updateObject")
	public ResponseEntity<Object> updateEmployeeObject(@RequestBody Cognizant cog) {
		return new ResponseEntity<>(service.updateEmp(cog),HttpStatus.OK);	
		}
	
	@RequestMapping(value = "/import-excels", method = RequestMethod.POST)
	public ResponseEntity<List<Cognizant>> importExcelFile1(@RequestParam("file") MultipartFile files) throws IOException {
		HttpStatus status = HttpStatus.OK;
		List<Cognizant> cogList = new ArrayList<>();
		

		XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
		XSSFSheet worksheet = workbook.getSheetAt(0);

		for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
			if (index > 0) {
				Cognizant c = new Cognizant();

				XSSFRow row = worksheet.getRow(index);
				int id = (int) row.getCell(0).getNumericCellValue();

				c.setcId(id);
				c.setcName(row.getCell(1).getStringCellValue());
				c.setDept(row.getCell(2).getStringCellValue());
				cogList.add(c);

			}

		}
		cr.saveAll(cogList);
		return new ResponseEntity<>(cogList, status);

	}
	
	@RequestMapping(value = "/listPageable", method = RequestMethod.GET)
	Page<Cognizant> employeesPageable(Pageable pageable) {
		return cr.findAll(pageable);
	}
	
	@RequestMapping(value = "/sort", method = RequestMethod.GET)
	List<Cognizant> CogSort(Pageable pageable) {
		return cr.findAll(Sort.by(Sort.Direction.DESC,"cName"));
	}
}
