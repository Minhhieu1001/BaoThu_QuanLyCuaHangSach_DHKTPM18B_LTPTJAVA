import connectDB.ConnectDB;
import dao.HoaDonTra_DAO;
import dao.HoaDon_DAO;
import entities.HoaDonTra;
import entities.KhachHang;
import entities.NhanVien;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

public class HoaDonTra_Test_DAO {
    private static HoaDonTra_DAO hoaDonTraDao;

    @BeforeAll
    public static void  setUp(){
        ConnectDB.connect();
        try {
            hoaDonTraDao = new HoaDonTra_DAO();
        }catch (Exception e){
            e.printStackTrace();
            fail("Loi khi tao HoaDonTra_Dao");
        }
    }

    @Test
    public void getListAllHoaDonTra(){
       try {
           List<HoaDonTra> hoaDonTras = hoaDonTraDao.getDanhSachHoaDon();
           assertNotNull(hoaDonTras,"Danh sach hoa don tra la null");
       }catch (Exception e){
           e.printStackTrace();
           fail("Loi khi tao HoaDonTra_Dao");
       }
    }

    @Test
    public void addHoaDonTra(){
        HoaDonTra hoaDonTra = new HoaDonTra();

        hoaDonTra.setHoaDonID("HD052177");
        hoaDonTra.setNgayTraHoaDon(new Date());
        hoaDonTra.setTongHoan(300000);
        hoaDonTra.setTrangThai("DANG_XU_LY");
        hoaDonTra.setKhachHang(new KhachHang("KH1321"));
        hoaDonTra.setNhanVien(new NhanVien("NV123465"));

        try {
            boolean result = hoaDonTraDao.createHoaDon(hoaDonTra);
        }catch (Exception e){
            e.printStackTrace();
            fail("Loi khi tao HoaDonTra_Dao");
        }
    }
}
