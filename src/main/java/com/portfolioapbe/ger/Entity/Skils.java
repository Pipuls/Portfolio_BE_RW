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
public class Skils {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String nameS;
    @NotNull
    private int percentageS;
    @NotNull
    private String logoS;
    @NotNull
    private String colorS;

    public Skils() {
    }

    public Skils(String nameS, int percentageS, String logoS, String colorS) {
        this.nameS = nameS;
        this.percentageS = percentageS;
        this.logoS = logoS;
        this.colorS = colorS;
    }
}
