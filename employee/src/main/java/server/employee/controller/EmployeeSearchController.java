package server.employee.controller;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.employee.model.Employee;
import server.employee.services.EmployeeSearchService;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeSearchController {
    @Autowired
    EmployeeSearchService employeeSearchService;
    @Autowired
    private Environment env;

    @RequestMapping("/")
    public String home() {
        return "HOLA MUNDO DESDE EMPLEADOS: " + env.getProperty("local.server.port");
    }

    @RequestMapping("/employee/find/{id}")
    public Employee findById(@PathVariable Long id){
        return employeeSearchService.findById(id);
    }
    @RequestMapping("/employee/findall")
    public Collection<Employee> findAll(){
        return employeeSearchService.findAll();
    }
}

