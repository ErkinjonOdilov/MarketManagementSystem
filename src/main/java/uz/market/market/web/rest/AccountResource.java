package uz.market.market.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.market.market.domain.User;
import uz.market.market.security.SecurityUtils;
import uz.market.market.service.UserService;

@RestController
@RequestMapping("/api")
public class AccountResource {

    private final UserService userService;

    public AccountResource(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping("/account")
    public ResponseEntity<?> getAccount(){
        String login= SecurityUtils.getCurrentUserName().get();
        User user=userService.findByUserName(login);
        return ResponseEntity.ok(user);
    }
}
