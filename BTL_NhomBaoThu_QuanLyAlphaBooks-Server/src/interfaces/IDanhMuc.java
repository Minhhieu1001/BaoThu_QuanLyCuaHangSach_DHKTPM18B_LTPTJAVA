package interfaces;

import entities.DanhMuc;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IDanhMuc extends Remote{
	public List<DanhMuc> getAllDanhMuc() throws RemoteException;
	public List<DanhMuc> getDanhMucTheoID(int x) throws RemoteException;
	public boolean addDanhMuc(DanhMuc x) throws RemoteException;
	public boolean editDanhMuc (DanhMuc x) throws RemoteException;
}
