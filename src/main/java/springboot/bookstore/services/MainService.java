package springboot.bookstore.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.bookstore.entitys.Books;
import springboot.bookstore.entitys.OrderDetail;
import springboot.bookstore.entitys.Orders;
import springboot.bookstore.repositorys.MainRepository;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private MainRepository mainRepository;


    // ===== BOOK ===== \\
    public List<Books> getAllBook() {
        return mainRepository.listBook();
    }

    public Books getBookById(int id) {
        return mainRepository.findBookById(id);
    }

    public void addToBook(Books books) {
        mainRepository.addToBook(books);
    }

    public void updateBook(int id, Books book) {
        mainRepository.updateToBook(id, book);
    }

    public void deleteBook(int id) {
        mainRepository.deleteBook(id);
    }

    // ===== Order Detail ===== \\

    public void createOrderDetail(int idBook) {
        mainRepository.createOrderDetail(idBook);
    }

    public List<OrderDetail> detailList() {
        return mainRepository.detailList();
    }

    public void deleteOrderDetail(int idDetail) {
        mainRepository.deleteDetail(idDetail);
    }

    // ===== Orders ===== \\
    public List<Orders> ordersList() {
        return mainRepository.ordersList();
    }

    public void createOrders(int idDetail) {
        mainRepository.createOrders(idDetail);
    }
}
