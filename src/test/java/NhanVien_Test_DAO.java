import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import entities.NhanVien;
import entities.ThuongHieu;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NhanVien_Test_DAO {
    private static NhanVien_DAO nhanVien_dao;
    @BeforeAll
    public static void setUp() {
        ConnectDB.connect();
        try {
            nhanVien_dao = new NhanVien_DAO();
        }catch (Exception e) {
            e.printStackTrace();
            fail("Loi khi khi tao NhanVien_Dao");
        }
    }


    @Test
    public void testthemnhanvien() {
        try {
            List<NhanVien> nhanViens = nhanVien_dao.getAllEmployees();
            assertNotNull(nhanViens,"danh sach nhan vien khong duoc null");
        }catch (Exception e) {
            e.printStackTrace();
            fail("Loi khi khi tao NhanVien_Dao");
        }

    }

    @Test
    public void timnhanvientheoID() {
        try {
            NhanVien nhanViens =  nhanVien_dao.getNhanVienByNhanVienID("NV0209");
            assertNotNull(nhanViens, "Danh sách nhan vien không được null");
            assertFalse(nhanViens.equals(null),"Không tìm thấy nhan vien với ID đã cho");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Lỗi khi lấy danh sách nhan vien theo ID");
        }
    }

//    @Test
//    public void testDeleteNhanVien() throws RemoteException {
//        NhanVien existingNhanVien = nhanVien_dao.getNhanVienByNhanVienID("NV0209");
//        if (existingNhanVien != null) {
//            boolean result = nhanVien_dao.deleteNhanVien(existingNhanVien);
//
//           assertTrue(result,"Xoa nhan vien that bai");
//        } else {
//            fail("Nhân viên không tồn tại");
//        }
//    }

    @Test
    public void testUpdateNhanVien() throws RemoteException {
        NhanVien existingNhanVien = nhanVien_dao.getNhanVienByNhanVienID("NV0209");
        existingNhanVien.setUserName("Nguyen Van Dai");
        try {

            boolean result = nhanVien_dao.editNhanVien(existingNhanVien);
            assertTrue(result,"edit nhan vien that bai");
        }catch (Exception e) {
            e.printStackTrace();
            fail("nhan Vien Khong ton tai");
        }
    }

    @Test
    public void testAddNhanVien() throws Exception {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setNhanVienID("NV1235");
        nhanVien.setUserName("Hoang Van Kien");
        nhanVien.setChucVu("Nhân Viên");
        nhanVien.setDiaChi("13 lê lơi");
        nhanVien.setEmail("13loi@gmail.com");
        nhanVien.setGioiTinh("Nam");
        nhanVien.setHoTen("David Nguyen");
        nhanVien.setNgaySinh(LocalDate.parse("2034-12-12"));
        nhanVien.setNgayTaoTK(LocalDate.parse("2034-12-12"));
        nhanVien.setPassword("1231231");
        nhanVien.setSoDienThoai("0123456789");
         try {

             boolean result =   nhanVien_dao.addNhanVien(nhanVien);
             assertTrue(result,"add nhan vien that bai");
         }catch (Exception e) {
             e.printStackTrace();
             fail("add nhan Vien Khong ton tai");
         }

    }


}
