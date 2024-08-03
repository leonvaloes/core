package Core.Core.Model.DTO.Request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class RegisterRequestDTO {
    private String name;
    private Timestamp createdAt;
    private Timestamp birthday;
    private String CPF;
    private String email;
    private String password;
}
