/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acuario_bd1.entidades;

/**
 *
 * @author sebab
 */
public class PreciosVenta {
    private int idprecio;
    private String descripcion, tipoventa;
    private float perdida, preciokilo;

    public PreciosVenta(int idprecio, String descripcion, String tipoventa, float perdida, float preciokilo) {
        this.idprecio = idprecio;
        this.descripcion = descripcion;
        this.tipoventa = tipoventa;
        this.perdida = perdida;
        this.preciokilo = preciokilo;
    }

    public int getIdprecio() {
        return idprecio;
    }

    public void setIdprecio(int idprecio) {
        this.idprecio = idprecio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipoventa() {
        return tipoventa;
    }

    public void setTipoventa(String tipoventa) {
        this.tipoventa = tipoventa;
    }

    public float getPerdida() {
        return perdida;
    }

    public void setPerdida(float perdida) {
        this.perdida = perdida;
    }

    public float getPreciokilo() {
        return preciokilo;
    }

    public void setPreciokilo(float preciokilo) {
        this.preciokilo = preciokilo;
    }
    
    
}