package dashboard.employee.controllers;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import dashboard.employee.entities.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home() {
		return "HOLA MUNDO DESDE EL DASHBOARD DE EMPLEADOS: " + env.getProperty("local.server.port");
	}

	@RequestMapping("/listar")
	public Collection<EmployeeInfo> getemployees() {
		Collection<EmployeeInfo> list = restTemplate.getForObject("http://employee-service/employee/findall", Collection.class);
		return list;
	}

	@RequestMapping("/buscar/{id}")
	@HystrixCommand( fallbackMethod = "defaultMe" )
	public EmployeeInfo getempoyees(@PathVariable Long id){
		EmployeeInfo emp = restTemplate.getForObject("http://employee-service/employee/find/"+id, EmployeeInfo.class);
		return emp;
	}

	private EmployeeInfo defaultMe(Long id){
		EmployeeInfo info = new EmployeeInfo();
		info.setEmployeeId(id);
		info.setName("sin datos");
		info.setCompanyInfo("sin datos");
		info.setDesignation("sin datos");
		return info;
	}
}