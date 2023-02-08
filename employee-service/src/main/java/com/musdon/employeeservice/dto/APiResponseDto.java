package com.musdon.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APiResponseDto {
    private EmployeeDto employeeDto;
    private DepartmentDto departmentDto;
}
