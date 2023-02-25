package ssf.day19_class.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssf.day19_class.model.News;
import ssf.day19_class.services.NewsServices;

@Controller
@RequestMapping(path = "/news")
public class NewsController {

    
@Autowired
private NewsServices newsServices;

    @GetMapping
    public String getNews(Model model, @RequestParam String country) {

        List<News> news = newsServices.getNews(country);

        model.addAttribute("country", news); 
        
        return "news";
    }

    
}
