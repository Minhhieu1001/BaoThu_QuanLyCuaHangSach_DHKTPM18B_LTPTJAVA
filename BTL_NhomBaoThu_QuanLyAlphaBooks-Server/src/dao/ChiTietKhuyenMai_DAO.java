package dao;

import connectDB.ConnectDB;
import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.SanPham;
import interfaces.IChiTietKhuyenMai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class ChiTietKhuyenMai_DAO extends UnicastRemoteObject implements IChiTietKhuyenMai{
	private EntityManager em;

	@Override
	public List<ChiTietKhuyenMai> getAllChiTietKhuyenMai() throws RemoteException{
		return em.createNamedQuery("ChiTietKhuyenMai.findAll", ChiTietKhuyenMai.class).getResultList();
	}

	public List<ChiTietKhuyenMai> getChiTietKhuyenMaiTheoMa(String maKM) throws RemoteException{
		try {
			return em.createNamedQuery("ChiTietKhuyenMai.getChiTietKhuyenMaiTheoMa", ChiTietKhuyenMai.class).setParameter("maKM", maKM).getResultList();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Date getNgayTao(String maKM) throws RemoteException {
		try {
			// Kiểm tra maKM hợp lệ
			if (maKM == null || maKM.trim().isEmpty()) {
				System.err.println("maKM is null or empty");
				return new Date(System.currentTimeMillis()); // Giá trị mặc định
			}

			// Sử dụng getResultList thay vì getSingleResult để tránh NonUniqueResultException
			List<ChiTietKhuyenMai> results = em.createNamedQuery("ChiTietKhuyenMai.getNgayTao", ChiTietKhuyenMai.class)
					.setParameter("maKM", maKM)
					.getResultList();

			// Kiểm tra kết quả
			if (results != null && !results.isEmpty()) {
				Date ngayTao = results.get(0).getNgayTao();
				return (ngayTao != null) ? ngayTao : new Date(System.currentTimeMillis()); // Giá trị mặc định nếu ngayTao là NULL
			} else {
				System.err.println("No ChiTietKhuyenMai found for maKM: " + maKM);
				return new Date(System.currentTimeMillis()); // Giá trị mặc định nếu không có bản ghi
			}
		} catch (Exception e) {
			System.err.println("Error fetching NgayTao for maKM: " + maKM);
			e.printStackTrace();
			return new Date(System.currentTimeMillis()); // Giá trị mặc định
		}
	}

	public boolean addSDanhSachSPKM(KhuyenMai khuyenMai, List<SanPham> danhSachSPKM) throws RemoteException{
		if(danhSachSPKM.size() > 0) {
			for(int i = 0; i  < danhSachSPKM.size(); i++) {
				addSanPhamKhuyenMai(khuyenMai, danhSachSPKM.get(i));
			}
			return true;
		}
		return false;
	}

	public boolean addSanPhamKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham) throws RemoteException{
		EntityTransaction tr = em.getTransaction();
		try {
			tr.begin();
			ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai(khuyenMai, sanPham, new Date(Calendar.getInstance().getTime().getTime()));
			em.persist(chiTietKhuyenMai);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai,int masanPham) throws RemoteException{
		EntityTransaction tr = em.getTransaction();
        try {
            tr.begin();
            ChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai(em.find(KhuyenMai.class, makhuyenMai), em.find(SanPham.class, masanPham), new Date(Calendar.getInstance().getTime().getTime()));
            em.persist(chiTietKhuyenMai);
            tr.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
	}

	public ChiTietKhuyenMai_DAO() throws RemoteException{
		em = ConnectDB.getEntityManager();
	}
}
