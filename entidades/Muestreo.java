/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acuario_bd1.entidades;

/**
 *
 * @author sebab
 */
public class Muestreo {
    private int idestanque, idespecie;
    private String fecha;
    private float pesomuestrobiomasa;

    public Muestreo(int idestanque, int idespecie, String fecha, float pesomuestrobiomasa) {
        this.idestanque = idestanque;
        this.idespecie = idespecie;
        this.fecha = fecha;
        this.pesomuestrobiomasa = pesomuestrobiomasa;
    }

    public int getIdestanque() {
        return idestanque;
    }

    public void setIdestanque(int idestanque) {
        this.idestanque = idestanque;
    }

    public int getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(int idespecie) {
        this.idespecie = idespecie;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPesomuestrobiomasa() {
        return pesomuestrobiomasa;
    }

    public void setPesomuestrobiomasa(float pesomuestrobiomasa) {
        this.pesomuestrobiomasa = pesomuestrobiomasa;
    }
    
    
}
