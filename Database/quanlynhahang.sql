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
  constraint fk_Account_Employee foreign key(idEmp) references Employee(idEmp) ON DELETE CASCADE
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
  quantity INT NOT NULL,
  note nvarchar(255) NOT NULL
)
CREATE TABLE Tables (
  idTB INT IDENTITY(1,1) PRIMARY KEY,
  tbNumber INT NOT NULL,
  note nvarchar(255)
) 

CREATE TABLE Expense (
  idExp INT IDENTITY(1,1) PRIMARY KEY,
  createdAt Date NOT NULL DEFAULT GETDATE(),
  idEmp INT NOT NULL,
  constraint fk_Expense_Employee foreign key(idEmp) references Employee(idEmp) ON DELETE CASCADE
)

CREATE TABLE Expensedetail (
  idExpDetail INT IDENTITY(1,1) PRIMARY KEY,
  quantity INT NOT NULL,
  price money NOT NULL,
  type nvarchar(20) NOT NULL,
  idExp INT NOT NULL,
  id_type INT NOT NULL,
  constraint fk_Expensedetail_Expense foreign key(idExp) references Expense(idExp) ON DELETE CASCADE
)
CREATE TABLE Bill (
  idBill INT IDENTITY(1,1) PRIMARY KEY,
  idTb INT NOT NULL,
  idCus INT NOT NULL,
  idEmp INT NOT NULL,
  createdAt Date NOT NULL DEFAULT GETDATE(),
  constraint fk_Bill_Tables foreign key(idTb) references Tables(idTb),
  constraint fk_Bill_Customer foreign key(idCus) references Customer(idCus) ON DELETE CASCADE,
  constraint fk_Bill_Employee foreign key(idEmp) references Employee(idEmp) ON DELETE CASCADE
) 

CREATE TABLE Billdetail (
  idBill INT,
  idDish INT ,
  quantity INT NOT NULL,
  constraint pk_Billdetail primary key(idBill,idDish),
  constraint fk_pk_Billdetail_Bill foreign key(idBill) references Bill(idBill) ON DELETE CASCADE,
  constraint fk_pk_Billdetail_Dish foreign key(idDish) references Dish(idDish) ON DELETE CASCADE
)

--- start trigger 

create trigger trg_update_quantity_when_insert_Equipment on Equipment
for insert
as begin
	declare @idEquip int
	declare @type nvarchar(20) = 'Equipment'
	select @idEquip  = @idEquip from inserted
	if(exists(select * from Expensedetail where id_type = @idEquip and type = @type))
		begin	
				declare @quantity int = (select quantity from inserted)
				update Expensedetail
				Set quantity += @quantity where id_type = @idEquip and type = @type
		end
end
create trigger trg_update_quantity_when_insert_Material on Material
for insert
as begin
	declare @idMat int
	declare @type nvarchar(20) = 'Material'
	select @idMat  = @idMat from inserted
	if(exists(select * from Expensedetail where id_type = @idMat and type = @type))
		begin	
				declare @quantity int = (select quantity from inserted)
				update Expensedetail
				Set quantity += @quantity where id_type = @idMat and type = @type
		end
end

--- end trigger 
-- --------------------------------------------------------
insert into Employee values(N'Nguyễn văn dương','0328669614','6/7/2001',N'Nam',7500000,N'Thanh Hóa','Nhân viên');
insert into Account values('duong2k1','duong2k1','Admin',1);

select * from Employee

select * from Account

select * from Equipment

select * from Material