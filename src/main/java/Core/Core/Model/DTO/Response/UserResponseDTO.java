package Core.Core.Model.DTO.Response;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
public class UserResponseDTO {
    private String name;
    private Timestamp createdAt;
    private Timestamp birthday;
    private String CPF;
    private String email;
    private String password;
}
