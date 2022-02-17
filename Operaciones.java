/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package acuario_bd1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author sebab
 */
public class Operaciones {

    private PreparedStatement st;
    private ResultSet rs;
    private String Select;
    private String InsertEspecie;
    private String UpdateEspecie;
    private String DeleteEspecie;
    private String InsertEstanque;
    private String UpdateEstanque;
    private String DeleteEstanque;
    private String InsertProveedor;
    private String UpdateProveedor;
    private String DeleteProveedor;
    private String InsertPreciosVenta;
    private String UpdatePreciosVenta;
    private String DeletePreciosVenta;
    private String InsertAlimenta;
    private String UpdateAlimenta;
    private String DeleteAlimenta;
    private String InsertAlimento;
    private String UpdateAlimento;
    private String DeleteAlimento;
    private String InsertMuestreo;
    private String UpdateMuestreo;
    private String DeleteMuestreo;
    private String InsertSiembra;
    private String UpdateSiembra;
    private String DeleteSiembra;
    private String InsertVenta;
    private String UpdateVenta;
    private String DeleteVenta;

    public Operaciones() {
        st = null;
        rs = null;
        Select = "SELECT x FROM y";
        UpdateEspecie = "Update especie SET idespecie=x, descripcion=\"y\"  WHERE idespecie=z";
        InsertEspecie = "INSERT INTO especie VALUES(?, ?)";
        DeleteEspecie = "DELETE FROM especie WHERE idespecie=x";
        UpdateEstanque = "UPDATE estanque SET idestanque=?, descripcion=?, area=?, cantidadmaxima=?  WHERE idestanque=?";
        InsertEstanque = "INSERT INTO estanque VALUES(?, ?, ?, ?)";
        DeleteEstanque = "DELETE FROM estanque WHERE idestanque=?";
        UpdateProveedor = "UPDATE proveedor SET idproveedor=?, nombre=?, telefono=? WHERE idproveedor=?";
        DeleteProveedor = "DELETE FROM proveedor WHERE idproveedor=?";
        InsertProveedor = "INSERT INTO PROVEEDOR VALUES(?,?,?)";
        InsertPreciosVenta = "INSERT INTO PRECIOSVENTA VALUES(?,?,?,?,?)";
        UpdatePreciosVenta = "UPDATE preciosventa SET idprecio=?, descripcion=?, perdida=?, tipoventa=?, preciokilo=? WHERE idprecio=?";
        DeletePreciosVenta = "DELETE FROM PRECIOSVENTA WHERE idprecio=?";
        InsertAlimenta = "INSERT INTO ALIMENTA VALUES(?,?,?,?,?,?)";
        UpdateAlimenta = "UPDATE ALIMENTA SET idespecie=?, idestanque=?, fecha=?, idalimento=?, racion=?, precioalimento=? WHERE idespecie=? and idestanque=? and fecha=? and idalimento=? ";
        DeleteAlimenta = "DELETE FROM ALIMENTA WHERE idespecie=?, idestanque=?, fecha=?, idalimento=?";
        InsertAlimento = "INSERT INTO ALIMENTO VALUES (?,?,?,?)";
        UpdateAlimento = "UPDATE ALIMENTO SET idalimento=?, idpro=?, descripcion=?, tipo=? WHERE idalimento=?";
        DeleteAlimento = "DELETE FROM ALIMENTO WHERE idalimento=?";
        InsertMuestreo = "INSERT INTO MUESTREO VALUES (?,?,?,?)";
        UpdateMuestreo = "UPDATE MUESTREO SET idestanque=?, idespecie=?, fecha=?, pesomuestreobiomasa=? WHERE destanque=? and idespecie=?";
        DeleteMuestreo = "DELETE FROM MUESTREO WHERE destanque=? and idespecie=?";
        InsertSiembra = "INSERT INTO SIEMBRA VALUES (?,?,?,?,?,?)";
        UpdateSiembra = "UPDATE SIEMBRA SET idespecie = ?, idestanque=?, fecha=?, cantidad=?, pesoInicioBiomasa=?, preciocompra=? WHERE idespecie = ? and idestanque=? and fecha=?";
        DeleteSiembra = "DELETE FROM SIEMBRA WHERE idespecie = ? and idestanque=? and fecha=?";
        InsertVenta = "INSERT INTO VENTA VALUES (?,?,?,?,?,?)";
        UpdateVenta = "UPDATE VENTA SET idespecie = ?, idestanque=?, fecha=?, idprecio=?, pesobiomasa=?. valorventa=? WHERE idespecie = ? and idestanque=? and fecha=? and idprecio=? ";
        DeleteVenta = "DELETE FROM VENTA WHERE idespecie = ? and idestanque=? and fecha=? and idprecio=?";
    }

    public String getInsertProveedor() {
        return InsertProveedor;
    }

    public String getUpdateProveedor() {
        return UpdateProveedor;
    }

    public String getDeleteProveedor() {
        return DeleteProveedor;
    }

    public String getInsertPreciosVenta() {
        return InsertPreciosVenta;
    }

    public String getUpdatePreciosVenta() {
        return UpdatePreciosVenta;
    }

    public String getDeletePreciosVenta() {
        return DeletePreciosVenta;
    }

    public String getInsertAlimenta() {
        return InsertAlimenta;
    }

    public String getUpdateAlimenta() {
        return UpdateAlimenta;
    }

    public String getDeleteAlimenta() {
        return DeleteAlimenta;
    }

    public String getInsertAlimento() {
        return InsertAlimento;
    }

    public String getUpdateAlimento() {
        return UpdateAlimento;
    }

    public String getDeleteAlimento() {
        return DeleteAlimento;
    }

    public String getInsertMuestreo() {
        return InsertMuestreo;
    }

    public String getUpdateMuestreo() {
        return UpdateMuestreo;
    }

    public String getDeleteMuestreo() {
        return DeleteMuestreo;
    }

    public String getInsertSiembra() {
        return InsertSiembra;
    }

    public String getUpdateSiembra() {
        return UpdateSiembra;
    }

    public String getDeleteSiembra() {
        return DeleteSiembra;
    }

    public String getInsertVenta() {
        return InsertVenta;
    }

    public String getUpdateVenta() {
        return UpdateVenta;
    }

    public String getDeleteVenta() {
        return DeleteVenta;
    }
    
    public void setSt(PreparedStatement st) {
        this.st = st;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public String getInsertEstanque() {
        return InsertEstanque;
    }

    public String getUpdateEstanque() {
        return UpdateEstanque;
    }

    public String getDeleteEstanque() {
        return DeleteEstanque;
    }

    public String getUpdateEspecie() {
        return UpdateEspecie;
    }

    public void setUpdateEspecie(String newid, String desc, String oldid) {
        UpdateEspecie = UpdateEspecie.replace("x", newid);
        UpdateEspecie = UpdateEspecie.replace("y", desc);
        UpdateEspecie = UpdateEspecie.replace("z", oldid);
    }

    public void setSelect(String atributos, String tabla) {
        Select = Select.replace("x", atributos);
        Select = Select.replace("y", tabla);
    }

    public String getDeleteEspecie() {
        return DeleteEspecie;
    }

    public void setDeleteEspecie(String id) {
        DeleteEspecie = DeleteEspecie.replace("x", id);
    }

    public String getSelect() {
        return Select;
    }

    public String getInsertEspecie() {
        return InsertEspecie;
    }

    public PreparedStatement getSt() {
        return st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void Close(PreparedStatement St) {
        try {
            St.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public void Close(ResultSet RS) {
        try {
            RS.close();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

}
