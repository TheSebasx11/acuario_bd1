/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acuario_bd1.entidades;

/**
 *
 * @author sebab
 */
public class Alimento {
 
       private int idalimento, idproveedor;
       private String descripcion, tipo;

    public Alimento(int idalimento, int idproveedor, String descripcion, String tipo) {
        this.idalimento = idalimento;
        this.idproveedor = idproveedor;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public int getIdalimento() {
        return idalimento;
    }

    public void setIdalimento(int idalimento) {
        this.idalimento = idalimento;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
       
       
}