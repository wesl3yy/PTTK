package logicapplication.customerDAO;

import java.util.List;

import model.customer.Customer;

public interface CustomerDAO {
	

	// them
	Customer addUser(Customer user);
	// sua
	void updateUser(Customer user);
	// xoa
	boolean removeUser(int id);
	// kiem tra trung
	boolean isDuplicate(String username, String email);
	// tim user theo username
	Customer getUserByUserName(String username);
	// tim user theo id
	Customer getUserByUserId(int id);
	// lay danh sach user
	List<Customer> getListUser();
	// kiem tra dang nhap
	boolean checkLoginInfo(String username, String password);
	// dem xem co bao nhieu thanh vien
	int countUsers();
	// lay ten user tu id cua user
	String getUserFullNameByIdUser(int id);
}
