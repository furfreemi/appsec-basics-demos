package demo.xss.shopping;

import demo.xss.shopping.model.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class OrderController {

    private LinkedList<Order> ordersList;

    public OrderController(LinkedList<Order> ordersList) {
        this.ordersList = ordersList;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("order", new Order());
        return "home";
    }

    @GetMapping("/thankyou")
    public String thankYouPage() {
        return "thankyou";
    }

    @PostMapping(path = "/order")
    public String transactionSubmission(@ModelAttribute Order order) {
        ordersList.addFirst(order);
        return "redirect:/thankyou";
    }
}