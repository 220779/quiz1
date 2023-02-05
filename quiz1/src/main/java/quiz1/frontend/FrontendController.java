package quiz1.frontend;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import quiz1.service.QuizDataService;

@Controller
@Log
public class FrontendController {

    @Autowired
    private QuizDataService quizDataService;



    @GetMapping("/")
    public String hello(Model model) {
        model.addAttribute("message", "some message");

        return "hello";
    }

    @GetMapping("/select")
    public String select(Model model) {
        model.addAttribute("gameOptions", new GameOptions());
        model.addAttribute("categories", quizDataService.getQuizCategories());
        return "select";
    }

      @PostMapping("/select")
        public String postSelectForm(Model model, @ModelAttribute GameOptions gameOptions) {
            log.info("Form submitted with data: " + gameOptions);
            return "index";
        }
    }


