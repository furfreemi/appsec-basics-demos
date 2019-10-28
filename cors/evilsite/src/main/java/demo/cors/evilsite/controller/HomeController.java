package demo.cors.evilsite.controller;

import demo.cors.evilsite.service.DogFactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private DogFactService dogFactService;

    public HomeController(DogFactService dogFactService) {
        this.dogFactService = dogFactService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("fact", dogFactService.getDogFact());
        return "home";
    }
}