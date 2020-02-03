package br.com.frwk.gateway.controller;

import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.frwk.gateway.config.exceptions.ValidationException;
import br.com.frwk.gateway.model.UserInfo;
import br.com.frwk.gateway.repository.UserInfoRepository;

@RestController
@CrossOrigin
public class UserInfoController {

	final private UserInfoRepository userInfoRepository;

	public UserInfoController(UserInfoRepository userInfoRepository) {
		this.userInfoRepository = userInfoRepository;
	}

	@PostMapping("/signup")
	public Boolean create(@RequestBody Map<String, String> body) throws NoSuchAlgorithmException {
		String username = body.get("username");
		if (userInfoRepository.existsByUsername(username)) {
			throw new ValidationException("Usuário já registrado");
		}

		String password = body.get("password");
		String encodedPassword = new BCryptPasswordEncoder().encode(password);
		String fullname = body.get("fullname");
		userInfoRepository.save(new UserInfo(username, encodedPassword, fullname));
		return true;
	}

}
