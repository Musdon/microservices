package com.musdon.employeeservice.service.impl;

import com.musdon.employeeservice.dto.APiResponseDto;
import com.musdon.employeeservice.dto.DepartmentDto;
import com.musdon.employeeservice.dto.EmployeeDto;
import com.musdon.employeeservice.entity.Employee;
import com.musdon.employeeservice.repository.EmployeeRepository;
import com.musdon.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = Employee.builder()
                .id(employeeDto.getId())
                .firstName(employeeDto.getFirstName())
                .lastName(employeeDto.getLastName())
                .email(employeeDto.getEmail())
                .departmentCode(employeeDto.getDepartmentCode())
                .build();
        Employee savedEmployee = employeeRepository.save(employee);

        return EmployeeDto.builder()
                .id(savedEmployee.getId())
                .firstName(savedEmployee.getFirstName())
                .lastName(savedEmployee.getLastName())
                .email(savedEmployee.getEmail())
                .departmentCode(savedEmployee.getDepartmentCode())
                .build();
    }

    @Override
    public APiResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).get();
        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(),
                DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = EmployeeDto.builder()
                .id(employee.getId())
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();
        APiResponseDto aPiResponseDto = new APiResponseDto();
        aPiResponseDto.setEmployeeDto(employeeDto);
        aPiResponseDto.setDepartmentDto(departmentDto);
        return aPiResponseDto;
    }
}
