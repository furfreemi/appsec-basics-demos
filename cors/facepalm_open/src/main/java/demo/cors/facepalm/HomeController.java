package demo.cors.facepalm;

import demo.cors.facepalm.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

@Controller
public class HomeController {
    private LinkedList<String> posts = new LinkedList<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("posts", posts);
        return "home";
    }

    @PostMapping(path = "/", consumes = "application/json")
    @CrossOrigin(origins = "*")
    public String displayPost(@RequestBody Post post) {
        posts.addFirst(dateFormat.format(new Date()) + "\n" + post.getPostContent());
        return "home";
    }
}