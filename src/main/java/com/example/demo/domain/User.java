package com.example.demo.domain;

import com.example.demo.enums.ProfileEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_entity")
@Getter @Setter @ToString @EqualsAndHashCode
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String email;
    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "profile", nullable = false )
    private ProfileEnum profileEnum;

    public User() {

    }


}
