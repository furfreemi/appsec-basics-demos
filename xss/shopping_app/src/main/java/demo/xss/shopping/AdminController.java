package demo.xss.shopping;

import demo.xss.shopping.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedList;
import java.util.List;

import static java.util.Collections.emptyList;


@Controller
public class AdminController {

    private LinkedList<Order> ordersList;

    public AdminController(LinkedList<Order> ordersList) {
        this.ordersList = ordersList;
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("orders", ordersList);
        return "admin";
    }
}
