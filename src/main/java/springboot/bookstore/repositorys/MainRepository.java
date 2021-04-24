package springboot.bookstore.repositorys;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springboot.bookstore.entitys.Books;
import springboot.bookstore.entitys.OrderDetail;

import java.util.List;


@Repository
public class MainRepository {

    @Autowired
    private SessionFactory sessionFactory;

    // ===== BOOK ===== \\
    @Transactional
    public List<Books> listBook() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("SELECT a FROM Books a", Books.class).getResultList();
    }

    @Transactional
    public Books findBookById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Books books = session.get(Books.class, id);
        return session.get(Books.class, id);
    }

    @Transactional
    public void addToBook(Books books) {
        Session session = sessionFactory.getCurrentSession();
        Books newBook = new Books();
        newBook.setTitle(books.getTitle());
        newBook.setPrice(books.getPrice());
        newBook.setPages(books.getPages());
        session.save(newBook);
    }

    public void updateToBook(int id, Books books) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Books crtBooks = session.load(Books.class, id);
            crtBooks.setTitle(books.getTitle());
            crtBooks.setPrice(books.getPrice());
            crtBooks.setPages(books.getPages());
            session.update(crtBooks);
            session.flush();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void deleteBook(int id ) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Books books = session.load(Books.class, id);
            session.delete(books);
            session.flush();
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    // ===== Order Detail ===== \\

    @Transactional
    public void createOrderDetail(OrderDetail orderDetail) {
        Session session = sessionFactory.getCurrentSession();
        OrderDetail newOrderDetail = new OrderDetail();
        newOrderDetail.setBooksList(orderDetail.getBooksList());
        newOrderDetail.setOrders(orderDetail.getOrders());
        session.save(newOrderDetail);
    }

}
