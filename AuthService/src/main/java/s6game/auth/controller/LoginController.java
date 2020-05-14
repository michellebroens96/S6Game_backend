package s6game.auth.controller;

import s6game.auth.model.User;
import s6game.auth.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;
    private Gson gson;

    @PostMapping(path = "/register")
    public User register(@RequestBody User user) {
        loginRepository.save(user);
        return user;
    }

    @PostMapping
    public boolean login(@RequestBody User user) {
        if(loginRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()) != null) {
			return true;
        }
        return false;
    }
}