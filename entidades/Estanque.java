
package acuario_bd1.entidades;

/**
 *
 * @author sebab
 */
public class Estanque {
    private int idestanque, cantidadmaxima;
    private float area;
    private String descripcion;

    public Estanque(int idestanque, int cantidadmaxima, float area, String descripcion) {
        this.idestanque = idestanque;
        this.cantidadmaxima = cantidadmaxima;
        this.area = area;
        this.descripcion = descripcion;
    }

    public int getIdestanque() {
        return idestanque;
    }

    public void setIdestanque(int idestanque) {
        this.idestanque = idestanque;
    }

    public int getCantidadmaxima() {
        return cantidadmaxima;
    }

    public void setCantidadmaxima(int cantidadmaxima) {
        this.cantidadmaxima = cantidadmaxima;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
