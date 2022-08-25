package com.portfolioapbe.ger.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Xperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String positionX;
    private String yearX;
    private String companyX;
    private String descriptionX;

    public Xperience() {
    }

    public Xperience(String positionX, String yearX, String companyX, String descriptionX) {
        this.positionX = positionX;
        this.yearX = yearX;
        this.companyX = companyX;
        this.descriptionX = descriptionX;
    }
}
