create database QL_KhachSan
go
use QL_KhachSan

---bảng Phòng
create table Phong(
	MaP varchar(20) primary key,
	TenP nvarchar(100) not null,
	Gia float not null,
	TrangThai bit not null--0 là Trống,1 là đang thuê
)

---bảng Nhân viên
create table NhanVien(
	MaNV varchar(20) primary key,
	TenNV nvarchar(100) not null,
	GioiTinh bit not null, -- 0 là nữ, 1 là Nam
	NgaySinh date not null,
	SDT varchar(15) not null
)

---bảng Khách Hàng
create table KhachHang(
	MaKH varchar(20) primary key,
	TenKH nvarchar(100) not null,
	GioiTinh bit not null, -- 0 là nữ, 1 là Nam
	DiaChi nvarchar(250) not null,
	SDT varchar(15) not null,
	CMND varchar(15) not null,
	TrangThai bit -- 1 Thue Phong, 0 Da roi di
)

---bảng Dịch Vụ
create table DichVu(
	MaDV varchar(20) primary key,
	TenDV nvarchar(100) not null,
	Gia float not null
)
---bảng Hóa đơn 
create table HoaDon(
	MaHD varchar(20)primary key,
	MaKH varchar(20) not null,
	FOREIGN KEY (MaKH) REFERENCES KhachHang(MaKH),
	MaNV varchar(20) not null,
	FOREIGN KEY (MaNV) REFERENCES NhanVien(MaNV),
)

create table DatPhong(
	MaHD varchar(20) ,
	FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
	MaP varchar(20),
	FOREIGN KEY (MaP) REFERENCES Phong(MaP),
	NgayDen date not null,
	NgayDi date not null
	primary key(MaHD,MaP)
)

create table SuDungDV(
	MaHD varchar(20) not null,
	FOREIGN KEY (MaHD) REFERENCES HoaDon(MaHD),
	MaDV varchar(20) not null,
	FOREIGN KEY (MaDV) REFERENCES DichVu(MaDV),
	SoLuong int not null,
	NgaySuDung date not null,
		
)



create table NguoiDung(
	MaND int identity primary key,
	TaiKhoan varchar(20),
	MatKhau varchar(20)
)

insert into NguoiDung(TaiKhoan,MatKhau) values ('hotel','123456')

--Insert Phòng
insert into Phong(MaP,TenP,Gia,TrangThai) values
('P01',N'Phòng bình dân 01','500000',1),
('P02',N'Phòng bình dân 02','500000',1),
('P03',N'Phòng bình dân 04','500000',1),
('P04',N'Phòng bình dân 05','500000',1),
('P05',N'Phòng bình dân 06','500000',1),
('P06',N'Phòng bình dân 07','500000',1)
select *from Phong
--Insert Nhân viên
insert into NhanVien(MaNV,TenNV,GioiTinh,NgaySinh,SDT) values
('NV01',N'Nguyễn Chí Phèo',1,'1990-8-20','0968123123'),
('NV02',N'Nguyễn Thị Nở',0,'1991-8-11','0968123456')
select *from NhanVien

--Insert Khách hàng
insert into KhachHang(MaKH,TenKH,GioiTinh,DiaChi,SDT,CMND,TrangThai) values
('KH01',N'Nguyễn Văn Hớn',1,N'Cổ Nhuế-Hà Nội','0968123789','174456456',1),
('KH02',N'Nguyễn Văn Vở',1,N'Hai Bà Trưng-Hà Nội','0968111222','174111222',1)
select *from KhachHang

--Insert Dịch vụ
insert into DichVu(MaDV,TenDV,Gia) values
('DV01',N'Gà quay bắc kinh','500000'),
('DV02',N'Mỳ Ý','100000'),
('DV03',N'Bánh mỳ ','10000')
select *from DichVu

--Insert Hóa Đơn
insert HoaDon(MaHD,MaKH,MaNV)values
('HD01','KH01','NV02')
select *from HoaDon

select HoaDon.MaHD,KhachHang.TenKH,NhanVien.TenNV,HoaDon.NgayLapHD from HoaDon join NhanVien on HoaDon.MaNV=NhanVien.MaNV join KhachHang on HoaDon.MaKH=KhachHang.MaKH



----Bảng view Tiền phòng
create view TienPhong as
	select DatPhong.MaHD,Phong.MaP,Phong.TenP,Phong.Gia,DatPhong.NgayDen,DatPhong.NgayDi,DATEDIFF(Day,DatPhong.NgayDen,DatPhong.NgayDi)*Phong.Gia AS TienPhong from DatPhong 
		join Phong on DatPhong.MaP = Phong.MaP



 --Bảng view Tiền DV
create view TienDichVu as
	select SuDungDV.MaHD,DichVu.MaDV,DichVu.TenDV,DichVu.Gia,SuDungDV.SoLuong,SuDungDV.NgaySuDung,DichVu.Gia*SuDungDV.SoLuong AS TienDV from SuDungDV
		join DichVu on SuDungDV.MaDV = DichVu.MaDV


create view HoaDonDTO as
	select HoaDon.MaHD,KhachHang.MaKH,KhachHang.TenKH,NhanVien.MaNV,NhanVien.TenNV,KhachHang.TrangThai 
	from HoaDon join NhanVien on HoaDon.MaNV=NhanVien.MaNV join KhachHang on HoaDon.MaKH=KhachHang.MaKH







----------------Phòng--------------------
	--Thêm
		create procedure pr_Them_Phong
			@MaP varchar(20),
			@TenP nvarchar(100),
			@Gia float,
			@TrangThai bit
			as
				insert into Phong(MaP,TenP,Gia,TrangThai) values (@MaP,@TenP,@Gia,@TrangThai)
				
			

	--Sửa
		create procedure pr_Sua_Phong
			@MaP varchar(20),
			@TenP nvarchar(100),
			@Gia float,
			@TrangThai bit
			as
				update Phong set TenP=@TenP,Gia=@Gia,TrangThai=@TrangThai where MaP=@MaP

	--Xóa
		create procedure pr_Xoa_Phong
			@MaP varchar(20)
			as
				delete Phong where MaP=@MaP

				
----------------Nhân Viên--------------------
	--Thêm 
	create procedure pr_Them_NhanVien
		@MaNV varchar(20),
		@TenNV nvarchar(100),
		@GioiTinh bit, -- 0 là nữ, 1 là Nam
		@NgaySinh date,
		@SDT varchar(15)
		as
			insert into NhanVien(MaNV,TenNV,GioiTinh,NgaySinh,SDT) values(@MaNV,@TenNV,@GioiTinh,@NgaySinh,@SDT)

	--Sửa
	create procedure pr_Sua_NhanVien
		@MaNV varchar(20),
		@TenNV nvarchar(100),
		@GioiTinh bit, -- 0 là nữ, 1 là Nam
		@NgaySinh date,
		@SDT varchar(15)
		as
			update NhanVien set TenNV=@TenNV,GioiTinh=@GioiTinh,NgaySinh=@NgaySinh,SDT=@SDT where MaNV=@MaNV

	--Xóa
	create procedure pr_Xoa_NhanVien
		@MaNV varchar(20)
		as
			delete NhanVien where MaNV=@MaNV

	--Tìm theo tên Nhân viên
	create procedure pr_TimKiemTheoTen_NhanVien
		@TenNV nvarchar(100)
		as
			select *from NhanVien where TenNV like '%' +@TenNV+ '%' 

--------Dich Vu---------------
--Thêm
	create procedure pr_Them_DichVu
		@MaDV varchar(20),
		@TenDV nvarchar(100),
		@Gia float
		as
			insert into DichVu(MaDV,TenDV,Gia)values(@MaDV,@TenDV,@Gia)	
		
	--Sửa
	create procedure pr_Sua_DichVu
		@MaDV varchar(20),
		@TenDV nvarchar(100),
		@Gia float
	as
		update DichVu set TenDV=@TenDV,Gia=@Gia where MaDV=@MaDV
		
	
	--Xóa
	create procedure pr_Xoa_DichVu
	@MaDV varchar(20)
	as
		delete DichVu where MaDV=@MaDV	
		
	--Tim kiem theo ten dich vu
	create procedure pr_TimKiemTheoTen_DichVu
		@TenDV nvarchar(100)
		as
			select *from DichVu where TenDV like '%' +@TenDV+ '%' 

----------------Khách Hàng--------------------
	--Thêm
	create procedure pr_Them_KhachHang
		@MaKH varchar(20),
		@TenKH nvarchar(100),
		@GioiTinh bit, -- 0 là nữ, 1 là Nam
		@DiaChi nvarchar(250),
		@SDT varchar(15),
		@CMND varchar(15),
		@TrangThai bit
		as
			insert into KhachHang(MaKH,TenKH,GioiTinh,DiaChi,SDT,CMND,TrangThai) 
			values(@MaKH,@TenKH,@GioiTinh,@DiaChi,@SDT,@CMND,@TrangThai)
			
	--Sửa
	create procedure pr_Sua_KhachHang
		@MaKH varchar(20),
		@TenKH nvarchar(100),
		@GioiTinh bit, -- 0 là nữ, 1 là Nam
		@DiaChi nvarchar(250),
		@SDT varchar(15),
		@CMND varchar(15),
		@TrangThai bit
		as
			update KhachHang set 
			TenKH=@TenKH,GioiTinh=@GioiTinh,DiaChi=@DiaChi,SDT=@SDT,CMND=@CMND,TrangThai=@TrangThai
			 where MaKH=@MaKH
			
	--Xóa
	create procedure pr_Xoa_KhachHang
		@MaKH varchar(20)
		as
			delete KhachHang where MaKH=@MaKH

--Tim kiem theo tên khách hàng
	create procedure pr_TimKiemTheoTen_KhachHang
		@TenKH nvarchar(100)
		as
			select *from KhachHang where TenKH like '%' +@TenKH+ '%'


--Tim kiem theo tên khách hàng ở hóa đơn
	create procedure pr_TimKiemTheoTen_KhachHang_HoaDon
		@TenKH nvarchar(100)
		as
			select *from HoaDonDTO where TenKH like '%' +@TenKH+ '%' 