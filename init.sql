CREATE DATABASE IF NOT EXISTS gwuser CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

use gwuser;

create table tbl_user (
    uuid varchar(255) primary key,
    username varchar(255) not null unique,
    password varchar(255) not null,
    name varchar(255),
    email varchar(255),
    phone varchar(50)
);
