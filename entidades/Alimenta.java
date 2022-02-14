/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acuario_bd1.entidades;

/**
 *
 * @author sebab
 */
public class Alimenta {
    
    private String fecha;
    private float precioalimento;
    private int iespecie, idestanque, idalimento, racion;

    public Alimenta(String fecha, float precioalimento, int iespecie, int idestanque, int idalimento, int racion) {
        this.fecha = fecha;
        this.precioalimento = precioalimento;
        this.iespecie = iespecie;
        this.idestanque = idestanque;
        this.idalimento = idalimento;
        this.racion = racion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPrecioalimento() {
        return precioalimento;
    }

    public void setPrecioalimento(float precioalimento) {
        this.precioalimento = precioalimento;
    }

    public int getIespecie() {
        return iespecie;
    }

    public void setIespecie(int iespecie) {
        this.iespecie = iespecie;
    }

    public int getIdestanque() {
        return idestanque;
    }

    public void setIdestanque(int idestanque) {
        this.idestanque = idestanque;
    }

    public int getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(int idalimento) {
        this.idalimento = idalimento;
    }

    public int getRacion() {
        return racion;
    }

    public void setRacion(int racion) {
        this.racion = racion;
    }


    
    
    
}
