package com.musdon.departmentservice.service.impl;

import com.musdon.departmentservice.dto.DepartmentDto;
import com.musdon.departmentservice.entity.Department;
import com.musdon.departmentservice.repository.DepartmentRepository;
import com.musdon.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        //convert department to department jpa entity
        Department department = Department.builder()
                .id(departmentDto.getId())
                .departmentName(departmentDto.getDepartmentName())
                .departmentDescription(departmentDto.getDepartmentDescription())
                .departmentCode(departmentDto.getDepartmentCode())
                .build();
        Department savedDepartment = departmentRepository.save(department);
        DepartmentDto savedDepartmentDto = DepartmentDto.builder()
                .id(savedDepartment.getId())
                .departmentName(savedDepartment.getDepartmentName())
                .departmentDescription(savedDepartment.getDepartmentDescription())
                .departmentCode(savedDepartment.getDepartmentCode())
                .build();
        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code);
        DepartmentDto departmentDto = DepartmentDto.builder()
                .id(department.getId())
                .departmentName(department.getDepartmentName())
                .departmentDescription(department.getDepartmentDescription())
                .departmentCode(department.getDepartmentCode())
                .build();
        return departmentDto;
    }
}
