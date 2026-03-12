package com.fims.userservice.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@GetMapping("/{username}")
	public String getUser(@PathVariable String username){
		return String.format("welcome to %s", username);
	}

	@GetMapping("/check")
	public String check(HttpServletRequest request){
		int port = request.getServerPort();
		return String.format("PORT : %d", port);
	}
}
