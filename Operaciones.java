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
    
    
    public Operaciones() {
        st = null;
        rs = null;
        UpdateEspecie = "Update especie SET idespecie=x, descripcion=\"y\"  WHERE idespecie=z";
        InsertEspecie = "INSERT INTO especie VALUES(?, ?)";
        Select = "SELECT x FROM y";
        DeleteEspecie = "DELETE FROM especie WHERE idespecie=x";
    }
    
     public void setSt(PreparedStatement st) {
        this.st = st;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
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
