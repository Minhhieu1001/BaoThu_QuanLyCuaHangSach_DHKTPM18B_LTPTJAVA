import connectDB.ConnectDB;
import dao.KhuyenMai_DAO;
import entities.KhuyenMai;
import interfaces.IKhuyenMai;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

public class KhuyenMai_Test_Dao {
    private static KhuyenMai_DAO khuyenMaiDao;

    @BeforeAll

    public static void setUp() throws Exception {
        ConnectDB.connect();
        try {
            khuyenMaiDao = new KhuyenMai_DAO();
        }catch (Exception e){
            e.printStackTrace();
            fail("loi khi tao KhuyenMai_Dao");
        }
    }

    @Test
    public void getListAllKhuyenMai() throws Exception {
        try {
            List<KhuyenMai> khuyenMais = khuyenMaiDao.getAllKhuyenMai();
            assertNotNull(khuyenMais,"danh sach khuyen mai null");
        }catch (Exception e){
            e.printStackTrace();
            fail("loi khi tao KhuyenMai_Dao");
        }
    }
    @Test
    public void getKhuyenMaiById() throws Exception {
       try {
           List<KhuyenMai> khuyenMais = khuyenMaiDao.getKhuyenMaiByID("45018");
           assertNotNull(khuyenMais,"khuyen mai null");
           assertFalse(khuyenMais.isEmpty(),"khong tim thay khuyen mai ID tren");
       }catch (Exception e){
           e.printStackTrace();
           fail("loi khi tao KhuyenMai_Dao");
       }
    }

    @Test
    public void addKhuyenMai() throws Exception {
        KhuyenMai khuyenMai = new KhuyenMai();
         khuyenMai.setCodeKhuyenMai("KM123458");
         khuyenMai.setDonHangTu(123456);
         khuyenMai.setGiaTri(2000);
         khuyenMai.setLoaiKhuyenMai("GIA_TRI");
         khuyenMai.setNgayHetHanKM(Date.valueOf(LocalDate.now()));
         khuyenMai.setNgayKhuyenMai(Date.valueOf(LocalDate.now()));
         khuyenMai.setSoLuongKhuyenMai(20);
         khuyenMai.setSoLuotDaApDung(60);
         khuyenMai.setTenKhuyenMai("Ngay Tet");

         try {
             boolean result = khuyenMaiDao.addKhuyenMai(khuyenMai);
             assertTrue(result,"add khuyen mai khong thanh cong");
         }catch (Exception e){
             e.printStackTrace();
             fail("loi khi tao KhuyenMai_Dao");
         }

    }

    @Test
    public void updateKhuyenMai() throws Exception {
        List<KhuyenMai> khuyenMais = khuyenMaiDao.getKhuyenMaiByID("45018");
        KhuyenMai khuyenMai = khuyenMais.get(0);
        khuyenMai.setTenKhuyenMai("Giang Sinh Vui Ve");

        try {
            boolean result = khuyenMaiDao.editKhuyenMai(khuyenMai);
            assertTrue(result,"edit khuyen mai khong thanh cong");
        }catch (Exception e){
            e.printStackTrace();
            fail("loi khi tao KhuyenMai_Dao");
        }
    }


}
