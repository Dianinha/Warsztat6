package pl.coderslab.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pl.coderslab.entities.User;
import pl.coderslab.repositories.UserRepository;

@Controller
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping(path = "/login")
	public String showLoginForm() {
		return "login/login";
	}

	@PostMapping(path = "/login")
	public String processLoginRequest(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model,HttpSession session) {
		User user = userRepository.findOneByUsername(username);

		if (user != null) {
			String passHashed = user.getPassword();
			if (BCrypt.checkpw(password, passHashed)) {
				System.out.println("It matches");
				model.addAttribute("username", username);
				session.setAttribute("loggedUser", user);
				return "login/success";
			} else {
				System.out.println("It does not match");
				model.addAttribute("message", "Password does not match");
				return "login/login";
			}
			

		} else {
			model.addAttribute("message", "There is no user with this username.");
			return "login/login";
		}
	}

	@GetMapping(path = "/register")
	public String showRegisterForm(Model model) {
		model.addAttribute("user", new User());
		return "login/register";
	}

	@PostMapping(path = "/register")
	public String processRegistartionRequest(@Valid User user, BindingResult bresult, HttpSession session) {

		if (bresult.hasErrors()) {

			return "login/register";

		} else {
			if (user.getPassword()!=null) {
				userRepository.save(user);
				session.setAttribute("loggedUser", user);
				return "login/success";
			}
			else {
				return "login/register";
			}

		}
	}

}
