package com.xperiencehr.timetracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Controller
@RequestMapping("/report")
@RequiredArgsConstructor
@Slf4j
public class TimeRecordReportController {

    @GetMapping
    public String getReport() {
        return "work_hours_report";
    }
    
    
}
