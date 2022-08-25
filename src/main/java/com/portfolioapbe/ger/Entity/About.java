package com.portfolioapbe.ger.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Getter
@Setter
@Entity
public class About implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @NotNull
    @Size(min = 10, max = 1000, message = "Debe escribir al menos 10 caracteres y maximo 1000.")
    private String textAboutMe;

    public About() {
    }

    public About(String textAboutMe) {
        this.textAboutMe = textAboutMe;
    }
}
