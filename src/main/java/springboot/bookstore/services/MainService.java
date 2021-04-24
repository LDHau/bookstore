package springboot.bookstore.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.bookstore.entitys.Books;
import springboot.bookstore.entitys.OrderDetail;
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

    public void updateBook(int id, Books books) {
        mainRepository.updateToBook(id, books);
    }

    public void deleteBook(int id) {
        mainRepository.deleteBook(id);
    }

    // ===== Order Detail ===== \\

    public void createOrderDetail(OrderDetail orderDetail) {
        mainRepository.createOrderDetail(orderDetail);
    }

}
