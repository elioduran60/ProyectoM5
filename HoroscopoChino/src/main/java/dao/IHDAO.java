package dao;

import java.sql.Date;

import modelo.Horoscopo;

/*
 * Interface para la Clase ObtenerHoroscopo.DAO
 */
public interface IHDAO {
    public Horoscopo horoscopoPorFecha(Date fecha_nacimiento);
}
