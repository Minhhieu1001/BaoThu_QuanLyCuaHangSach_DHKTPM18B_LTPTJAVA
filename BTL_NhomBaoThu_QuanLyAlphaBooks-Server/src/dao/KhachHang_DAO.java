package dao;

import connectDB.ConnectDB;
import entities.KhachHang;
import entities.NhanVien;
import interfaces.IKhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ultilities.ProcessingEnumDBForQuy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class KhachHang_DAO extends UnicastRemoteObject implements IKhachHang {

	private EntityManager em;

	public List<KhachHang> findKhachHangAdvanced(String maKhachHang, String tenKhachHang, String soDienThoai,
			String gioiTinh, String loaiKhachHang) throws RemoteException{
		
		gioiTinh = ProcessingEnumDBForQuy.gioiTinhToEnum(gioiTinh);
		loaiKhachHang = ProcessingEnumDBForQuy.convertKhachHangToEnum(loaiKhachHang);

		List<KhachHang> listKhachHang = new ArrayList<>();
		
		String query = "SELECT kh FROM KhachHang kh WHERE "
				+ "khachHangID LIKE :khachHangID "
				+ "AND hoTen LIKE :hoTen "
				+ "AND soDienThoai LIKE :soDienThoai ";

		List<String> parameters = new ArrayList<>();
		
		parameters.add(maKhachHang.isBlank() ? "%" : "%" + maKhachHang + "%");
		parameters.add(tenKhachHang.isBlank() ? "%" : "%" + tenKhachHang + "%");
		parameters.add(soDienThoai.isBlank() ? "%" : "%" + soDienThoai + "%");
		
		if (gioiTinh.isBlank())
			query += "AND gioiTinh like '%' ";
		else {
			if (gioiTinh.equalsIgnoreCase("NAM"))
				query += "AND gioiTinh like 'NAM' ";
			else
				query += "AND gioiTinh not like 'NAM' ";
		}
		if (loaiKhachHang.isBlank())
			query += "AND loaiKhachHang like '%' ";
		else {
			if (loaiKhachHang.equals("CA_NHAN"))
				query += "AND loaiKhachHang like 'CA_NHAN' ";
			else
				query += "AND loaiKhachHang not like 'CA_NHAN' ";
		}

		try {
			
			listKhachHang = em.createQuery(query, KhachHang.class)
					.setParameter("khachHangID", parameters.get(0)).setParameter("hoTen", parameters.get(1))
					.setParameter("soDienThoai", parameters.get(2)).getResultList();
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listKhachHang;
	}

	@Override
	public List<KhachHang> getAllKhachHang() throws RemoteException{
		try {
			return em.createNamedQuery("KhachHang.getAllEmployees", KhachHang.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public long totalKhachHang() throws RemoteException{
		return 0;
	}

	public boolean addKhachHang(KhachHang kh) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		boolean isTransactionManagedHere = false;

		try {
			// Kiểm tra xem giao dịch đã được bắt đầu hay chưa
			if (!tx.isActive()) {
				tx.begin();
				isTransactionManagedHere = true;
			}

			em.persist(kh);

			// Chỉ commit nếu giao dịch được bắt đầu trong phương thức này
			if (isTransactionManagedHere) {
				tx.commit();
			}
			return true;
		} catch (Exception e) {
			// Rollback nếu giao dịch được bắt đầu trong phương thức này
			if (isTransactionManagedHere && tx.isActive()) {
				tx.rollback();
			}
			e.printStackTrace();
			return false;
		}
	}

	public KhachHang getKhachHangByKhachHangID(String ma) throws RemoteException{
		try {
			return em.createNamedQuery("KhachHang.getKhachHangByID", KhachHang.class).setParameter("id", ma)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean editKhachHang(KhachHang kh) throws RemoteException{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(kh);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean deleteKhachHang(KhachHang kh) throws RemoteException{
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.remove(kh);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String getLayTenTuMa(String x) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public KhachHang getKhachHangTuMaVaSDT(String x) throws RemoteException{
		try {
			return em.createNamedQuery("KhachHang.getKhachHangTuMaVaSDT", KhachHang.class).setParameter("id", x).setParameter("sdt", x)
					.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<NhanVien> findKhachHang(String x) throws RemoteException{
		// TODO Auto-generated method stub
		return null;
	}

	public long phatSinhMaKhachHang() throws RemoteException {
		try {
			// Lấy khachHangID lớn nhất
			String maxId = em.createQuery("SELECT MAX(kh.khachHangID) FROM KhachHang kh", String.class)
					.getSingleResult();
			if (maxId == null || !maxId.startsWith("KH")) {
				return 1; // Nếu chưa có bản ghi nào, bắt đầu từ 1 (KH0001)
			}
			// Tách phần số từ mã (VD: KH0003 -> 3)
			int num = Integer.parseInt(maxId.substring(2));
			return num + 1; // Tăng lên 1 để được mã mới (VD: 4 cho KH0004)
		} catch (Exception e) {
			System.err.println("Error generating khachHangID: " + e.getMessage());
			e.printStackTrace();
			return 1; // Giá trị mặc định nếu có lỗi
		}
	}

	public String phatSinhMaSoThue(String loaiKhachHang) throws RemoteException {
		try {
			// Lấy số lượng khách hàng của loại đã cho
			int count = em.createNamedQuery("KhachHang.phatSinhMaSoThue", Integer.class)
                    .setParameter("loaiKhachHang", loaiKhachHang).getSingleResult();

			// Phát sinh mã số thuế dựa trên loại khách hàng
			String prefix = (loaiKhachHang.equalsIgnoreCase("Cá nhân")) ? "TKH0" : "TKH1";
			return prefix + String.format("%03d", count + 1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean checkIfKhachHangExists(String maKH) throws RemoteException {
		try {
			return em.createNamedQuery("KhachHang.checkIfKhachHangExists", Long.class).setParameter("id", maKH)
					.getSingleResult() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean chuyenLoaiKhachHang(String maKhachHang, String loaiKhachHangMoi)throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		try {
			return em.createNamedQuery("KhachHang.chuyenLoaiKhachHang")
					.setParameter("loaiKhachHang", loaiKhachHangMoi).setParameter("id", maKhachHang).executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public KhachHang_DAO() throws RemoteException{
		em = ConnectDB.getEntityManager();
	}

}
