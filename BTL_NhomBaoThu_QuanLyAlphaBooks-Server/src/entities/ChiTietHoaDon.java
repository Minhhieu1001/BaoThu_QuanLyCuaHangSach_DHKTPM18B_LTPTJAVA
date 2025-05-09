package entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
	@NamedQuery(name = "ChiTietHoaDon.deleteAllByHoaDonID", 
			query = "DELETE FROM ChiTietHoaDon cthd WHERE cthd.hoaDon.hoaDonID = :hoaDonID"),
	@NamedQuery(name = "ChiTietHoaDon.findAllByHoaDonID",
	        query = "SELECT cthd FROM ChiTietHoaDon cthd WHERE cthd.hoaDon.hoaDonID = :hoaDonID")
})
public class ChiTietHoaDon implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int soLuong;
	private double donGia; // Dẫn xuất
    
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sanPhamId")
    private SanPham sanPham;
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hoaDonId")
	private HoaDon hoaDon;

	public ChiTietHoaDon(SanPham sanPham, int soLuong) {
		super();
		this.soLuong = soLuong;
		this.sanPham = sanPham;
	}

	public ChiTietHoaDon(SanPham sanPham, int soLuong, HoaDon hoaDon) {
		super();
		this.soLuong = soLuong;
		this.sanPham = sanPham;
		this.hoaDon = hoaDon;
	}
	
	public ChiTietHoaDon() {
		super();
	}


	public HoaDon getHoaDon() {
		return hoaDon;
	}

	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
	    // Kiểm tra soLuong > 0
	    if (soLuong < 0) {
	        throw new IllegalArgumentException("Số lượng phải là số nguyên dương");
	    }

	    this.soLuong = soLuong;
	}
	

	public double getDonGia() {
		return donGia > 0 ? donGia : sanPham.getGiaBan();
	}


	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}


	public SanPham getSanPham() {
		return sanPham;
	}


	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	
	public double tinhTongTien() {
		// Nếu là đơn giá từ database lưu trữ thì tính theo db, ngược lại là hoá đơn
		// đang lập. Giá bán đã kèm VAT
		return donGia > 0 ? donGia * soLuong : (soLuong * sanPham.getGiaBan());
	}


	@Override
	public int hashCode() {
		return Objects.hash(sanPham);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return Objects.equals(sanPham, other.sanPham);
	}

	@Override
	public String toString() {
		return sanPham.getTenSanPham();
	}
	
}
