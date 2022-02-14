/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acuario_bd1.entidades;

/**
 *
 * @author sebab
 */
public class Siembra {
    private int idespecie, idestanque, cantidad;
    private float pesoInicioBiomasa, preciocompra;
    private String fecha;

    public Siembra(int idespecie, int idestanque, int cantidad, float pesoInicioBiomasa, float preciocompra, String fecha) {
        this.idespecie = idespecie;
        this.idestanque = idestanque;
        this.cantidad = cantidad;
        this.pesoInicioBiomasa = pesoInicioBiomasa;
        this.preciocompra = preciocompra;
        this.fecha = fecha;
    }

    public int getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(int idespecie) {
        this.idespecie = idespecie;
    }

    public int getIdestanque() {
        return idestanque;
    }

    public void setIdestanque(int idestanque) {
        this.idestanque = idestanque;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPesoInicioBiomasa() {
        return pesoInicioBiomasa;
    }

    public void setPesoInicioBiomasa(float pesoInicioBiomasa) {
        this.pesoInicioBiomasa = pesoInicioBiomasa;
    }

    public float getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(float preciocompra) {
        this.preciocompra = preciocompra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    
}