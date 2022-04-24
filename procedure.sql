/*
DEMO INSERT INTO DATABASE
*/
--set múi giờ của VN cho database
ALTER SESSION SET TIME_ZONE = '-7:0';
/*
CREATE PROCEDURE FOR DATABASE
*/
-- procedure 1
CREATE OR REPLACE PROCEDURE P_INSERT_ACCOUNT (--USERID TB_USER.USERID%type,
                                            FIRSTNAME TB_USER.FIRSTNAME%type,
                                            LASTNAME TB_USER.LASTNAME%type,
                                            GENDER TB_USER.GENDER%type,
                                            PHONE TB_USER.PHONE%type,
                                            DATEOFBIRTH TB_USER.DATEOFBIRTH%type,
                                            EMAIL TB_USER.EMAIL%type,
                                            SCORE TB_USER.SCORE%type,
                                            AVATAR TB_USER.AVATAR%type,
                                            --CREATEDON TB_USER.CREATEDON%type,
                                            PASSWORD TB_USER.PASSWORD%type,
                                            ROLEID TB_USER.ROLEID%type)
AS
BEGIN
    INSERT INTO TB_USER (
        FIRSTNAME, LASTNAME, GENDER, PHONE, DATEOFBIRTH, EMAIL, SCORE,
        AVATAR, PASSWORD, ROLEID)
    VALUES (
        FIRSTNAME, LASTNAME, GENDER, PHONE, DATEOFBIRTH, EMAIL, SCORE,
        AVATAR, PASSWORD, ROLEID);
END;
/
-- procedure 2
CREATE OR REPLACE PROCEDURE P_INSERT_POST (--POSTID TB_POST.POSTID%type,
                                            --OWNERID TB_POST.OWNERID%type,
                                            --PARTNERID TB_POST.PARTNERID%type,
                                            STATUSID TB_POST.STATUSID%type,
                                            TITLE TB_POST.TITLE%type,
                                            CONTENT TB_POST.CONTENT%type,
                                            CATEGORYID TB_POST.CATEGORYID%type,
                                            IMAGEPATH TB_POST.IMAGEPATH%type,
                                            --CREATEDON TB_POST.CREATEDON%type,
                                            UPDATEDON TB_POST.UPDATEDON%type,
                                            PURPOSEID TB_POST.PURPOSEID%type
                                            )
AS
BEGIN
    INSERT INTO TB_POST (STATUSID, TITLE, CONTENT, CATEGORYID, IMAGEPATH, UPDATEDON, PURPOSEID)
    VALUES (STATUSID, TITLE, CONTENT, CATEGORYID, IMAGEPATH, NULL, PURPOSEID);
END;
/
-- procedure 3
CREATE OR REPLACE PROCEDURE P_UPDATE_ACCOUNT (USERID TB_USER.USERID%type,
                                            FIRSTNAME TB_USER.FIRSTNAME%type,
                                            LASTNAME TB_USER.LASTNAME%type,
                                            GENDER TB_USER.GENDER%type,
                                            PHONE TB_USER.PHONE%type,
                                            DATEOFBIRTH TB_USER.DATEOFBIRTH%type,
                                            EMAIL TB_USER.EMAIL%type,
                                            SCORE TB_USER.SCORE%type,
                                            AVATAR TB_USER.AVATAR%type,
                                            --CREATEDON TB_USER.CREATEDON%type,
                                            PASSWORD TB_USER.PASSWORD%type,
                                            ROLEID TB_USER.ROLEID%type)
AS
BEGIN
    UPDATE TB_USER
    SET TB_USER.FIRSTNAME = FIRSTNAME, 
        TB_USER.LASTNAME = LASTNAME, 
        TB_USER.GENDER = GENDER, 
        TB_USER.PHONE = PHONE, 
        TB_USER.DATEOFBIRTH = DATEOFBIRTH, 
        TB_USER.EMAIL = EMAIL, 
        TB_USER.SCORE = SCORE,
        TB_USER.AVATAR = AVATAR, 
        TB_USER.PASSWORD = PASSWORD, 
        TB_USER.ROLEID = ROLEID
    WHERE TB_USER.USERID = USERID;
END;
/
-- procedure 4
CREATE OR REPLACE PROCEDURE P_UPDATE_POST (POSTID TB_POST.POSTID%type,
                                            --OWNERID TB_POST.OWNERID%type,
                                            --PARTNERID TB_POST.PARTNERID%type,
                                            STATUSID TB_POST.STATUSID%type,
                                            TITLE TB_POST.TITLE%type,
                                            CONTENT TB_POST.CONTENT%type,
                                            CATEGORYID TB_POST.CATEGORYID%type,
                                            IMAGEPATH TB_POST.IMAGEPATH%type,
                                            --CREATEDON TB_POST.CREATEDON%type,
                                            UPDATEDON TB_POST.UPDATEDON%type,
                                            PURPOSEID TB_POST.PURPOSEID%type
                                            )
AS
BEGIN
    UPDATE TB_POST
    SET TB_POST.STATUSID = STATUSID,
        TB_POST.TITLE = TITLE,
        TB_POST.CONTENT = CONTENT,
        TB_POST.CATEGORYID = CATEGORYID,
        TB_POST.IMAGEPATH = IMAGEPATH,
        TB_POST.UPDATEDON = CURRENT_DATE,
        TB_POST.PURPOSEID = PURPOSEID
    WHERE TB_POST.POSTID = POSTID;
END;
/
--Bật lưu trữ hàng trên TB_USER.
alter table TB_USER row archival;
/
-- procedure 5
CREATE OR REPLACE PROCEDURE P_DELETE_ACCOUNT (USERID TB_USER.USERID%type)
AS
BEGIN
    update TB_USER
    set ora_archive_state = dbms_ilm.archivestatename(1)
    where TB_USER.USERID =  USERID;
END;
/
--Bật lưu trữ hàng trên TB_USER.
alter table TB_POST row archival;
/
-- procedure 6
CREATE OR REPLACE PROCEDURE P_DELETE_POST (POSTID TB_POST.POSTID%type)
AS
BEGIN
    update TB_POST
    set ora_archive_state = dbms_ilm.archivestatename(1)
    where TB_POST.POSTID =  POSTID;
END;
/*
GIẢI THÍCH:
- khi bật tính năng ora_archive_state của Oracle bằng câu lệnh: alter table TB_NAME row archival;
thì chúng ta có thể ẩn đi 1 hàng dữ liệu bên trong database bằng lênh update
--tltk: https://www.oracle.com/webfolder/technetwork/tutorials/obe/db/12c/r1/ilm/row_archival/row_archival.html
*/
/
-- procedure 7
CREATE OR REPLACE PROCEDURE P_HARD_DELETE_ACCOUNT (USERID TB_USER.USERID%type)
AS
BEGIN
    delete from TB_USER
    where TB_USER.USERID =  USERID;
END;
/
-- procedure 8
CREATE OR REPLACE PROCEDURE P_HARD_DELETE_POST (POSTID TB_POST.POSTID%type)
AS
BEGIN
    delete from TB_POST
    where TB_POST.POSTID =  POSTID;
END;
/