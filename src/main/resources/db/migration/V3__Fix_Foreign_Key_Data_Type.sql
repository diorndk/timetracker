ALTER TABLE time_record 
ALTER COLUMN employee_id TYPE INT8,
ALTER COLUMN project_id TYPE INT8;

ALTER TABLE time_record
ADD CONSTRAINT fk_time_record_employee FOREIGN KEY (employee_id) REFERENCES employee(id) ON DELETE CASCADE,
ADD CONSTRAINT fk_time_record_project FOREIGN KEY (project_id) REFERENCES project(id) ON DELETE CASCADE