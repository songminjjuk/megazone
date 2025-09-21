package com.kimdragon.employeemanagement.service;

import com.kimdragon.employeemanagement.domain.Employee;
import com.kimdragon.employeemanagement.domain.EmployeeMasked;
import com.kimdragon.employeemanagement.exception.EmployeeNotFoundException;
import com.kimdragon.employeemanagement.repository.EmployeeMaskedRepository;
import com.kimdragon.employeemanagement.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final EmployeeMaskedRepository employeeMaskedRepository; //추가
    @Autowired
    public EmployeeService(IEmployeeRepository employeeRepository, EmployeeMaskedRepository employeeMaskedRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeMaskedRepository = employeeMaskedRepository;
    }

    @Override
    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
    // 마스킹 뷰 전체 조회
    @Override
    public List<EmployeeMasked> getAllMasked() {
        return employeeMaskedRepository.findAll();
    }
    @Override
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id:" + id));
    }
    // 마스킹 뷰 단건 조회
    @Override
    public EmployeeMasked findMaskedById(Long id) {
        return employeeMaskedRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found with id:" + id));
    }
    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

}
