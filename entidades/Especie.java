
package acuario_bd1.entidades;

/**
 *
 * @author sebab
 */
public class Especie {
    private int idespecie;
    private String descripcion;

    public Especie(int idespecie, String descripcion) {
        this.idespecie = idespecie;
        this.descripcion = descripcion;
    }
    
    public int getIdespecie() {
        return idespecie;
    }

    public void setIdespecie(int idespecie) {
        this.idespecie = idespecie;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
