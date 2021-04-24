package springboot.bookstore.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.bookstore.entitys.Books;
import springboot.bookstore.entitys.OrderDetail;
import springboot.bookstore.repositorys.MainRepository;
import springboot.bookstore.services.MainService;

import java.util.List;

//@RestController
@Controller
public class OrderDetailController {

    @Autowired
    private MainService mainService;
//
//    @PostMapping("/orderdetail")
//    public void createBook(@RequestBody OrderDetail orderDetail) {
//     mainService.createOrderDetail(orderDetail);
//    }

//    @Autowired
//    private SessionFactory sessionFactory;


    @PostMapping("/adddetail")
    @ResponseBody
    public void createOrderDetail(@RequestParam int idbook) {
        mainService.createOrderDetail(idbook);
    }

    @GetMapping("/listdetail")
    public String getListDetail(Model model) {
        List<OrderDetail> listDetail = mainService.detailList();
        model.addAttribute("details", listDetail);
        return "listorderdetail";
    }

//    @GetMapping("/listdetail")
//    public List<OrderDetail> getListDetail() {
//        List<OrderDetail> listDetail = mainService.detailList();
//        return listDetail;
//    }



}
