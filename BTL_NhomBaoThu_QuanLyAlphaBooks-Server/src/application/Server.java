package application;

import connectDB.ConnectDB;
import dao.*;
import interfaces.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.rmi.registry.LocateRegistry;

public class Server {
	private static final String HOST = "localhost";
	private static final int PORT = 3307;
	public static void main(String[] args) {

		try {
			ConnectDB.connect();
			
			Context ctx = new InitialContext();

			IChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon_DAO();
			IChiTietKhuyenMai chiTietKhuyenMai = new ChiTietKhuyenMai_DAO();
			IChiTietTraHang chiTietTraHang = new ChiTietTraHang_DAO();
			IDanhMuc danhMuc = new DanhMuc_DAO();
			IHoaDon hoaDon = new HoaDon_DAO();
			IHoaDonTra hoaDonTra = new HoaDonTra_DAO();
			IKhachHang khachHang = new KhachHang_DAO();
			IKhuyenMai khuyenMai = new KhuyenMai_DAO();
			INhaCungCap nhaCungCap = new NhaCungCap_DAO();
			INhanVien nhanVien = new NhanVien_DAO();
			INhaXuatBan nhaXuatBan = new NhaXuatBan_DAO();
			ISanPham sanPham = new SanPham_DAO();
			ITacGia tacGia = new TacGia_DAO();
			ITheLoai theLoai = new TheLoai_DAO();
			IThuongHieu thuongHieu = new ThuongHieu_DAO();

			LocateRegistry.createRegistry(PORT);
			
			ctx.bind("rmi://" + HOST + ":" + PORT + "/chiTietHoaDon", chiTietHoaDon);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/chiTietKhuyenMai", chiTietKhuyenMai);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/chiTietTraHang", chiTietTraHang);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/danhMuc", danhMuc);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/hoaDon", hoaDon);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/hoaDonTra", hoaDonTra);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/khachHang", khachHang);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/khuyenMai", khuyenMai);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/nhaCungCap", nhaCungCap);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/nhanVien", nhanVien);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/nhaXuatBan", nhaXuatBan);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/sanPham", sanPham);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/tacGia", tacGia);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/theLoai", theLoai);
			ctx.bind("rmi://" + HOST + ":" + PORT + "/thuongHieu", thuongHieu);
			System.out.println("Server is running on " + HOST + ":" + PORT);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
