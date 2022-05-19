-----FUNCTION---------
Function thống kê số bài viết mới trong khoảng thời gian
CREATE OR REPLACE FUNCTION f_count_new_post (
    from_date         DATE,
    to_date           DATE,
    statusid_filter   tb_post.statusid%TYPE,
    purposeid_filter  tb_post.purposeid%TYPE
    --nếu statusid_filter = 0 hoặc purposeid_filter = 0 nghĩa là không xét bất kì điều kiện nào
) RETURN INTEGER AS
    count_new_post  INTEGER;
    temp            INTEGER;
BEGIN
    SELECT
        COUNT(postid)
    INTO count_new_post
    FROM
        tb_post
    WHERE
            createdon >= from_date
        AND createdon <= to_date
        AND ( ( ( statusid_filter != 0 )
                AND statusid = statusid_filter )
              OR ( statusid_filter = 0 ) )
        AND ( ( ( purposeid_filter != 0 )
                AND purposeid = purposeid_filter )
              OR ( purposeid_filter = 0 ) );

    RETURN count_new_post;
END;
/

DECLARE
    total_of_post NUMBER;
BEGIN
    total_of_post := f_count_new_post(TO_DATE('1/1/2000', 'dd/mm/yyyy'), TO_DATE('1/1/2024', 'dd/mm/yyyy'), 0, 0);
    dbms_output.put_line('Tong so bai viet moi trong thang: ' || total_of_post);
END;

--Function thống kê số người tham gia mới trong khoảng thời gian
CREATE OR REPLACE FUNCTION f_count_new_user (
    from_date  DATE,
    to_date    DATE
) RETURN INTEGER AS
    count_new_user INTEGER;
BEGIN
    SELECT
        COUNT(userid)
    INTO count_new_user
    FROM
        tb_user
    WHERE
            createdon >= FROM_DATE AND createdon <= TO_DATE
        AND roleid = '1';

    RETURN count_new_user;
END;

DECLARE
    total_of_user_month NUMBER;
BEGIN
    total_of_user_month := f_count_new_user(TO_DATE('1/1/2000', 'dd/mm/yyyy'),TO_DATE('1/1/2024', 'dd/mm/yyyy'));
    dbms_output.put_line('Tong so nguoi dung moi trong thang: ' || total_of_user_month);
END;

