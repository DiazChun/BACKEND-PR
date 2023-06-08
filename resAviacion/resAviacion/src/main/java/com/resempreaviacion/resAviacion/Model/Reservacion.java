package com.resempreaviacion.resAviacion.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservacion")
public class Reservacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_persona")
    private int idPersona;

    @Column(name = "descripcion_reservacion")
    private String descripcionReservacion;

    @Column(name = "salida")
    private Date salida;

    @Column(name = "destino")
    private String destino;

    @Column(name = "llegada")
    private Date llegada;

    // Getters y Setters

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getDescripcionReservacion() {
        return descripcionReservacion;
    }

    public void setDescripcionReservacion(String descripcionReservacion) {
        this.descripcionReservacion = descripcionReservacion;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getLlegada() {
        return llegada;
    }

    public void setLlegada(Date llegada) {
        this.llegada = llegada;
    }
}
