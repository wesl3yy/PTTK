package model.order;

import model.book.BookItem;
import java.io.Serializable;
import java.util.List;
import model.customer.Customer;

public class Order implements Serializable {

	private static final long serialVersionUID = 6L;
	private int id;
	private Customer user;
	private List<BookItem> items;
	private String createdDate;
	private int status;
        private Payment payment;
	public Order() {
		super();
	}
	public Order(int id, Customer user, List<BookItem> items, String createdDate, int status, Payment payment) {
		super();
		this.id = id;
		this.user = user;
		this.items = items;
		this.createdDate = createdDate;
		this.status = status;
                this.payment = payment;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getUser() {
		return user;
	}
	public void setUser(Customer user) {
		this.user = user;
	}
	public List<BookItem> getItems() {
		return items;
	}
	public void setItems(List<BookItem> items) {
		this.items = items;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

        public Payment getPayment() {
                return payment;
        }

        public void setPayment(Payment payment) {
                this.payment = payment;
        }
        
        
	@Override
	public String toString() {
		return "Order [id=" + id + ", user=" + user + ", items=" + items + ", createdDate=" + createdDate + ", status="
				+ status + "]";
	}
}
