package dao;

import connectDB.ConnectDB;
import entities.ChiTietTraHang;
import interfaces.IChiTietTraHang;
import jakarta.persistence.EntityManager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChiTietTraHang_DAO extends UnicastRemoteObject implements IChiTietTraHang {
	private EntityManager em;

	public boolean addMotChiTietCuaHoaDon(ChiTietTraHang x) throws RemoteException {
		boolean isThisSession = em.getTransaction().isActive();
		try {
			if (isThisSession == false)
				em.getTransaction().begin();
			x.setDonGia(x.getSanPham().getGiaBan());
			System.out.println("Saving ChiTietTraHang: sanPhamID=" + x.getSanPham().getSanPhamID() +
					", soLuong=" + x.getSoLuong() +
					", liDoTraHang=" + x.getLiDoTraHang()); // Log để kiểm tra
			em.persist(x);
			if (isThisSession == false)
				em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addNhieuChiTietCuaMotHoaDon(List<ChiTietTraHang> x) throws RemoteException{
		boolean isThisSession = em.getTransaction().isActive();
		// Xoá chi tiết hoá đơn cũ để cập nhật lại
		if (x.size() < 1)
			return true;
		try {
			// TODO Auto-generated method stub
			if (isThisSession == false)
				em.getTransaction().begin();
			em.createNamedQuery("ChiTietTraHang.deleteAllByHoaDonID")
					.setParameter("hoaDonID", x.get(0).getHoaDon().getHoaDonID()).executeUpdate();
			for (ChiTietTraHang y : x) {
				if (!addMotChiTietCuaHoaDon(y))
					return false;
			}
			if (isThisSession == false)
				em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
			return false;
		}

		// Cập nhật chi tiết hoá đơn mới

		return true;
	}

	@Override
	public List<ChiTietTraHang> getAllChiTietCuaMotHoaDon(String maHoaDon) throws RemoteException{
		// TODO Auto-generated method stub
		List<ChiTietTraHang> listCT = new ArrayList<ChiTietTraHang>();

		try {
			listCT = em.createNamedQuery("ChiTietTraHang.findAllByHoaDonID", ChiTietTraHang.class)
					.setParameter("hoaDonID", maHoaDon).getResultList();

			return listCT;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listCT;
		}
	}

	@Override
	public boolean removeMotChiTietCuaHoaDon(ChiTietTraHang x) throws RemoteException{
		// TODO Auto-generated method stub
		return false;
	}

	public ChiTietTraHang_DAO() throws RemoteException{
		// TODO Auto-generated constructor stub
		em = ConnectDB.getEntityManager();
	}

}
