create database projecthex;
use projecthex;
create table customer(cid int primary key, FName varchar(20), LName varchar(20), email varchar(20),phonenumber varchar(20), address varchar(20), username varchar(20) unique, password varchar(20), registrationdate date);
create table vechile( vid int primary key auto_increment , model varchar(20), manuyear year, color varchar(20), regno varchar(20), avaliability boolean, dailyrate decimal(10,2));
create table reservation(reservationid int primary key, cid int, vid int, startdate datetime,enddate datetime,totalcost decimal(10,2),statusof varchar(20),foreign key(cid) references customer(cid), foreign key (vid) references  Vechile(vid));
create table admint(adminid int primary key , fname varchar(20),lname varchar(20),email varchar(20),phonenum varchar(20),username1 varchar(20) unique, password1 varchar(20),roles varchar(20),joindate date);
INSERT INTO customer (cid, FName, LName, email, phonenumber, address, username, password, registrationdate)
VALUES
(1, 'John', 'Doe', 'john@example.com', '1234567890', '123 Main St', 'johndoe', 'password123', '2024-01-01'),
(2, 'Jane', 'Smith', 'smith@example.com', '0987654321', '456 Elm St', 'janesmith', 'password456', '2024-01-02'),
(3, 'Michael', 'Johnson', 'michael@example.com', '5555555555', '789 Oak St', 'michaelj', 'password789', '2024-01-03'),
(4, 'Emily', 'Brown', 'brown@example.com', '1112223333', '101 Pine St', 'emilyb', 'passwordabc', '2024-01-04'),
(5, 'David', 'Wilson', 'david@example.com', '4444444444', '202 Maple St', 'davidw', 'passwordxyz', '2024-01-05');
INSERT INTO vechile (vid, model, manuyear, color, regno, avaliability, dailyrate)
VALUES
(1, 'Toyota Camry', 2020, 'Blue', 'ABC123', true, 50.00),
(2, 'Honda Civic', 2019, 'Red', 'XYZ456', true, 45.00),
(3, 'Ford Mustang', 2021, 'Black', 'DEF789', true, 70.00),
(4, 'Chevrolet Malibu', 2018, 'Silver', 'GHI101', true, 55.00),
(5, 'Nissan Altima', 2022, 'White', 'JKL202', true, 60.00);
INSERT INTO reservation (reservationid, cid, vid, startdate, enddate, totalcost, statusof)
VALUES
(1, 1, 2, '2024-01-10 08:00:00', '2024-01-15 12:00:00', 250.00, 'Confirmed'),
(2, 2, 3, '2024-02-05 10:00:00', '2024-02-10 15:00:00', 350.00, 'Confirmed'),
(3, 3, 4, '2024-03-01 09:00:00', '2024-03-05 11:00:00', 275.00, 'Confirmed'),
(4, 4, 5, '2024-04-20 08:30:00', '2024-04-25 10:30:00', 300.00, 'Confirmed'),
(5, 5, 1, '2024-05-15 07:00:00', '2024-05-20 14:00:00', 300.00, 'Confirmed');
INSERT INTO admint (adminid, fname, lname, email, phonenum, username1, password1, roles, joindate)
VALUES
(1, 'Admin', 'One', 'admin1@example.com', '9998887777', 'admin1', 'adminpass1', 'Super Admin', '2024-01-01'),
(2, 'Admin', 'Two', 'admin2@example.com', '7776665555', 'admin2', 'adminpass2', 'Admin', '2024-01-02'),
(3, 'Admin', 'Three', 'admin3@example.com', '5554443333', 'admin3', 'adminpass3', 'Admin', '2024-01-03'),
(4, 'Admin', 'Four', 'admin4@example.com', '3332221111', 'admin4', 'adminpass4', 'Admin', '2024-01-04'),
(5, 'Admin', 'Five', 'admin5@example.com', '1110009999', 'admin5', 'adminpass5', 'Admin', '2024-01-05');
select * from customer;
select * from vechile;
select * from reservation;
select * from admint;
ALTER TABLE Customer MODIFY cid INT AUTO_INCREMENT;

drop table vechile;



