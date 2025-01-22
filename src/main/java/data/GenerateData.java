package data;

import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class GenerateData {
    private Faker faker = new Faker();
    EntityManager em = Persistence.createEntityManagerFactory("AlphaBook-Production")
            .createEntityManager();

    public SanPham generateSanPham(DanhMuc danhMuc, NhaCungCap nhaCungCap, NhaXuatBan nhaXuatBan, TacGia tacGia, TheLoai theLoai, ThuongHieu thuongHieu) throws Exception {
        SanPham sanPham = new SanPham();
        sanPham.setTenSanPham(faker.commerce().productName());
        sanPham.setSoLuongTon(faker.number().numberBetween(0, 100));
        sanPham.setNamSanXuat(faker.number().numberBetween(2000, LocalDate.now().getYear()));
        sanPham.setSoTrang(faker.number().numberBetween(1, 500));
        sanPham.setNgayNhap(new Date());
        sanPham.setGiaNhap(faker.number().randomDouble(2, 100, 1000));
        sanPham.setThue(faker.number().randomDouble(2, 0, 20));
        sanPham.setLoaiDoiTra("DUOC_DOI_TRA");
        sanPham.setBarcode(faker.code().ean13());
        sanPham.setImgPath(faker.internet().url());
        sanPham.setTinhTrang("CON_HANG");
        sanPham.setLoaiSanPham(faker.commerce().department());
        sanPham.setDonViDoLuong("Piece");
        sanPham.setKichThuoc(faker.number().numberBetween(10, 100) + "x" + faker.number().numberBetween(10, 100) + "x" + faker.number().numberBetween(1, 50));
        sanPham.setXuatXu(faker.country().name());
        sanPham.setNgonNgu(faker.options().option("Vietnamese", "English", "Japanese"));
        sanPham.setLoaiBia(faker.options().option("Bìa mềm", "Bìa cứng"));
        sanPham.setDanhMuc(danhMuc);
        sanPham.setNhaCungCap(nhaCungCap);
        sanPham.setNhaXuatBan(nhaXuatBan);
        sanPham.setTacGia(tacGia);
        sanPham.setTheLoai(theLoai);
        sanPham.setThuongHieu(thuongHieu);
        return sanPham;
    }

    public NhanVien generateNhanVien() throws Exception {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setNhanVienID("NV" + String.format("%04d", ThreadLocalRandom.current().nextInt(1, 10000)));
        nhanVien.setUserName(faker.name().username());
        nhanVien.setPassword(faker.internet().password());
        nhanVien.setNgayTaoTK(LocalDate.now().minusDays(faker.number().numberBetween(1, 365)));
        nhanVien.setHoTen(faker.name().fullName());
        nhanVien.setGioiTinh(faker.options().option("Nam", "Nữ", "Khác"));
        nhanVien.setSoDienThoai(faker.phoneNumber().cellPhone());
        nhanVien.setChucVu(faker.options().option("Nhân Viên", "Quản Lý", "Giám Đốc"));
        nhanVien.setEmail(faker.internet().emailAddress());
        nhanVien.setNgaySinh(LocalDate.now().minusYears(faker.number().numberBetween(18, 60)));
        nhanVien.setDiaChi(faker.address().fullAddress());
        return nhanVien;
    }

    public KhachHang generateKhachHang() throws Exception {
        KhachHang khachHang = new KhachHang();
        khachHang.setKhachHangID("KH" + String.format("%04d", ThreadLocalRandom.current().nextInt(1, 10000)));
        khachHang.setHoTen(faker.name().fullName());
        khachHang.setSoDienThoai(faker.phoneNumber().cellPhone());
        khachHang.setNgaySinh(LocalDate.now().minusYears(faker.number().numberBetween(18, 60)));
        khachHang.setGioiTinh(faker.options().option("Nam", "Nữ", "Khác"));
        khachHang.setEmail(faker.internet().emailAddress());
        khachHang.setMaSoThue(faker.number().digits(10));
        khachHang.setDiaChi(faker.address().fullAddress());
        khachHang.setLoaiKhachHang(faker.options().option("Cá nhân", "Doanh nghiệp"));
        return khachHang;
    }

    public KhuyenMai generateKhuyenMai() {
        KhuyenMai khuyenMai = new KhuyenMai();
        String codeKhuyenMai = "KM" + faker.number().digits(5);
        khuyenMai.setCodeKhuyenMai(codeKhuyenMai != null && !codeKhuyenMai.isEmpty() ? codeKhuyenMai : "KM12345");
        khuyenMai.setTenKhuyenMai(faker.commerce().promotionCode());
        khuyenMai.setLoaiKhuyenMai(faker.options().option("PHAM_TRAM", "GIA_TRI"));
        khuyenMai.setGiaTri(faker.number().randomDouble(2, 10, 50));
        khuyenMai.setNgayKhuyenMai(new java.sql.Date(System.currentTimeMillis() - ThreadLocalRandom.current().nextInt(1, 10) * 86400000L));
        khuyenMai.setNgayHetHanKM(new java.sql.Date(System.currentTimeMillis() + ThreadLocalRandom.current().nextInt(1, 10) * 86400000L));
        khuyenMai.setDonHangTu(faker.number().randomDouble(2, 100, 500));
        khuyenMai.setSoLuongKhuyenMai(faker.number().numberBetween(1, 100));
        khuyenMai.setSoLuotDaApDung(faker.number().numberBetween(0, khuyenMai.getSoLuongKhuyenMai()));
        return khuyenMai;
    }

    public ChiTietKhuyenMai generateChiTietKhuyenMai(int sanPhamID, String codeKhuyenMai) throws Exception {
        System.out.println("DEBUG: codeKhuyenMai = " + codeKhuyenMai + ", sanPhamID = " + sanPhamID);
        SanPham sanPham = em.find(SanPham.class, sanPhamID);
        KhuyenMai khuyenMai = em.find(KhuyenMai.class, codeKhuyenMai);

        ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai();
        chiTietKhuyenMai.setNgayTao(new java.sql.Date(System.currentTimeMillis() - ThreadLocalRandom.current().nextInt(1, 30) * 86400000L));
        chiTietKhuyenMai.setSanPham(sanPham);
        chiTietKhuyenMai.setKhuyenMai(khuyenMai);


        return chiTietKhuyenMai;
    }

    public NhaCungCap generateNhaCungCap() {
        NhaCungCap nhaCungCap = new NhaCungCap();
        nhaCungCap.setNhaCungCapID(faker.idNumber().valid());
        nhaCungCap.setTenNhaCungCap(faker.company().name());
        nhaCungCap.setSoDienThoai(faker.phoneNumber().phoneNumber());
        nhaCungCap.setDiaChi(faker.address().streetAddress());
        nhaCungCap.setEmail(faker.internet().emailAddress());
        return nhaCungCap;
    }

    public NhaXuatBan generateNhaXuatBan() {
        NhaXuatBan nhaXuatBan = new NhaXuatBan();
        nhaXuatBan.setTenNhaXuatBan(faker.company().name());
        nhaXuatBan.setDiaChi(faker.address().streetAddress());
        nhaXuatBan.setSoDienThoai(faker.phoneNumber().phoneNumber());
        nhaXuatBan.setEmail(faker.internet().emailAddress());
        nhaXuatBan.setWebsite(faker.internet().url());
        nhaXuatBan.setNamThanhLap(faker.number().numberBetween(1900, 2023));
        nhaXuatBan.setLinhVucXuatBan(faker.book().genre());
        nhaXuatBan.setQuocGia(faker.address().country());
        return nhaXuatBan;
    }

    public TacGia generateTacGia() throws Exception {
        TacGia tacGia = new TacGia();
        tacGia.setTenTacGia(faker.name().fullName());
        tacGia.setQuocTich(faker.address().country());
        return tacGia;
    }

    public TheLoai generateTheLoai() throws Exception {
        TheLoai theLoai = new TheLoai();
        theLoai.setTenTheLoai(faker.book().genre());
        return theLoai;
    }

    public ThuongHieu generateThuongHieu() throws Exception {
        ThuongHieu thuongHieu = new ThuongHieu();
        thuongHieu.setTenThuongHieu(faker.book().genre());
        return thuongHieu;
    }

    public HoaDon generateHoaDon(KhachHang khachHang, NhanVien nhanVien,KhuyenMai khuyenMai) throws Exception {
        HoaDon hoaDon = new HoaDon();
        String hoaDonID = "HD" + faker.number().randomNumber(6, true);
        hoaDon.setHoaDonID(hoaDonID);
        hoaDon.setGiaKhuyenMai(faker.number().randomDouble(2, 0, 100));
        hoaDon.setNgayLapHoaDon(new Date());
        hoaDon.setThue(faker.number().randomDouble(2, 0, 20));
        hoaDon.setTongTien(faker.number().randomDouble(2, 100, 1000));
        hoaDon.setTrangThai(faker.options().option("CHO_XU_LY", "DA_XU_LY", "HUY_BO"));
        hoaDon.setKhachHang(khachHang);
        hoaDon.setKhuyenMai(khuyenMai);
        hoaDon.setNhanVien(nhanVien);
        return hoaDon;
    }

    public ChiTietHoaDon generateChiTietHoaDon(String hoaDonID, int sanPhamID) throws Exception {
        System.out.println("DEBUG: hoaDonID = " + hoaDonID + ", sanPhamID = " + sanPhamID);
        // Lấy đối tượng HoaDon từ cơ sở dữ liệu
        HoaDon hoaDon = em.find(HoaDon.class, hoaDonID);
        if (hoaDon == null) {
            throw new Exception("Không tìm thấy HoaDon với ID: " + hoaDonID);
        }

        // Lấy đối tượng SanPham từ cơ sở dữ liệu
        SanPham sanPham = em.find(SanPham.class, sanPhamID);
        if (sanPham == null) {
            throw new Exception("Không tìm thấy SanPham với ID: " + sanPhamID);
        }

        // Tạo đối tượng ChiTietHoaDon
        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon();
        chiTietHoaDon.setHoaDon(hoaDon);
        chiTietHoaDon.setSanPham(sanPham);
        chiTietHoaDon.setSoLuong(faker.number().numberBetween(1, 10));
        chiTietHoaDon.setDonGia(Double.parseDouble(faker.commerce().price()));
        return chiTietHoaDon;
    }



    public DanhMuc generateDanhMuc() throws Exception {
        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setTenDanhMuc(faker.book().genre());
        return danhMuc;
    }

    public HoaDonTra generateHoaDonTra(KhachHang khachHang, NhanVien nhanVien) throws Exception {
        HoaDonTra hoaDonTra = new HoaDonTra();
        // Ensure the ID is numeric and 6 digits long
        String hoaDonID = "HD" + String.format("%06d", faker.number().numberBetween(1, 999999));
        hoaDonTra.setHoaDonID(hoaDonID); // Set the formatted ID
        hoaDonTra.setNgayTraHoaDon(new java.sql.Date(System.currentTimeMillis() - ThreadLocalRandom.current().nextInt(1, 30) * 86400000L));
        hoaDonTra.setTongHoan(faker.number().randomDouble(2, 50, 500));
        String[] trangThaiOptions = {"DA_XU_LY", "CHO_XU_LY", "HUY_BO"};
        String trangThai = faker.options().option(trangThaiOptions);
        hoaDonTra.setTrangThai(trangThai);
        hoaDonTra.setKhachHang(khachHang);
        hoaDonTra.setNhanVien(nhanVien);
        return hoaDonTra;
    }

    public ChiTietTraHang generateChiTietTraHang(int sanPhamID, String hoaDonID) throws Exception {
        System.out.println("DEBUG: hoaDonTraID = " + hoaDonID + ", sanPhamID = " + sanPhamID);
        HoaDonTra hoaDon = em.find(HoaDonTra.class, hoaDonID);
        SanPham sanPham = em.find(SanPham.class, sanPhamID);
        ChiTietTraHang chiTietTraHang = new ChiTietTraHang();

        chiTietTraHang.setSanPham(sanPham);
        chiTietTraHang.setHoaDon(hoaDon);
        chiTietTraHang.setSoLuong(faker.number().numberBetween(1, 10));  // Số lượng ngẫu nhiên từ 1 đến 10
        chiTietTraHang.setLiDoTraHang(faker.lorem().sentence());  // Lý do trả hàng ngẫu nhiên
        chiTietTraHang.setDonGia(Double.parseDouble(faker.commerce().price()));  // Đơn giá sản phẩm
        return chiTietTraHang;
    }

    private int getRandomSanPhamID(EntityManager em) {
        List<Integer> ids = em.createQuery("SELECT s.sanPhamID FROM SanPham s", Integer.class).getResultList();
        if (ids.isEmpty()) {
            throw new RuntimeException("Không có sản phẩm nào trong database!");
        }
        return ids.get(ThreadLocalRandom.current().nextInt(ids.size()));
    }


    public void generatePrintSimPleData() throws Exception {
        EntityManager em = Persistence.createEntityManagerFactory("AlphaBook-Production").createEntityManager();
        EntityTransaction tx = em.getTransaction();

        for (int i = 0; i < 2; i++) {
            try {
                tx.begin();

                // Tạo các thực thể
                DanhMuc danhMuc = generateDanhMuc();
                em.persist(danhMuc);

                NhaCungCap nhaCungCap = generateNhaCungCap();
                em.persist(nhaCungCap);

                NhaXuatBan nhaXuatBan = generateNhaXuatBan();
                em.persist(nhaXuatBan);

                TacGia tacGia = generateTacGia();
                em.persist(tacGia);

                TheLoai theLoai = generateTheLoai();
                em.persist(theLoai);

                ThuongHieu thuongHieu = generateThuongHieu();
                em.persist(thuongHieu);

                SanPham sanPham = generateSanPham(danhMuc, nhaCungCap, nhaXuatBan, tacGia, theLoai, thuongHieu);
                em.persist(sanPham);
                em.flush();

                NhanVien nhanVien = generateNhanVien();
                em.persist(nhanVien);

                KhachHang khachHang = generateKhachHang();
                em.persist(khachHang);

                KhuyenMai khuyenMai = generateKhuyenMai();
                em.persist(khuyenMai);

                HoaDon hoaDon = generateHoaDon(khachHang, nhanVien, khuyenMai);
                em.persist(hoaDon);

                HoaDonTra hoaDonTra = generateHoaDonTra(khachHang, nhanVien);
                em.persist(hoaDonTra);

                tx.commit();

                int rd = getRandomSanPhamID(em);
                //Lấy một sản phẩm ngẫu nhiên đã lưu
                tx.begin();
                ChiTietKhuyenMai chiTietKhuyenMai = generateChiTietKhuyenMai(rd, khuyenMai.getCodeKhuyenMai());
                em.persist(chiTietKhuyenMai);

                ChiTietHoaDon chiTietHoaDon = generateChiTietHoaDon(hoaDon.getHoaDonID(), rd);
                em.persist(chiTietHoaDon);

                ChiTietTraHang chiTietTraHang = generateChiTietTraHang(rd, hoaDonTra.getHoaDonID());
                em.persist(chiTietTraHang);

                tx.commit();

            } catch (Exception e) {
                tx.rollback();
                e.printStackTrace();
            }
        }
    }




    public static void main(String[] args) throws Exception {
        GenerateData generateData = new GenerateData();
        generateData.generatePrintSimPleData();
    }
}
