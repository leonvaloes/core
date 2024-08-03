package Core.Core.Model.DTO.Request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class LoginRequestDTO {
    private String email;
    private String password;
}
