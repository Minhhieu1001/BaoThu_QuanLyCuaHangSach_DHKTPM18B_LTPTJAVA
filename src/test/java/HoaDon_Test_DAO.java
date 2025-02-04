import connectDB.ConnectDB;
import dao.HoaDon_DAO;
import entities.HoaDon;
import entities.KhachHang;
import entities.KhuyenMai;
import entities.NhanVien;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HoaDon_Test_DAO {
    private static HoaDon_DAO hoaDon_DAO;

    @BeforeAll
    public static void setUp() {
        ConnectDB.connect();
        try {
            hoaDon_DAO = new HoaDon_DAO();
        }catch (Exception e) {
            e.printStackTrace();
            fail("loi khi tao HoaDon_DAO");
        }
    }
    @Test
    public void getListAllHoaDon(){
       try {
           List<HoaDon> hoadons = hoaDon_DAO.getDanhSachHoaDon();
           assertNotNull(hoadons,"danh sach hoa don la null");
       }catch (Exception e) {
           e.printStackTrace();
           fail("loi khi tao HoaDon_DAO");
       }
    }

    @Test
    void testGetHoaDonByID_ValidID() throws RemoteException {
        HoaDon expectedHoaDon = new HoaDon();
        expectedHoaDon.setHoaDonID("HD321207");

        HoaDon result = hoaDon_DAO.getHoaDonByID(expectedHoaDon);

        assertNotNull(result, "Hóa đơn không được null khi tìm thấy");
        assertEquals(expectedHoaDon.getHoaDonID(), result.getHoaDonID(), "ID phải khớp với hóa đơn mong đợi");
    }

    @Test
    public void addHoaDon() throws RemoteException {
        HoaDon hoaDon = new HoaDon();
        hoaDon.setHoaDonID("HD111207");
        hoaDon.setGiaKhuyenMai(123132);
        hoaDon.setNgayLapHoaDon(new Date());
        hoaDon.setThue(1.2);
        hoaDon.setTongTien(456456);
        hoaDon.setTrangThai("Da_Xu_Ly");
        hoaDon.setKhachHang(new KhachHang("KH0652"));
        hoaDon.setNhanVien(new NhanVien("NV0320"));
        hoaDon.setKhuyenMai(new KhuyenMai("KM32670"));

        try {
            boolean result = hoaDon_DAO.createHoaDon(hoaDon);
            assertTrue(result,"them hoa don that bai");
        }catch (Exception e) {
            e.printStackTrace();
            fail("loi khi tao HoaDon_DAO");
        }
    }

    @Test
    public void updateHoaDon() throws RemoteException {
        List<HoaDon> hoaDons = hoaDon_DAO.getDanhSachHoaDon();
        HoaDon hoaDon = hoaDons.get(0);
        hoaDon.setThue(212131);

        try {
            boolean result = hoaDon_DAO.updateHoaDon(hoaDon);
            assertTrue(result,"update hoa don that bai");
        }catch (Exception e) {
            e.printStackTrace();
            fail("loi khi tao HoaDon_DAO");
        }

    }
}
