CREATE OR REPLACE PROCEDURE p_delete_post (
    postid_in tb_post.postid%TYPE
) AS
    partner  tb_post.partnerid%type;
    owner    tb_post.ownerid%type;
BEGIN
    UPDATE tb_post
    SET
        isdeleted = 1
    WHERE
        tb_post.postid = postid_in;

    SELECT
        ownerid
    INTO owner
    FROM
        tb_post
    WHERE
        tb_post.postid = postid_in;

    SELECT
        partnerid
    INTO partner
    FROM
        tb_post
    WHERE
        tb_post.postid = postid_in;

    INSERT INTO tb_notification (
        userid,
        content
    ) VALUES (
        owner,
        'Bài viết '
        || temp_post.title
        || 'đã được xóa thành công.'
    );

    IF ( partner IS NOT NULL ) THEN
        INSERT INTO tb_notification (
            userid,
            content
        ) VALUES (
            ownerid,
            'Bài viết '
            || temp_post.title
            || 'đã bị xóa, lịch hẹn của bạn cũng sẽ bị hủy.'
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

    COMMIT;
END;

-- procedure xóa mềm một tài khoản(có thể khôi phục lại thao tác xóa)

CREATE OR REPLACE PROCEDURE p_delete_account (
    userid_in tb_user.userid%TYPE
) AS
    --cursor lấy ra bài viết chưa hoàn thành có người dùng bị xóa đăng kí

    CURSOR get_post_scheduled IS
    SELECT
        *
    FROM
        tb_post
    WHERE
            partnerid = userid_in
        AND statusid = 2;

    --cursor lấy ra bài viết chưa hoàn thành và có người đặt hẹn của người dùng bị xóa tài khoản

    CURSOR get_post IS
    SELECT
        *
    FROM
        tb_post
    WHERE
            ownerid = userid_in
        AND statusid = 2;

    temp_post tb_post%rowtype;
BEGIN
    UPDATE tb_user
    SET
        isdeleted = 1
    WHERE
        tb_user.userid = userid_in;

    BEGIN
        OPEN get_post_scheduled;
        LOOP
            FETCH get_post_scheduled INTO temp_post;
            EXIT WHEN temp_post%notfound;
        END LOOP;
        CLOSE get_post_scheduled;
        
        --hủy lịch hẹn của người này trên mọi bài viết(chưa hoàn thành)
        UPDATE tb_post
        SET
            statusid = 1
        WHERE
            postid = temp_post.postid;
        --gửi một thông báo đến các bài viết đang có người này đặt hẹn(chưa hoàn thành)

        INSERT INTO tb_notification (
            userid,
            content
        ) VALUES (
            temp_post.ownerid,
            'Bài viết '
            || temp_post.title
            || 'đã bị xóa, lịch hẹn của bạn cũng sẽ bị hủy.'
        );

        

        
    
    --trường hợp nếu một bài viết đã hoàn thành, có người dùng bị xóa thực hiện đặt hẹn
    --xóa hết các bài đăng của người dùng này

        UPDATE tb_post
        SET
            isdeleted = 2 --0: khả dụng, 1:bị xóa bởi người dùng, 2: bị xóa bởi hệ thống
        WHERE
            tb_post.ownerid = userid_in;
        
    --gửi một thông báo đến các người dùng đang đặt hẹn với các bài viết mà người này đã đăng(chưa hoàn thành)

        INSERT INTO tb_notification (
            userid,
            content
        ) VALUES (
            temp_post.ownerid,
            'Bài viết '
            || temp_post.title
            || ' của bạn đã bị hủy lịch hẹn.'
        );

    END;    
    
    
    
    

