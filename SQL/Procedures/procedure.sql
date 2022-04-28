/*
DEMO INSERT INTO DATABASE
*/
--set múi giờ của VN cho database
ALTER SESSION SET time_zone = '-7:0';

/*
CREATE PROCEDURE FOR DATABASE
*/

--procedure thêm tài khoản mới

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

    COMMIT;
END;

/* Mẫu cho hàm p_insert_account
    BEGIN
        p_insert_account('Trịnh Gia', 'Phat', 1, '0941511664', TO_DATE('26/10/2002',
                        'dd/mm/yyyy'), 'congatayu@gmai.com', '123', 2);
    END;
*/

--procedure thêm một bài đăng mới

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

    COMMIT;
END;

/*Mẫu 
BEGIN
P_INSERT_POST(1,'Cho kẹo','Kẹo nhà làm',1,1);
END;
*/
-- procedure xóa mềm một tài khoản(có thể khôi phục lại thao tác xóa)

CREATE OR REPLACE PROCEDURE p_delete_account (
    userid_in tb_user.userid%TYPE
) AS
BEGIN
    UPDATE tb_user
    SET
        isdeleted = 1
    WHERE
        tb_user.userid = userid_in;

    COMMIT;
END;

-- procedure xóa mềm một bài viết(có thể khôi phục lại thao tác xóa)

CREATE OR REPLACE PROCEDURE p_delete_post (
    postid_in tb_post.postid%TYPE
) AS
BEGIN
    UPDATE tb_post
    SET
        isdeleted = 1
    WHERE
        tb_post.postid = postid_in;

    COMMIT;
END;

-- procedure khôi phục tài khoản bị xóa

CREATE OR REPLACE PROCEDURE p_recovery_account (
    userid_in tb_user.userid%TYPE
) AS
BEGIN
    UPDATE tb_user
    SET
        isdeleted = 0
    WHERE
        tb_user.userid = userid_in;

    COMMIT;
END;

-- procedure khôi phục tài khoản bị xóa

CREATE OR REPLACE PROCEDURE p_recovery_post (
    postid_in tb_post.postid%TYPE
) AS
BEGIN
    UPDATE tb_post
    SET
        isdeleted = 0
    WHERE
        tb_post.postid = postid_in;

    COMMIT;
END;

-- procedure xóa hẳn tài khoản ra khỏi cơ sở dữ liệu

CREATE OR REPLACE PROCEDURE p_hard_delete_account (
    userid_in tb_user.userid%TYPE
) AS
BEGIN
    DELETE FROM tb_user
    WHERE
        tb_user.userid = userid_in;

    COMMIT;
END;

-- procedure xóa hẳn bài viết ra khỏi cơ sở dữ liệu

CREATE OR REPLACE PROCEDURE p_hard_delete_post (
    postid_in tb_post.postid%TYPE
) AS
BEGIN
    DELETE FROM tb_post
    WHERE
        tb_post.postid = postid_in;

    COMMIT;
END;

-- procedure tạo một thông báo mới

CREATE OR REPLACE PROCEDURE p_insert_notification (
    userid_in   tb_user.userid%TYPE,
    content_in  tb_notification.content%TYPE
) AS
BEGIN
    INSERT INTO tb_notification (
        userid,
        content
    ) VALUES (
        userid_in,
        content_in
    );

    COMMIT;
END;

-- procedure cập nhật lại trạng thái bài viết

CREATE OR REPLACE PROCEDURE p_update_status_post (
    postid_in    tb_post.postid%TYPE,
    statusid_in  tb_post.statusid%TYPE
) AS
BEGIN
    UPDATE tb_post
    SET
        statusid = statusid_in
    WHERE
        postid = postid_in;

    COMMIT;
END;