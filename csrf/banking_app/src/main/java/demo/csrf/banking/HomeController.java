package demo.csrf.banking;

import demo.csrf.banking.model.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.LinkedList;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private LinkedList<Transaction> transactions = new LinkedList<>();
    private double balance = 10000;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("transactions", transactions);
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("balance", balance);
        return "home";
    }

    @PostMapping(path = "/transaction")
    public String transactionSubmission(@ModelAttribute Transaction transaction) {
        if (Pattern.matches("(\\p{Digit}+)", transaction.getAmount())) {
            balance -= Double.parseDouble(transaction.getAmount());
            transaction.setDate(new Date());
            transactions.addFirst(transaction);
        }
        return "redirect:/";
    }
}