package com.in28minutes.Springboot.web.springbootfirstwebapplication.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.in28minutes.Springboot.web.springbootfirstwebapplication.repository.EmployeeRepository;
import com.in28minutes.Springboot.web.springbootfirstwebapplication.service.Employee;
import com.in28minutes.Springboot.web.springbootfirstwebapplication.service.EmployeeService;

@Controller
public class EmployeeController
{
	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private static final org.slf4j.Logger log = 
			LoggerFactory.getLogger(EmployeeController.class); //Loggers from Logger Factory

	//Initbinder to bind certain format to the relevant class. It binds using Web data binder
	@InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
		//Date dd/MM/yyyy
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, false));
	}

	@RequestMapping(value="/employeeForm", method = RequestMethod.GET)
	public String employeeForm(ModelMap model) {
		model.addAttribute("employee", new Employee()); //Default object. This requires if we use Spring commandline tag in .JSP
		return "EmployeeInfo";
	}

	//	@RequestMapping(value="/employeeForm", method = RequestMethod.POST)
	//	public String addEmployee(@RequestParam String empName, @RequestParam String empId) {
	//		if(empService.addEmployee(empName, empId)) {
	//			return "redirect:/EmployeeReport";
	//		}
	//		return "error";
	//	}

	//Above mapping has problem if request param is added with new field or form has too many request params.
	//Instead use CommandBean
	//Add @Valid to employee bean. This is marker that validation must be carried out.
	//Check Employee class properties for @size similar annotations
	@RequestMapping(value="/employeeForm", method = RequestMethod.POST)
	public String addEmployee(@Valid Employee employee, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/employeeForm";
		}

		if(empService.addEmployee(employee.getEmpName(), employee.getEmpId(), employee.getDob())) {
			return "redirect:/EmployeeReport";
		}

		return "error";
	}
	
//	//Using RESTful/Json
//	@PostMapping("/GeneratePayslip/{empId}")
//	public ResponseEntity<Void> postPaySlip(@PathVariable String empId, @RequestBody PaystubService paystub) { //JSON would be mapped using @RequestBody
//		
//		boolean result = empService.addPaySlip(paystub);
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/error")
//				.buildAndExpand(result).toUri();
//		if(result) {
//			location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{empId}")
//					.buildAndExpand(paystub.getCheckNo()).toUri();
//			//Status
//			return ResponseEntity.created(location).build();
//			
//		}
//		
//		return ResponseEntity.noContent().build();
//	}

	@Value("${employee.page.EmployeeReport}")
	private String employeeReportPageName; //Autowired from application.properties
	
	@RequestMapping(value = "/EmployeeReport", method = RequestMethod.GET)
	public String dispEmployeeList() {
		return employeeReportPageName;
	}
	
	
	@RequestMapping(value="/EmployeeSearch", method = RequestMethod.GET)
	public String getEmployeeSearchPage() {
		return "EmployeeSearch";
	}

	@RequestMapping(value="/EmployeeSearch", method = RequestMethod.POST)
	public String getEmployeeSearchPage(@RequestBody String empId, ModelMap model) {
		model.addAttribute("empObj", empService.getEmployee(empId)); //Default object. This requires if we use Spring commandline tag in .JSP
		
		return "EmpDetailsRaw";
	}
	
	@RequestMapping(value="/addToDatabase")
	public String addtoDatabase() {
		Employee e = new Employee();
		e.setEmpId(666);
		e.setEmpName("ramkiiiii");
		e.setDob(new Date());
		employeeRepository.save(e);
		
		return "EmployeeReport";
	}

}