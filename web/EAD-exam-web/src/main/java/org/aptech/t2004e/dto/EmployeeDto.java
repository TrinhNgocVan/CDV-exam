package org.aptech.t2004e.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private Long id;
    private String name;
    private double salary;

    public EmployeeDto(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
