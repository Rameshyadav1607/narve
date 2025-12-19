CREATE TABLE department
(
    department_id SERIAL PRIMARY KEY,
    department_name VARCHAR(50) NOT NULL,
    department_location VARCHAR(50),
    created_date DATE DEFAULT CURRENT_DATE,
    updated_date DATE
);

CREATE TABLE employee
(
    employee_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email_id VARCHAR(50) NOT NULL UNIQUE,
    phone_no VARCHAR(50) NOT NULL,
    created_date DATE DEFAULT CURRENT_DATE,
    department_id INTEGER NOT NULL,
    updated_date DATE,
    CONSTRAINT fk_department_employee
        FOREIGN KEY (department_id)
        REFERENCES public.department (department_id)
);

CREATE TABLE address
(
    address_id SERIAL PRIMARY KEY,
    house_no VARCHAR(50) NOT NULL,
    street VARCHAR(50) NOT NULL,
    country VARCHAR(50) NOT NULL,
    state_of_country VARCHAR(50) NOT NULL,
    zipcode VARCHAR(10) NOT NULL,
    employee_id INTEGER,
    CONSTRAINT fk_address_employee
        FOREIGN KEY (employee_id)
        REFERENCES public.employee (employee_id)
);
