package pl.coderslab.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.coderslab.entities.Comment;
import pl.coderslab.entities.Tweet;
import pl.coderslab.entities.User;
import pl.coderslab.repositories.CommentRepository;
import pl.coderslab.repositories.TweetRepository;
import pl.coderslab.repositories.UserRepository;

@Controller
@RequestMapping(path = "/tweet")
public class TweeterController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	TweetRepository tweetRepository;
	@Autowired
	CommentRepository commentRepository;
	
	@GetMapping(path="/{id}")
	public String tweetDetails(Model model, @PathVariable("id") long id) {
		Tweet detailedTweet = tweetRepository.findOne(id);
		model.addAttribute("tweet", detailedTweet);
		model.addAttribute("comments", commentRepository.findByTweetId(id));
		model.addAttribute("comment", new Comment());
		return "tweet/tweetDetails";
	}
	
	@PostMapping(path="/{id}")
	public String tweetDetailsPost(Model model, @PathVariable("id") long id, @ModelAttribute Comment comment, HttpSession session) {
		comment.setCreated(LocalDateTime.now());
		comment.setUser((User) session.getAttribute("loggerUser"));
		Tweet detailedTweet = tweetRepository.findOne(id);
		comment.setTweet(detailedTweet);
		commentRepository.save(comment);
		model.addAttribute("tweet", detailedTweet);
		model.addAttribute("comments", commentRepository.findByTweetId(id));
		model.addAttribute("comment", new Comment());
		return "tweet/tweetDetails";
	}
	
}
