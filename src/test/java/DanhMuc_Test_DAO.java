import connectDB.ConnectDB;
import dao.DanhMuc_DAO;
import entities.DanhMuc;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DanhMuc_Test_DAO {
    private static DanhMuc_DAO danhMuc_DAO;

    @BeforeAll
    public static void setUp() {
        ConnectDB.connect();
        try {
            danhMuc_DAO = new DanhMuc_DAO();
        }catch(Exception e) {
            e.printStackTrace();
            fail("Loi khi tao DanhMuc_DAO");
        }
    }

    @Test

    public void getListAllDanhMuc() throws Exception {

        try {
            List<DanhMuc> danhMucs = danhMuc_DAO.getAllDanhMuc();
            assertNotNull(danhMucs,"Danh sach danh muc khong duoc null");
        }catch (Exception e) {
            e.printStackTrace();
            fail("Loi khi tao DanhMuc_DAO");
        }
    }

    @Test
    public void getDanhMucByID() throws Exception {
        try {
            List<DanhMuc> danhMucs = danhMuc_DAO.getDanhMucTheoID(141);
            assertNotNull(danhMucs,"danh muc khong duoc null");
            assertFalse(danhMucs.isEmpty(),"khong tim thay danh muc theo ID tren");
        }catch (Exception e) {
            e.printStackTrace();
            fail("Loi khi tao DanhMuc_DAO");
        }
    }

    @Test
    public void addDanhMuc() throws Exception {

        DanhMuc danhMuc = new DanhMuc();
        danhMuc.setTenDanhMuc("Bay Vien Ngoc Rong");

        try {
            boolean result = danhMuc_DAO.addDanhMuc(danhMuc);
            assertTrue(result,"them danh muc that bai");
        }catch (Exception e) {
            e.printStackTrace();
            fail("Loi khi tao DanhMuc_DAO");
        }
    }

    @Test
    public void updateDanhMuc() throws Exception {
        List<DanhMuc> danhMucs = danhMuc_DAO.getDanhMucTheoID(193);
        DanhMuc danhMuc = danhMucs.get(0);
        danhMuc.setTenDanhMuc("Co nan Tham Tu Lung Danh");
        try {
            boolean result = danhMuc_DAO.editDanhMuc(danhMuc);
            assertTrue(result,"update danh muc that bai");
        }catch (Exception e) {
            e.printStackTrace();
            fail("Loi khi tao DanhMuc_DAO");
        }
    }
}
