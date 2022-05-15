package com.ap.argentinaprograma.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long idSkill;
    private String nombreSkill;
    private String fotoSkill;
    private int porcentaje;

    public Skills() {
    }

    public Skills(Long idSkill, String nombreSkill, String fotoSkill, int porcentaje) {
        this.idSkill = idSkill;
        this.nombreSkill = nombreSkill;
        this.fotoSkill = fotoSkill;
        this.porcentaje = porcentaje;
    }
    
    
}
