/*
DEMO INSERT INTO DATABASE
*/
--set múi giờ của VN cho database
ALTER SESSION SET TIME_ZONE = '-7:0';

/*
CREATE PROCEDURE FOR DATABASE
*/

-- procedure 1: procedure thêm tài khoản mới
CREATE OR REPLACE PROCEDURE p_insert_account (
    firstname    tb_user.firstname%TYPE,
    lastname     tb_user.lastname%TYPE,
    gender       tb_user.gender%TYPE,
    phone        tb_user.phone%TYPE,
    dateofbirth  tb_user.dateofbirth%TYPE,
    email        tb_user.email%TYPE,
    password     tb_user.password%TYPE,
    roleid       tb_user.roleid%TYPE
    --Thuộc tính Score, CreateOn, Avatar đã được thiết lặp mặc định trong TRIGGER_DEFAULT_VALUE_USER
) AS
BEGIN
    INSERT INTO tb_user (
        firstname,
        lastname,
        gender,
        phone,
        dateofbirth,
        email,
        password,
        roleid
    ) VALUES (
        firstname,
        lastname,
        gender,
        phone,
        dateofbirth,
        email,
        password,
        roleid
    );
END;

/* Mẫu cho hàm p_insert_account
    BEGIN
        p_insert_account('Trịnh Gia', 'Phat', 1, '0941511664', TO_DATE('26/10/2002',
                        'dd/mm/yyyy'), 'congatayu@gmai.com', '123', 2);
    END;
*/

-- procedure 2: procedure thêm một bài đăng mới
CREATE OR REPLACE PROCEDURE p_insert_post (
    ownerid     tb_post.ownerid%TYPE,
    title       tb_post.title%TYPE,
    content     tb_post.content%TYPE,
    categoryid  tb_post.categoryid%TYPE,
    purposeid   tb_post.purposeid%TYPE
) AS
BEGIN
    INSERT INTO tb_post (
        ownerid,
        title,
        content,
        categoryid,
        purposeid
    ) VALUES (
        ownerid,
        title,
        content,
        categoryid,
        purposeid
    );
END;

/*Mẫu 
BEGIN
P_INSERT_POST(1,'Cho kẹo','Kẹo nhà làm',1,1);
END;
*/
/
-- procedure cập nhật thông tin tài khoản người dùng
CREATE OR REPLACE PROCEDURE p_update_account (
    --không thể thực hiện việc cập nhật userid, score, roleid, createon
    userid       tb_user.userid%TYPE,
    firstname    tb_user.firstname%TYPE,
    lastname     tb_user.lastname%TYPE,
    gender       tb_user.gender%TYPE,
    phone        tb_user.phone%TYPE,
    dateofbirth  tb_user.dateofbirth%TYPE,
    email        tb_user.email%TYPE,
    avatar       tb_user.avatar%TYPE,
    password     tb_user.password%TYPE
) AS
BEGIN
    UPDATE tb_user
    SET
        tb_user.firstname = firstname,
        tb_user.lastname = lastname,
        tb_user.gender = gender,
        tb_user.phone = phone,
        tb_user.dateofbirth = dateofbirth,
        tb_user.email = email,
        tb_user.avatar = avatar,
        tb_user.password = password
    WHERE
        tb_user.userid = userid;
END;

-- procedure 4 -- chưa sửa
CREATE OR REPLACE PROCEDURE p_update_post (
    postid      tb_post.postid%TYPE,
    partnerid   tb_post.partnerid%TYPE,
    statusid    tb_post.statusid%TYPE,
    title       tb_post.title%TYPE,
    content     tb_post.content%TYPE,
    categoryid  tb_post.categoryid%TYPE,
    imagepath   tb_post.imagepath%TYPE,
    purposeid   tb_post.purposeid%TYPE
) AS
BEGIN
    UPDATE tb_post
    SET
        tb_post.statusid = statusid,
        tb_post.title = title,
        tb_post.content = content,
        tb_post.categoryid = categoryid,
        tb_post.imagepath = imagepath,
        tb_post.purposeid = purposeid
    WHERE
        tb_post.postid = postid;
END;



-- procedure xóa mềm một tài khoản(có thể khôi phục lại thao tác xóa)
CREATE OR REPLACE PROCEDURE P_DELETE_ACCOUNT (USERID_IN TB_USER.USERID%type)
AS
BEGIN
    update TB_USER
    set isDeleted = 1
    where TB_USER.USERID =  USERID_IN;
END;

-- procedure xóa mềm một bài viết(có thể khôi phục lại thao tác xóa)
CREATE OR REPLACE PROCEDURE P_DELETE_POST (POSTID_IN TB_POST.POSTID%type)
AS
BEGIN
    update TB_POST
    set isDeleted = 1
    where TB_POST.POSTID =  POSTID_IN;
END;

-- procedure khôi phục tài khoản bị xóa
CREATE OR REPLACE PROCEDURE P_RECOVERY_ACCOUNT (USERID_IN TB_USER.USERID%type)
AS
BEGIN
    update TB_USER
    set isDeleted = 0
    where TB_USER.USERID =  USERID_IN;
END;

-- procedure khôi phục tài khoản bị xóa
CREATE OR REPLACE PROCEDURE P_RECOVERY_POST (POSTID_IN TB_POST.POSTID%type)
AS
BEGIN
    update TB_POST
    set isDeleted = 0
    where TB_POST.POSTID =  POSTID_IN;
END;

-- procedure xóa hẳn tài khoản ra khỏi cơ sở dữ liệu
CREATE OR REPLACE PROCEDURE P_HARD_DELETE_ACCOUNT (USERID_IN TB_USER.USERID%type)
AS
BEGIN
    delete from TB_USER
    where TB_USER.USERID =  USERID_IN;
END;

-- procedure xóa hẳn bài viết ra khỏi cơ sở dữ liệu
CREATE OR REPLACE PROCEDURE P_HARD_DELETE_POST (POSTID_IN TB_POST.POSTID%type)
AS
BEGIN
    delete from TB_POST
    where TB_POST.POSTID =  POSTID_IN;
END;
