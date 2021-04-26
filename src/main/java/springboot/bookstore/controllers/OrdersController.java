package springboot.bookstore.controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springboot.bookstore.entitys.OrderDetail;
import springboot.bookstore.entitys.Orders;
import springboot.bookstore.services.MainService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrdersController {

    @Autowired
    MainService mainService;

    @GetMapping("/listorders")
    public List<Orders> getOrdersList() {
        return mainService.ordersList();
    }

    @PostMapping("/createorders")
    public void createOrders(@RequestParam int idDetail) {
        mainService.createOrders(idDetail);
    }
}
