package io.reflectoring.ems.mapper;

import io.reflectoring.ems.dto.EmployeeDto;
import io.reflectoring.ems.entity.Employee;

public class EmployeeMapper {
    // Employee -> EmployeeDto dönüşümü
    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return  new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    // EmployeeDto -> Employee dönüşümü
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
