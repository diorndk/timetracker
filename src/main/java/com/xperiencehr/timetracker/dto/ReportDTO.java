package com.xperiencehr.timetracker.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {
    private String employeeCode;
    private String employeeName;
    private String projectName;
    private BigDecimal hoursWorked;
}
