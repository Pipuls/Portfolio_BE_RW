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
public class Profile implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Size(min = 3, max = 50, message = "Debe escribir al menos 3 caracteres y maximo 50.")
    private String name;

    @NotNull
    @Size(min = 3, max = 50, message = "Debe escribir al menos 3 caracteres y maximo 50.")
    private String lastname;

    @NotNull
    @Size(min = 3, max = 255, message = "Debe escribir al menos 3 caracteres y maximo 255.")
    private String imgUrl;

    @NotNull
    @Size(min = 3, max = 50, message = "Debe escribir al menos 3 caracteres y maximo 50.")
    private String profession1;

    @NotNull
    @Size(min = 3, max = 50, message = "Debe escribir al menos 3 caracteres y maximo 50.")
    private String profession2;



    public Profile() {
    }
    /*@OneToMany(fetch = FetchType.LAZY, mappedBy = "id" )
    private List<Educacion> educacionList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id" )
    private List<JobXp> jobXpList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id" )
    private List<Skils> skilsList;*/

    public Profile(String name, String lastname, String imgUrl, String profession1, String profession2) {
        this.name = name;
        this.lastname = lastname;
        this.imgUrl = imgUrl;
        this.profession1 = profession1;
        this.profession2 = profession2;
    }
}
