package com.kimdragon.employeemanagement.domain;

import io.swagger.annotations.ApiModel;

import javax.persistence.*;                  // added

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.Immutable;       // added

@Entity                                          // added
@Table(name = "v_employee_masked")               // added - 뷰 이름에 매핑
@Immutable                                       // added - 읽기 전용
public class EmployeeMasked {                    // added
    @Id                                        // added
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    private String emailAddress;                  // added

    protected EmployeeMasked() {}                 // added

    public Long getId() { return id; }           // added
    public String getEmailAddress() { return emailAddress; } // added
    public String getFirstName() { return firstName; }       // added
    public String getLastName() { return lastName; }         // added
}