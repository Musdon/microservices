package com.musdon.employeeservice.controller;

import com.musdon.employeeservice.dto.APiResponseDto;
import com.musdon.employeeservice.dto.EmployeeDto;
import com.musdon.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<APiResponseDto> getEmployee(@PathVariable("id") Long employeeId){
        APiResponseDto aPiResponseDto = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(aPiResponseDto, HttpStatus.OK);
    }
}
