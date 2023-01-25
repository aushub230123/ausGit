USE SAKILA

-- CONSTRAINT ENSURE INTEGRITY OF DATA
CREATE TABLE NEWAUTHOR2(
    AUT_ID VARCHAR(8) NOT NULL PRIMARY KEY,
    AUT_NAME VARCHAR(50) NOT NULL
);

DELETE FROM NEWAUTHOR2;
INSERT INTO NEWAUTHOR2 VALUES (2,'JOSHUA');
INSERT INTO NEWAUTHOR2 VALUES (NULL,'MYSQL1');
INSERT INTO NEWAUTHOR2 VALUES (3,NULL);
INSERT INTO NEWAUTHOR2 VALUES (3,'RICHARD');


SELECT * FROM NEWAUTHOR2;

CREATE TABLE NEWBOOK2 (
    BOOK_ID VARCHAR(8) NOT NULL PRIMARY KEY ,
    BOOK_NAME VARCHAR(50) NOT NULL,
    AUTHOR_ID VARCHAR(8),
    -- DEFINE THE CONSTRAINT (FOREIGN KEY)
    --  FOREIGN KEY (AUTHOR_ID) REFERENCES NEWAUTHOR2(AUT_ID)
    FOREIGN KEY (AUTHOR_ID)
        REFERENCES NEWAUTHOR2(AUT_ID) ON DELETE CASCADE
);

SELECT * FROM NEWBOOK2;
# INSERT INTO NEWBOOK2 VALUES (1, 'EFFECTIVE JAVA', 3);
INSERT INTO NEWBOOK2 VALUES (1, 'EFFECTIVE JAVA', 2);
# INSERT INTO NEWBOOK2 VALUES (1, 'EFFECTIVE JAVA', 3);
INSERT INTO NEWBOOK2 VALUES (2, 'EFFECTIVE JAVA', 2);
INSERT INTO NEWBOOK2 VALUES (3, 'EFFECTIVE JAVA', NULL);
INSERT INTO NEWBOOK2 VALUES (4, 'EFFECTIVE JAVA', NULL);

DROP TABLE NEWAUTHOR2;
DROP TABLE NEWBOOK2;
SELECT * FROM NEWAUTHOR2;
DELETE FROM NEWAUTHOR2;
DELETE FROM NEWAUTHOR2 WHERE AUT_ID = 2;
DELETE FROM NEWAUTHOR2 WHERE AUT_ID = 3;

-- INSTANT PRACTICE (IP)
-- US01 : AS A DB DEV, I WOULD LIKE TO DELETE AN AUTHOR, AND THE BOOKS OF THE AUTHOR TOO WHEN I ISSUE A DELETE STATEMENT ON THE AUTHOR TABLE.
-- US02 : DEMONSTRATE OTHER POSSIBILITIES, LIKE DELETING AN AUTHOR AND THE BOOKS WILL HAVE AUTHOR_ID NULLIFIED.

ALTER TABLE NEWBOOK2
    ADD CONSTRAINT FOREIGN KEY (Author_id)
    REFERENCES NEWAUTHOR2(Aut_id) ON DELETE CASCADE;


-- REFACTORED CASCADE DELETE
CREATE TABLE NEWAUTHOR2(
                           AUT_ID VARCHAR(8) NOT NULL PRIMARY KEY,
                           AUT_NAME VARCHAR(50) NOT NULL
);

CREATE TABLE NEWBOOK2 (
                          BOOK_ID VARCHAR(8) NOT NULL PRIMARY KEY ,
                          BOOK_NAME VARCHAR(50) NOT NULL,
                          AUTHOR_ID VARCHAR(8),
    -- DEFINE THE CONSTRAINT (FOREIGN KEY)
    --  FOREIGN KEY (AUTHOR_ID) REFERENCES NEWAUTHOR2(AUT_ID)
                          FOREIGN KEY (AUTHOR_ID)
                              REFERENCES NEWAUTHOR2(AUT_ID) ON DELETE CASCADE
);

INSERT INTO NEWAUTHOR2 VALUES (2,'JOSHUA');
-- INSERT INTO NEWAUTHOR2 VALUES (NULL,'MYSQL1');
INSERT INTO NEWAUTHOR2 VALUES (3,NULL);
INSERT INTO NEWAUTHOR2 VALUES (3,'RICHARD');

# SELECT * FROM NEWBOOK2;
# INSERT INTO NEWBOOK2 VALUES (1, 'EFFECTIVE JAVA', 3);
INSERT INTO NEWBOOK2 VALUES (1, 'EFFECTIVE JAVA', 2);
# INSERT INTO NEWBOOK2 VALUES (1, 'EFFECTIVE JAVA', 3);
INSERT INTO NEWBOOK2 VALUES (2, 'EFFECTIVE JAVA', 2);
INSERT INTO NEWBOOK2 VALUES (3, 'EFFECTIVE JAVA', NULL);
INSERT INTO NEWBOOK2 VALUES (4, 'EFFECTIVE JAVA', NULL);

SELECT * FROM NEWAUTHOR2;
SELECT * FROM NEWBOOK2;
DELETE FROM NEWAUTHOR2 WHERE AUT_ID = 2;
DELETE FROM NEWAUTHOR2 WHERE AUT_ID = 3;

