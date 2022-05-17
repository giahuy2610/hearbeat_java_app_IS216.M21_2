----Create table Address
CREATE TABLE TB_ADDRESS
(
    USERID INTEGER PRIMARY KEY,
    CITYID INTEGER NOT NULL,
    DISTRICTID INTEGER NOT NULL,
    WARD NVARCHAR2(255),
    ADDRESS NVARCHAR2(255)
);

--FOREIGN KEY OF TABLE TB_ADDRESS
alter table TB_ADDRESS 
add constraint FK_ADDR_USER foreign key (UserId)
references TB_USER(UserId);

alter table TB_ADDRESS 
add constraint FK_ADDR_CITYID foreign key (CITYId)
references TB_CITY(CITYId);

alter table TB_ADDRESS 
add constraint FK_ADDR_DISTRICTID foreign key (DISTRICTId)
references TB_DISTRICT(DISTRICTId);
