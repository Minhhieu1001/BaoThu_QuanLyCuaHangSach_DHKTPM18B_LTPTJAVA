package dao;

import connectDB.ConnectDB;
import entities.NhanVien;
import interfaces.INhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import ultilities.ProcessingEnumDBForQuy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class NhanVien_DAO extends UnicastRemoteObject implements INhanVien{

    private EntityManager em;

    public List<NhanVien> findEmployeeAdvanced(String maNhanVien, String tenNhanVien, String soDienThoai,
            String gioiTinh, String chucVu) throws RemoteException{
    	
    	gioiTinh = ProcessingEnumDBForQuy.gioiTinhToEnum(gioiTinh);

    	chucVu = ProcessingEnumDBForQuy.convertNhanVienRolesToEnum(chucVu);
        List<NhanVien> listNhanVien = new ArrayList<>();

        String query = "SELECT nv FROM NhanVien nv WHERE nhanVienID LIKE :id AND hoTen LIKE :hoTen AND soDienThoai LIKE :sdt ";
        List<String> parameters = new ArrayList<>();
        parameters.add(maNhanVien.isBlank() ? "%" : "%" + maNhanVien + "%");
        parameters.add(tenNhanVien.isBlank() ? "%" : "%" + tenNhanVien + "%");
        parameters.add(soDienThoai.isBlank() ? "%" : "%" + soDienThoai + "%");
        if(gioiTinh.isBlank())
        	query += "AND gioiTinh like '%' ";
        else {
			if (gioiTinh.equalsIgnoreCase("NAM"))
				query += "AND gioiTinh like 'NAM' ";
			else
				query += "AND gioiTinh not like 'NAM' ";
        }
        if(chucVu.isBlank())
        	query += "AND chucVu like '%' ";
        else {
			if (chucVu.equals("NHAN_VIEN_BAN_HANG"))
				query += "AND chucVu like 'NHAN_VIEN_BAN_HANG' ";
			else
				query += "AND chucVu not like 'NHAN_VIEN_BAN_HANG' ";
        }

        try {
        	
			listNhanVien = em.createQuery(query, NhanVien.class).setParameter("id", parameters.get(0))
					.setParameter("hoTen", parameters.get(1)).setParameter("sdt", parameters.get(2)).getResultList();
	
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listNhanVien;
    }

    @Override
    public List<NhanVien> getAllEmployees() throws RemoteException{
    	try {
			return em.createQuery("FROM NhanVien", NhanVien.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public int totalNhanVien() throws RemoteException{
        // TODO Auto-generated method stub
    	try {
    	    Long count = em.createQuery("SELECT COUNT(nv) FROM NhanVien nv", Long.class).getSingleResult();
    	    return count.intValue(); 
    	} catch (Exception e) {
    	    e.printStackTrace();
    	    return 0;
    	}
    }

	@Override
	public boolean addNhanVien(NhanVien x) throws RemoteException {
		EntityTransaction tx = em.getTransaction();
		boolean isTransactionManagedHere = false;

		try {
			// Kiểm tra xem giao dịch đã được bắt đầu hay chưa
			if (!tx.isActive()) {
				tx.begin();
				isTransactionManagedHere = true;
			}

			em.persist(x);

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

    @Override
    public boolean editNhanVien(NhanVien x) throws RemoteException{
		try {
			em.getTransaction().begin();
			em.merge(x);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }

    @Override
    public boolean deleteNhanVien(NhanVien x) throws RemoteException{
		try {
			em.getTransaction().begin();
			em.remove(x);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
    }

    @Override
    public String getTenTuMa(String x) throws RemoteException{
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public NhanVien getNhanVienByNhanVienID(String x) throws RemoteException{
		try {
			em.getTransaction().begin();
			NhanVien nv = em.find(NhanVien.class, x);
			em.getTransaction().commit();
			return nv;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

    @Override
    public boolean isMaNhanVienExists(String x) throws RemoteException {
		try {
			return em.find(NhanVien.class, x) != null;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
    }

	@Override
	public int phatSinhMaNhanVien() throws RemoteException {
		try {
			// Lấy nhanVienID lớn nhất
			String maxId = em.createQuery("SELECT MAX(nv.nhanVienID) FROM NhanVien nv", String.class)
					.getSingleResult();
			if (maxId == null || !maxId.startsWith("NV")) {
				return 1; // Nếu chưa có bản ghi nào, bắt đầu từ 1 (NV0001)
			}
			// Tách phần số từ mã (VD: NV0003 -> 3)
			int num = Integer.parseInt(maxId.substring(2));
			return num + 1; // Tăng lên 1 để được mã mới (VD: 4 cho NV0004)
		} catch (Exception e) {
			System.err.println("Error generating nhanVienID: " + e.getMessage());
			e.printStackTrace();
			return 1; // Giá trị mặc định nếu có lỗi
		}
	}

    @Override
    public List<NhanVien> findEmployee(String x) throws RemoteException{
        // TODO Auto-generated method stub
        return null;
    }

	public boolean chuyenChucVuNhanVienCu(String maNhanVien) throws RemoteException {
		try {
			em.getTransaction().begin();
			int updatedRows = em.createQuery("UPDATE NhanVien SET chucVu = :chucVu WHERE nhanVienID = :maNhanVien")
					.setParameter("chucVu", "NHAN_VIEN_CU")
					.setParameter("maNhanVien", maNhanVien)
					.executeUpdate();
			em.getTransaction().commit();
			return updatedRows > 0;
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			return false;
		}
	}

    public NhanVien_DAO() throws RemoteException{
    	em = ConnectDB.getEntityManager();
    }

	@Override
	public NhanVien dangNhapNhanVien(String user, String password) throws RemoteException {
		try {
			List<NhanVien> result = em.createQuery("FROM NhanVien WHERE userName = :user AND password = :password", NhanVien.class)
					.setParameter("user", user)
					.setParameter("password", password)
					.getResultList();

			// Kiểm tra xem có kết quả hay không
			if (result.isEmpty()) {
				return null; // Trả về null nếu không tìm thấy nhân viên
			}

			return result.get(0); // Trả về nhân viên đầu tiên nếu tìm thấy
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

    @Override
    public String getNhanVienEmailViaUsername(String username) throws RemoteException{
    	try {
			return em.createQuery("SELECT email FROM NhanVien WHERE userName = :username", String.class)
					.setParameter("username", username).getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    }

	@Override
	public boolean resetUserPassword(String username, String newPassword) throws RemoteException {
		try {
			em.getTransaction().begin(); // Bắt đầu giao dịch
			int updatedRows = em.createQuery("UPDATE NhanVien SET password = :newPassword WHERE userName = :username")
					.setParameter("newPassword", newPassword)
					.setParameter("username", username)
					.executeUpdate();
			em.getTransaction().commit(); // Xác nhận giao dịch
			return updatedRows > 0;
		} catch (Exception e) {
			em.getTransaction().rollback(); // Hoàn tác nếu có lỗi
			e.printStackTrace();
			return false;
		}
	}

}
