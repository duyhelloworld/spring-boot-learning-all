-- Active: 1682410322038@@127.0.0.1@3306

CREATE DATABASE VietLaiSinhVien;

USE VietLaiSinhVien;

create table
    department (
        room_name varchar(5) not null,
        location varchar(100) not null,
        primary key (room_name)
    );
INSERT INTO
    VietLaiSinhVien.department
VALUES
("101H1", "phòng 101 tòa H1"),
("102H1", "phòng 102 tòa H1"),
("201H1", "phòng 201 tòa H1"),
("110H2", "phòng 110 tòa H2"), 
("401H2", "phòng 401 tòa H2");
create table subject (
        id integer not null auto_increment,
        description TEXT,
        is_obligatory bit,
        is_prerequisite bit,
        name varchar(200),
        primary key (id)
    );
INSERT INTO `VietLaiSinhVien`.subject 
VALUES(DEFAULT, "", 1, 1, "Triết học Marc-Lénin"),
    (DEFAULT, "", 0, 0, "Toán học tính toán"),
    (DEFAULT, "", 1, 0, "Phương pháp LT HĐT"),
    (DEFAULT, "", 1, 1, "Giáo dục thể chất 2"),
    (DEFAULT, "", 1, 0, "Đại số tuyến tính");

create table teacher (
        id integer not null auto_increment,
        current_live_in varchar(100),
        dob date,
        email varchar(100),
        full_name varchar(200),
        number_phone varchar(10),
        sex bit,
        was_born_in varchar(100),
        primary key (id)
    );
INSERT INTO `VietLaiSinhVien`.teacher
VALUES (DEFAULT, "4, Đại Hoàn, Kim Quang, Hà Nội", "1989-10-02", "truongpham@standford.edu", "Phạm Hoàng Trường", "0232342345", 1, "Hà Giang"),
    (DEFAULT, "15, Trần Phú, Đống Đa, Hà Nội", "1985-06-22", "nguyenquang@harvard.edu", "Nguyễn Quang", "0123456789", 1, "Hà Tĩnh"), 
    (DEFAULT, "20, Phùng Hưng, Hoàn Kiếm, Hà Nội", "1990-03-10", "tranminh@rmit.edu", "Trần Minh", "0234567890", 1, "Hải Phòng"), 
    (DEFAULT, "25, Lê Văn Lương, Thanh Xuân, Hà Nội", "1982-11-05", "nguyetvo@yale.edu", "Võ Nguyệt", "0345678901", 0, "Quảng Ninh"), 
    (DEFAULT, "10, Tôn Thất Tùng, Đống Đa, Hà Nội", "1987-07-15", "nguyenvan@princeton.edu", "Nguyễn Văn", "0456789012", 1, "Nghệ An"), 
    (DEFAULT, "5, Nguyễn Trãi, Thanh Xuân, Hà Nội", "1984-12-31", "phuongdinh@stanford.edu", "Đinh Phương", "0567890123", 0, "Bắc Ninh");

create table
    manage_class (
        id integer not null auto_increment,
        name varchar(20),
        teacher_id integer,
        primary key (id)
    );
INSERT INTO `VietLaiSinhVien`.manage_class (name, teacher_id)
VALUES  ("66IT5", 1),
        ("66CL9", 2),
        ("65KT3", 3),
        ("67XL2", 5),
        ("64IT1", 4);

create table student (
        id integer not null auto_increment,
        current_live_in varchar(100),
        dob date,
        email varchar(100),
        full_name varchar(200),
        number_phone varchar(10),
        sex bit,
        was_born_in varchar(100),
        manage_class_id integer,
        primary key (id)
    );
INSERT INTO `VietLaiSinhVien`.student (current_live_in, dob, email, full_name, number_phone, sex, was_born_in, manage_class_id)
VALUES
    ("12, Lê Đức Thọ, Mỹ Đình, Hà Nội", "2002-02-05", "nguyenvananh@gmail.com", "Nguyễn Văn Anh", "0912345678", 1, "Hà Nội", 1),
    ("7, Ngô Quyền, Hoàn Kiếm, Hà Nội", "2003-09-12", "tranthithao@yahoo.com", "Trần Thị Thảo", "0922323912", 0, "Hải Phòng", 2),
    ("10, Hoàng Văn Thụ, Hoàng Mai, Hà Nội", "2001-11-23", "phanthanhhoa@hotmail.com", "Phan Thanh Hòa", "0934567891", 1, "Ninh Bình", 3),
    ("15, Trần Phú, Đống Đa, Hà Nội", "2004-05-06", "lethanhthao@gmail.com", "Lê Thanh Thảo", "0378902310", 0, "Hà Nội", 4),
    ("20, Yên Bái, Ba Đình, Hà Nội", "2003-12-31", "phamthuylinh@yahoo.com", "Phạm Thúy Linh", "0912291021", 0, "Yên Bái", 4),
    ("25, Kim Mã, Ba Đình, Hà Nội", "2002-06-15", "vuongminhquan@hotmail.com", "Vương Minh Quân", "093112943", 1, "Hà Nội", 5),
    ("5, Tôn Thất Tùng, Đống Đa, Hà Nội", "2004-01-01", "nguyenvanb@gmail.com", "Nguyễn Văn B", "0934567890", 1, "Bắc Ninh", 3),
    ("17, Tây Sơn, Đống Đa, Hà Nội", "2001-08-20", "hoangthihuong@yahoo.com", "Hoàng Thị Hương", "0911777091", 0, "Hà Nội", 5),
    ("9, Trần Quốc Toản, Hoàn Kiếm, Hà Nội", "2003-03-17", "tranquanghuy@hotmail.com", "Trần Quang Huy", "093234891", 1, "Hà Nội", 1),
    ("22, Nguyễn Trãi, Thanh Xuân, Hà Nội", "2002-12-25", "nguyenquanghien@gmail.com", "Nguyễn Quang Hiền", "036901012", 1, "Nam Định", 5);

create table
    subject_class (
        id integer not null auto_increment,
        name varchar(20),
        department_name varchar(5),
        subject_id integer,
        primary key (id)
    );
INSERT INTO `VietLaiSinhVien`.subject_class (name, department_name, subject_id)
VALUES
    ("66ML1", "101H1", 1),
    ("67THTT2", "102H1", 2),
    ("65HDT4", "101H1", 3),
    ("66TC2", "110H2", 4),
    ("64DSTT7", "201H1", 5);

create table
    subject_class_teacher (
        subject_class_id integer not null,
        teacher_id integer not null,
        primary key (subject_class_id, teacher_id)
    );
INSERT INTO `VietLaiSinhVien`.subject_class_teacher 
VALUES (1, 1), (1, 2), (1, 4), (2, 3), (2, 5), (3, 1), (3, 2), (3, 5), (4, 4), (5, 2), (5, 5);

create table
    subject_class_student (
        subject_class_id integer not null,
        student_id integer not null,
        primary key (subject_class_id, student_id)
    );
INSERT INTO `VietLaiSinhVien`.subject_class_student 
VALUES (2, 10), (3, 2), (3, 7), (2, 9), (5, 1), (5, 2), (5, 3), (5, 5), (5, 6), (5, 9),(5, 10), (5, 8),
(1, 1), (1, 2), (1, 3), (1, 5), (1, 10), (2, 4), (3, 6), (3, 8), (4, 9);

