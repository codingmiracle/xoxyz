package at.codingmiracle.ticktacktoe.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SessionController {

	@RequestMapping("/")
	public String index(Model model, HttpSession session) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) session.getAttribute("messages");
		if (messages == null) {
			messages = new ArrayList<>();
		}

		model.addAttribute("sessionMessages", messages);
		model.addAttribute("sessionId", session.getId());

		return "index" + model.toString();
	}

	@PostMapping("/persistMessage")
	public String persistMessage(@RequestParam("msg") String message, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>) request.getSession().getAttribute("SESSION_MESSAGES");
		if (messages == null) {
			messages = new ArrayList<>();
			request.getSession().setAttribute("SESSION_MESSAGES", messages);
		}
		messages.add(message);
		request.getSession().setAttribute("SESSION_MESSAGES", messages);
		return "redirect:/";
	}

	@PostMapping("/destroy")
	public String destroySession(HttpServletRequest request) {
		request.getSession().invalidate();
		return "redirect:/";
	}
}
