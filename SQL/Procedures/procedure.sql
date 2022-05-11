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

-- procedure thêm một sao kê
CREATE OR REPLACE PROCEDURE p_insert_statement (
    userid_in   tb_user.userid%TYPE,
    postid_in  tb_post.postid%TYPE,
    total_in tb_statement.total%TYPE
) AS
BEGIN
    INSERT INTO tb_statement (
        postid,
        userid,
        total
    ) VALUES (
        postid_in,
        userid_in,
        total_in
    );
    COMMIT;
END;

--Procedure đặt hẹn
CREATE OR REPLACE PROCEDURE p_scheduling (
    postid_in  tb_post.postid%TYPE,--bài viết bị tác động lên
    userid_in  tb_user.userid%TYPE --id người dùng thực hiện đặt hẹn
) AS
    get_post          tb_post%rowtype;
    username          tb_user.lastname%TYPE;
    current_schedule  NUMBER; --số bài viết đang hẹn(để nhận) của người đặt hẹn
BEGIN
    SELECT
        *
    INTO get_post
    FROM
        tb_post
    WHERE
        postid = postid_in;

    SELECT
        lastname
    INTO username
    FROM
        tb_user
    WHERE
        userid = userid_in;

    --xét không cho chủ bài viết đặt hẹn chính bài viết của bản thân

    IF ( userid_in = get_post.ownerid ) THEN
        dbms_output.put_line('Lỗi!! Không thể tự đặt hẹn cho chính mình!');
    ELSE 
        --bài viết đang chưa có ai đặt hẹn nên có thể đặt hẹn
        IF ( get_post.statusid = 1 ) THEN
            --nếu người dùng này đang đặt hẹn để giúp đỡ người khác thì không xét điều kiện
            --xét người này có đang đặt hẹn(xin nhận) hoặc đã đăng bài(xin nhận) đồng thời ở 5 bài viết khác trong 7 ngày gần đây không
            SELECT
                COUNT(postid)
            INTO current_schedule
            FROM
                tb_post
            WHERE
                (
                    partnerid = userid_in
                AND purposeid = 1
                AND createdon > sysdate - 7
                )
                
                OR 
                
                (
                ownerid = userid_in
                AND purposeid = 2
                AND createdon > sysdate - 7
                );

            IF ( get_post.purposeid = 1 AND current_schedule > 5 ) THEN
                dbms_output.put_line('Không thể đặt hẹn do đã quá 5 lần đặt hẹn trong tuần');

            ELSE
                --cập nhật lại trạng thái bài viết là đã có người hẹn
                UPDATE tb_post
                SET
                    statusid = 2
                WHERE
                    postid = postid_in;
                --cập nhật id của người đặt hẹn vào bài viết

                UPDATE tb_post
                SET
                    partnerid = userid_in
                WHERE
                    postid = postid_in;
                --gửi thông báo đến người đặt hẹn

                INSERT INTO tb_notification (
                    userid,
                    content
                ) VALUES (
                    userid_in,
                    'Bạn đã đặt lịch hẹn thành công tại bài viết' || get_post.title
                );
                --gửi thông báo đến chủ bài viết

                INSERT INTO tb_notification (
                    userid,
                    content
                ) VALUES (
                    get_post.ownerid,
                    'Bài viết'
                    || get_post.title
                    || ' của bạn đã được đặt hẹn bởi '
                    || username
                );

                dbms_output.put_line('Thực hiện đặt hẹn thành công');

            END IF;

        ELSE
            dbms_output.put_line('Lỗi!! Bài viết không khả dụng lúc này.');
        END IF;
    END IF;

END;

--procedure hủy lịch hẹn
CREATE OR REPLACE PROCEDURE p_cancel_scheduling (
    postid_in  tb_post.postid%TYPE,--bài viết bị tác động lên
    userid_in  tb_user.userid%TYPE --id người dùng thực hiện hủy hẹn
) AS
    get_post tb_post%rowtype;
BEGIN
    SELECT
        *
    INTO get_post
    FROM
        tb_post
    WHERE
        postid = postid_in;

    if (get_post.statusid != 2 ) then
        dbms_output.put_line('Bài viết chưa có lịch hẹn để thực hiện thao tác hủy');
    else  
        update tb_post set statusid = 1, partnerid = null where ownerid = postid_in;
        --gửi thông báo tới người dùng
        INSERT INTO tb_notification (
                    userid,
                    content
                ) VALUES (
                    userid_in,
                    'Bạn đã hủy lịch hẹn thành công tại bài viết' || get_post.title
                );
        --gửi thông báo đến chủ bài viết

        INSERT INTO tb_notification (
                    userid,
                    content
                ) VALUES (
                    get_post.ownerid,
                    'Bài viết'
                    || get_post.title
                    || ' của bạn đã bị hủy lịch hẹn '
                );
        
        dbms_output.put_line('Hủy lịch hẹn thành công');
    end if;
END;

--procedure xác nhận đã hỗ trợ thành công
CREATE OR REPLACE PROCEDURE p_scheduling (
    postid_in  tb_post.postid%TYPE,--bài viết bị tác động lên
    userid_in  tb_user.userid%TYPE --id chủ bài viết
) AS
    get_post          tb_post%rowtype;
BEGIN
IF (get_post.statusid != 2) then
    dbms_output.put_line('Bài viết chưa có lịch hẹn');
ELSE 
    --chỉ có chủ bài viết mới có thể xác nhận hoàn thành
    IF (userid_in != get_post.ownerid) then
        dbms_output.put_line('Lỗi, chỉ chủ bài đăng có thể xác nhận');
    ELSE 
        UPDATE tb_post
        SET
            statusid = 3
        WHERE
            postid = postid_in;
        --sau thời điểm này, TRIGGER TRIGGER_ADD_SCORE sẽ được chạy để cộng điểm cho người hỗ trợ
    END IF;
END IF;
END;