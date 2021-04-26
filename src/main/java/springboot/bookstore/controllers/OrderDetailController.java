package springboot.bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.bookstore.entitys.OrderDetail;
import springboot.bookstore.services.MainService;

import java.util.List;

@Controller
public class OrderDetailController {

    @Autowired
    private MainService mainService;

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

//    @GetMapping("/deletedetail")
//    public void deleteDetail(@RequestParam int idDetail) {
//        mainService.deleteOrderDetail(idDetail);
//    }


}
