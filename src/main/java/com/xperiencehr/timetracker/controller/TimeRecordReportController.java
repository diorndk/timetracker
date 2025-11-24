package com.xperiencehr.timetracker.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xperiencehr.timetracker.dto.ReportDTO;
import com.xperiencehr.timetracker.service.TimeRecordService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/report")
@RequiredArgsConstructor
@Slf4j
public class TimeRecordReportController {

    private final TimeRecordService timeRecordService;

    @GetMapping
    public String getReport(@RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
            Authentication authentication,
            Model model) {

        if(startDate == null) {
            startDate = LocalDateTime.now().minusMonths(1);
        }

        if(endDate == null) {
            endDate = LocalDateTime.now();
        }

        String username = authentication.getName();
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"));

        log.info("User {} (role: {}) accessing report. Start Date: {}, End Date: {}", username, isAdmin ? "ADMIN" : "EMPLOYEE", startDate, endDate);

        List<ReportDTO> reportData;
        
        if(isAdmin) {
            reportData = timeRecordService.getAllEmployeeTimeRecord(startDate, endDate);
        } else {
            reportData = timeRecordService.getEmployeeTimeRecordByEmployee(username, startDate, endDate);
        }

        model.addAttribute("reportData", reportData);
        model.addAttribute("username", username);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);

        return "work_hours_report";
    }
    
    
}
