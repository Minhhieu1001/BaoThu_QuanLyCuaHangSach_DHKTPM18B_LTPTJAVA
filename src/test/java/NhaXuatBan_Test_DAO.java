import connectDB.ConnectDB;
import dao.NhaXuatBan_DAO;
import entities.NhaXuatBan;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.rmi.RemoteException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NhaXuatBan_Test_DAO {
    private static NhaXuatBan_DAO nhaXuatBanDao;

    @BeforeAll
    public static void setUp() {
        ConnectDB.connect();
        try {
            nhaXuatBanDao = new NhaXuatBan_DAO();
        } catch (Exception e) {
            e.printStackTrace();
            fail("Loi khi khi tao NhaXuatBan_DAO");
        }
    }

    @Test
    public void getListAllNhaXuatBan() throws RemoteException {
       try {
           List<NhaXuatBan> nhaXuatBans = nhaXuatBanDao.getAllNhaXuatBan();
           assertNotNull(nhaXuatBans,"danh sach nha xuat ban khong duoc null");
       }catch (Exception e){
           e.printStackTrace();
           fail("Loi khi khi tao NhaXuatBan_DAO");
       }
    }

    @Test
    public void getListNhaXuatBanByID() throws RemoteException {
        try {
            List<NhaXuatBan> nhaXuatBans = nhaXuatBanDao.getNhaXuatBanTheoID("139");
            assertNotNull(nhaXuatBans,"danh sach nha xuat ban khong duoc null");
            assertFalse(nhaXuatBans.isEmpty(),"khong tin thay nha xuat ban theo ID");
        }catch (Exception e){
            e.printStackTrace();
            fail("Loi khi khi tao NhaXuatBan_DAO");
        }
    }

    @Test
    public void addNhaXuatBan() throws RemoteException {
        NhaXuatBan nhaXuatBan = new NhaXuatBan();

        nhaXuatBan.setDiaChi("13 Nguyen Thang");
        nhaXuatBan.setEmail("nguyen@gmail.com");
        nhaXuatBan.setLinhVucXuatBan("7 vien ngoc rong");
        nhaXuatBan.setNamThanhLap(2000);
        nhaXuatBan.setQuocGia("Viet Nam");
        nhaXuatBan.setSoDienThoai("0123456789");
        nhaXuatBan.setTenNhaXuatBan("Pham Minh Hieu");
        nhaXuatBan.setWebsite("http://www.janell-wunsch.io:30463/necessitatibus?nobis=ea&odio=ipsam");

        try {
            boolean result = nhaXuatBanDao.addNhaXuatBan(nhaXuatBan);
            assertTrue(result,"them nha xuat ban that bai");
        }catch (Exception e){
            e.printStackTrace();
            fail("Loi khi khi tao NhaXuatBan_DAO");
        }
    }

    @Test
    public void updateNhaXuatBan() throws RemoteException {
        List<NhaXuatBan> nhaXuatBans = nhaXuatBanDao.getNhaXuatBanTheoID("189");
        NhaXuatBan nhaXuatBan = nhaXuatBans.get(0);
        nhaXuatBan.setTenNhaXuatBan("Nguyen Quoc Viet");

        try {
            boolean result = nhaXuatBanDao.editNhaXuatBan(nhaXuatBan);
            assertTrue(result,"update nha xuat ban that bai");
        }catch (Exception e){
            e.printStackTrace();
            fail("Loi khi khi tao NhaXuatBan_DAO");
        }
    }
}
