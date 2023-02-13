CREATE SEQUENCE EMPLOYEE_ID_GENERATOR_SEQUENCE START WITH 1000;
CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1000;
SELECT nextval('EMPLOYEE_ID_GENERATOR_SEQUENCE');


create table employees (employee_id int4 not null, first_name varchar(255) not null, salary int4 not null, primary key (employee_id));
create table registrations (email varchar(25) not null, admin_name varchar(25) not null, password varchar(255), phone varchar(255), primary key (email))
create sequence hibernate_sequence start 1 increment 1

SELECT * FROM registrations;