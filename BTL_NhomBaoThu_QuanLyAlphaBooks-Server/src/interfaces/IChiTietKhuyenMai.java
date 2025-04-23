package interfaces;

import entities.ChiTietKhuyenMai;
import entities.KhuyenMai;
import entities.SanPham;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.List;

public interface IChiTietKhuyenMai extends Remote{
	public List<ChiTietKhuyenMai> getAllChiTietKhuyenMai() throws RemoteException;
	public boolean addSDanhSachSPKM(KhuyenMai khuyenMai, List<SanPham> danhSachSPKM) throws RemoteException;
	public boolean addSanPhamKhuyenMai(KhuyenMai khuyenMai, SanPham sanPham) throws RemoteException;
	public Date getNgayTao(String maKM) throws RemoteException;
	public boolean addSanPhamKhuyenMaiKhiUpdate(String makhuyenMai,int masanPham) throws RemoteException;
	public List<ChiTietKhuyenMai> getChiTietKhuyenMaiTheoMa(String txt) throws RemoteException;
}
