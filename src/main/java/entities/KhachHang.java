package entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
@NamedQueries({
	@NamedQuery(name = "KhachHang.getAllEmployees", query = "from KhachHang"),
	@NamedQuery(name = "KhachHang.getKhachHangByID", query = "from KhachHang where khachHangID = :id"),
	@NamedQuery(name = "KhachHang.getKhachHangTuMaVaSDT", query = "from KhachHang where khachHangID = :id or soDienThoai = :sdt"),
	@NamedQuery(name = "KhachHang.phatSinhMaKhachHang", query = "select count(*) from KhachHang"),
	@NamedQuery(name = "KhachHang.phatSinhMaSoThue", query = "select count(*) from KhachHang where loaiKhachHang = :loaiKhachHang"),
	@NamedQuery(name = "KhachHang.checkIfKhachHangExists", query = "select count(*) from KhachHang where khachHangID = :id"),
	@NamedQuery(name = "KhachHang.chuyenLoaiKhachHang", query = "update KhachHang set loaiKhachHang = :loaiKhachHang where khachHangID = :id"),
})
public class KhachHang implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "khachHangID", columnDefinition = "VARCHAR(255)")
	private String khachHangID;
	@Column(name = "hoTen", columnDefinition = "NVARCHAR(255)")
	private String hoTen;
	@Column(name = "soDienThoai", columnDefinition = "NVARCHAR(255)")
	private String soDienThoai;
	private LocalDate ngaySinh;
	@Column(name = "gioiTinh", columnDefinition = "NVARCHAR(255)")
	private String gioiTinh;
	@Column(name = "email", columnDefinition = "NVARCHAR(255)")
	private String email;
	@Column(name = "maSoThue", columnDefinition = "NVARCHAR(255)")
	private String maSoThue;
	@Column(name = "diaChi", columnDefinition = "NVARCHAR(255)")
	private String diaChi;
	@Column(name = "loaiKhachHang", columnDefinition = "NVARCHAR(255)")
	private String loaiKhachHang;
	
	@OneToMany(mappedBy = "khachHang", fetch = jakarta.persistence.FetchType.LAZY)
	private List<HoaDon> hoaDons;
	
	public List<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	public KhachHang(String khachHangID) {
		this.khachHangID = khachHangID;
	}
	
	public KhachHang() {
	}
	
	public KhachHang(String khachHangID, String hoTen, String soDienThoai, LocalDate ngaySinh, String gioiTinh, String email,
			String maSoThue, String diaChi, String loaiKhachHang) {
		this.khachHangID = khachHangID;
		this.hoTen = hoTen;
		this.soDienThoai = soDienThoai;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.maSoThue = maSoThue;
		this.diaChi = diaChi;
		this.loaiKhachHang = loaiKhachHang;
	}

	public String getKhachHangID() {
		return khachHangID;
	}

	public void setKhachHangID(String khachHangID) throws Exception {
		if (khachHangID.trim() == "" || khachHangID.isBlank() || khachHangID.isEmpty())
			throw new Exception("Mã khách hàng rỗng! Đã có lỗi trong quá trình phát sinh");
		this.khachHangID = khachHangID;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) throws Exception {
	
		this.hoTen = hoTen;
	}

	public String getSoDienThoai() {
		
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) throws Exception {
		if (soDienThoai.trim() == "" || soDienThoai.isBlank() || soDienThoai.isEmpty())
			throw new Exception("Số điện thoại là một trường bắt buộc!");
		this.soDienThoai = soDienThoai;
	}

	public LocalDate getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(LocalDate ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) throws Exception {
		this.diaChi = diaChi;
	}

	public String getLoaiKhachHang() {
		return loaiKhachHang;
	}

	public void setLoaiKhachHang(String loaiKhachHang) {
		this.loaiKhachHang = loaiKhachHang;
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(khachHangID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhachHang other = (KhachHang) obj;
		return Objects.equals(khachHangID, other.khachHangID);
	}

	@Override
	public String toString() {
		return "KhachHang [khachHangID=" + khachHangID + ", hoTen=" + hoTen + ", soDienThoai=" + soDienThoai
				+ ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", email=" + email + ", maSoThue=" + maSoThue
				+ ", diaChi=" + diaChi + ", loaiKhachHang=" + loaiKhachHang + ", hoaDons=" + hoaDons + "]";
	}
	
	
}
