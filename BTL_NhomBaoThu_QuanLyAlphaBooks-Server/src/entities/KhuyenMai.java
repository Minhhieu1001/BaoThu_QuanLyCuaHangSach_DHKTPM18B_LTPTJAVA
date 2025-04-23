package entities;

import jakarta.persistence.*;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
	@NamedQuery(name = "KhuyenMai.getALL", query = "SELECT km FROM KhuyenMai km"),
	@NamedQuery(name = "KhuyenMai.getRecentKhuyenMai", query = "SELECT KM FROM KhuyenMai KM ORDER BY ngayKhuyenMai DESC"),
	@NamedQuery(name = "KhuyenMai.xoaSanPhamKhuyenMai", query = "DELETE FROM ChiTietKhuyenMai ctkm WHERE ctkm.khuyenMai.codeKhuyenMai = :maKM"),
	@NamedQuery(name = "KhuyenMai.getChiTietKhuyenMaiTheoMa", query = "SELECT ctkm FROM ChiTietKhuyenMai ctkm WHERE ctkm.khuyenMai.codeKhuyenMai = :maKM"),
	@NamedQuery(name = "KhuyenMai.getKhuyenMaiByID", query = "SELECT km FROM KhuyenMai km WHERE km.codeKhuyenMai like CONCAT('%', :maKM, '%')"),
	@NamedQuery(name = "KhuyenMai.getKhuyenMaiByIDAndName", query = "SELECT km FROM KhuyenMai km WHERE km.codeKhuyenMai like CONCAT('%', :maKM, '%') OR km.tenKhuyenMai like CONCAT('%', :tenKM, '%')"),
	@NamedQuery(name = "KhuyenMai.getKhuyenMaiTheoTen", query = "SELECT km FROM KhuyenMai km WHERE km.tenKhuyenMai = :tenKM"),
	@NamedQuery(name = "KhuyenMai.SapXepKhuyenMaiTheoGiaTri", query = "SELECT km FROM KhuyenMai km WHERE km.codeKhuyenMai like CONCAT('%', :maKM, '%') ORDER BY km.giaTri"),
	@NamedQuery(name = "KhuyenMai.getKhuyenMaiFollowDay", query = "SELECT km FROM KhuyenMai km WHERE km.ngayKhuyenMai BETWEEN :startDay AND :expriedDay"),
	//SELECT TOP 1 * from KhuyenMai km JOIN ChiTietKhuyenMai ct ON km.CodeKhuyenMai = ct.CodeKhuyenMai WHERE SanPhamID = ? AND NgayKhuyenMai <= GETDATE() AND NgayHetHanKM >= GETDATE() AND SoLuongKhuyenMai > 1 AND SoLuotDaApDung < SoLuongKhuyenMai ORDER BY NgayKhuyenMai DESC
	@NamedQuery(name = "KhuyenMai.getKhuyenMaiViaSanPhamAutoApply", query = "SELECT km FROM KhuyenMai km JOIN ChiTietKhuyenMai ct ON km.codeKhuyenMai = ct.khuyenMai.codeKhuyenMai WHERE ct.sanPham.sanPhamID = :sanPhamID AND km.ngayKhuyenMai <= CURRENT_DATE AND km.ngayHetHanKM >= CURRENT_DATE AND km.soLuongKhuyenMai > 1 AND km.soLuotDaApDung < km.soLuongKhuyenMai ORDER BY km.ngayKhuyenMai DESC"),
	@NamedQuery(name = "KhuyenMai.layMaNCCCuoiCung", query = "SELECT COUNT(km) FROM KhuyenMai km"),
	@NamedQuery(name = "KhuyenMai.getKhuyenMaiByCodeKMForSeller", query = "SELECT km FROM KhuyenMai km WHERE km.codeKhuyenMai = :maKM"),
	@NamedQuery(name = "KhuyenMai.getKhuyenMaiByName", query = "SELECT km FROM KhuyenMai km WHERE km.tenKhuyenMai = :tenKM"),
})
public class KhuyenMai implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "codeKhuyenMai", columnDefinition = "VARCHAR(255)")
	private String codeKhuyenMai;
	@Column(name = "tenKhuyenMai", columnDefinition = "NVARCHAR(255)")
	private String tenKhuyenMai;
	@Column(name = "LoaiGiamGia", columnDefinition = "NVARCHAR(255)")
	private String loaiKhuyenMai; // PHAM_TRAM && GIA_TRI
	private double giaTri;
	private Date ngayKhuyenMai;
	private Date ngayHetHanKM;
	private double donHangTu;
	private int soLuongKhuyenMai, soLuotDaApDung;

	@OneToMany(mappedBy = "khuyenMai", fetch = FetchType.LAZY)
	private List<ChiTietKhuyenMai> listApDung;
	
	public List<HoaDon> getHoaDons() {
		return hoaDons;
	}

	public void setHoaDons(List<HoaDon> hoaDons) {
		this.hoaDons = hoaDons;
	}

	@OneToMany(mappedBy = "khuyenMai", fetch = FetchType.LAZY)
	private List<HoaDon> hoaDons;

	public KhuyenMai(String codeKhuyenMai, String tenKhuyenMai, String loaiKhuyenMai, double giaTri, Date ngayKhuyenMai,
			Date ngayHetHanKM, double donHangTu) {
		this.setCodeKhuyenMai(codeKhuyenMai);
		this.setTenKhuyenMai(tenKhuyenMai);
		this.setLoaiKhuyenMai(loaiKhuyenMai);
		this.setGiaTri(giaTri);
		this.setNgayKhuyenMai(ngayKhuyenMai);
		this.setNgayHetHanKM(ngayHetHanKM);
		this.setDonHangTu(donHangTu);
	}

	public KhuyenMai(String codeKhuyenMai, String tenKhuyenMai, String loaiKhuyenMai, double giaTri, Date ngayKhuyenMai,
			Date ngayHetHanKM, double donHangTu, int soLuongKhuyenMai, int soLuotDaApDung) {
		this.codeKhuyenMai = codeKhuyenMai;
		this.tenKhuyenMai = tenKhuyenMai;
		this.loaiKhuyenMai = loaiKhuyenMai;
		this.giaTri = giaTri;
		this.ngayKhuyenMai = ngayKhuyenMai;
		this.ngayHetHanKM = ngayHetHanKM;
		this.donHangTu = donHangTu;
		this.soLuongKhuyenMai = soLuongKhuyenMai;
		this.soLuotDaApDung = soLuotDaApDung;
	}

	public List<ChiTietKhuyenMai> getListApDung() {
		return listApDung;
	}

	public void setListApDung(List<ChiTietKhuyenMai> listApDung) {
		this.listApDung = listApDung;
	}

	public List<ChiTietKhuyenMai> getChiTietKhuyenMai() {
		return listApDung;
	}

	public void setChiTietKhuyenMai(List<ChiTietKhuyenMai> listApDung) {
		this.listApDung = listApDung;
	}

	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhuyenMai(String codeKhuyenMai) {
		this.codeKhuyenMai = codeKhuyenMai;
	}

	public String getCodeKhuyenMai() {
		return codeKhuyenMai;
	}

	public void setCodeKhuyenMai(String codeKhuyenMai) {
		this.codeKhuyenMai = codeKhuyenMai;
	}

	public String getTenKhuyenMai() {
		return tenKhuyenMai;
	}

	public void setTenKhuyenMai(String tenKhuyenMai) {
		this.tenKhuyenMai = tenKhuyenMai;
	}

	public String getLoaiKhuyenMai() {
		return loaiKhuyenMai;
	}

	public void setLoaiKhuyenMai(String loaiKhuyenMai) {
		this.loaiKhuyenMai = loaiKhuyenMai;
	}

	public double getGiaTri() {
		return giaTri;
	}

	public void setGiaTri(double giaTri) {
		this.giaTri = giaTri;
	}

	public Date getNgayKhuyenMai() {
		return ngayKhuyenMai;
	}

	public void setNgayKhuyenMai(Date ngayKhuyenMai) {
		this.ngayKhuyenMai = ngayKhuyenMai;
	}

	public Date getNgayHetHanKM() {
		return ngayHetHanKM;
	}

	public void setNgayHetHanKM(Date ngayHetHanKM) {
		this.ngayHetHanKM = ngayHetHanKM;
	}

	public double getDonHangTu() {
		return donHangTu;
	}

	public void setDonHangTu(double donHangTu) {
		this.donHangTu = donHangTu;
	}

	public int getSoLuongKhuyenMai() {
		return soLuongKhuyenMai;
	}

	public void setSoLuongKhuyenMai(int soLuongKhuyenMai) {
		this.soLuongKhuyenMai = soLuongKhuyenMai;
	}

	public int getSoLuotDaApDung() {
		return soLuotDaApDung;
	}

	public void setSoLuotDaApDung(int soLuotDaApDung) {
		this.soLuotDaApDung = soLuotDaApDung;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codeKhuyenMai, donHangTu, giaTri, loaiKhuyenMai, ngayHetHanKM, ngayKhuyenMai,
				soLuongKhuyenMai, soLuotDaApDung, tenKhuyenMai);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KhuyenMai other = (KhuyenMai) obj;
		return Objects.equals(codeKhuyenMai, other.codeKhuyenMai)
				&& Double.doubleToLongBits(donHangTu) == Double.doubleToLongBits(other.donHangTu)
				&& Double.doubleToLongBits(giaTri) == Double.doubleToLongBits(other.giaTri)
				&& Objects.equals(loaiKhuyenMai, other.loaiKhuyenMai)
				&& Objects.equals(ngayHetHanKM, other.ngayHetHanKM)
				&& Objects.equals(ngayKhuyenMai, other.ngayKhuyenMai) && soLuongKhuyenMai == other.soLuongKhuyenMai
				&& soLuotDaApDung == other.soLuotDaApDung && Objects.equals(tenKhuyenMai, other.tenKhuyenMai);
	}

	@Override
	public String toString() {
		return "KhuyenMai [codeKhuyenMai=" + codeKhuyenMai + ", tenKhuyenMai=" + tenKhuyenMai + ", loaiKhuyenMai="
				+ loaiKhuyenMai + ", giaTri=" + giaTri + ", ngayKhuyenMai=" + ngayKhuyenMai + ", ngayHetHanKM="
				+ ngayHetHanKM + ", donHangTu=" + donHangTu + ", soLuongKhuyenMai=" + soLuongKhuyenMai
				+ ", soLuotDaApDung=" + soLuotDaApDung + "]";
	}

}
