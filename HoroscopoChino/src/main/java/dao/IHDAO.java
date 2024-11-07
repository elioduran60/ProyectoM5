package dao;

import java.sql.Date;

import modelo.Horoscopo;


public interface IHDAO {
    public Horoscopo horoscopoPorFecha(Date fecha_nacimiento);
}
