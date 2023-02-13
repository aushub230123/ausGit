INSERT INTO employees VALUES (10,'BILL',5000);
INSERT INTO employees VALUES (11,'BELL',5000);
SELECT * FROM employees;
SELECT * FROM REGISTRATIONS;


create table employees (employee_id integer not null, first_name varchar(255) not null, salary integer not null, primary key (employee_id));


 create table employees_del (employee_id integer not null, first_name varchar(255) not null, salary integer not null, primary key (employee_id)) ;
 create table hibernate_sequence (next_val bigint);
 insert into hibernate_sequence values ( 1 );

# create table EMPLOYEE_ID_GENERATOR_SEQUENCE (next_val bigint);
create table HIBERNATE_SEQUENCE (next_val bigint);

# CREATE SEQUENCE EMPLOYEE_ID_GENERATOR_SEQUENCE START WITH 1000;