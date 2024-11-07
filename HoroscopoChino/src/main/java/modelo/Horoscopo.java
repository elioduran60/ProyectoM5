package modelo;

import java.sql.Date;

public class Horoscopo {
    private Long id;
    private String animal;
    private java.sql.Date fecha_inicio;
    private java.sql.Date fecha_fin;

    public Horoscopo(Long id,String animal, java.sql.Date fecha_inicio, java.sql.Date fecha_fin) {
        this.id = id;
        this.animal = animal;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getAnimal() {
        return animal;
    }
    public void setAnimal(String animal) {
        this.animal = animal;
    }
    public Date getFecha_inicio() {
        return fecha_inicio;
    }
    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }
    public Date getFecha_fin() {
        return fecha_fin;
    }
    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
    public boolean isPresent() {
       return true;
    }
}