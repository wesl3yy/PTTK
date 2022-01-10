package model.order;

import model.book.BookItem;
import java.io.Serializable;
import java.util.List;
import model.customer.Customer;

public class Cart implements Serializable{
    static final long serialVersionUID = 12L;
    private int id;
    private Customer customer;
    private List<BookItem> item;    

    public Cart(int id, Customer customer,List<BookItem> item) {
        this.id = id;
        this.customer = customer;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<BookItem> getItem() {
        return item;
    }

    public void setItem(List<BookItem> item) {
        this.item = item;
    }
    
}
