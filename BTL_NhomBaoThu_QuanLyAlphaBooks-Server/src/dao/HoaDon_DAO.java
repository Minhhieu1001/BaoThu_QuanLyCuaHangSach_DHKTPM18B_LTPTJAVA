 package dao;

 import connectDB.ConnectDB;
 import entities.*;
 import interfaces.IHoaDon;
 import jakarta.persistence.EntityManager;
 import jakarta.persistence.TypedQuery;
 import ultilities.QueryBuilder;

 import java.rmi.RemoteException;
 import java.rmi.server.UnicastRemoteObject;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;
 import java.util.List;

public class HoaDon_DAO extends UnicastRemoteObject implements IHoaDon {
	private final int LIMIT_RESULT = 100;
	private EntityManager em;

	public HoaDon_DAO() throws RemoteException{
		// TODO Auto-generated constructor stub
		em = ConnectDB.getEntityManager();
	}

	@Override
	public boolean createHoaDon(HoaDon x) throws RemoteException{
		// TODO Auto-generated method stub
		boolean isThisSession = em.getTransaction().isActive();
		if (x.getKhachHang() == null) {
			x.setKhachHang(new KhachHang("KH0001"));
		}

		if (x.getNhanVien() == null) {
			x.setNhanVien(new NhanVien("NV0001"));
		}

		if (x.getKhuyenMai() == null) {
			x.setKhuyenMai(new KhuyenMai("NO_APPLY"));
		}

		x.setNgayLapHoaDon(new Date());

		x.setTongTien(x.tinhThanhTien());

		x.setTrangThai(x.getTrangThai());

		x.setThue(x.getThue());

		x.setHoaDonID(x.getHoaDonID());

		try {
			if (isThisSession == false)
				em.getTransaction().begin();
			em.persist(x);
			if (isThisSession == false)
				em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateHoaDon(HoaDon x) throws RemoteException{
		boolean isThisSession = em.getTransaction().isActive();
		try {
			if (x.getKhachHang() == null) {
				x.setKhachHang(new KhachHang("KH0001"));
			}

			if (x.getNhanVien() == null) {
				x.setNhanVien(new NhanVien("NV0001"));
			}

			if (x.getKhuyenMai() == null) {
				x.setKhuyenMai(new KhuyenMai("NO_APPLY"));
			}

			x.setNgayLapHoaDon(new Date());

			x.setTongTien(x.tinhThanhTien());

			if (isThisSession == false)
				em.getTransaction().begin();

			List<ChiTietHoaDon> tempList = x.getListChiTietHoaDon();
			x.setListChiTietHoaDon(null);
			em.merge(x);
			if (isThisSession == false)
				em.getTransaction().commit();

			x.setListChiTietHoaDon(tempList);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean cancelHoaDon(HoaDon x) throws RemoteException{
		boolean isThisSession = em.getTransaction().isActive();
		try {
			HoaDon oriHoaDon = em.createNamedQuery("HoaDon.findById", HoaDon.class)
					.setParameter("hoaDonID", x.getHoaDonID()).getSingleResult();
			
			oriHoaDon.setTrangThai("TRA_HANG");
			if (isThisSession == false)
				em.getTransaction().begin();
			
			
//			List<ChiTietHoaDon> tempListCTHD = x.getListChiTietHoaDon();
//			oriHoaDon.setListChiTietHoaDon(null);
			
			em.merge(oriHoaDon);
			
			if (isThisSession == false)
				em.getTransaction().commit();
//			oriHoaDon.setListChiTietHoaDon(tempListCTHD);

			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<HoaDon> getDanhSachHoaDon() throws RemoteException{
		List<HoaDon> listHoaDon = new ArrayList<HoaDon>();
		try {
			listHoaDon = em.createNamedQuery("HoaDon.findAll").setMaxResults(LIMIT_RESULT).getResultList();
			return listHoaDon;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return listHoaDon;
		}
	}

	@Override
	public List<HoaDon> getDanhSachHoaDonTheoThoiGian(Date batDau, Date ketThuc) throws RemoteException {
		List<HoaDon> listHoaDon = new ArrayList<>();

		try {
			String query = "SELECT hd.* FROM HoaDon hd " +
					"LEFT JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID " +
					"LEFT JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID " +
					"LEFT JOIN KhuyenMai km ON km.CodeKhuyenMai = hd.CodeKhuyenMai " +
					"WHERE hd.ngayLapHoaDon > :batDau AND hd.ngayLapHoaDon <= :ketThuc " +
					"ORDER BY hd.ngayLapHoaDon ASC";

			listHoaDon = em.createNativeQuery(query, HoaDon.class)
					.setParameter("batDau", batDau)
					.setParameter("ketThuc", ketThuc)
					.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return listHoaDon;
	}

	@Override
	public List<HoaDon> getDanhSachHoaDonNangCao(Object[] params) throws RemoteException {
		List<HoaDon> listHoaDon = new ArrayList<>();

		String query = "SELECT hd.* FROM HoaDon hd " +
				"LEFT JOIN NhanVien nv ON hd.NhanVienID = nv.NhanVienID " +
				"LEFT JOIN KhachHang kh ON hd.KhachHangID = kh.KhachHangID " +
				"LEFT JOIN KhuyenMai km ON km.CodeKhuyenMai = hd.CodeKhuyenMai ?  ORDER BY ngayLapHoaDon ASC LIMIT 150";

		try {
			QueryBuilder queryBuilder = new QueryBuilder(query);

			// Xử lý tham số ngày
			if (params[0] != null) {
				System.out.println("Định dạng ngày bắt đầu: " + params[0].toString());
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.DATE, "NgayLapHoaDon", ">=", params[0]);
			}
			if (params[1] != null) {
				System.out.println("Định dạng ngày kết thúc: " + params[1].toString());
				// Sử dụng định dạng đầy đủ cho ngày kết thúc
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String endDateStr = sdf.format(params[1]);
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.STRING, "NgayLapHoaDon", "<=", "'" + endDateStr + "'");
			}

			// Xử lý trạng thái
			if (params[2] != null && !((String) params[2]).isEmpty()) {
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.STRING, "TrangThai", "=", params[2]);
			}

			// Xử lý tổng tiền
			if (params[3] != null) {
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.DOUBLE, "TongTien", ">=", params[3]);
			} else {
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.DOUBLE, "TongTien", ">=", 0.0);
			}
			if (params[4] != null) {
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.DOUBLE, "TongTien", "<=", params[4]);
			} else {
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.DOUBLE, "TongTien", "<=", 999999999.0);
			}

			// Xử lý mã hóa đơn, khách hàng, nhân viên
			if (params[5] != null && !((String) params[5]).isEmpty()) {
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.STRING, "HoaDonID", "%?%", params[5]);
			} else {
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.STRING, "HoaDonID", "%?%", "%");
			}
			if (params[6] != null && !((String) params[6]).isEmpty()) {
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.STRING, "hd.KhachHangID", "%?%", params[6]);
			} else {
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.STRING, "hd.KhachHangID", "%?%", "%");
			}
			if (params[7] != null && !((String) params[7]).isEmpty()) {
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.STRING, "hd.NhanVienID", "%?%", params[7]);
			} else {
				queryBuilder.addParameter(QueryBuilder.Enum_DataType.STRING, "hd.NhanVienID", "%?%", "%");
			}

			// In truy vấn để debug
			String nativeQuery = (String) queryBuilder.generateQueryWithValue("AND")[1];

			listHoaDon = em.createNativeQuery(nativeQuery, HoaDon.class).getResultList();

			return listHoaDon;
		} catch (Exception e) {
			e.printStackTrace();
			return listHoaDon;
		}
	}

	
	@Override
	public HoaDon getHoaDonByID(HoaDon hd) throws RemoteException{
		try {
			hd = em.createNamedQuery("HoaDon.findById", HoaDon.class).setParameter("hoaDonID", hd.getHoaDonID())
					.getSingleResult();

			return hd;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public List<Object[]> getDanhSachHoaDonThongKeXuHuong(Date batDau, Date ketThuc) throws RemoteException{
	    List<Object[]> listHoaDon = new ArrayList<>();

	    try {
	        TypedQuery<Object[]> query = em.createNamedQuery("HoaDon.ThongKeDoanhThu", Object[].class);
	        query.setParameter("batDau", batDau);
	        query.setParameter("ketThuc", ketThuc);
	        query.setParameter("trangThai", "DA_XU_LY");
	        query.getResultList().forEach(
		        	obj -> {
		        		Object[] tempObj = { 0, (String) obj[1], (String) obj[2], (int) obj[3],
		        				(long) obj[4], 0, (double) obj[5], (double) obj[6],
		        				(double) obj[5] - (double) obj[6], 0f };
		    	        listHoaDon.add(tempObj);
		        	}
		        );
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return listHoaDon;
	}

	
	@Override
	public int getSoHoaDonTrongNgay() throws RemoteException{
	    try {
	        TypedQuery<Long> query = em.createNamedQuery("HoaDon.countToday", Long.class);

	        return query.getSingleResult().intValue();
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}


}
