-- SWITCH TO A DATABASE
USE SAKILA;
SELECT * FROM SAKILA.ACTOR;
SELECT ACTOR_ID, LAST_NAME, FIRST_NAME FROM ACTOR;


CREATE DATABASE TESTDB1;
USE TESTDB1;
-- CREATE TABLE PRODUCTS (PRODUCT_ID INT NULL , PRODUCT_NAME CHAR(50) NULL, PRICE FLOAT NULL);
CREATE TABLE PRODUCTS (PRODUCT_ID INT NOT NULL, PRODUCT_NAME CHAR(50), PRICE FLOAT);
SELECT * FROM PRODUCTS;
INSERT INTO PRODUCTS  VALUES (1, 'SWW',155.50);
INSERT INTO PRODUCTS  VALUES (2, NULL,155.50);
INSERT INTO PRODUCTS  VALUES (1, 'NULL',155.50);
INSERT INTO PRODUCTS  VALUES (1, 'NOT NULL',155.50);
DELETE FROM PRODUCTS WHERE PRODUCT_NAME = 'NOT NULL';
-- COUNT (*) COUNTS ALL THE ROWS
-- COUNT (COLUMN) COUNT OF ALL NON NULL VAUES
-- COUNT (DISTINCT COLUMN) COUNT OF ALL THE DISTINCT COLUMN VALUES

SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = NULL;
SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = 'NULL';
SELECT * FROM PRODUCTS WHERE PRODUCT_NAME IS NULL;
SELECT * FROM PRODUCTS WHERE PRODUCT_NAME IS NOT NULL;
SELECT * FROM PRODUCTS WHERE ! PRODUCT_NAME  IS NOT NULL;
-- THE TWO QUERIES BELOW ARE THE SAME
SELECT COUNT(PRODUCT_NAME) FROM PRODUCTS;
SELECT COUNT( ALL PRODUCT_NAME) FROM PRODUCTS;
SELECT COUNT(DISTINCT PRODUCT_NAME) FROM PRODUCTS;

SELECT COUNT(*) FROM PRODUCTS;
SELECT COUNT(ALL *) FROM PRODUCTS;
INSERT INTO PRODUCTS (PRICE, PRODUCT_NAME, PRODUCT_ID) VALUES (156.50, 'SQLPROG', 2);
INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME ) VALUES (3, 'ANGULAR');
DELETE FROM PRODUCTS;
DROP TABLE PRODUCTS;

-- NOT NULL CONSTRAINT
CREATE TABLE PRODUCTS (PRODUCT_ID INT NOT NULL, PRODUCT_NAME CHAR(50) NOT NULL, PRICE FLOAT NOT NULL);
INSERT INTO PRODUCTS VALUES (1, 'SWW',155.50);
INSERT INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME ) VALUES (3, 'ANGULAR');
INSERT INTO PRODUCTS VALUES (1, 'SWW',155.50);

-- PRIMARY KEY CONSTRAINT
SELECT * FROM PRODUCTS;
CREATE TABLE PRODUCTS (PRODUCT_ID INT PRIMARY KEY NOT NULL, PRODUCT_NAME CHAR(50) NOT NULL, PRICE FLOAT NOT NULL);
INSERT INTO PRODUCTS VALUES (1, 'SWW',155.50);
INSERT INTO PRODUCTS VALUES (1, 'JAVA',178.50);
INSERT INTO PRODUCTS VALUES (2, 'JAVA',178.50);

SELECT * FROM PRODUCTS WHERE PRODUCT_ID = 1;
UPDATE PRODUCTS SET PRODUCT_NAME = 'JAVA'
WHERE PRODUCT_ID = 2;

DELETE FROM PRODUCTS WHERE PRODUCT_ID = 1;

-- STATIC VALUES
SELECT 'WELCOME TO THE WORLD OF SQL';
-- ARITHMETIC OPERATIONS
SELECT PI();
SELECT 100 + 100;
SELECT MOD(45,7);
SELECT SQRT(25);

USE SAKILA;
SELECT * FROM ACTOR;
-- SORT ORDER
SELECT * FROM ACTOR ORDER BY FIRST_NAME;
SELECT * FROM ACTOR ORDER BY FIRST_NAME ASC;
SELECT * FROM ACTOR ORDER BY FIRST_NAME DESC;
-- USING COLUMN NUMBER
SELECT * FROM ACTOR ORDER BY 4 DESC;
-- FILTERING RECORDS
SELECT * FROM ACTOR WHERE FIRST_NAME = 'JULIA';
SELECT * FROM ACTOR WHERE ACTOR_ID < 3;
SELECT * FROM ACTOR WHERE FALSE;
SELECT * FROM ACTOR WHERE TRUE;
SELECT COUNT(*) FROM ACTOR;
SELECT * FROM ACTOR WHERE 1 = 2 ;

SELECT ROUND(50.567);
SELECT ROUND(50.567,0);
SELECT ROUND(50.567, 2);
SELECT ROUND(567.567, 0);
SELECT ROUND(567.567, -1);
SELECT ROUND(567.567, -2);
SELECT FLOOR(1.2);
SELECT CEILING(1.2);
SELECT FLOOR(1.7);
SELECT CEILING(1.7);
SELECT FLOOR(-1.7);
SELECT CEILING(-1.7);

-- STRING OPERATIONS
SELECT '1' + '1';
SELECT '1' + 'ABC1';
SELECT CONCAT('1','1');
-- USER DEFINED COLUMN HEADING
SELECT CONCAT('1','1') AS 'CONCATENATED VALUE';
SELECT * FROM ACTOR;
-- IP
-- COULUMN NAME : FULL_NAME
-- VALUE : PENELOPE.GUNESS
-- NULL AND ' '
-- NULL IS MISSING INFORMATION
SELECT * FROM ACTOR WHERE LAST_NAME IS NULL;
SELECT 'PENELOPE.GUNESS' AS FULL_NAME;

USE SAKILA;
SELECT FIRST_NAME, LAST_NAME, CONCAT(FIRST_NAME,LAST_NAME) AS FULL_NAME FROM ACTOR;
SELECT CONCAT(FIRST_NAME, '.' ,LAST_NAME) AS FULL_NAME FROM ACTOR;
SELECT FIRST_NAME, LEFT(LAST_NAME, 1) AS 'NAME WITH INITAILS', LAST_NAME FROM ACTOR;

SELECT FIRST_NAME,last_name, concat(FIRST_NAME,'.',LEFT(last_name,1),'_',RIGHT(LAST_NAME,1)) As 'FORMATED NAME' FROM ACTOR;
SELECT CONCAT(First_Name,'.', LEFT(Last_Name, 1),'_',RIGHT(UPPER(Last_Name),1)) As Full_NAME From ACTOR;

-- IP
-- NAME WITH INITIALS (A NEW FORMAT)
-- HEADING : FORMATTED NAME
-- VALUE    :  NICK.W_G


select concat(first_name, '.', left(last_name, 1)) as 'NAME WITH INITIALS' from actor;
SELECT COUNT(FIRST_NAME) FROM ACTOR;
SELECT COUNT(DISTINCT FIRST_NAME) FROM ACTOR;
-- GET THE DETAILS OF KENNETH AND ED (FIRST_NAME)
SELECT *FROM ACTOR WHERE FIRST_NAME ='KENNETH' OR FIRST_NAME ='ED';
-- GET THE DETAILS OF ED CHASE (FIRST_NAME)
SELECT *FROM ACTOR WHERE FIRST_NAME ='ED' AND LAST_NAME ='CHASE';
SELECT *FROM sakila.actor WHERE (first_name = 'KENNETH' AND actor_id < 80) OR last_name = 'TEMPLE';
SELECT * FROM sakila.actor WHERE first_name = 'KENNETH' OR NOT(last_name = 'TEMPLE' AND actor_id > 169)

-- ROUGH WORK
# TRUE (OR NOT (FALSE & FALSE))
# TRUE (OR NOT (FALSE))
# TRUE.
#
#
# KIM  BLOOM 145 -- YES
# BOB  RANDOM 19 -- 21 KRISTEN PALTROW YES
# SELECT * FROM sakila.actor
#          WHERE first_name = 'BOB' OR NOT(last_name = 'RANDOM' AND actor_id > 19)
#         AND ACTOR_ID = 21;
#
# SELECT * FROM sakila.actor WHERE first_name = 'BOB' OR NOT(last_name = 'RANDOM' AND actor_id > 19)
#     FALSE (OR NOT (FALSE & TRUE))
#          FALSE (OR NOT (FALSE))
#           FALSE OR     TRUE.
#
#  TRUE (OR NOT (FALSE & FALSE))
# TRUE (OR NOT (FALSE))
# TRUE.
#
#
#
# SELECT * FROM sakila.actor
#          WHERE first_name = 'KIM' OR NOT(last_name = 'BLOOM' AND actor_id > 145)
#          AND ACTOR_ID = 145;
