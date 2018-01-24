package pl.coderslab.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import pl.coderslab.entities.Tweet;
import pl.coderslab.entities.User;
import pl.coderslab.repositories.TweetRepository;

@Controller
public class HomeController {
	
	@Autowired
	TweetRepository tweetRepository;
	

	@GetMapping(path = "/")
	public String index(Model model) {
		model.addAttribute("tweets", tweetRepository.findAll());
		model.addAttribute("tweet", new Tweet());
		return "index";
	}
	
	@PostMapping(path="/newTweet")
	public String addNewTweet(@ModelAttribute Tweet tweet, HttpSession session){
		tweet.setCreated(LocalDateTime.now());
		tweet.setUser((User) session.getAttribute("loggedUser"));
		tweetRepository.save(tweet);
		return "redirect:/index";
		
	}
}
