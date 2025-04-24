nhanviennhanvienUSE AlphaBooksAlphaBooks

DELIMITER //

CREATE TRIGGER trg_ThemChiTietHoaDon
AFTER INSERT ON ChiTietHoaDon
FOR EACH ROW
BEGIN
    DECLARE v_SanPhamID VARCHAR(255);
    DECLARE v_SoLuongLayDi INT;
    
    SET v_SanPhamID = NEW.SanPhamID;
    SET v_SoLuongLayDi = NEW.SoLuong;
    
    IF (SELECT TrangThai FROM HoaDon WHERE HoaDonID = NEW.HoaDonID) = 'DA_XU_LY' THEN
        UPDATE SanPham 
        SET SoLuongTon = SoLuongTon - v_SoLuongLayDi
        WHERE SanPhamID = v_SanPhamID;
    END IF;
END;//

DELIMITER ;AlphaBooks

DELIMITER //

CREATE TRIGGER trg_ThemHoaDon
AFTER INSERT ON HoaDon
FOR EACH ROW
BEGIN
    DECLARE v_KhuyenMaiID VARCHAR(255);
    
    SET v_KhuyenMaiID = NEW.CodeKhuyenMai;
    
    IF NEW.TrangThai = 'DA_XU_LY' THEN
        IF v_KhuyenMaiID != 'NO_APPLY' THEN
            UPDATE KhuyenMai 
            SET SoLuotDaApDung = SoLuotDaApDung + 1
            WHERE CodeKhuyenMai = v_KhuyenMaiID 
            AND SoLuotDaApDung + 1 <= SoLuongKhuyenMai;
        END IF;
    END IF;
END;//

DELIMITER ;

DELIMITER //

CREATE TRIGGER trg_ThemChiTietTraHang
AFTER INSERT ON ChiTietTraHang
FOR EACH ROW
BEGIN
    DECLARE v_SanPhamID VARCHAR(255);
    DECLARE v_SoLuongTraLai INT;
    
    SET v_SanPhamID = NEW.SanPhamID;
    SET v_SoLuongTraLai = NEW.SoLuong;
    
    UPDATE SanPham 
    SET SoLuongTon = SoLuongTon + v_SoLuongTraLai
    WHERE SanPhamID = v_SanPhamID;
END;//

DELIMITER ;


INSERT INTO KhachHang (KhachHangID, HoTen, SoDienThoai, NgaySInh, GioiTinh, Email, MaSoThue, DiaChi, LoaiKhachHang)
VALUES
    ('KH0001', N'Khách lẻ', '0000', '1990-05-15', 'NAM', '', '', '', 'DOANH_NGHIEP'),
    ('KH0002', N'Nguyễn Thành Luân', '0123456789', '1990-05-15', 'NAM', 'customer1@example.com', '1234567890', '123 Customer St', 'DOANH_NGHIEP'),
    ('KH0003', N'Chu Công Quý', '0123456788', '1985-10-20', 'NAM', 'customer2@example.com', '9876543210', '456 Shopper Ave', 'CA_NHAN'), 
    ('KH0004', N'Dương Thái Bảo', '0123456777', '1985-10-20', 'NAM', 'customer3@example.com', '', '', 'CA_NHAN');

INSERT ThuongHieu (TenThuongHieu) VALUES (N'Hồng Hạnh Books');
INSERT ThuongHieu (TenThuongHieu) VALUES (N'Kim Yên Cung cấp');
INSERT ThuongHieu (TenThuongHieu) VALUES (N'Luân Providers');
INSERT ThuongHieu (TenThuongHieu) VALUES (N'Công ty Một mình tôi');
INSERT ThuongHieu (TenThuongHieu) VALUES (N'Công ty Họ nhà Báo');
INSERT ThuongHieu (TenThuongHieu) VALUES (N'Công ty Si mê');
INSERT ThuongHieu (TenThuongHieu) VALUES (N'Công ty Học chăm');
INSERT ThuongHieu (TenThuongHieu) VALUES (N'Nhà cung cấp Hồng');

-- TÁC GIẢ
INSERT INTO TacGia (TenTacGia, QuocTich) VALUES (N'Nguyễn Nhựt Ánh', N'Việt Nam');
INSERT INTO TacGia (TenTacGia, QuocTich) VALUES (N'Rosie Nguyễn', N'Việt Nam');
INSERT INTO TacGia (TenTacGia, QuocTich) VALUES (N'Rani Shah', N'Việt Nam');
INSERT INTO TacGia (TenTacGia, QuocTich) VALUES (N'Bảo Dương', N'Địa Ngục');
INSERT INTO TacGia (TenTacGia, QuocTich) VALUES (N'Huy Nguyễn', N'Việt Nam');
INSERT INTO TacGia (TenTacGia, QuocTich) VALUES (N'Kennex', N'USK');
INSERT INTO TacGia (TenTacGia, QuocTich) VALUES (N'Mai Rồi Viết', N'Japan');
INSERT INTO TacGia (TenTacGia, QuocTich) VALUES (N'Người Ẩn Danh', N'KOREA');
INSERT INTO TacGia (TenTacGia, QuocTich) VALUES (N'Ngủ và Viết', N'Việt Nam');

INSERT INTO DanhMuc (TenDanhMuc)
VALUES
    (N'Danh mục 1'),
    (N'Danh mục 2'),
    (N'Danh mục 3'),
    (N'Danh mục 4'),
    (N'Danh mục 5'),
    (N'Danh mục 6'),
    (N'Danh mục 7'),
    (N'Danh mục 8');

-- Thể loại
INSERT INTO TheLoai (TenTheLoai)
VALUES
    (N'Thể loại 1'),
    (N'Thể loại 2'),
    (N'Thể loại 3'),
    (N'Thể loại 4'),
    (N'Thể loại 5'),
    (N'Thể loại 6'),
    (N'Thể loại 7'),
    (N'Thể loại 8'),
    (N'Thể loại 9'),
    (N'Thể loại 10');
	
-- Nhà xuất bản
-- Sample data for NhaXuatBan table
INSERT INTO NhaXuatBan (TenNhaXuatBan, DiaChi, SoDienThoai, Email, Website, NamThanhLap, LinhVucXuatBan, QuocGia)
VALUES
    ('Publisher 1', '123 Publisher St', '111-222-3333', 'publisher1@example.com', 'www.publisher1.com', 1990, 'Fiction', 'USA'),
    ('Publisher 2', '456 Publisher Ave', '444-555-6666', 'publisher2@example.com', 'www.publisher2.com', 1985, 'Mystery', 'UK');



INSERT INTO NhaCungCap (NhaCungCapID, TenNhaCungCap, SoDienThoai, Email, DiaChi)
VALUES
    ('NCC00001', N'Công Ty Cổ Phần Phát Hành Sách Tp. HCM', '02838225798', 'fahasa-sg@hcm.vnn.vn', N'60-62 Lê Lợi, P. Bến Nghé, Q. 1, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00002', N'Trí Tuệ - Công Ty Cổ Phần Sách & Thiết Bị Giáo Dục Trí Tuệ', '02438515567', 'kinhdoanh@nhasachtritue.com', N'187 Giảng Võ, Q. Đống Đa, Hà Nội'),
    ('NCC00003', N'Công Ty TNHH Văn Hóa Việt Long', '02838452708', 'info@vietlonbook.com', N'14/35, Đào Duy Anh, P.9, Q. Phú Nhuận, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00004', N'Công Ty Cổ Phần Sách Mcbooks', '0986066630', 'thongtinsach@mcbooks.vn', N'Lô 34E, Khu Đấu Giá 3ha, P. Phúc Diễn, Q. Bắc Từ Liêm, Hà Nội'),
    ('NCC00005', N'Nhà Sách Trực Tuyến BOOKBUY.VN', '02838207153', 'info@bookbuy.vn', N'147 Pasteur, P. 6, Q. 3, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00006', N'Công Ty TNHH Đăng Nguyên', '02543716857', 'vudinh200574@yahoo.com', N'Thôn Đức Mỹ, X. Suối Nghệ, H. Châu Đức, Bà Rịa-Vũng Tàu'),
    ('NCC00007', N'Công Ty Cổ Phần Sách Giáo Dục Tại Thành Phố Hà Nội', '02462534308', 'hongtran27979@gmail.com', N'Công Ty Cổ Phần Sách Giáo Dục Tại Thành Phố Hà Nội'),
    ('NCC00008', N'DaNaBook - Công Ty Cổ Phần Sách & Thiết Bị Trường Học Đà Nẵng', '02363821009', 'danabook@gmail.com', N'78 Bạch Đằng, Q. Hải Châu, Tp. Đà Nẵng'),
    ('NCC00009', N'Công Ty Cổ Phần Sách & Thiết Bị Trường Học Kiên Giang', '02973862125', 'donghobooks@gmail.com', N'Lô E16, Số 30, 31, 32 Đường 3 Tháng 2, P. Vĩnh Lạc, TP Rạch Giá, Kiên Giang'),
    ('NCC00010', N'Công Ty CP Sách Và Thiết Bị Trường Học Đà Nẵng', '02363821133', 'doanhongtien@gmail.com', N'76-78 Bạch Đằng, Q. Hải Châu, Tp. Đà Nẵng'),
    ('NCC00011', N'Công Ty Cổ Phần Dịch Vụ Xuất Bản Giáo Dục Hà Nội', '02435121977', 'info@xbgdhn.vn', N'Tầng 4 Tòa Nhà Diamond Flower Tower 48 Lê Văn Lương, P. Nhân Chính, Q. Thanh Xuân Hà Nội'),
    ('NCC00012', N'Nhà Sách Trực Tuyến Atlazbooks', '02485857659', 'info@atlazbooks.com', N'Tầng 5, Số 23 Hoàng Văn Thái, P. Khương Mai, Q. Thanh Xuân, Hà Nội'),
    ('NCC00013', N'Quỳnh Phát - Công Ty TNHH Thương Mại Dịch Vụ Quỳnh Phát', '02838612167', 'quynhphatbook@yahoo.com', N'232 Trần Thủ Độ, P. Phú Thạnh, Q. Tân Phú, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00014', N'Nhà Sách Nguyễn Du', '02543533399', 'sales@nguyendubook.com', N'17C Nam Kỳ Khởi Nghĩa, P.3, Tp. Vũng Tàu, Bà Rịa-Vũng Tàu'),
    ('NCC00015', N'Nhà Sách Bích Quân', '0944566788', 'sachsichauhaiphong@gmail.com', N'249 Lý Thường Kiệt, KP. Thống Nhất 1, Dĩ An, Bình Dương'),
    ('NCC00016', N'Công Ty Cổ Phần Phát Hành Sách Khánh Hòa', '02583822120', 'sachsichaukhanhhoa@gmail.com', N'34-36 Thống Nhất, Tp. Nha Trang, Khánh Hòa'),
    ('NCC00017', N'Công Ty Cổ Phần Sách - Thiết Bị Trường Học Đắk Lắk', '02623950306', 'sachtbthdaklak@gmail.com', N'19 Trường Chinh, P. Tân Lợi, Tp. Buôn Ma Thuột, Đắk Lắk'),
    ('NCC00018', N'Công Ty Cổ Phần Sách Và Thiết Bị Đồng Tháp', '02773861802', 'sachthietbidt@gmail.com', N'NguyễAlphaBookschitiethoadonnhanvienn Sinh Sắc, P. 2, TP. Sa Đéc, Đồng Tháp'),
    ('NCC00019', N'Công Ty TNHH Đầu Tư Và Phát Triển Kiwi', '0906302311', 'tuanpatc@gmail.com', N'Số 19 Lê Quý Đôn, P. Đồng Mỹ, TP. Đồng Hới, Quảng Bình'),
    ('NCC00020', N'Công Ty Cổ Phần Sách Và Thiết Bị Trường Học Trà Vinh', '02943862278', 'stbthtravinh@yahoo.com.vn', N'3A Trưng Nữ Vương, P. 1, TP. Trà Vinh, Trà Vinh'),
    ('NCC00021', N'Công Ty TNHH Thiết Bị Kiên Huy Anh', '02973876688', 'nhasachkienhuy@gmail.com', N'884B Nguyễn Trung Trực, Tp. Rạch Giá, Kiên Giang'),
    ('NCC00022', N'Nhà Sách Tài Chính', '0931307898', 'dinhphuongnam102@gmail.com', N'TL 37 Thạnh Lộc, Q. 12, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00023', N'Công Ty Cổ Phần Sách Và Thiết Bị Trường Học Long An', '02723822374', 'stbthla@yahoo.com.vn', N'39 Hai Bà Trưng, P. 1, TP. Tân An, Long An'),
    ('NCC00024', N'Công Ty Cổ Phần Truyền Thông Và Xuất Bản Amak', '02462559966', 'info@amak.vn', N'Tầng 2, Số 46 Tân ấp, P. Phúc Xá, Q. Ba Đình, Hà Nội'),
    ('NCC00025', N'Công Ty Cổ Phần Sách - Thiết Bị Vĩnh Long', '02703822373', 'sachthietbivinhlong@gmail.com', N'23 Lê Văn Tám, P. 1, TX. Vĩnh Long, Vĩnh Long'),
    ('NCC00026', N'Công Ty Cổ Phần Sách & Thiết Bị Trường Học', '02223821614', 'congtysachbn@gmail.com', N'Số 14, Nguyễn Đăng Đạo, Tp. Bắc Ninh, Bắc Ninh'),
    ('NCC00027', N'Công Ty Cổ Phần Sách Thiết Bị Trường Học Thành Phố Cần Thơ', '02923822106', 'stbcantho@gmail.com', N'179B/7, Võ Văn Kiệt, P. Long Hòa, Q. Bình Thủy, Tp. Cần Thơ'),
    ('NCC00028', N'Nhà Sách Nguyệt Linh', '02438252394', 'nguyetlinhbook@gmail.com', N'Gác 2, Số 5 Đinh Lễ, Phường Tràng Tiền, Quận Hoàn Kiếm, Hà Nội'),
    ('NCC00029', N'Nhà Sách Ngoại Văn BOA', '0909892312', 'boa.bookstore@gmail.com', N'Phòng C26, Lầu 2, 42 Trần Cao Vân, Q.3 (Hồ Con Rùa), Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00030', N'Công Ty TNHH MTV Sách - Thiết Bị & Xây Dựng Trường Học Hà Nội', '02439361052', 'rat.bookstore@gmail.com', N'45B Lý Thường Kiệt, Q. Hoàn Kiếm, Hà Nội'),
    ('NCC00031', N'Công Ty Cổ Phần Sách - Thiết Bị Bến Tre', '02753822389', 'stbbtvn@yahoo.com', N'450E Ấp Hữu Nhơn, X. Hữu Định, Q. Châu Thành, Bến Tre'),
    ('NCC00032', N'Công Ty TNHH Thương Mại Và Dịch Vụ Sách Gia Định', '02873036803', 'giadinhbook@gmail.com', N'6/20A Lê Đức Thọ, P. 16, Q. Gò Vấp, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00033', N'Công Ty Cổ Phần Sách Và Thiết Bị Sóc Trăng', '02993820093', 'sachsoctrang@gmail.com', N'47 Lê Duẩn, P. 3, Tp. Sóc Trăng, Sóc Trăng'),
    ('NCC00034', N'Nhà Sách An Dương Vương', '02838351939', 'thachnguyen2711@gmail.com', N'87/1 Trần Phú, P. 4, Q. 5, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00035', N'Doanh Nghiệp Tư Nhân In Ấn Nhật Đăng', '02963842835', 'loind2015@yahoo.com', N'291/6 Hùng Vương, P. Mỹ Long, TP. Long Xuyên, An Giang'),
    ('NCC00036', N'Công Ty Cổ Phần Sách Thiết Bị Cà Mau', '02903831859', 'ctcpstbcamau@gmail.com', N'26-28 Lê Lợi, P. 2, Tp. Cà Mau, Cà Mau'),
    ('NCC00037', N'Công Ty Cổ Phần Văn Hóa Nhân Văn', '02836007777', 'sieuthisachnhanvan@gmail.com', N'1 Trường Chinh, P. 1, Q. Tân Bình, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00038', N'Công Ty CP Sách & Thiết Bị Trường Học Quảng Ninh', '02033825130', 'congtysach.soquangninh@gmail.com', N'10 Long Tiên, Tp. Hạ Long, Quảng Ninh'),
    ('NCC00039', N'Công Ty Cổ Phần Sách Và Thiết Bị Trường Học Thành Phố Hồ Chí Minh', '02838554645', 'lienhe@stb.com.vn', N'223 Nguyễn Tri Phương, P. 9, Q. 5, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00040', N'Hiệu Sách Tiến Thành', '0919196677', 'kimlong240988@gmail.com', N'Số 11-13 Đường 53, P. 10, Q. 6, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00041', N'Nhà Sách Quyết Bình', '02835561920', 'tbgd_thanhkien@yahoo.com', N'55/5 Bình Quới, P. 28, Q. Bình Thạnh, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00042', N'Công Ty Cổ Phần Sách & Dịch Vụ Văn Hóa Bình Thuận', '02523827545', 'sachvhbt@hcm.vnn.vn', N'284 Trần Hưng Đạo, Tp. Phan Thiết, Bình Thuận'),
    ('NCC00043', N'Nhà Sách 19', '02838243913', 'thienvuongcp@yahoo.com', N'64B Nguyễn Thị Minh Khai, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00044', N'Công Ty Truyền Thông Rubby Media', '02462911322', 'info@thuvientructuyen.vn', N'183 Hoàng Văn Thái, Thanh Xuân, Hà Nội'),
    ('NCC00045', N'Công Ty TNHH Thương Mại Và Dịch Vụ Sách Gia Định', '02173036803', 'giadinhboo2k@gmail.com', N'6/20A Lê Đức Thọ, P. 16, Q. Gò Vấp, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00046', N'Nhà Sách Online Sgbook.Net', '0916574202', 'sgbook.net@sgbook.net', N'265/79 Nguyễn Thái Sơn, P. 7, Q. Gò Vấp, Tp. Hồ Chí Minh (TPHCM)'),
    ('NCC00047', N'Công Ty TNHH MTV Sách - Thiết Bị & Xây Dựng Trường Học Hà Nội', '02139361052', 'sgbook.com@sgbook.net', N'45B Lý Thường Kiệt, Q. Hoàn Kiếm, Hà Nội'),
    ('NCC00048', N'Nhà Sách Thanh Niên Quy Nhơn', '02563818295', 'tonthatkhuyet@gmail.com', N'339-341 Đường Trần Hưng Đạo, Bình Định');

INSERT INTO SanPham (TacGiaID, TheLoaiID, NhaXuatBanID, ThuongHieuID, DanhMucID, NhaCungCapID, TenSanPham, NgayNhap, Thue, LoaiDoiTra, Barcode, ImgPath, TinhTrang, SoLuongTon, NamSanXuat, LoaiSanPham, DonViDoLuong, KichThuoc, XuatXu, NgonNgu, SoTrang, LoaiBia, GiaNhap)
VALUES
    (1, 1, 1, 1, 1, 'NCC00001', N'Mắt biếc', '2023-11-01 00:00:00', 1, 'DUOC_DOI_TRA', '8933456123456', 'img/products/MatBiec.jpg', 'CON_HANG', 4000, 2023, 'SACH', 'pcs', 'A5', 'USA', 'English', 250, 'Hardcover', 50000),
    (2, 2, 1, 1, 2, 'NCC00002', N'BatMan', '2023-11-02 00:00:00', 4, 'DUOC_DOI_TRA', '8936789012345', 'img/products/BatMan.png', 'CON_HANG', 4000, 2022, 'SACH', 'pcs', 'A4', 'UK', 'English', 300, 'Paperback', 70000),
    (2, 1, 2, 1, 1, 'NCC00001', N'Bí ẩn là mãi mãi', '2023-11-17 00:00:00', 4, 'DUOC_DOI_TRA', '8939876543210', 'img/products/BiAnLaMaiMai.png', 'NGUNG_KINH_DOANH', 4000, 2003, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 100, 'Hardcover', 35000),
    (6, 1, 1, 1, 1, 'NCC00001', N'Bí ẩnn đảo lớn', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8939876543212', 'img/products/BiAnDaoLon.png', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 230, 'Paperback', 500000),
    (1, 1, 1, 1, 1, 'NCC00001', N'Ngồi khóc trên cây', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8938765432198', 'img/products/Cryingintrees.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 127, 'Paperback', 40000),
    (6, 1, 1, 1, 1, 'NCC00001', N'Đắc Nhân Tâm', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8937654321987', 'img/products/DacNhanTam.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 238, 'Paperback', 130000),
    (5, 1, 1, 1, 1, 'NCC00001', N'Làm bạn với bầu trời', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8936543219876', 'img/products/LamBanVoiBauTroi.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 100, 'Paperback', 20000),
    (2, 1, 1, 1, 1, 'NCC00001', N'Mình nói gì với hạnh phúc', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8935432198765', 'img/products/MinhNoiGiVeHanhPhuc.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 30, 'Paperback', 75000),
    (2, 1, 1, 1, 1, 'NCC00001', N'Những chồi non hy vọng', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8934321987654', 'img/products/NhungChoiNonHyVong.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 100, 'Paperback', 42000),
    (3, 1, 1, 1, 1, 'NCC00002', N'Triết lý từ những điều tầm thường', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8933219876543', 'img/products/TrietLyTuNhungDieuTamThuong.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 98, 'Paperback', 36000),
    (6, 1, 1, 1, 1, 'NCC00001', N'Tin học', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8931111222233', 'img/products/TinHoc.png', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 201, 'Paperback', 120000),
    (6, 1, 1, 1, 1, 'NCC00002', N'Tin học 3', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8934444555566', 'img/products/TinHoc3.png', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 100, 'Paperback', 110000),
    (6, 1, 1, 1, 1, 'NCC00001', N'Tuổi trẻ đáng giá bao nhiêu', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8937777888899', 'img/products/TuoiTreDangGiaBaoNhieu.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 200, 'Paperback', 22000),
    (6, 1, 1, 1, 1, 'NCC00002', N'Vừa nhắm mắt vừa mở cửa s?', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8931234567890', 'img/products/VuaNhamMatVuaMoCuaSo.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A4', 'Việt Nam', 'VietNamese', 200, 'Paperback', 15000),
    (6, 1, 1, 1, 1, 'NCC00001', N'Chị sáu ở côn đảo', '2023-11-01 00:00:00', 1, 'DUOC_DOI_TRA', '8932345678901', 'img/products/ChiSauOConDao.jpg', 'CON_HANG', 4000, 2023, 'SACH', 'pcs', 'A5', 'USA', 'English', 250, 'Hardcover', 90000),
    (2, 2, 1, 1, 2, 'NCC00002', N'Ngộ quá cái gì cũng hóa', '2023-11-02 00:00:00', 6, 'DUOC_DOI_TRA', '8933456789012', 'img/products/NgoQuaCaiGiCungHoa.jpg', 'NGUNG_KINH_DOANH', 4000, 2022, 'SACH', 'pcs', 'A4', 'UK', 'English', 300, 'Paperback', 23000),
    (2, 1, 1, 1, 1, 'NCC00001', N'Những đứa trẻ hiểu chuyện thường không có kẹo ăn', '2023-11-17 00:00:00', 1, 'DUOC_DOI_TRA', '8934567890123', 'img/products/NhungDuaTreHieuChuyenThuongKhongCoKeoAn.jpg', 'CON_HANG', 4000, 2003, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 200, 'Hardcover', 79000),
    (6, 1, 1, 1, 1, 'NCC00001', N'Dế mèn phiêu lưu ký', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8935678901234', 'img/products/DeMenPhieuLuuKy.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 110, 'Hardcover', 60000),
    (1, 1, 1, 1, 1, 'NCC00001', N'Ông già và biển cả', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8936789012345', 'img/products/OngGiaVaBienCa.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 220, 'Hardcover', 59000),
    (6, 1, 1, 1, 1, 'NCC00001', N'Toán không hề ngán', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8937890123456', 'img/products/ToanKhongHeNgan.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 138, 'Hardcover', 192000),
    (5, 1, 1, 1, 1, 'NCC00001', N'Như sao trời ôm lấy đại dương', '2023-11-02 00:00:00', 1, 'DUOC_DOI_TRA', '8938901234567', 'img/products/NhuSaoTroiOmLayDaiDuong.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 280, 'Hardcover', 40000),
    (2, 1, 1, 1, 1, 'NCC00001', N'Sự im lặng của bầy cừu', '2023-11-02 00:00:00', 1, 'KHONG_DOI_TRA', '8939012345678', 'img/products/SuImLangCuaBayCuu.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 210, 'Hardcover', 58000),
    (2, 1, 1, 1, 1, 'NCC00001', N'Truyện ngắn Nguyên Hồng', '2023-11-02 00:00:00', 1, 'KHONG_DOI_TRA', '8931122334455', 'img/products/TruyenNganNguyenHong.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 210, 'Hardcover', 93000),
    (3, 1, 1, 1, 1, 'NCC00002', N'Đồ thị và các thuật toán', '2023-11-02 00:00:00', 1, 'KHONG_DOI_TRA', '8932233445566', 'img/products/DoThiVaCacThuatToan.jpg', 'CON_HANG', 5, 2020, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 200, 'Hardcover', 75000),
    (6, 1, 1, 1, 1, 'NCC00001', N'Tư duy thuật toán', '2023-11-02 00:00:00', 1, 'KHONG_DOI_TRA', '8933344556677', 'img/products/TuDuyThuatToan.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 280, 'Paperback', 299000),
    (6, 1, 1, 1, 1, 'NCC00002', N'Ngữ pháp Tiếng Anh', '2023-11-02 00:00:00', 1, 'KHONG_DOI_TRA', '8934455667788', 'img/products/NguPhapTiengAnh.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 120, 'Paperback', 128000),
    (6, 1, 1, 1, 1, 'NCC00001', N'Bài tập ngữ pháp Tiếng Pháp', '2023-11-02 00:00:00', 1, 'KHONG_DOI_TRA', '8935566778899', 'img/products/BaiTapNguPhapTiengPhap.jpg', 'CON_HANG', 4000, 2020, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 300, 'Paperback', 120000),
    (6, 1, 1, 1, 1, 'NCC00002', N'Nhà giả kim', '2023-11-02 00:00:00', 1, 'KHONG_DOI_TRA', '8936677889900', 'img/products/NhaGiaKim.jpg', 'NGUNG_KINH_DOANH', 4000, 2020, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 100, 'Paperback', 18000),
    (1, 1, 1, 3, 1, 'NCC00001', N'Bút gel', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8937788990011', 'img/products/ButGelDeli.jpg', 'NGUNG_KINH_DOANH', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 5000),
    (1, 1, 1, 6, 1, 'NCC00002', N'Ghim kẹp giấy', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8938899001122', 'img/products/GhimKepGiayMeKI.jpg', 'CON_HANG', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 3000),
    (1, 1, 1, 3, 1, 'NCC00002', N'Bút xóa', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8939900112233', 'img/products/ButXoaDeli.jpg', 'CON_HANG', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 59000),
    (1, 1, 1, 6, 1, 'NCC00002', N'Bìa lá', '2023-11-26 00:00:00', 2, 'DUOC_DOI_TRA', '8931234432112', 'img/products/BiaLaMEKI.jpg', 'CON_HANG', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 74000),
    (1, 1, 1, 4, 1, 'NCC00001', N'Hộp đựng bút', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8934321123412', 'img/products/HopDungButUUMIR.jpg', 'NGUNG_KINH_DOANH', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 58000),
    (1, 1, 1, 3, 1, 'NCC00001', N'Kéo', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8939876543210', 'img/products/KeoDeli.jpg', 'CON_HANG', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 35000),
    (1, 1, 1, 5, 1, 'NCC00001', N'Nhãn dính', '2023-11-04 00:00:00', 1, 'DUOC_DOI_TRA', '8938765432109', 'img/products/NhanDinhEELHOE.jpg', 'CON_HANG', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 102000),
    (1, 1, 1, 5, 1, 'NCC00002', N'Nhíp màu', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8937654321098', 'img/products/NhipMauEELHOE.jpg', 'CON_HANG', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 20000),
    (1, 1, 1, 5, 1, 'NCC00002', N'Viên làm sạch oxy', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8936543210987', 'img/products/VienLamSachOxyELLHOE.jpg', 'CON_HANG', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 77000),
    (1, 1, 1, 3, 1, 'NCC00001', N'Thước', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8935432109876', 'img/products/ThuocDeli.jpg', 'CON_HANG', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt nam', '1', 1, '', 12000),
    (1, 1, 1, 6, 1, 'NCC00002', N'Sổ ghi chú', '2023-11-26 00:00:00', 2, 'DUOC_DOI_TRA', '8934321098765', 'img/products/SoLoXoMEKI.jpg', 'CON_HANG', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 23000),
    (1, 1, 1, 5, 1, 'NCC00001', N'Sticker', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8933210987654', 'img/products/StickerEELHOE.jpg', 'CON_HANG', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 56000),
    (1, 1, 1, 6, 1, 'NCC00002', N'Hộp đựng bút', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8932109876543', 'img/products/TuiDungButMEKI.jpg', 'CON_HANG', 4000, 2023, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 52000),
    (6, 1, 1, 1, 1, 'NCC00001', N'Cây cam ngọt của tôi', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8931357924680', 'img/products/CayCamNgotCuaToi.jpg', 'NGUNG_KINH_DOANH', 4000, 2023, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 100, 'Paperback', 10000),
    (6, 1, 1, 1, 1, 'NCC00001', N'Vợ nhặt', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8932468013579', 'img/products/VoNhat.jpg', 'NGUNG_KINH_DOANH', 4000, 2000, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 100, 'Paperback', 10000),
    (1, 1, 1, 3, 1, 'NCC00001', N'Ô', '2023-11-26 00:00:00', 1, 'DUOC_DOI_TRA', '8931029384756', 'img/products/ODeli.jpg', 'CON_HANG', 4000, 2003, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 10000),
    (2, 3, 2, 1, 2, 'NCC00001', N'Vật lý siêu hấp dẫn', '2023-12-01 00:00:00', 1, 'DUOC_DOI_TRA', '8932093847561', 'img/products/VatLySieuHapDan.jpg', 'NGUNG_KINH_DOANH', 4000, 2003, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 100, 'Paperback', 10000),
    (1, 1, 1, 2, 1, 'NCC00002', N'1', '2023-12-01 00:00:00', 1, 'DUOC_DOI_TRA', '8939786543215', '', 'CON_HANG', 4000, 2003, 'SAN_PHAM_KHAC', '', '', 'Việt Nam', '1', 1, '', 10000),
    (9, 2, 1, 1, 2, 'NCC00002', N'Tiểu sử các quốc gia', '2023-12-01 00:00:00', 3, 'DUOC_DOI_TRA', '8937654321098', 'img/products/TieuSuCacQuocGia.jpg', 'CON_HANG', 4000, 2003, 'SACH', 'pcs', 'A2', 'Việt Nam', 'VietNamese', 100, 'Paperback', 20000);




INSERT INTO KhuyenMai (CodeKhuyenMai, TenKhuyenMai, LoaiGiamGia, GiaTri, NgayKhuyenMai, NgayHetHanKM, DonHangTu, SoLuongKhuyenMai, SoLuotDaApDung) VALUES 
('APPLY_PRODUCT_3', 'Sự kiện chào đón năm mới', 'PHAN_TRAM', 3, '2024-12-12 00:00:00', '2025-02-28 00:00:00', 11200, 100, 0),
('APPLY_PRODUCT_ONE', 'Giảm giá cuối năm 2023', 'PHAN_TRAM', 4, '2024-11-01 00:00:00', '2025-12-31 00:00:00', 10000, 1, 0),
('APPLY_PRODUCT_TWO', 'Giảm giá đầu năm 2024', 'GIA_TRI', 40000, '2024-01-01 00:00:00', '2025-02-28 00:00:00', 15000, 1, 0),
('KM0001', 'Discount 10%', 'PHAN_TRAM', 10, '2024-11-01 00:00:00', '2025-11-30 00:00:00', 1, 100, 0),
('KM0002', 'Black Friday', 'GIA_TRI', 20000, '2023-11-25 00:00:00', '2025-11-27 00:00:00', 1, 200, 0),
('NO_APPLY', 'Không áp dụng', 'PHAN_TRAM', 0, '2023-11-01 00:00:00', '2025-11-30 00:00:00', 1, 100, 0),
('Voucher_aLvkPW', 'Sự kiện tết nguyên đám', 'PHAN_TRAM', 10, '2023-12-12 00:00:00', '2025-01-30 00:00:00', 100000, 1, 0),
('Voucher_dpnzQo', 'Giảm giá cho đơn trên 20k', 'GIA_TRI', 50000, '2023-12-12 00:00:00', '2025-01-12 00:00:00', 10000, 1, 0),
('Voucher_H4evz9', 'Sự kiện tết nguyên đám', 'PHAN_TRAM', 10, '2023-12-12 00:00:00', '2025-01-30 00:00:00', 100000, 1, 0),
('Voucher_JS3I_B', 'Giảm giá cho đơn trên 20k', 'GIA_TRI', 50000, '2023-12-12 00:00:00', '2025-01-12 00:00:00', 10000, 1, 0),
('Voucher_nqqRki', 'Sự kiện tết nguyên đám', 'PHAN_TRAM', 10, '2023-12-12 00:00:00', '2025-01-30 00:00:00', 100000, 1, 0),
('Voucher_NZpB1Z', 'Giảm giá cho đơn trên 20k', 'GIA_TRI', 50000, '2023-12-12 00:00:00', '2025-01-12 00:00:00', 10000, 1, 0),
('Voucher_o71A5b', 'Sự kiện tết nguyên đám', 'PHAN_TRAM', 10, '2023-12-12 00:00:00', '2025-01-30 00:00:00', 100000, 1, 0),
('Voucher_uA9lZa', 'Giảm giá cho đơn trên 20k', 'GIA_TRI', 50000, '2023-12-12 00:00:00', '2025-01-12 00:00:00', 10000, 1, 0),
('Voucher_W59SdW', 'Sự kiện tết nguyên đám', 'PHAN_TRAM', 10, '2023-12-12 00:00:00', '2025-01-30 00:00:00', 100000, 1, 0),
('Voucher_yKgduo', 'Giảm giá cho đơn trên 20k', 'GIA_TRI', 50000, '2023-12-12 00:00:00', '2025-01-12 00:00:00', 10000, 1, 0);


INSERT INTO ChiTietKhuyenMai (NgayTao, SanPhamID, CodeKhuyenMai) VALUES 
('2023-12-12 00:00:00', 1, 'APPLY_PRODUCT_ONE'),
('2023-12-12 00:00:00', 2, 'APPLY_PRODUCT_ONE'),
('2023-12-12 00:00:00', 1, 'APPLY_PRODUCT_TWO'),
('2023-12-12 00:00:00', 2, 'APPLY_PRODUCT_TWO'),
('2023-12-12 00:00:00', 1, 'APPLY_PRODUCT_3'),
('2023-12-12 00:00:00', 2, 'APPLY_PRODUCT_3');



INSERT INTO NhanVien (NhanVienID, UserName, Password, NgayTaoTK, HoTen, GioiTinh, SoDIenThoai, ChucVu, Email, NgaySInh, DiaChi)
VALUES
    ('NV0001', 'quanly01', '123456', '2023-11-01', N'Bùi Tấn Phát', 'NAM', '0869510030', 'NGUOI_QUAN_LY', 'duongthaibao.job@gmail.com', '2003-12-19', N'Bình Phước'),
    ('NV0002', 'nhanvien02', '123456', '2023-11-02', N'Nguyễn Lê Nhật Huy', 'NAM', '9876543210', 'NHAN_VIEN_BAN_HANG', 'huynguyen@gmail.com', '1985-05-20', '456 Elm St'),
    ('NV0003', 'nhanvien03', '123456', '2023-11-02', N'Pham Minh Hiếu', 'NAM', '0123456789', 'NHAN_VIEN_BAN_HANG', 'hieu@gmail.com', '1985-05-20', '456 Elm St'),
    ('NV0004', 'nhanvien04', '123456', '2023-11-02', N'Nguyễn Văn Hậu', 'NAM', '0987654321', 'NHAN_VIEN_BAN_HANG', 'hau@gmail.com', '1985-05-20', '456 Elm St');


INSERT INTO HoaDon (HoaDonID, CodeKhuyenMai, KhachHangID, NhanVienID, NgayLapHoaDon, TongTien, TrangThai, Thue, GiaKhuyenMai)
VALUES
    ('HD010123001', 'NO_APPLY', 'KH0002', 'NV0001', '2025-01-01 08:35:05', 2816520, 'DA_XU_LY', 0, 0),
    ('HD010123002', 'NO_APPLY', 'KH0003', 'NV0001', '2025-01-01 06:54:11', 3100896, 'DA_XU_LY', 0, 0),
    ('HD010123003', 'NO_APPLY', 'KH0003', 'NV0001', '2025-01-01 09:02:00', 24240, 'DA_XU_LY', 0, 0),
    ('HD010123004', 'NO_APPLY', 'KH0002', 'NV0001', '2025-01-01 07:51:16', 1980408, 'DA_XU_LY', 0, 0),
    ('HD010123005', 'NO_APPLY', 'KH0003', 'NV0001', '2025-01-01 13:57:44', 3471168, 'DA_XU_LY', 0, 0),
    ('HD010223001', 'NO_APPLY', 'KH0001', 'NV0001', '2025-02-01 05:58:03', 1135680, 'DA_XU_LY', 0, 0),
    ('HD010323001', 'NO_APPLY', 'KH0003', 'NV0001', '2025-03-01 20:50:22', 3348756, 'DA_XU_LY', 0, 0);
INSERT INTO ChiTietHoaDon (SoLuong, HoaDonID, SanPhamID, DonGia)
VALUES
    (2, 'HD010123001', 46, 12120),
    (2, 'HD010123002', 16, 29256),
    (10, 'HD010123003', 39, 28152),
    (3, 'HD010123004', 30, 3636),
    (7, 'HD010123005', 20, 232704),
    (4, 'HD010223001', 44, 12120),
    (3, 'HD010323001', 40, 67872),
    (3, 'HD010323001', 13, 26664);
