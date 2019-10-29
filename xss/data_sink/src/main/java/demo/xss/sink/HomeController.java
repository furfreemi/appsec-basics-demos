package demo.xss.sink;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    private String data = "";

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("data", data);
        return "home";
    }

    @PostMapping("/")
    @CrossOrigin("*")
    public String takeData(@RequestBody String data) {
        this.data += data;
        return "redirect:/";
    }
}