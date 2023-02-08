package com.musdon.employeeservice.service;

import com.musdon.employeeservice.dto.APiResponseDto;
import com.musdon.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APiResponseDto getEmployeeById(Long employeeId);
}
