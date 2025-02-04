import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import entities.KhachHang;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class KhachHang_Test_DAO {

    private static KhachHang_DAO khachHangDao;

    @BeforeAll
    public static void setUp() {
        ConnectDB.connect();
        try {
            khachHangDao = new KhachHang_DAO();
        }catch (Exception e) {
            e.printStackTrace();
            fail("loi khi tao KhachHangDao");
        }
    }

    @Test
    public void getListAllKhachHang() {
        try {
            List<KhachHang> khachHangs = khachHangDao.getAllKhachHang();
            assertNotNull(khachHangs,"danh sach khach hang khong duoc null");
        }catch (Exception e) {
            e.printStackTrace();
            fail("loi khi tao KhachHangDao");
        }
    }

    @Test
    public void getKhachHangById() {
        try {
            KhachHang khachHangs = khachHangDao.getKhachHangByKhachHangID("KH1256");
            assertNotNull(khachHangs,"danh sach khach hang null");
            assertFalse(khachHangs.equals(null),"Khong tim thay khach khach hang ID tren");
        }catch (Exception e){
            e.printStackTrace();
            fail("loi khi tao KhachHangDao");
        }

    }
    @Test
    public void addKhachHang() throws Exception {
        KhachHang khachHang = new KhachHang();

        khachHang.setKhachHangID("KH8386");
        khachHang.setDiaChi("13 Le loi");
        khachHang.setEmail("NguyenLong123@gmail.com");
        khachHang.setGioiTinh("Nam");
        khachHang.setHoTen("Nguyen Van Long");
        khachHang.setLoaiKhachHang("Doanh nghiep");
        khachHang.setMaSoThue("1213456789");
        khachHang.setNgaySinh(LocalDate.now());
        khachHang.setSoDienThoai("0123456789");

        try {
            boolean result = khachHangDao.addKhachHang(khachHang);
            assertTrue(result,"addKhachHang that bai");
        }catch (Exception e){
            e.printStackTrace();
            fail("loi khi tao KhachHangDao");
        }
    }
    @Test
    public void updateKhachHang() throws Exception {
        KhachHang khachHang = khachHangDao.getKhachHangByKhachHangID("KH1256");
        khachHang.setDiaChi("123 Nguen Thi Minh Khai");
        try {
            boolean result = khachHangDao.editKhachHang(khachHang);
            assertTrue(result,"editKhachHang that bai");
        }catch (Exception e){
            e.printStackTrace();
            fail("loi khi tao KhachHangDao");
        }
    }
}
