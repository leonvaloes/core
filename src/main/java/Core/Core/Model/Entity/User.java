package Core.Core.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "created_at", nullable = false, updatable = false)
    private Timestamp createdAt;

    private Timestamp birthday;

    @Column(unique = true, nullable = false)
    private String CPF;
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
