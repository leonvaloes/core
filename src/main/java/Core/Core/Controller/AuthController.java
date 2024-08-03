package Core.Core.Controller;

import Core.Core.Model.DTO.Request.LoginRequestDTO;
import Core.Core.Model.DTO.Request.RegisterRequestDTO;
import Core.Core.Model.DTO.Response.UserResponseDTO;
import Core.Core.Model.Entity.User;
import Core.Core.Model.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class AuthController {

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/teste")
    public void teste(){
        System.out.println("teste");
    }
    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> login(@RequestBody LoginRequestDTO loginRequest, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }

        User user = userService.findByEmail(loginRequest.getEmail());
        if (user == null || !userService.checkPassword(user, loginRequest.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }

        UserResponseDTO response = new UserResponseDTO();
        response.setEmail(user.getEmail());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody RegisterRequestDTO registerRequest, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }

        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setPassword(registerRequest.getPassword());

        User savedUser = userService.save(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setEmail(savedUser.getEmail());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
