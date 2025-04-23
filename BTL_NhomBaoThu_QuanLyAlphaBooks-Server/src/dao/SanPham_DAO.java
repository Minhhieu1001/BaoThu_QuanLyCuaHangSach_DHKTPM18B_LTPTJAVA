package dao;

import connectDB.ConnectDB;
import entities.*;
import interfaces.ISanPham;
import jakarta.persistence.EntityManager;
import ultilities.Numberic;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SanPham_DAO extends UnicastRemoteObject implements ISanPham {
	private final int LIMIT_RESULT = 100;
	private EntityManager em;

	// Lấy danh sách sản phẩm cho khuyến mãi
	public List<SanPham> laySanPhamChoKM() throws RemoteException{
		List<SanPham> list = new ArrayList<SanPham>();
		try {
			list = em.createNamedQuery("SanPham.findAll").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<SanPham> getSPTheoThuongHieu(String maThuongHieu) throws RemoteException{
		List<SanPham> list = new ArrayList<SanPham>();
		try {
			list = em.createNamedQuery("SanPham.findByThuongHieuID").setParameter("thuongHieuID", maThuongHieu)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<ThuongHieu> getThuongHieu() throws RemoteException{
		List<ThuongHieu> list = new ArrayList<ThuongHieu>();
		try {
			list = em.createNamedQuery("ThuongHieu.listThuongHieu").getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<SanPham> getDanhSachSanPham(String query) throws RemoteException {
		List<SanPham> list = new ArrayList<>();
		try {
			list = em.createNativeQuery(query, SanPham.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean addSanPham(SanPham sp) throws RemoteException {
		boolean isThisSession = em.getTransaction().isActive();
		try {
			if (isThisSession == false)
				em.getTransaction().begin();
			em.persist(sp);
			if (isThisSession == false)
				em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editSanPham(SanPham sp)throws RemoteException {
		try {
			em.getTransaction().begin();
			em.merge(sp);
			em.getTransaction().commit();
			return true;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<SanPham> getDanhSachSanPhamSapHet() throws RemoteException{
		List<SanPham> list = new ArrayList<SanPham>();

		list = em.createNamedQuery("SanPham.getSanPhamSapHet").getResultList();
		return list;

	}

	public SanPham_DAO() throws RemoteException{
		super();
		// TODO Auto-generated constructor stub
		em = ConnectDB.getEntityManager();
	}

	@Override
	public List<SanPham> searchSanPham(String sanPhamID) throws RemoteException{
		List<SanPham> list;
		list = new ArrayList<SanPham>();

		list = em.createNamedQuery("SanPham.findById").setParameter("id", sanPhamID).getResultList();

		return list;
	}

	@Override
	public List<SanPham> getDanhSachSanPham() throws RemoteException{
		List<SanPham> list = new ArrayList<>();
		list = em.createNamedQuery("SanPham.findAll").setMaxResults(LIMIT_RESULT).getResultList();
		return list;
	}

	@Override
	public SanPham getChiMotSanPhamTheoMaHoacBarcode(String x) throws RemoteException{

		SanPham sanPham = null;
		int id = 0;
		try {

			if (x.length() > 5) {
				id = Numberic.parseInteger("-1");
			} else {
				id = Numberic.parseInteger(x);
			}

			sanPham = (SanPham) em.createNamedQuery("SanPham.findByIdAndBarcode").setParameter("id", id)
					.setParameter("barcode", x).getSingleResult();

			return sanPham;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getIdTacGiaByName(String name) throws RemoteException {
		if (name == null || name.trim().isEmpty()) {
			return -1;
		}
		try {
			List<TacGia> result = em.createNamedQuery("TacGia.findByName")
					.setParameter("name", name.trim())
					.getResultList();
			if (!result.isEmpty()) {
				return result.get(0).getTacGiaID();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int getIdTheloaiByName(String name) throws RemoteException {
		if (name == null || name.trim().isEmpty()) {
			return -1;
		}
		try {
			List<TheLoai> result = em.createNamedQuery("TheLoai.findByName")
					.setParameter("name", name.trim())
					.getResultList();
			if (!result.isEmpty()) {
				return result.get(0).getTheLoaiID();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int getIdNhaXuatBanByName(String name) throws RemoteException {
		if (name == null || name.trim().isEmpty()) {
			return -1;
		}
		try {
			List<NhaXuatBan> result = em.createNamedQuery("NhaXuatBan.findByName")
					.setParameter("name", name.trim())
					.getResultList();
			if (!result.isEmpty()) {
				return result.get(0).getNhaXuatBanID();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public String getIdNhaCungCapByName(String name) throws RemoteException {
		if (name == null || name.trim().isEmpty()) {
			return "";
		}
		try {
			List<NhaCungCap> result = em.createNamedQuery("NhaCungCap.findByName")
					.setParameter("name", name.trim())
					.getResultList();
			if (!result.isEmpty()) {
				return result.get(0).getNhaCungCapID();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public int getIdThuongHieuByName(String name) throws RemoteException {
		if (name == null || name.trim().isEmpty()) {
			return -1;
		}
		try {
			List<ThuongHieu> result = em.createNamedQuery("ThuongHieu.findByName")
					.setParameter("name", name.trim())
					.getResultList();
			if (!result.isEmpty()) {
				return result.get(0).getThuongHieuID();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int getIdDanhMucByName(String name) throws RemoteException {
		if (name == null || name.trim().isEmpty()) {
			return -1;
		}
		try {
			List<DanhMuc> result = em.createNamedQuery("DanhMuc.findByName")
					.setParameter("name", name.trim())
					.getResultList();
			if (!result.isEmpty()) {
				return result.get(0).getDanhMucID();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public String getNameTacGiaByID(int ID) throws RemoteException{
		try {
			TacGia tg = (TacGia) em.createNamedQuery("TacGia.findByID").setParameter("id", ID).getSingleResult();
			if (tg != null)
				return tg.getTenTacGia();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String getNameNhaXuatBanByID(int ID) throws RemoteException {
		try {
			NhaXuatBan nxb = (NhaXuatBan) em.createNamedQuery("NhaXuatBan.findByID").setParameter("id", ID)
					.getSingleResult();
			if (nxb != null)
				return nxb.getTenNhaXuatBan();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String getNameDanhMucByID(int ID) throws RemoteException{
		try {
			DanhMuc dm = (DanhMuc) em.createNamedQuery("DanhMuc.findByID").setParameter("id", ID).getSingleResult();
			if (dm != null)
				return dm.getTenDanhMuc();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String getNameTheLoaiByID(int ID) throws RemoteException{
		try {
			TheLoai tl = (TheLoai) em.createNamedQuery("TheLoai.findByID").setParameter("id", ID).getSingleResult();
			if (tl != null)
				return tl.getTenTheLoai();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String getNameThuongHieuByID(int ID) throws RemoteException{
		try {
			ThuongHieu th = (ThuongHieu) em.createNamedQuery("ThuongHieu.findByID").setParameter("id", ID)
					.getSingleResult();
			if (th != null)
				return th.getTenThuongHieu();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public String getNameNhaCungCapByID(String ID) throws RemoteException{
		try {
			NhaCungCap ncc = (NhaCungCap) em.createNamedQuery("NhaCungCap.findByID").setParameter("id", ID)
					.getSingleResult();
			if (ncc != null)
				return ncc.getTenNhaCungCap();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	@Override
	public List<SanPham> SapXepTangTheoGia(List<SanPham> list) throws RemoteException {
		System.out.println("Gọi SapXepTangTheoGia");
		List<SanPham> sortedList = new ArrayList<>(list);
		Collections.sort(sortedList, new Comparator<SanPham>() {
			@Override
			public int compare(SanPham sp1, SanPham sp2) {
				return Double.compare(sp1.getGiaBan(), sp2.getGiaBan());
			}
		});
		return sortedList;
	}

	@Override
	public List<SanPham> SapXepGiamTheoGia(List<SanPham> list) throws RemoteException {
		System.out.println("Gọi SapXepGiamTheoGia");
		List<SanPham> sortedList = new ArrayList<>(list);
		Collections.sort(sortedList, new Comparator<SanPham>() {
			@Override
			public int compare(SanPham sp1, SanPham sp2) {
				return Double.compare(sp2.getGiaBan(), sp1.getGiaBan());
			}
		});
		return sortedList;
	}

	@Override
	public List<SanPham> SapXepTangTheoSoLuong(List<SanPham> list) throws RemoteException {
		System.out.println("Gọi SapXepTangTheoSoLuong");
		List<SanPham> sortedList = new ArrayList<>(list);
		Collections.sort(sortedList, new Comparator<SanPham>() {
			@Override
			public int compare(SanPham sp1, SanPham sp2) {
				return Integer.compare(sp1.getSoLuongTon(), sp2.getSoLuongTon());
			}
		});
		return sortedList;
	}

	@Override
	public boolean editTrangThaiSanPham(SanPham sp) throws RemoteException {
		int id = sp.getSanPhamID();
		try {
			SanPham sp2 = em.find(SanPham.class, id);
			em.getTransaction().begin();
			sp2.setTinhTrang(sp.getTinhTrang());
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		return false;
	}

}