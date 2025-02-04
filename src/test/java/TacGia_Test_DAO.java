import dao.TacGia_DAO;
import entities.TacGia;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import connectDB.ConnectDB;

import java.rmi.RemoteException;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TacGia_Test_DAO {
    private TacGia_DAO tacGiaDAO;

    @BeforeAll
    public void setup() {
        // Thiết lập kết nối và khởi tạo DAO
        ConnectDB.connect();
        try {
            tacGiaDAO = new TacGia_DAO();
        } catch (RemoteException e) {
            e.printStackTrace();
            fail("Lỗi khi khởi tạo TacGia_DAO");
        }
    }

    @Test
    public void testLayDanhSachTacGia() {
        try {
            List<TacGia> danhSachTacGia = tacGiaDAO.getAllTacGia();
            assertNotNull(danhSachTacGia, "Danh sách tác giả không được null");
            assertTrue(danhSachTacGia.size() >= 0, "Danh sách tác giả phải có ít nhất 0 phần tử");
        } catch (RemoteException e) {
            e.printStackTrace();
            fail("Lỗi khi gọi phương thức getAllTacGia");
        }
    }

    @Test
    public void testThemTacGia() throws Exception {
        TacGia tacGiaMoi = new TacGia();
        tacGiaMoi.setTenTacGia("Nguyễn Văn A");
        tacGiaMoi.setQuocTich("VietNam");

        try {
            boolean ketQua = tacGiaDAO.addTacGia(tacGiaMoi);
            assertTrue(ketQua, "Thêm tác giả thất bại");
        } catch (RemoteException e) {
            e.printStackTrace();
            fail("Lỗi khi gọi phương thức addTacGia");
        }
    }

    @Test
    public void testThemTacGiaKhongHopLe() {
        TacGia tacGiaKhongHopLe = null; // Tác giả null

        try {
            boolean ketQua = tacGiaDAO.addTacGia(tacGiaKhongHopLe);
            assertFalse(ketQua, "Thêm tác giả null không nên thành công");
        } catch (RemoteException e) {
            assertTrue(true, "RemoteException xảy ra như mong đợi với dữ liệu không hợp lệ");
        } catch (Exception e) {
            fail("Lỗi không mong đợi: " + e.getMessage());
        }
    }
}
