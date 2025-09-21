package com.kimdragon.employeemanagement.repository;

import com.kimdragon.employeemanagement.domain.EmployeeMasked;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository   // added - 기존 IEmployeeRepository와 형식 맞춤
public interface EmployeeMaskedRepository extends JpaRepository<EmployeeMasked, Long> {
}
