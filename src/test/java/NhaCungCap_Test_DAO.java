import connectDB.ConnectDB;
import dao.NhaCungCap_DAO;
import dao.NhanVien_DAO;
import entities.NhaCungCap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NhaCungCap_Test_DAO {

    private static NhaCungCap_DAO nhaCungCapDao;
    @BeforeAll
    public static void setUp() {
        ConnectDB.connect();
        try {
            nhaCungCapDao = new NhaCungCap_DAO();
        }catch (Exception e){
            e.printStackTrace();
            fail("Loi khi khi tao NhaCungCap_DAO");
        }
    }
    @Test
    public void testGetListNhaCungCap() throws RemoteException {
      try {
          List<NhaCungCap> nhaCungCaps = nhaCungCapDao.getAllNhaCungCap();
          assertNotNull(nhaCungCaps,"danh sach nha cung cap khong duoc null");
      }catch (Exception e){
          e.printStackTrace();
          fail("Loi khi khi tao NhaCungCap_DAO");
      }
    }
    @Test
    public void testGetNhaCungCapbyID() throws RemoteException {
        try {
            List<NhaCungCap> nhaCungCaps = nhaCungCapDao.getNCCByID("101-75-2865");
            assertNotNull(nhaCungCaps,"danh sach nha cung cap khong null");
            assertFalse(nhaCungCaps.isEmpty(),"khong tim thay nha cung cap vs ID da cho");
        }catch (Exception e){
            e.printStackTrace();
            fail("Loi khi khi tao NhaCungCap_DAO");
        }
    }
    @Test
    public void addNhaCungCap(){
        NhaCungCap nhaCungCap = new NhaCungCap();
        nhaCungCap.setNhaCungCapID("111-55-2222");
        nhaCungCap.setDiaChi("12 Ngo Quyen");
        nhaCungCap.setEmail("13NguyenVanAn@gmail.com");
        nhaCungCap.setSoDienThoai("(305) 667-6962");
        nhaCungCap.setTenNhaCungCap("Dai Nguyen");

        try {
            Boolean result = nhaCungCapDao.addNhaCungCap(nhaCungCap);
            assertTrue(result,"them nha cung cap that bai");
        }catch (Exception e){
            e.printStackTrace();
            fail("Loi khi khi tao NhaCungCap_DAO");
        }
    }

    @Test
    public void updateNhaCungCap() throws RemoteException {
        List<NhaCungCap> nhaCungCaps = nhaCungCapDao.getNCCByID("111-55-2222");
        NhaCungCap nhaCungcap = nhaCungCaps.get(0);
        nhaCungcap.setTenNhaCungCap("Bach Hoa Xanh");
        try {
            boolean result = nhaCungCapDao.editNhaCungCap(nhaCungcap);
            assertTrue(result,"edit nha cung cap that bai");
        }catch (Exception e){
            e.printStackTrace();
            fail("Loi khi khi tao NhaCungCap_DAO");
        }
    }

}
