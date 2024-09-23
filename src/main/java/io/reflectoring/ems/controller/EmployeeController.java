package io.reflectoring.ems.controller;

import io.reflectoring.ems.dto.EmployeeDto;
import io.reflectoring.ems.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")
public class EmployeeController {
    private EmployeeService employeeService;
    //Build add employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDto>createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee=employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    //Build Get Employee By Id Rest Api
    @GetMapping("{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long employeeId) {
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Build Get All Employees Rest Api
    @GetMapping
    public ResponseEntity<List<EmployeeDto>>getAllEmployees(){
        List<EmployeeDto>employees=employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build Update Employees Rest Api
    @PutMapping("{employeeId}")
    public ResponseEntity<EmployeeDto>updateEmployee(@PathVariable Long employeeId,@RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto=employeeService.updateEmployee(employeeId,updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //Build Delete Employees Rest Api
    @DeleteMapping("{employeeId}")
    public ResponseEntity<String>deleteEmployee(@PathVariable Long employeeId){
       employeeService.deleteEmployee(employeeId);
       return ResponseEntity.ok("Employee Deleted Successfully");
    }

}
