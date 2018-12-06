    drop table Customer cascade constraints;
    
    drop sequence CUSTOMER_SEQ;

    drop table Currency cascade constraints;

    drop table Customer cascade constraints;

    drop table PAYMENT_METHOD cascade constraints;

    drop table POS_ORDER cascade constraints;

    drop table POS_ORDER_DETAIL cascade constraints;

    drop table POS_TRANSACTION cascade constraints;

    drop table POS_TRANSACTION_TYPE cascade constraints;

    drop table Product cascade constraints;

    drop table PRODUCT_CAT cascade constraints;

    drop table TRANSACTION_DETAIL cascade constraints;

    drop table TRANSACTION_PAYMENT cascade constraints;

    drop sequence CUSTOMER_SEQ;

    drop sequence hibernate_sequence;

    drop sequence PRODUCT_CAT_SEQ;

    drop sequence PRODUCT_SEQ;

    drop sequence TRANSACTION_PAYMENT_SEQ;

    drop sequence TRANSACTION_SEQ;
    
create sequence CUSTOMER_SEQ start with 1001 increment by 1;
create sequence hibernate_sequence start with 1001 increment by 1;
create sequence PRODUCT_CAT_SEQ start with 1001 increment by 1;
create sequence PRODUCT_SEQ start with 1001 increment by 1;
create sequence TRANSACTION_PAYMENT_SEQ start with 1001 increment by 1;
create sequence TRANSACTION_SEQ start with 1001 increment by 50;
create sequence CUSTOMER_SEQ start with 1 increment by 50;

    create table Customer (
       CUSTOMER_ID number(19,0) not null,
        address varchar2(255),
        CUSTOMER_NAME varchar2(255),
        TEL_NO varchar2(255),
        primary key (CUSTOMER_ID)
    );


    create table Currency (
       CURR_ID number(19,0) not null,
        CURR_CODE varchar2(255),
        CURR_DESC varchar2(255),
        primary key (CURR_ID)
    );

    create table Customer (
       CUSTOMER_ID number(19,0) not null,
        address varchar2(255),
        CUSTOMER_NAME varchar2(255),
        TEL_NO varchar2(255),
        primary key (CUSTOMER_ID)
    );

    create table PAYMENT_METHOD (
       PAYMENT_METHOD_ID number(19,0) not null,
        description varchar2(255),
        primary key (PAYMENT_METHOD_ID)
    );

    create table POS_ORDER (
       ORDER_ID number(19,0) not null,
        USERNAME varchar2(255),
        CUSTOMER_ID number(19,0),
        primary key (ORDER_ID)
    );

    create table POS_ORDER_DETAIL (
       ORDER_DETAIL_ID number(19,0) not null,
        DESCRIPTION varchar2(255),
        ORDER_ID number(19,0),
        PRICE float,
        primary key (ORDER_DETAIL_ID)
    );

    create table POS_TRANSACTION (
       TRANSACTION_ID number(19,0) not null,
        status number(19,2),
        TRANSACTION_AMOUNT double precision,
        TRANSACTION_DATE date,
        TRANSACTION_OPEN_AMOUNT double precision,
        CUSTOMER_ID number(19,0),
        TRANSACTION_TYPE_ID number(19,0),
        primary key (TRANSACTION_ID)
    );

    create table POS_TRANSACTION_TYPE (
       TRANSACTION_TYPE_ID number(19,0) not null,
        description varchar2(255),
        primary key (TRANSACTION_TYPE_ID)
    );

    create table Product (
       PRODUCT_ID number(19,0) not null,
        barcode varchar2(255),
        description varchar2(255),
        price double precision not null,
        serialnum varchar2(255),
        CURR_ID number(19,0),
        PRODUCT_CAT_ID number(19,0),
        primary key (PRODUCT_ID)
    );

    create table PRODUCT_CAT (
       PRODUCT_CAT_ID number(19,0) not null,
        description varchar2(255),
        primary key (PRODUCT_CAT_ID)
    );

    create table TRANSACTION_DETAIL (
       TRANSACTION_ID number(19,0) not null,
        PRODUCT_ID number(19,0) not null
    );

    create table TRANSACTION_PAYMENT (
       PAYMENT_ID number(19,0) not null,
        PAYMENT_AMOUNT double precision,
        PAYMENT_METHOD_ID number(19,0),
        TRANSACTION_ID number(19,0),
        primary key (PAYMENT_ID)
    );

    alter table POS_ORDER 
       add constraint FKfx6rqb4jeyn0dixs2w7uci6dq 
       foreign key (CUSTOMER_ID) 
       references Customer;

    alter table POS_ORDER_DETAIL 
       add constraint FKjs3mjpefvbgmwn3bi8410oj2l 
       foreign key (ORDER_ID) 
       references POS_ORDER;

    alter table POS_TRANSACTION 
       add constraint FKdk17c865ace4ce45b05ds7m55 
       foreign key (CUSTOMER_ID) 
       references Customer;

    alter table POS_TRANSACTION 
       add constraint FKncen8594jync80ytuuduneg8 
       foreign key (TRANSACTION_TYPE_ID) 
       references POS_TRANSACTION_TYPE;

    alter table Product 
       add constraint FKkkmjq8rpi6nxsshcihororyr 
       foreign key (CURR_ID) 
       references Currency;

    alter table Product 
       add constraint FKkvfr2ytp4aoigctswilalbq4n 
       foreign key (PRODUCT_CAT_ID) 
       references PRODUCT_CAT;

    alter table TRANSACTION_DETAIL 
       add constraint FKm7x2ej7xm3btib2kp8gttij9p 
       foreign key (PRODUCT_ID) 
       references Product;

    alter table TRANSACTION_DETAIL 
       add constraint FK55xds11vbb7a1e3176q4gen9p 
       foreign key (TRANSACTION_ID) 
       references POS_TRANSACTION;

    alter table TRANSACTION_PAYMENT 
       add constraint FK8jx10ttpt0dul0yhcrv0dvekt 
       foreign key (PAYMENT_METHOD_ID) 
       references PAYMENT_METHOD;

    alter table TRANSACTION_PAYMENT 
       add constraint FKfda1284f9egj3clve4n9gldnv 
       foreign key (TRANSACTION_ID) 
       references POS_TRANSACTION;
