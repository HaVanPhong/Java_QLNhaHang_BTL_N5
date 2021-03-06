use master
go
create database QuanLyNhaHang
go
use QuanLyNhaHang
go

CREATE TABLE Employee (
  idEmp INT IDENTITY(1,1) PRIMARY KEY,
  fullname nvarchar(255) NOT NULL,
  phone nvarchar(15) NOT NULL,
  birthday nvarchar(20) NOT NULL,
  gender nvarchar(10) not null,
  salary money not null,
  address nvarchar(255) NOT NULL,
  position nvarchar(20) not null
)
CREATE TABLE Account (
  idUser INT IDENTITY(1,1) PRIMARY KEY,
  username nvarchar(50) NOT NULL,
  password nvarchar(30) NOT NULL,
  role nvarchar(10) ,
  idEmp int,
  constraint fk_Account_Employee foreign key(idEmp) references Employee(idEmp)
)
CREATE TABLE Customer (
  idCus INT IDENTITY(1,1) PRIMARY KEY,
  fullname nvarchar(50) NOT NULL,
  phone nvarchar(15) NOT NULL
) 
CREATE TABLE Dish (
  idDish INT IDENTITY(1,1) PRIMARY KEY,
  name nvarchar(255) NOT NULL,
  price money NOT NULL
) 
CREATE TABLE Equipment (
  idEquip INT IDENTITY(1,1) PRIMARY KEY,
  name nvarchar(255) NOT NULL,
  quantity INT NOT NULL,
  note nvarchar(255)
)
CREATE TABLE Material (
  idMat INT IDENTITY(1,1) PRIMARY KEY,
  name nvarchar(255) NOT NULL,
  quantity float NOT NULL,
  note nvarchar(255)
)

CREATE TABLE Tables (
  idTB INT IDENTITY(1,1) PRIMARY KEY,
  tbNumber INT NOT NULL,
  note nvarchar(255)
) 

CREATE TABLE Expense (
  idExp INT IDENTITY(1,1) PRIMARY KEY,
  idEmp INT,
  createdAt Date NOT NULL DEFAULT GETDATE(),
  constraint fk_Expense_Employee foreign key(idEmp) references Employee(idEmp)
)

CREATE TABLE Expensedetail (
  idExpDetail INT IDENTITY(1,1) PRIMARY KEY,
  idExp INT NOT NULL,
  idType INT NOT NULL,
  type nvarchar(20) NOT NULL,
  quantity int NOT NULL,
  price money NOT NULL,
  constraint fk_Expensedetail_Expense foreign key(idExp) references Expense(idExp)
)

CREATE TABLE Bill (
  idBill INT IDENTITY(1,1) PRIMARY KEY,
  idTb INT ,
  idCus INT,
  idEmp INT,
  total money NOT NULL,
  createdAt Date NOT NULL DEFAULT GETDATE(),
  constraint fk_Bill_Tables foreign key(idTb) references Tables(idTb),
  constraint fk_Bill_Customer foreign key(idCus) references Customer(idCus),
  constraint fk_Bill_Employee foreign key(idEmp) references Employee(idEmp)
) 

CREATE TABLE Billdetail (
  idBill INT,
  idDish INT ,
  quantity INT NOT NULL,
  constraint pk_Billdetail primary key(idBill,idDish),
  constraint fk_pk_Billdetail_Bill foreign key(idBill) references Bill(idBill),
  constraint fk_pk_Billdetail_Dish foreign key(idDish) references Dish(idDish)
)

-- --------------------------------------------------------
insert into Employee values(N'Nguyễn văn dương','0328669614','6/7/2001',N'Nam',7500000,N'Thanh Hóa','Nhân viên');
insert into Account values('duong2k1','duong2k1','Quản lý',1);
insert into Tables values(1)
insert into Customer values (N'Nguyễn Bá Đông', '0123456789');
insert into Dish(name, price) values(N'pizza hải sản', 100000),
									(N'khoai tây chiên', 20000) 

insert into Customer values ('anonymous', '0000')


insert into Material(name, quantity) values (N'Thịt lợn', 20),
											(N'Cần tây', 10)

insert into Equipment(name, quantity) values(N'Bàn', 10),
											(N'Ghế', 10)


select * from Employee

select * from Account

select * from Tables

select * from Customer

select * from Bill

select * from Dish


select * from Billdetail

select * from Material
