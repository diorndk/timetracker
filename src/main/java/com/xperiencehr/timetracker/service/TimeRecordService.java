package com.xperiencehr.timetracker.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xperiencehr.timetracker.dto.ReportDTO;
import com.xperiencehr.timetracker.repository.TimeRecordRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class TimeRecordService {

    private final TimeRecordRepository timeRecordRepository;

    public List<ReportDTO> getAllEmployeeTimeRecord(LocalDateTime startDate, LocalDateTime endDate) {
        log.info("fetching all time record");
        List<ReportDTO> result = timeRecordRepository.getAllReportData(startDate, endDate);

        return result;
    }

    public List<ReportDTO> getEmployeeTimeRecordByEmployee(String employeeCode, LocalDateTime startDate, LocalDateTime endDate) {
        log.info("fetching time record for employee {}", employeeCode);
        List<ReportDTO> result = timeRecordRepository.getReportDataByEmployee(startDate, endDate, employeeCode);

        return result;
    }
    
}
