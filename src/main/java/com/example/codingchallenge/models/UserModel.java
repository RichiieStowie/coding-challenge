package com.example.codingchallenge.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserModel implements Serializable {
    private static final long serialVersionUID = 5926468583005150707L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
}
