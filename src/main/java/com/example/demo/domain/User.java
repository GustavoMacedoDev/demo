package com.example.demo.domain;

import com.example.demo.enums.ProfileEnum;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_entity")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String email;
    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile", nullable = false )
    private ProfileEnum profileEnum;


}
