import connectDB.ConnectDB;
import dao.SanPham_DAO;
import entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SanPham_Test_DAO {

    private static SanPham_DAO sanPham_dao;

    @BeforeAll
    public static void setup(){

        ConnectDB.connect();
        try {
            sanPham_dao = new SanPham_DAO();
        }catch (Exception e){
            e.printStackTrace();
            fail("loi khi tao SanPham_DAO");
        }
    }

    @Test
    public void getListAllSanPham(){

        try {
            List<SanPham> sanPhams = sanPham_dao.getDanhSachSanPham();
            assertNotNull(sanPhams,"danh sach san pham khong duoc null");
        }catch (Exception e){
            e.printStackTrace();
            fail("loi khi tao SanPham_DAO");
        }

    }

    @Test
    public void getSanPhamById(){
        try {
            List<SanPham> sanPhams = sanPham_dao.getSanPhamByID(229);
            assertNotNull(sanPhams,"san pham khong duoc null");
            assertFalse(sanPhams.isEmpty(),"khong tim thay san pham ID tren");
        }catch (Exception e){
            e.printStackTrace();
            fail("loi khi tao SanPham_DAO");
        }
    }

    @Test
    public void addSanPham() throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlphaBook-Production");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        SanPham sanPham = new SanPham();
        sanPham.setBarcode("4450300237617");
        sanPham.setDonViDoLuong("Piece");
        sanPham.setGiaNhap(20000);
        sanPham.setImgPath("https://www.ian-hilpert.co/?aspernatur=ducimus&perferendis=doloribus#est");
        sanPham.setKichThuoc("65x55x77");
        sanPham.setLoaiBia("Bìa cứng");
        sanPham.setLoaiDoiTra("DUOC_DOI_TRA");
        sanPham.setLoaiSanPham("Music");
        sanPham.setNamSanXuat(2000);
        sanPham.setNgayNhap(new Date());
        sanPham.setNgonNgu("Viet Nam");
        sanPham.setSoLuongTon(12);
        sanPham.setSoTrang(123);
        sanPham.setTenSanPham("Practical Wooden Hat");
        sanPham.setTinhTrang("CON_HANG");
        sanPham.setXuatXu("CON_HANG");

        DanhMuc danhMuc = null;
        sanPham.setDanhMuc(danhMuc);

        NhaCungCap nhaCungCap = null;
        sanPham.setNhaCungCap(nhaCungCap);

        NhaXuatBan nhaXuatBan = null;
        sanPham.setNhaXuatBan(nhaXuatBan);

        TacGia tacGia = null;
        sanPham.setTacGia(tacGia);

        TheLoai theLoai = null;
        sanPham.setTheLoai(theLoai);

        ThuongHieu thuongHieu = null;
        sanPham.setThuongHieu(thuongHieu);

        try {
            boolean result = sanPham_dao.addSanPham(sanPham);
            assertTrue(result, "Thêm sản phẩm thất bại");
        } catch (Exception e) {
            e.printStackTrace();
            fail("Lỗi khi tạo SanPham_DAO");
        } finally {
            em.getTransaction().commit();
            em.close();
            emf.close();
        }
    }


    @Test
    public void updateSanPham() throws Exception {
        List<SanPham> sanPhams = sanPham_dao.getSanPhamByID(184);
        SanPham sanPham = sanPhams.get(0);
        sanPham.setBarcode("111111111111111");
        try {
            boolean result = sanPham_dao.editSanPham(sanPham);
            assertTrue(result,"edit san pham that bai");
        }catch (Exception e){
            e.printStackTrace();
            fail("loi khi tao SanPham_DAO");
        }
    }




}
