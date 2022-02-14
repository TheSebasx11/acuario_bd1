/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acuario_bd1.entidades;

/**
 *
 * @author sebab
 */
public class Venta {
    private int idestanque, idespecie, idprecio;
    private float pesobiomasa, valorventa;
    private String fecha;

    public Venta(int idestanque, int idespecie, int idprecio, float pesobiomasa, float valorventa, String fecha) {
        this.idestanque = idestanque;
        this.idespecie = idespecie;
        this.idprecio = idprecio;
        this.pesobiomasa = pesobiomasa;
        this.valorventa = valorventa;
        this.fecha = fecha;
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

    public int getIdprecio() {
        return idprecio;
    }

    public void setIdprecio(int idprecio) {
        this.idprecio = idprecio;
    }

    public float getPesobiomasa() {
        return pesobiomasa;
    }

    public void setPesobiomasa(float pesobiomasa) {
        this.pesobiomasa = pesobiomasa;
    }

    public float getValorventa() {
        return valorventa;
    }

    public void setValorventa(float valorventa) {
        this.valorventa = valorventa;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
}