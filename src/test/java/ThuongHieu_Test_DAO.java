import connectDB.ConnectDB;
import dao.TheLoai_DAO;
import dao.ThuongHieu_DAO;
import entities.ThuongHieu;
import interfaces.IThuongHieu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class ThuongHieu_Test_DAO {
    private static ThuongHieu_DAO thuongHieu_dao;

    @BeforeAll
    public static void setUp() {
        // thiết lập kết nối
        ConnectDB.connect();

       try {
           thuongHieu_dao = new ThuongHieu_DAO();
       }catch (Exception e){
           e.printStackTrace();
           fail("lỗi khởi tạo ThuongHieu_DAO");
       }

    }

    @Test
    public void laydanhsachthuonghieu(){
        try {
            List<ThuongHieu> danhsachthoThuongHieus = thuongHieu_dao.getAllThuongHieu();
            assertNotNull(danhsachthoThuongHieus, "danh sach thuonghieu khong duoc null");
            assertTrue(danhsachthoThuongHieus.size() > 0,"danh sach thuonghieu phai it nhat 0 phan tu");
        }catch (Exception e){
            e.printStackTrace();
            fail("loi lay danh sach thuong hieu");
        }
    }

    @Test
    public void timthuonghieutheoID() {
        try {
            List<ThuongHieu> thuongHieuID = thuongHieu_dao.getThuongHieuTheoID(130);
            assertNotNull(thuongHieuID, "Danh sách thương hiệu không được null");
            assertFalse(thuongHieuID.isEmpty(), "Không tìm thấy thương hiệu với ID đã cho");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Lỗi khi lấy danh sách thương hiệu theo ID");
        }
    }

    @Test
    public void themthuonghieu() throws Exception {

        ThuongHieu thuongHieu = new ThuongHieu();
        thuongHieu.setTenThuongHieu("Vinfast");
        try {
        Boolean ketQua = thuongHieu_dao.addThuongHieu(thuongHieu);
        assertTrue(ketQua, "Thêm thuong hieu thất bại");
        }catch (Exception e){
            e.printStackTrace();
            fail("Lỗi khi them thuong hieu");
        }
    }



}
