package com.portfolioapbe.ger.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String titleE;
    @NotNull
    private String institutionE;
    @NotNull
    private String placeE;
    @NotNull
    private String yearE;
    @NotNull
    private String logoE;

    public Education() {
    }

    public Education(String titleE, String institutionE, String placeE, String yearE, String logoE) {
        this.titleE = titleE;
        this.institutionE = institutionE;
        this.placeE = placeE;
        this.yearE = yearE;
        this.logoE = logoE;
    }
}
