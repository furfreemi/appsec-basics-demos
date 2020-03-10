package demo.sql.banking;

import demo.sql.banking.model.Item;
import demo.sql.banking.service.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;

@Controller
public class HomeController {

    private ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("item", new Item());
        return "home";
    }

    @PostMapping(path = "/items")
    public ModelAndView searchForItem(@ModelAttribute Item item, RedirectAttributes redirectAttributes) throws SQLException {
        ModelAndView mv = new ModelAndView("redirect:/results");
        redirectAttributes.addFlashAttribute("items", itemService.getItemByName(item.getName()));
        return mv;
    }

    @GetMapping("/results")
    public String resultsPage(Model model) {
        return "results";
    }
}