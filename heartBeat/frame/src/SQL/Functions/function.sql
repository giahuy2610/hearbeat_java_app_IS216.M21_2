-----FUNCTION---------
--1. F_SUM_SCORE
CREATE OR REPLACE FUNCTION F_SUM_SCORE(USER_ID INTEGER)
RETURN INTEGER
AS
    TOTAL_SCORE INTEGER;
BEGIN
    SELECT SUM(SCORE) INTO TOTAL_SCORE
    FROM TB_USER
    WHERE USERID=USER_ID;
RETURN TOTAL_SCORE;
EXCEPTION WHEN NO_DATA_FOUND THEN
RETURN ('NO DATA FOUND');
END;

SET SERVEROUTPUT ON;
EXECUTE dbms_output.put_line('TOTAL SCORE IS: '||F_SUM_SCORE(&USER_ID));

--2. F_SUM_POST_OWNER
CREATE OR REPLACE FUNCTION F_COUNT_POST_OWNER(OWNER_ID NUMBER)
RETURN NUMBER
AS
    COUNT_POST_OWNER NUMBER;
BEGIN
    SELECT COUNT(OWNERID) INTO COUNT_POST_OWNER
    FROM TB_POST
    WHERE OWNERID=OWNER_ID;
RETURN COUNT_POST_OWNER;
EXCEPTION WHEN NO_DATA_FOUND THEN
RETURN ('NO DATA FOUND');
END;

SET SERVEROUTPUT ON;
EXECUTE dbms_output.put_line('THE NUMBERS OF POSTS IS: '||F_COUNT_POST_OWNER(&OWNER_ID));
--3. THONG KE SO LUONG BAI VIET TRONG MOT NGAY
CREATE OR REPLACE FUNCTION F_SUM_POST_DAY (NGAY NUMBER, THANG NUMBER, NAM NUMBER )
RETURN NUMBER
AS
    SUM_POST_DAY NUMBER;
BEGIN
    SELECT COUNT(POSTID) INTO SUM_POST_DAY
    FROM TB_POST
    WHERE EXTRACT ( DAY FROM CREATEDON ) = NGAY AND EXTRACT ( MONTH FROM CREATEDON ) = THANG AND EXTRACT (YEAR FROM CREATEDON)=NAM; 
RETURN SUM_POST_DAY;
EXCEPTION WHEN NO_DATA_FOUND THEN
RETURN ('NO DATA FOUND');
END;
DECLARE
TOTAL_OF_DAY NUMBER;
BEGIN
TOTAL_OF_DAY := F_SUM_POST_DAY(29,04,2022);
DBMS_OUTPUT.PUT_LINE('Tong so bai viet trong ngay: ' || TOTAL_OF_DAY);
END;
--4. THONG KE SO LUONG BAI VIET TRONG MOT THANG, MOT NAM
CREATE OR REPLACE FUNCTION F_SUM_POST_MONTH_YEAR (THANG NUMBER, NAM NUMBER )
RETURN NUMBER
AS
    SUM_POST_MONTH_YEAR NUMBER;
BEGIN
    SELECT COUNT(POSTID) INTO SUM_POST_MONTH_YEAR
    FROM TB_POST
    WHERE EXTRACT ( MONTH FROM CREATEDON ) = THANG AND EXTRACT (YEAR FROM CREATEDON)=NAM; 
RETURN SUM_POST_MONTH_YEAR;
EXCEPTION WHEN NO_DATA_FOUND THEN
RETURN ('NO DATA FOUND');
END;
DECLARE
TOTAL_OF_MONTH_YEAR NUMBER;
BEGIN
TOTAL_OF_MONTH_YEAR := F_SUM_POST_MONTH_YEAR(04,2022);
DBMS_OUTPUT.PUT_LINE('Tong so bai viet trong thang va nam: ' || TOTAL_OF_MONTH_YEAR);
END;
--5. THONG KE SO LUONG NGUOI DUNG MOI TRONG MOT THANG 
CREATE OR REPLACE FUNCTION F_COUNT_USER_NEW_MONTH(THANG NUMBER)
RETURN NUMBER
AS
COUNT_USER_NEW_MONTH NUMBER;
BEGIN
IF( THANG < 1 AND THANG > 12 )
THEN
RAISE_APPLICATION_ERROR (-20399, 'Thang nhap vao khong hop le');
END IF;
SELECT COUNT(USERID) INTO COUNT_USER_NEW_MONTH
FROM TB_USER
WHERE EXTRACT(MONTH FROM CREATEDON) = THANG AND ROLEID='1';
RETURN COUNT_USER_NEW_MONTH;
END;
DECLARE
TOTAL_OF_USER_MONTH NUMBER;
BEGIN
TOTAL_OF_USER_MONTH := F_COUNT_USER_NEW_MONTH(04);
DBMS_OUTPUT.PUT_LINE('Tong so nguoi dung moi trong thang: ' || TOTAL_OF_USER_MONTH);
END; 
--4.F_FIND_USER

CREATE OR REPLACE FUNCTION F_FIND_USER(USER_ID TB_USER.USERID%TYPE)
RETURN %type
AS
RETURN 
    SELECT * 
    FROM TB_USER
    WHERE USERID=USER_ID;
END;

*/