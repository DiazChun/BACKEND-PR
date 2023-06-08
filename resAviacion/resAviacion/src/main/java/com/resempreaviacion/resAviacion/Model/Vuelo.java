package com.resempreaviacion.resAviacion.Model;

import javax.persistence.*;

@Entity
@Table(name = "vuelo")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_reservacion")
    private int idReservacion;

    @Column(name = "id_persona")
    private int idPersona;

    @Column(name = "numero_asiento")
    private String numeroAsiento;

    @Column(name = "hora_abordaje")
    private String horaAbordaje;

    @Column(name = "descripcion_vuelo")
    private String descripcionVuelo;

    // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public String getHoraAbordaje() {
        return horaAbordaje;
    }

    public void setHoraAbordaje(String horaAbordaje) {
        this.horaAbordaje = horaAbordaje;
    }

    public String getDescripcionVuelo() {
        return descripcionVuelo;
    }

    public void setDescripcionVuelo(String descripcionVuelo) {
        this.descripcionVuelo = descripcionVuelo;
    }
}
