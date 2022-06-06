/*
DEMO INSERT INTO DATABASE
*/
--set múi giờ của VN cho database
ALTER SESSION SET time_zone = '-7:0';

/*
CREATE PROCEDURE FOR DATABASE
*/



/* Mẫu cho hàm p_insert_account
    BEGIN
        p_insert_account('Trịnh Gia', 'Phat', 1, '0941511664', TO_DATE('26/10/2002','dd/mm/yyyy'), 'congatayu@gmai.com', '123', 2);
    END;
*/

--procedure thêm một bài đăng mới

--thêm bài viết
CREATE OR REPLACE PROCEDURE p_insert_post_new (
    ownerid     tb_post.ownerid%TYPE,
    title       tb_post.title%TYPE,
    content     tb_post.content%TYPE,
    categoryid  tb_post.categoryid%TYPE,
    purposeid   tb_post.purposeid%TYPE,
    imagepath       tb_post.imagepath%TYPE
) AS
BEGIN
    INSERT INTO tb_post (
        ownerid,
        title,
        content,
        categoryid,
        purposeid,
        imagepath
    ) VALUES (
        ownerid,
        title,
        content,
        categoryid,
        purposeid,
        imagepath
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
    --cursor lấy ra bài viết chưa hoàn thành mà người dùng này đăng ký

    CURSOR get_post_scheduled IS
    SELECT
        *
    FROM
        tb_post
    WHERE
            partnerid = userid_in
        AND statusid = 2 and isdeleted = 0;

    --cursor lấy ra bài viết chưa hoàn thành của người này và đã có lịch hẹn

    CURSOR get_post IS
    SELECT
        *
    FROM
        tb_post
    WHERE
            ownerid = userid_in
        AND statusid = 2 and isdeleted = 0;

    temp_post tb_post%rowtype;
BEGIN
    UPDATE tb_user
    SET
        isdeleted = 1
    WHERE
        tb_user.userid = userid_in;

        OPEN get_post_scheduled;
        LOOP
            FETCH get_post_scheduled INTO temp_post;
            EXIT WHEN get_post_scheduled%notfound;
            --hủy lịch hẹn của người này trên mọi bài viết(chưa hoàn thành)
            UPDATE tb_post
            SET
                statusid = 1
            WHERE
                postid = temp_post.postid and isdeleted = 0;
            --gửi một thông báo đến các chủ bài viết

            INSERT INTO tb_notification (
                userid,
                content
            ) VALUES (
                temp_post.ownerid,
                'Bài viết '
                || temp_post.title
                || 'đã bị hủy lịch hẹn.'
            );

        END LOOP;
    CLOSE get_post_scheduled;
        
    --xóa hết các bài đăng của người dùng này
    UPDATE tb_post
    SET
        isdeleted = 2 , partnerid = null 
        --0: khả dụng, 1:bị xóa bởi người dùng, 2: bị xóa bởi hệ thống
        --gán lại partnerid = null để xóa hết người dùng đã đặt hẹn, phòng trường hợp có khôi phục lại bài viết thì không bị lưu lại thông tin của người đặt hẹn cũ
    WHERE
        tb_post.ownerid = userid_in and isdeleted = 0;
        
    --gửi một thông báo đến các người dùng đang đặt hẹn với các bài viết mà người này đã đăng(chưa hoàn thành) 
    OPEN get_post;
        LOOP
            FETCH get_post INTO temp_post;
                EXIT WHEN get_post%notfound;
                INSERT INTO tb_notification (
                    userid,
                    content
                ) VALUES (
                    temp_post.ownerid,
                    'Lịch hẹn của bạn ở bài viết '
                    || temp_post.title
                    || ' bị hủy do bài viết đã xóa.'
                );
        END LOOP;
    CLOSE get_post;
END;

-- procedure xóa mềm một bài viết(có thể khôi phục lại thao tác xóa)

CREATE OR REPLACE PROCEDURE p_delete_post (
    postid_in tb_post.postid%TYPE
) AS
    temp_post tb_post%rowtype;
BEGIN
    UPDATE tb_post
    SET
        isdeleted = 1
    WHERE
        tb_post.postid = postid_in;

    SELECT * into temp_post from tb_post where postid = postid_in;

    INSERT INTO tb_notification (
        userid,
        content
    ) VALUES (
        temp_post.ownerid,
        'Bài viết '
        || temp_post.title
        || ' đã được xóa thành công.'
    );

    IF (temp_post.statusid = 2  AND temp_post.partnerid IS NOT NULL) THEN
        INSERT INTO tb_notification (
            userid,
            content
        ) VALUES (
            temp_post.partnerid,
            'Bài viết '
            || temp_post.title
            || ' đã bị xóa, lịch hẹn của bạn cũng sẽ bị hủy.'
        );

    END IF;

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

    UPDATE tb_post
    SET
        isdeleted = 0 , partnerid = null 
        --0: khả dụng, 1:bị xóa bởi người dùng, 2: bị xóa bởi hệ thống
        --gán lại partnerid = null để xóa hết người dùng đã đặt hẹn, phòng trường hợp có khôi phục lại bài viết thì không bị lưu lại thông tin của người đặt hẹn cũ
    WHERE
        tb_post.ownerid = userid_in and isdeleted = 2;


    COMMIT;
END;

-- procedure khôi phục bài viết bị xóa

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

/*Bổ sung thêm ngày 10/5-Giahuy*/
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
        --bài viết đang chưa có ai đặt hẹn và không bị xóa nên có thể đặt hẹn
        IF ( get_post.statusid = 1  and get_post.isdeleted = 0) THEN
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

            IF ( get_post.purposeid = 1 AND current_schedule >= 5 ) THEN
                raise_application_error(-20000,'Không thể đặt hẹn do đã quá 5 lần đặt hẹn trong tuần');

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
                    'Bạn đã đặt lịch hẹn thành công tại bài viết ' || get_post.title
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
            raise_application_error(-20000,'Lỗi!! Bài viết không khả dụng lúc này.');
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
        raise_application_error(-20000,'Bài viết chưa có lịch hẹn để thực hiện thao tác hủy');
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

--procedure xác nhận bài viết đã thành công
CREATE OR REPLACE PROCEDURE p_confirm_scheduling (
    postid_in  tb_post.postid%TYPE,--bài viết bị tác động lên
    userid_in  tb_user.userid%TYPE --id chủ bài viết
) AS
    get_post          tb_post%rowtype;
BEGIN
IF (get_post.statusid != 2) then
    raise_application_error(-20000,'Bài viết chưa có lịch hẹn');
ELSE 
    --chỉ có chủ bài viết mới có thể xác nhận hoàn thành
    IF (userid_in != get_post.ownerid) then
        raise_application_error(-20000,'Lỗi, chỉ chủ bài đăng có thể xác nhận');
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

--procedure lấy ra bảng xếp hạng nhân ái ở thời điểm hiện tại
CREATE OR REPLACE PROCEDURE p_score_list 
AS
    USER_ROW TB_USER%ROWTYPE;
    CURSOR GET_TOP_USER IS SELECT * FROM TB_USER WHERE ISDELETED = 0 ORDER BY SCORE DESC FETCH NEXT 5 ROWS ONLY;
    --phải xét isdeleted = 0 để tránh thống kê phải những tài khoản đã bị xóa(xóa mềm)
BEGIN
    OPEN GET_TOP_USER;
    LOOP
    FETCH GET_TOP_USER INTO USER_ROW;
    EXIT WHEN GET_TOP_USER%notfound;
    dbms_output.put_line(USER_ROW.FIRSTNAME || ' ' || USER_ROW.LASTNAME || ' ' || USER_ROW.SCORE || ' điểm');
    END LOOP;
    CLOSE GET_TOP_USER;
END;

--procedure lấy ra thông tin 1 bài viết, procedure khá cùi nên chỉ dùng để mô phỏng giao tác đồng thời
CREATE OR REPLACE PROCEDURE p_post_show (POSTID_IN TB_POST.POSTID%TYPE)
AS
    GET_POST TB_POST%ROWTYPE;
    OWNER_NAME TB_USER.FIRSTNAME%TYPE;
    PURPOSE_NAME TB_PURPOSE.PURPOSENAME%TYPE;
    CATEGORY_NAME TB_CATEGORY.CATEGORYNAME%TYPE;
    STATUS_NAME TB_POSTSTATUS.STATUSNAME%TYPE;
BEGIN
SELECT * INTO GET_POST FROM TB_POST WHERE POSTID = POSTID_IN;
SELECT FIRSTNAME || LASTNAME INTO OWNER_NAME FROM TB_USER WHERE USERID = GET_POST.OWNERID;
SELECT PURPOSENAME INTO PURPOSE_NAME FROM TB_PURPOSE WHERE PURPOSEID = GET_POST.PURPOSEID;
SELECT CATEGORYNAME INTO CATEGORY_NAME FROM TB_CATEGORY WHERE CATEGORYID = GET_POST.CATEGORYID;
SELECT STATUSNAME INTO STATUS_NAME FROM TB_POSTSTATUS WHERE STATUSID = GET_POST.STATUSID;

DBMS_OUTPUT.PUT_LINE('Bài viết: ' || GET_POST.TITLE);
DBMS_OUTPUT.PUT_LINE('Ngày đăng: ' || GET_POST.CREATEDON);
DBMS_OUTPUT.PUT_LINE('Đăng bởi: ' || OWNER_NAME);
DBMS_OUTPUT.PUT_LINE('Phân loại: ' || PURPOSE_NAME);
DBMS_OUTPUT.PUT_LINE('Danh mục: ' || CATEGORY_NAME);
DBMS_OUTPUT.PUT_LINE('Nội dung: ' || GET_POST.CONTENT);
DBMS_OUTPUT.PUT_LINE('Tình trạng: ' || STATUS_NAME);
END;

--procedure cập nhật thông tin cá nhân
CREATE OR REPLACE PROCEDURE p_update_account (
    userid_in tb_user.userid%type,
    firstname_in    tb_user.firstname%TYPE,
    lastname_in     tb_user.lastname%TYPE,
    gender_in      tb_user.gender%TYPE,
    dateofbirth_in  tb_user.dateofbirth%TYPE,
    cityid_in tb_address.cityid%type,
    districtid_in tb_address.districtid%TYPE,
    address_in tb_address.address%type
) AS
BEGIN
    update tb_user set 
        firstname = firstname_in,
        lastname = lastname_in,
        gender = gender_in,
        dateofbirth = dateofbirth_in
    where userid = userid_in;
    
    update tb_address set
        cityid = cityid_in,
        districtid = districtid_in,
        address = address_in
    where userid = userid_in;
    
    INSERT INTO tb_notification (
        userid,
        content
    ) VALUES (
        userid_in,
        'Cập nhật thông tin tài khoản thành công'
    );
    
    COMMIT;
END;