ALTER TABLE employee 
ADD COLUMN employee_code VARCHAR(20);

UPDATE employee
SET employee_code = 'EMP0001' WHERE id = 101;

UPDATE employee
SET employee_code = 'EMP0002' WHERE id = 102;

ALTER TABLE employee 
ADD CONSTRAINT unique_employee_code UNIQUE (employee_code);
ALTER TABLE employee ALTER COLUMN employee_code SET NOT NULL;

-- Add more sample employee for testing
INSERT INTO employee (id, name, employee_code) VALUES 
    (103, 'John', 'EMP0003'), 
    (104, 'Cena', 'EMP0004');

INSERT INTO time_record (id, employee_id, project_id, time_from, time_to) VALUES 
    (4, 103, 1, '2025-10-28 08:30:00', '2025-10-28 17:15:00'), 
    (5, 104, 2, '2025-10-28 09:15:00', '2025-10-28 18:20:00')