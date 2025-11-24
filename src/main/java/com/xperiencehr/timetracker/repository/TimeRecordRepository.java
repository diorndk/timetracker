package com.xperiencehr.timetracker.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.xperiencehr.timetracker.dto.ReportDTO;
import com.xperiencehr.timetracker.entity.TimeRecord;

@Repository
public interface TimeRecordRepository extends JpaRepository<TimeRecord, Long> {
    
    @Query(value = "SELECT e.employee_code AS employeeCode, " +
                   "e.name AS employeeName, " +
                   "p.name AS projectName, " +
                   "SUM(EXTRACT(EPOCH FROM (tr.time_to - tr.time_from)) / 3600) AS hoursWorked " +
                   "FROM time_record tr " +
                   "JOIN employee e ON e.id = tr.employee_id " +
                   "JOIN project p ON p.id = tr.project_id " +
                   "WHERE tr.time_from BETWEEN :startDate AND :endDate " +
                   "GROUP BY e.employee_code, e.name, p.name " +
                   "ORDER BY e.name, p.name",
           nativeQuery = true)
    List<ReportDTO> getAllReportData(
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate);
    
    @Query(value = "SELECT e.employee_code AS employeeCode, " +
                   "e.name AS employeeName, " +
                   "p.name AS projectName, " +
                   "SUM(EXTRACT(EPOCH FROM (tr.time_to - tr.time_from)) / 3600) AS hoursWorked " +
                   "FROM time_record tr " +
                   "JOIN employee e ON e.id = tr.employee_id " +
                   "JOIN project p ON p.id = tr.project_id " +
                   "WHERE tr.time_from BETWEEN :startDate AND :endDate " +
                   "AND e.employee_code = :employeeCode " +
                   "GROUP BY e.employee_code, e.name, p.name " +
                   "ORDER BY e.name, p.name",
           nativeQuery = true)
    List<ReportDTO> getReportDataByEmployee(
        @Param("startDate") LocalDateTime startDate,
        @Param("endDate") LocalDateTime endDate,
        @Param("employeeCode") String employeeCode);
}