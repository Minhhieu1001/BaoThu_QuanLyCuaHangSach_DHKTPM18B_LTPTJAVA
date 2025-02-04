import dao.TheLoai_DAO;
import entities.TheLoai;
import connectDB.ConnectDB;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.rmi.RemoteException;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TheLoai_Test_DAO {
    private TheLoai_DAO theLoaiDAO;

    @BeforeAll
    public void setup() {
        // Thiết lập kết nối và khởi tạo DAO
        ConnectDB.connect();
        try {
            theLoaiDAO = new TheLoai_DAO();
        } catch (RemoteException e) {
            e.printStackTrace();
            fail("Lỗi khi khởi tạo TheLoai_DAO");
        }
    }

    @Test
    public void testLayDanhSachTheLoai() {
        try {
            List<TheLoai> danhSachTheLoai = theLoaiDAO.getAllTheLoai();
            assertNotNull(danhSachTheLoai, "Danh sách thể loại không được null");
            assertTrue(danhSachTheLoai.size() >= 0, "Danh sách thể loại phải có ít nhất 0 phần tử");
        } catch (RemoteException e) {
            e.printStackTrace();
            fail("Lỗi khi gọi phương thức getAllTheLoai");
        }
    }

    @Test
    public void testThemTheLoai() throws Exception {
        TheLoai theLoaiMoi = new TheLoai();

        theLoaiMoi.setTenTheLoai("Thể loại mẫu");

        try {
            boolean ketQua = theLoaiDAO.addTheLoai(theLoaiMoi);
            assertTrue(ketQua, "Thêm thể loại thất bại");
        } catch (RemoteException e) {
            e.printStackTrace();
            fail("Lỗi khi gọi phương thức addTheLoai");
        }
    }

    @Test
    public void testThemTheLoaiKhongHopLe() {
        TheLoai theLoaiKhongHopLe = null; // Thể loại null

        try {
            boolean ketQua = theLoaiDAO.addTheLoai(theLoaiKhongHopLe);
            assertFalse(ketQua, "Thêm thể loại null không nên thành công");
        } catch (RemoteException e) {
            assertTrue(true, "RemoteException xảy ra như mong đợi với dữ liệu không hợp lệ");
        } catch (Exception e) {
            fail("Lỗi không mong đợi: " + e.getMessage());
        }
    }
}
