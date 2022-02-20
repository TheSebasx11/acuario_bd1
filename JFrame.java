/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package acuario_bd1;

import acuario_bd1.entidades.*;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebab
 */
public class JFrame extends javax.swing.JFrame {

    /**
     * Creates new form JFrame
     */
    private DefaultTableModel DTM;
    private Operaciones ope;
    private conexion con;

    public JFrame() {
        initComponents();
        con = new conexion();
        DTM = null;
        ope = new Operaciones();

    }

    //operaciones con Especie
    public ArrayList<Especie> LlenarEspecie() {
        ArrayList<Especie> ListaEspecie = new ArrayList<Especie>();
        try {
            ope.setSelect("*", "especie");
            ope.setSt(con.getConexion().prepareStatement(ope.getSelect()));
            ope.setRs(ope.getSt().executeQuery(ope.getSelect()));
            while (ope.getRs().next()) {
                Especie es = new Especie(ope.getRs().getInt("idespecie"), ope.getRs().getString("descripcion"));
                ListaEspecie.add(es);
            }
            ope = new Operaciones();
            return ListaEspecie;
        } catch (Exception e) {
            System.out.println(e);
        }

        return ListaEspecie;
    }

    private void MostrarEspecie(ArrayList<Especie> Lista) {

        DTM.setRowCount(0);
        for (Especie esp : Lista) {
            int fila = DTM.getRowCount();
            DTM.setRowCount(fila + 1);
            DTM.setValueAt(esp.getIdespecie(), fila, 0);
            DTM.setValueAt(esp.getDescripcion(), fila, 1);

        }
        //System.out.println(jTable1.getColumnCount());
    }

    private void EliminarEspecie(String id) {
        try {
            ope.setDeleteEspecie(id);
            ope.setSt(con.getConexion().prepareStatement(ope.getDeleteEspecie()));
            int delete = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    private void AgregarEspecie(int id, String desc) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getInsertEspecie()));
            ope.getSt().setInt(1, id);
            ope.getSt().setString(2, desc);
            int update = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Agregado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    private void EditarEspecie(String oldID, String id, String desc) {
        try {
            ope.setUpdateEspecie(id + "", desc, oldID + "");
            ope.setSt(con.getConexion().prepareStatement(ope.getUpdateEspecie()));
            int update = ope.getSt().executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void Limpiar(JTextField... tfs) {
        for (JTextField tf : tfs) {
            tf.setText("");
        }
    }

    //Operaciones con Especie----
    //Operaciones con estanque
    public ArrayList<Estanque> LlenarEstanque() {
        ArrayList<Estanque> ListaEstanques = new ArrayList<Estanque>();
        try {
            ope.setSelect("*", "estanque");
            ope.setSt(con.getConexion().prepareStatement(ope.getSelect()));
            ope.setRs(ope.getSt().executeQuery(ope.getSelect()));
            while (ope.getRs().next()) {
                Estanque es = new Estanque(ope.getRs().getInt("idestanque"), ope.getRs().getInt("cantidadmaxima"),
                        ope.getRs().getFloat("area"), ope.getRs().getString("descripcion"));
                ListaEstanques.add(es);
            }
            ope = new Operaciones();
            return ListaEstanques;
        } catch (Exception e) {
            System.out.println(e);
        }

        return ListaEstanques;
    }

    private void MostrarEstanque(ArrayList<Estanque> Lista) {

        DTM.setRowCount(0);
        for (Estanque est : Lista) {
            int fila = DTM.getRowCount();
            DTM.setRowCount(fila + 1);
            DTM.setValueAt(est.getIdestanque(), fila, 0);
            DTM.setValueAt(est.getDescripcion(), fila, 1);
            DTM.setValueAt(est.getArea(), fila, 2);
            DTM.setValueAt(est.getCantidadmaxima(), fila, 3);
            combo_estanque.addItem("" + est.getIdestanque());
            combo_estanque1.addItem("" + est.getIdestanque());
            combo_estanque2.addItem("" + est.getIdestanque());
            combo_estanque3.addItem("" + est.getIdestanque());
        }
    }

    private void AgregarEstanque(int id, String desc, float area, int cant) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getInsertEstanque()));
            ope.getSt().setInt(1, id);
            ope.getSt().setString(2, desc);
            ope.getSt().setFloat(3, area);
            ope.getSt().setInt(4, cant);
            int update = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Agregado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    private void EditarEstanque(String oldID, String id, String desc, float area, int cant) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getUpdateEstanque()));
            ope.getSt().setString(1, id);
            ope.getSt().setString(2, desc);
            ope.getSt().setFloat(3, area);
            ope.getSt().setInt(4, cant);
            ope.getSt().setString(5, oldID);
            int update = ope.getSt().executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    private void EliminarEstanque(String id) {
        try {

            ope.setSt(con.getConexion().prepareStatement(ope.getDeleteEstanque()));
            ope.getSt().setString(1, id);
            int delete = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    //Operaciones con estanque
    //Operaciones con proveedor
    public ArrayList<Proveedor> LlenarProveedor() {
        ArrayList<Proveedor> ListaProveedores = new ArrayList<Proveedor>();
        try {
            ope.setSelect("*", "proveedor");
            ope.setSt(con.getConexion().prepareStatement(ope.getSelect()));
            ope.setRs(ope.getSt().executeQuery(ope.getSelect()));
            while (ope.getRs().next()) {
                Proveedor pro = new Proveedor(ope.getRs().getInt("idproveedor"), ope.getRs().getString("nombre"), ope.getRs().getString("telefono"));
                ListaProveedores.add(pro);
            }
            ope = new Operaciones();
            return ListaProveedores;
        } catch (Exception e) {
            System.out.println(e);
        }

        return ListaProveedores;
    }

    private void MostrarProveedor(ArrayList<Proveedor> Lista) {

        DTM.setRowCount(0);
        for (Proveedor pro : Lista) {
            int fila = DTM.getRowCount();
            DTM.setRowCount(fila + 1);
            DTM.setValueAt(pro.getIdproveedor(), fila, 0);
            DTM.setValueAt(pro.getNombre(), fila, 1);
            DTM.setValueAt(pro.getTelefono(), fila, 2);
            combo_pro.addItem(pro.getIdproveedor() + "");
        }
    }

    private void AgregarProveedor(int id, String nom, String tel) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getInsertProveedor()));
            ope.getSt().setInt(1, id);
            ope.getSt().setString(2, nom);
            ope.getSt().setString(3, tel);
            int update = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Agregado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    private void EliminarProveedor(String id) {
        try {

            ope.setSt(con.getConexion().prepareStatement(ope.getDeleteProveedor()));
            ope.getSt().setString(1, id);
            int delete = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    private void EditarProveedor(String oldID, String id, String nom, String tel) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getUpdateProveedor()));
            ope.getSt().setString(1, id);
            ope.getSt().setString(2, nom);
            ope.getSt().setString(3, tel);
            ope.getSt().setString(4, oldID);
            int update = ope.getSt().executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //Operaciones con proveedor
    //OPERACIONES CON PRECIOSVENTA|
    public ArrayList<PreciosVenta> LlenarPrecio() {
        ArrayList<PreciosVenta> ListaPrecio = new ArrayList<PreciosVenta>();
        try {
            ope.setSelect("*", "PreciosVenta");
            ope.setSt(con.getConexion().prepareStatement(ope.getSelect()));
            ope.setRs(ope.getSt().executeQuery(ope.getSelect()));
            while (ope.getRs().next()) {
                PreciosVenta pre = new PreciosVenta(ope.getRs().getInt("idprecio"), ope.getRs().getString("descripcion"),
                        ope.getRs().getString("tipoventa"), ope.getRs().getFloat("perdida"), ope.getRs().getFloat("preciokilo"));
                ListaPrecio.add(pre);
            }
            ope = new Operaciones();
            return ListaPrecio;
        } catch (Exception e) {
            System.out.println(e);
        }

        return ListaPrecio;
    }

    private void MostrarPrecio(ArrayList<PreciosVenta> Lista) {
        DTM.setRowCount(0);
        for (PreciosVenta pre : Lista) {
            int fila = DTM.getRowCount();
            DTM.setRowCount(fila + 1);
            DTM.setValueAt(pre.getIdprecio(), fila, 0);
            DTM.setValueAt(pre.getDescripcion(), fila, 1);
            DTM.setValueAt(pre.getPerdida(), fila, 2);
            DTM.setValueAt(pre.getTipoventa(), fila, 3);
            DTM.setValueAt(pre.getPreciokilo(), fila, 4);
        }
    }

    private void AgregarPrecio(int id, String desc, float perdida, String tipo, float precio) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getInsertPreciosVenta()));
            ope.getSt().setInt(1, id);
            ope.getSt().setString(2, desc);
            ope.getSt().setFloat(3, perdida);
            ope.getSt().setString(4, tipo);
            ope.getSt().setFloat(5, precio);
            int update = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Agregado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    private void EliminarPrecios(String id) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getDeletePreciosVenta()));
            ope.getSt().setString(1, id);
            int delete = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    private void EditarPrecios(String oldID, int id, String desc, float perdida, String tipo, float precio) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getUpdatePreciosVenta()));
            ope.getSt().setInt(1, id);
            ope.getSt().setString(2, desc);
            ope.getSt().setFloat(3, perdida);
            ope.getSt().setString(4, tipo);
            ope.getSt().setFloat(5, precio);
            ope.getSt().setString(6, oldID);
            int update = ope.getSt().executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //OPERACIONES CON PRECIOSVENTA
    public ArrayList<Alimento> LlenarAlimento() {
        ArrayList<Alimento> ListaAlimento = new ArrayList<Alimento>();
        try {
            ope.setSelect("*", "alimento");
            ope.setSt(con.getConexion().prepareStatement(ope.getSelect()));
            ope.setRs(ope.getSt().executeQuery(ope.getSelect()));
            while (ope.getRs().next()) {
                Alimento al = new Alimento(ope.getRs().getInt("idalimento"),
                        ope.getRs().getInt("idpro"), ope.getRs().getString("descripcion"), ope.getRs().getString("tipo"));
                ListaAlimento.add(al);
            }
            ope = new Operaciones();
            return ListaAlimento;
        } catch (Exception e) {
            System.out.println("Llenar error:" + e);
        }

        return ListaAlimento;
    }

    private void MostrarAlimento(ArrayList<Alimento> Lista) {
        DTM.setRowCount(0);
        for (Alimento Al : Lista) {
            int fila = DTM.getRowCount();
            DTM.setRowCount(fila + 1);
            DTM.setValueAt(Al.getIdalimento(), fila, 0);
            DTM.setValueAt(Al.getIdproveedor(), fila, 1);
            DTM.setValueAt(Al.getDescripcion(), fila, 2);
            DTM.setValueAt(Al.getTipo(), fila, 3);
            combo_alimento2.addItem("" + Al.getIdalimento());
        }
    }

    private void AgregarAlimento(int id, int idpro, String desc, String tipo) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getInsertAlimento()));
            ope.getSt().setInt(1, id);
            ope.getSt().setInt(2, idpro);
            ope.getSt().setString(3, desc);
            ope.getSt().setString(4, tipo);
            int update = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Agregado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    private void EliminarAlimento(String id) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getDeleteAlimento()));
            ope.getSt().setString(1, id);
            int delete = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Eliminado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    private void EditarAlimento(String oldID, int id, int idpro, String desc, String tipo) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getUpdateAlimento()));
            ope.getSt().setInt(1, id);
            ope.getSt().setInt(2, idpro);
            ope.getSt().setString(3, desc);
            ope.getSt().setString(4, tipo);
            ope.getSt().setString(6, oldID);
            int update = ope.getSt().executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public ArrayList<Venta> LlenarVenta() {
        ArrayList<Venta> ListaVenta = new ArrayList<Venta>();
        try {
            ope.setSelect("*", "venta order by fecha desc");
            ope.setSt(con.getConexion().prepareStatement(ope.getSelect()));
            ope.setRs(ope.getSt().executeQuery(ope.getSelect()));
            while (ope.getRs().next()) {
                Venta ven = new Venta(ope.getRs().getInt("idestanque"), ope.getRs().getInt("idespecie"), ope.getRs().getInt("idprecio"),
                        ope.getRs().getFloat("pesobiomasa"), ope.getRs().getFloat("valorventa"), ope.getRs().getDate("fecha").toString());
                ListaVenta.add(ven);
            }
            ope = new Operaciones();
            return ListaVenta;
        } catch (Exception e) {
            System.out.println("Llenar error:" + e);
        }

        return ListaVenta;
    }

    private void MostrarVenta(ArrayList<Venta> Lista) {
        DTM.setRowCount(0);
        for (Venta ven : Lista) {
            int fila = DTM.getRowCount();
            DTM.setRowCount(fila + 1);
            DTM.setValueAt(ven.getIdestanque(), fila, 0);
            DTM.setValueAt(ven.getIdespecie(), fila, 1);
            DTM.setValueAt(ven.getFecha(), fila, 2);
            DTM.setValueAt(ven.getIdprecio(), fila, 3);
            DTM.setValueAt(ven.getPesobiomasa(), fila, 4);
            DTM.setValueAt(ven.getValorventa(), fila, 5);
        }
    }

    private void AgregarVenta(int idestanque, int idespecie, int idprecio, float pesobiomasa, float valorventa, String fecha) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getInsertVenta()));
            ope.getSt().setInt(1, idestanque);
            ope.getSt().setInt(2, idespecie);
            ope.getSt().setString(3, fecha);
            ope.getSt().setInt(4, idprecio);
            ope.getSt().setFloat(5, pesobiomasa);
            ope.getSt().setFloat(6, valorventa);
            int update = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Agregado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    public ArrayList<Alimenta> LlenarAlimenta() {
        ArrayList<Alimenta> ListaAlimenta = new ArrayList<Alimenta>();
        try {
            ope.setSelect("*", "alimenta");
            ope.setSt(con.getConexion().prepareStatement(ope.getSelect()));
            ope.setRs(ope.getSt().executeQuery(ope.getSelect()));
            while (ope.getRs().next()) {
                Alimenta al = new Alimenta(ope.getRs().getDate("fecha").toString(), ope.getRs().getFloat("precioalimento"),
                        ope.getRs().getInt("idestanque"), ope.getRs().getInt("idespecie"), ope.getRs().getInt("idalimento"), ope.getRs().getInt("racion"));
                ListaAlimenta.add(al);
            }
            ope = new Operaciones();
            return ListaAlimenta;
        } catch (Exception e) {
            System.out.println("Llenar error:" + e);
        }

        return ListaAlimenta;
    }

    private void MostrarAlimenta(ArrayList<Alimenta> Lista) {
        DTM.setRowCount(0);
        for (Alimenta Al : Lista) {
            int fila = DTM.getRowCount();
            DTM.setRowCount(fila + 1);
            DTM.setValueAt(Al.getIDespecie(), fila, 0);
            DTM.setValueAt(Al.getIdestanque(), fila, 1);
            DTM.setValueAt(Al.getFecha(), fila, 3);
            DTM.setValueAt(Al.getIdalimento(), fila, 2);
            DTM.setValueAt(Al.getRacion(), fila, 4);
            DTM.setValueAt(Al.getPrecioalimento(), fila, 5);
        }
    }

    private void AgregarAlimenta(String fecha, float precioalimento, int idespecie, int idestanque, int idalimento, int racion) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getInsertAlimenta()));
            ope.getSt().setInt(1, idespecie);
            ope.getSt().setInt(2, idestanque);
            ope.getSt().setString(3, fecha);
            ope.getSt().setInt(4, idalimento);
            ope.getSt().setInt(5, racion);
            ope.getSt().setFloat(6, precioalimento);
            int update = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Agregado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    public ArrayList<Muestreo> LlenarMuestreo() {
        ArrayList<Muestreo> ListaMuestreo = new ArrayList<Muestreo>();
        try {
            ope.setSelect("*", "muestreo");
            ope.setSt(con.getConexion().prepareStatement(ope.getSelect()));
            ope.setRs(ope.getSt().executeQuery(ope.getSelect()));
            while (ope.getRs().next()) {
                Muestreo mu = new Muestreo(ope.getRs().getInt("idestanque"), ope.getRs().getInt("idespecie"),
                        ope.getRs().getDate("fecha").toString(), ope.getRs().getFloat("pesomuestreobiomasa"));
                ListaMuestreo.add(mu);
            }
            ope = new Operaciones();
            return ListaMuestreo;
        } catch (Exception e) {
            System.out.println("Llenar error:" + e);
        }

        return ListaMuestreo;
    }

    private void MostrarMuestreo(ArrayList<Muestreo> Lista) {
        DTM.setRowCount(0);
        for (Muestreo mu : Lista) {
            int fila = DTM.getRowCount();
            DTM.setRowCount(fila + 1);
            DTM.setValueAt(mu.getIdestanque(), fila, 0);
            DTM.setValueAt(mu.getIdespecie(), fila, 1);
            DTM.setValueAt(mu.getFecha(), fila, 2);
            DTM.setValueAt(mu.getPesomuestrobiomasa(), fila, 3);
        }
    }

    private void AgregarMuestreo(int idestanque, int idespecie, String fecha, float pesomuestrobiomasa) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getInsertMuestreo()));
            ope.getSt().setInt(2, idespecie);
            ope.getSt().setInt(1, idestanque);
            ope.getSt().setString(3, fecha);
            ope.getSt().setFloat(4, pesomuestrobiomasa);
            int update = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Agregado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    public ArrayList<Siembra> LlenarSiembra() {
        ArrayList<Siembra> ListaSiembra = new ArrayList<>();
        try {
            ope.setSelect("*", "siembra");
            ope.setSt(con.getConexion().prepareStatement(ope.getSelect()));
            ope.setRs(ope.getSt().executeQuery(ope.getSelect()));
            while (ope.getRs().next()) {
                Siembra siem = new Siembra(ope.getRs().getInt("idespecie"), ope.getRs().getInt("idestanque"), ope.getRs().getInt("cantidad"),
                        ope.getRs().getFloat("pesoIniciobiomasa"), ope.getRs().getFloat("preciocompra"), ope.getRs().getDate("fecha").toString());
                ListaSiembra.add(siem);
            }
            ope = new Operaciones();
            return ListaSiembra;
        } catch (Exception e) {
            System.out.println("Llenar error:" + e);
        }

        return ListaSiembra;
    }

    private void MostrarSiembra(ArrayList<Siembra> Lista) {
        DTM.setRowCount(0);
        for (Siembra siem : Lista) {
            int fila = DTM.getRowCount();
            DTM.setRowCount(fila + 1);
            DTM.setValueAt(siem.getIdestanque(), fila, 0);
            DTM.setValueAt(siem.getIdespecie(), fila, 1);
            DTM.setValueAt(siem.getFecha(), fila, 2);
            DTM.setValueAt(siem.getCantidad(), fila, 3);
            DTM.setValueAt(siem.getPesoInicioBiomasa(), fila, 4);
            DTM.setValueAt(siem.getPreciocompra(), fila, 5);
        }
    }

    private void AgregarSiembra(int idespecie, int idestanque, int cantidad, float pesoInicioBiomasa, float preciocompra, String fecha) {
        try {
            ope.setSt(con.getConexion().prepareStatement(ope.getInsertSiembra()));
            ope.getSt().setInt(2, idespecie);
            ope.getSt().setInt(1, idestanque);
            ope.getSt().setString(3, fecha);
            ope.getSt().setInt(4, cantidad);
            ope.getSt().setFloat(5, pesoInicioBiomasa);
            ope.getSt().setFloat(6, preciocompra);
            int update = ope.getSt().executeUpdate();
            JOptionPane.showMessageDialog(null, "Agregado con exito");
        } catch (Exception e) {
            System.out.println(e);
        }
        ope = new Operaciones();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        mostrar_esp = new javax.swing.JButton();
        add_esp = new javax.swing.JButton();
        del_esp = new javax.swing.JButton();
        ed_esp = new javax.swing.JButton();
        id_especie_tf = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        desc_especie_ta = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        especie_tab = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        estanque_tab = new javax.swing.JTable();
        estanque_id = new javax.swing.JTextField();
        jScrollPane11 = new javax.swing.JScrollPane();
        estanque_desc = new javax.swing.JTextArea();
        estanque_area = new javax.swing.JTextField();
        estanque_cantidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mostrar_esp1 = new javax.swing.JButton();
        add_esp1 = new javax.swing.JButton();
        ed_esp1 = new javax.swing.JButton();
        del_esp1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        proveedor_tab = new javax.swing.JTable();
        mostrar_esp4 = new javax.swing.JButton();
        add_esp4 = new javax.swing.JButton();
        ed_esp4 = new javax.swing.JButton();
        del_esp4 = new javax.swing.JButton();
        pro_id = new javax.swing.JTextField();
        pro_nombre = new javax.swing.JTextField();
        pro_telefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        pre_tab = new javax.swing.JTable();
        mostrar_esp5 = new javax.swing.JButton();
        add_esp5 = new javax.swing.JButton();
        ed_esp5 = new javax.swing.JButton();
        del_esp5 = new javax.swing.JButton();
        pre_id = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        pre_desc = new javax.swing.JTextArea();
        pre_perdida = new javax.swing.JTextField();
        pre_tipo = new javax.swing.JTextField();
        pre_kilo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        alimento_tab = new javax.swing.JTable();
        mostrar_esp6 = new javax.swing.JButton();
        add_esp6 = new javax.swing.JButton();
        ed_esp6 = new javax.swing.JButton();
        del_esp6 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        alimento_desc = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        alimento_tipo = new javax.swing.JTextField();
        alimento_id = new javax.swing.JTextField();
        combo_pro = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        venta_tab = new javax.swing.JTable();
        mostrar_esp7 = new javax.swing.JButton();
        add_esp7 = new javax.swing.JButton();
        ed_esp7 = new javax.swing.JButton();
        del_esp7 = new javax.swing.JButton();
        venta_fecha = new javax.swing.JTextField();
        venta_valor = new javax.swing.JTextField();
        venta_peso = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        combo_estanque = new javax.swing.JComboBox<>();
        combo_especie = new javax.swing.JComboBox<>();
        combo_precio = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        alimenta_tab = new javax.swing.JTable();
        mostrar_esp8 = new javax.swing.JButton();
        add_esp8 = new javax.swing.JButton();
        ed_esp8 = new javax.swing.JButton();
        del_esp8 = new javax.swing.JButton();
        alimenta_fecha = new javax.swing.JTextField();
        alimenta_racion = new javax.swing.JTextField();
        alimenta_precio = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        combo_alimento2 = new javax.swing.JComboBox<>();
        combo_estanque1 = new javax.swing.JComboBox<>();
        combo_especie1 = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        mues_tab = new javax.swing.JTable();
        mostrar_esp3 = new javax.swing.JButton();
        add_esp3 = new javax.swing.JButton();
        ed_esp3 = new javax.swing.JButton();
        del_esp3 = new javax.swing.JButton();
        muestreo_fecha = new javax.swing.JTextField();
        muestreo_peso = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        combo_estanque3 = new javax.swing.JComboBox<>();
        combo_especie3 = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        siem_tab = new javax.swing.JTable();
        mostrar_esp2 = new javax.swing.JButton();
        add_esp2 = new javax.swing.JButton();
        ed_esp2 = new javax.swing.JButton();
        del_esp2 = new javax.swing.JButton();
        siembra_fecha = new javax.swing.JTextField();
        siembra_cant = new javax.swing.JTextField();
        siembra_peso = new javax.swing.JTextField();
        siembra_compra = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        combo_estanque2 = new javax.swing.JComboBox<>();
        combo_especie2 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mostrar_esp.setText("Mostrar");
        mostrar_esp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_espActionPerformed(evt);
            }
        });

        add_esp.setText("Agregar");
        add_esp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_espActionPerformed(evt);
            }
        });

        del_esp.setText("Borrar");
        del_esp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_espActionPerformed(evt);
            }
        });

        ed_esp.setText("Editar");
        ed_esp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_espActionPerformed(evt);
            }
        });

        jLabel1.setText("Id de Especie");

        jLabel2.setText("Descripcion");

        desc_especie_ta.setColumns(20);
        desc_especie_ta.setRows(5);
        jScrollPane2.setViewportView(desc_especie_ta);

        especie_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Especie", "Descripcion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        especie_tab.setMinimumSize(new java.awt.Dimension(1200, 400));
        especie_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                especie_tabMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(especie_tab);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_especie_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 459, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(mostrar_esp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(del_esp, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ed_esp, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(add_esp)))))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_especie_tf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostrar_esp)
                            .addComponent(add_esp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(del_esp)
                            .addComponent(ed_esp)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Especie", jPanel1);

        estanque_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion", "Area", "Cantidad Max"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        estanque_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estanque_tabMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(estanque_tab);

        estanque_desc.setColumns(20);
        estanque_desc.setRows(5);
        jScrollPane11.setViewportView(estanque_desc);

        jLabel3.setText("ID");

        jLabel4.setText("Descripcion");

        jLabel5.setText("Area");

        jLabel6.setText("Cantidad");

        mostrar_esp1.setText("Mostrar");
        mostrar_esp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_esp1ActionPerformed(evt);
            }
        });

        add_esp1.setText("Agregar");
        add_esp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_esp1ActionPerformed(evt);
            }
        });

        ed_esp1.setText("Editar");
        ed_esp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_esp1ActionPerformed(evt);
            }
        });

        del_esp1.setText("Borrar");
        del_esp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_esp1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estanque_id, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(84, 84, 84)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(69, 69, 69)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estanque_area, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(estanque_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(mostrar_esp1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(del_esp1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ed_esp1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(add_esp1)))))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(estanque_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(estanque_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(estanque_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostrar_esp1)
                            .addComponent(add_esp1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(del_esp1)
                            .addComponent(ed_esp1))))
                .addGap(13, 13, 13))
        );

        jTabbedPane1.addTab("Estanque", jPanel2);

        proveedor_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Telefono"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        proveedor_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                proveedor_tabMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(proveedor_tab);

        mostrar_esp4.setText("Mostrar");
        mostrar_esp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_esp4ActionPerformed(evt);
            }
        });

        add_esp4.setText("Agregar");
        add_esp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_esp4ActionPerformed(evt);
            }
        });

        ed_esp4.setText("Editar");
        ed_esp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_esp4ActionPerformed(evt);
            }
        });

        del_esp4.setText("Borrar");
        del_esp4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_esp4ActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        jLabel8.setText("Nombre");

        jLabel9.setText("Telefono");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pro_id, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pro_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(pro_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mostrar_esp4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(del_esp4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ed_esp4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(add_esp4))))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostrar_esp4)
                            .addComponent(add_esp4)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(del_esp4)
                    .addComponent(ed_esp4)
                    .addComponent(pro_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pro_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pro_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proveedor", jPanel3);

        pre_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descripcion", "Perdida", "Tipo de venta", "Precio Kilo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        pre_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pre_tabMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(pre_tab);

        mostrar_esp5.setText("Mostrar");
        mostrar_esp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_esp5ActionPerformed(evt);
            }
        });

        add_esp5.setText("Agregar");
        add_esp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_esp5ActionPerformed(evt);
            }
        });

        ed_esp5.setText("Editar");
        ed_esp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_esp5ActionPerformed(evt);
            }
        });

        del_esp5.setText("Borrar");
        del_esp5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_esp5ActionPerformed(evt);
            }
        });

        pre_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pre_idActionPerformed(evt);
            }
        });

        pre_desc.setColumns(20);
        pre_desc.setRows(5);
        jScrollPane12.setViewportView(pre_desc);

        jLabel10.setText("ID");

        jLabel11.setText("Descripcion");

        jLabel12.setText("Perdida");

        jLabel13.setText("Tipo Venta");

        jLabel14.setText("Precio Kilo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pre_id, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pre_perdida, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pre_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(pre_kilo, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mostrar_esp5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(del_esp5, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ed_esp5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(add_esp5))))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1177, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostrar_esp5)
                            .addComponent(add_esp5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(del_esp5)
                            .addComponent(ed_esp5))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pre_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(pre_perdida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pre_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(pre_kilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("Precios venta", jPanel4);

        alimento_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "ID Proveedor", "Descripcion", "Tipo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        alimento_tab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alimento_tabMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(alimento_tab);

        mostrar_esp6.setText("Mostrar");
        mostrar_esp6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_esp6ActionPerformed(evt);
            }
        });

        add_esp6.setText("Agregar");
        add_esp6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_esp6ActionPerformed(evt);
            }
        });

        ed_esp6.setText("Editar");
        ed_esp6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ed_esp6ActionPerformed(evt);
            }
        });

        del_esp6.setText("Borrar");
        del_esp6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_esp6ActionPerformed(evt);
            }
        });

        jLabel15.setText("ID Alimento");

        jLabel16.setText("Descripción");

        alimento_desc.setColumns(20);
        alimento_desc.setRows(5);
        jScrollPane13.setViewportView(alimento_desc);

        jLabel17.setText("ID Proveedor");

        jLabel19.setText("Tipo");

        alimento_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alimento_tipoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 1181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(alimento_id, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(combo_pro, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alimento_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(67, 67, 67)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(mostrar_esp6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(add_esp6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(del_esp6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ed_esp6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(115, 115, 115))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(alimento_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alimento_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_pro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(mostrar_esp6)
                                    .addComponent(add_esp6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(del_esp6)
                                    .addComponent(ed_esp6)))
                            .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        jTabbedPane1.addTab("Alimento", jPanel5);

        venta_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Estanque", "ID Especie", "Fecha", "ID Precio", "Peso Biomasa", "Valor Venta"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(venta_tab);

        mostrar_esp7.setText("Mostrar");
        mostrar_esp7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_esp7ActionPerformed(evt);
            }
        });

        add_esp7.setText("Agregar");
        add_esp7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_esp7ActionPerformed(evt);
            }
        });

        ed_esp7.setText("Editar");

        del_esp7.setText("Borrar");

        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("ID Estanque");

        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Fecha");

        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("ID Especie");

        jLabel22.setText("ID Precio");

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Peso Biomasa");

        jLabel24.setText("Valor Venta");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(combo_estanque, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_especie, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(venta_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(combo_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(venta_peso, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(venta_valor, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel24)))
                        .addGap(249, 249, 249)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mostrar_esp7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(del_esp7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ed_esp7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(add_esp7))))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(venta_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(venta_valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(venta_peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_estanque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_especie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostrar_esp7)
                            .addComponent(add_esp7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(del_esp7)
                            .addComponent(ed_esp7))))
                .addGap(33, 33, 33)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jTabbedPane1.addTab("Venta", jPanel6);

        alimenta_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Especie", "ID Estanque", "ID Alimento", "Fecha", "Racion", "Precio Alimento"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane8.setViewportView(alimenta_tab);

        mostrar_esp8.setText("Mostrar");
        mostrar_esp8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_esp8ActionPerformed(evt);
            }
        });

        add_esp8.setText("Agregar");
        add_esp8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_esp8ActionPerformed(evt);
            }
        });

        ed_esp8.setText("Editar");

        del_esp8.setText("Borrar");

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("ID Especie");

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("ID Estanque");

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("ID Alimento");

        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Fecha");

        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Ración");

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Precio Alimento");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(combo_especie1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(51, 51, 51)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_estanque1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_alimento2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alimenta_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(54, 54, 54)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alimenta_racion, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(68, 68, 68)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(alimenta_precio)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mostrar_esp8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(del_esp8, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ed_esp8, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(add_esp8)))
                .addGap(70, 70, 70))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(alimenta_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alimenta_racion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alimenta_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_alimento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_estanque1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_especie1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostrar_esp8)
                            .addComponent(add_esp8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(del_esp8)
                            .addComponent(ed_esp8))))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jTabbedPane1.addTab("Alimenta", jPanel7);

        mues_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Estanque", "ID Especie", "Fecha", "Peso Biomasa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane9.setViewportView(mues_tab);

        mostrar_esp3.setText("Mostrar");
        mostrar_esp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_esp3ActionPerformed(evt);
            }
        });

        add_esp3.setText("Agregar");
        add_esp3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_esp3ActionPerformed(evt);
            }
        });

        ed_esp3.setText("Editar");

        del_esp3.setText("Borrar");

        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("ID Estanque");

        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("ID Especie");

        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Fecha");

        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Peso Biomasa");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 1211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(combo_estanque3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(combo_especie3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(muestreo_fecha, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addGap(86, 86, 86)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(muestreo_peso, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mostrar_esp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(del_esp3, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ed_esp3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(add_esp3)))
                .addGap(33, 33, 33))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(56, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(muestreo_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(muestreo_peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_estanque3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_especie3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostrar_esp3)
                            .addComponent(add_esp3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(del_esp3)
                            .addComponent(ed_esp3))))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jTabbedPane1.addTab("Muestreo", jPanel8);

        siem_tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Estanque", "ID Especie", "Fecha", "Cantidad", "Peso Biomasa", "Precio Compra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane10.setViewportView(siem_tab);

        mostrar_esp2.setText("Mostrar");
        mostrar_esp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrar_esp2ActionPerformed(evt);
            }
        });

        add_esp2.setText("Agregar");
        add_esp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_esp2ActionPerformed(evt);
            }
        });

        ed_esp2.setText("Editar");

        del_esp2.setText("Borrar");

        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("ID Estanque");

        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("ID Especie");

        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Fecha");

        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Cantidad");

        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Peso Biomasa");

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Precio Compra");

        combo_estanque2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_estanque2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 1194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo_estanque2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(combo_especie2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(73, 73, 73)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(siembra_fecha)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(84, 84, 84)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(siembra_cant)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(siembra_peso)
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(79, 79, 79)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(siembra_compra)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mostrar_esp2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(del_esp2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ed_esp2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(add_esp2)))
                .addGap(59, 59, 59))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)
                            .addComponent(jLabel37)
                            .addComponent(jLabel38)
                            .addComponent(jLabel39)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(siembra_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(siembra_cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(siembra_peso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(siembra_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_especie2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_estanque2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostrar_esp2)
                            .addComponent(add_esp2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(del_esp2)
                            .addComponent(ed_esp2))))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jTabbedPane1.addTab("Siembra", jPanel9);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mostrar_espActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_espActionPerformed
        DTM = (DefaultTableModel) especie_tab.getModel();
        try {
            MostrarEspecie(LlenarEspecie());
        } catch (Exception ex) {
            System.out.println(ex);
        };
    }//GEN-LAST:event_mostrar_espActionPerformed

    private void mostrar_esp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_esp1ActionPerformed
        DTM = (DefaultTableModel) estanque_tab.getModel();
        try {
            MostrarEstanque(LlenarEstanque());
        } catch (Exception ex) {
            System.out.println(ex);
        };
    }//GEN-LAST:event_mostrar_esp1ActionPerformed

    private void mostrar_esp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_esp2ActionPerformed
        combo_estanque2.removeAllItems();
        combo_especie2.removeAllItems();
        LlenarEstanque().forEach((E) -> {
            combo_estanque2.addItem(E.getIdestanque() + "");
        });
        LlenarEspecie().forEach((E) -> {
            combo_especie2.addItem(E.getIdespecie() + "");
        });
        DTM = (DefaultTableModel) siem_tab.getModel();
        try {
            MostrarSiembra(LlenarSiembra());
        } catch (Exception ex) {
            System.out.println(ex);
        };
    }//GEN-LAST:event_mostrar_esp2ActionPerformed

    private void mostrar_esp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_esp3ActionPerformed
        combo_estanque3.removeAllItems();
        combo_especie3.removeAllItems();
        LlenarEstanque().forEach((E) -> {
            combo_estanque3.addItem(E.getIdestanque() + "");
        });
        LlenarEspecie().forEach((E) -> {
            combo_especie3.addItem(E.getIdespecie() + "");
        });

        //MUESTREO
        DTM = (DefaultTableModel) mues_tab.getModel();
        try {
            MostrarMuestreo(LlenarMuestreo());
        } catch (Exception ex) {
            System.out.println("Boton eror" + ex);
        };
    }//GEN-LAST:event_mostrar_esp3ActionPerformed

    private void mostrar_esp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_esp4ActionPerformed
        DTM = (DefaultTableModel) proveedor_tab.getModel();
        try {
            MostrarProveedor(LlenarProveedor());
        } catch (Exception ex) {
            System.out.println(ex);
        };
    }//GEN-LAST:event_mostrar_esp4ActionPerformed

    private void mostrar_esp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_esp5ActionPerformed
        DTM = (DefaultTableModel) pre_tab.getModel();
        try {
            MostrarPrecio(LlenarPrecio());
        } catch (Exception ex) {
            System.out.println(ex);
        };
    }//GEN-LAST:event_mostrar_esp5ActionPerformed

    private void mostrar_esp6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_esp6ActionPerformed
        combo_pro.removeAllItems();
        LlenarProveedor().forEach((p) -> {
            combo_pro.addItem(p.getIdproveedor() + "");
        });
        DTM = (DefaultTableModel) alimento_tab.getModel();
        try {
            MostrarAlimento(LlenarAlimento());
        } catch (Exception ex) {
            System.out.println("Boton eror" + ex);
        };
    }//GEN-LAST:event_mostrar_esp6ActionPerformed

    private void mostrar_esp7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_esp7ActionPerformed
        combo_estanque.removeAllItems();
        combo_especie.removeAllItems();
        combo_precio.removeAllItems();
        LlenarEstanque().forEach((E) -> {
            combo_estanque.addItem(E.getIdestanque() + "");
        });
        LlenarEspecie().forEach((E) -> {
            combo_especie.addItem(E.getIdespecie() + "");
        });
        LlenarPrecio().forEach((P) -> {
            combo_precio.addItem(P.getIdprecio() + "");
        });
        DTM = (DefaultTableModel) venta_tab.getModel();
        try {
            MostrarVenta(LlenarVenta());
        } catch (Exception ex) {
            System.out.println("Boton eror" + ex);
        };
    }//GEN-LAST:event_mostrar_esp7ActionPerformed

    private void mostrar_esp8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrar_esp8ActionPerformed
        LlenarEstanque().forEach((E) -> {
            combo_estanque1.addItem(E.getIdestanque() + "");
        });
        LlenarEspecie().forEach((E) -> {
            combo_especie1.addItem(E.getIdespecie() + "");
        });
        LlenarAlimento().forEach((E) -> {
            combo_alimento2.addItem(E.getIdalimento() + "");
        });
        DTM = (DefaultTableModel) alimenta_tab.getModel();
        try {
            MostrarAlimenta(LlenarAlimenta());
        } catch (Exception ex) {
            System.out.println("Boton eror" + ex);
        };
    }//GEN-LAST:event_mostrar_esp8ActionPerformed

    private void pre_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pre_idActionPerformed


    }//GEN-LAST:event_pre_idActionPerformed

    private void alimento_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alimento_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alimento_tipoActionPerformed

    private void add_espActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_espActionPerformed
        String id = id_especie_tf.getText();
        String desc = desc_especie_ta.getText();
        if (!id.isEmpty() && !desc.isEmpty()) {
            AgregarEspecie(Integer.parseInt(id), desc);
            Limpiar(id_especie_tf);
            desc_especie_ta.setText("");
            mostrar_espActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_add_espActionPerformed

    private void del_espActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_espActionPerformed
        int row = especie_tab.getSelectedRow();
        EliminarEspecie("" + DTM.getValueAt(row, 0));
        DTM.removeRow(row);        // TODO add your handling code here:
    }//GEN-LAST:event_del_espActionPerformed

    private void ed_espActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_espActionPerformed
        String id = id_especie_tf.getText();
        String desc = desc_especie_ta.getText();
        String oldID = "" + DTM.getValueAt(especie_tab.getSelectedRow(), 0);
        EditarEspecie(oldID, id, desc);
        Limpiar(id_especie_tf);
        desc_especie_ta.setText("");
        mostrar_espActionPerformed(evt);  // TODO add your handling code here:
    }//GEN-LAST:event_ed_espActionPerformed

    private void especie_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_especie_tabMouseClicked
        int row = especie_tab.getSelectedRow();
        id_especie_tf.setText("" + DTM.getValueAt(row, 0));
        desc_especie_ta.setText("" + DTM.getValueAt(row, 1));
    }//GEN-LAST:event_especie_tabMouseClicked

    private void del_esp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_esp1ActionPerformed
        //EliminarEstanque
        int row = estanque_tab.getSelectedRow();
        EliminarEstanque("" + DTM.getValueAt(row, 0));
        DTM.removeRow(row);
    }//GEN-LAST:event_del_esp1ActionPerformed

    private void add_esp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_esp1ActionPerformed
        //Estanque Agregar
        String id = estanque_id.getText();
        String desc = estanque_desc.getText();
        String area = estanque_area.getText();
        String cant = estanque_cantidad.getText();
        if (!id.isEmpty() && !desc.isEmpty() && !area.isEmpty() && !cant.isEmpty()) {
            AgregarEstanque(Integer.parseInt(id), desc, Float.parseFloat(area), Integer.parseInt(cant));
            Limpiar(estanque_area, estanque_cantidad, estanque_id);
            estanque_desc.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
        mostrar_esp1ActionPerformed(evt);
    }//GEN-LAST:event_add_esp1ActionPerformed

    private void ed_esp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_esp1ActionPerformed
        //Editar Estanque
        String id = estanque_id.getText();
        String desc = estanque_desc.getText();
        String area = estanque_area.getText();
        String cant = estanque_cantidad.getText();
        String oldID = "" + DTM.getValueAt(estanque_tab.getSelectedRow(), 0);
        EditarEstanque(oldID, id, desc, Float.parseFloat(area), Integer.parseInt(cant));
        Limpiar(estanque_area, estanque_cantidad, estanque_id);
        estanque_desc.setText("");
        mostrar_esp1ActionPerformed(evt);

    }//GEN-LAST:event_ed_esp1ActionPerformed

    private void estanque_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estanque_tabMouseClicked
        int row = estanque_tab.getSelectedRow();
        estanque_id.setText("" + DTM.getValueAt(row, 0));
        estanque_desc.setText("" + DTM.getValueAt(row, 1));
        estanque_area.setText("" + DTM.getValueAt(row, 2));
        estanque_cantidad.setText("" + DTM.getValueAt(row, 3));
    }//GEN-LAST:event_estanque_tabMouseClicked

    private void add_esp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_esp4ActionPerformed
        //Agregar proveedor
        String id = pro_id.getText();
        String nom = pro_nombre.getText();
        String tel = pro_telefono.getText();
        if (!id.isEmpty() && !nom.isEmpty() && !tel.isEmpty()) {
            AgregarProveedor(Integer.parseInt(id), nom, tel);
            Limpiar(pro_id, pro_nombre, pro_telefono);
            mostrar_esp4ActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_add_esp4ActionPerformed

    private void del_esp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_esp4ActionPerformed
        //BORRAR PROVEEDOR
        int row = proveedor_tab.getSelectedRow();
        EliminarProveedor("" + DTM.getValueAt(row, 0));
        DTM.removeRow(row);

    }//GEN-LAST:event_del_esp4ActionPerformed

    private void ed_esp4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_esp4ActionPerformed
        //EDITAR PROVEEDOR
        String id = pro_id.getText();
        String nom = pro_nombre.getText();
        String tel = pro_telefono.getText();
        String oldID = "" + DTM.getValueAt(proveedor_tab.getSelectedRow(), 0);
        EditarProveedor(oldID, id, nom, tel);
        Limpiar(pro_id, pro_nombre, pro_telefono);
        mostrar_esp4ActionPerformed(evt);
    }//GEN-LAST:event_ed_esp4ActionPerformed

    private void proveedor_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_proveedor_tabMouseClicked
        //EVENTO MOUSE TABLA PROVEEDOR
        int row = proveedor_tab.getSelectedRow();
        pro_id.setText("" + DTM.getValueAt(row, 0));
        pro_nombre.setText("" + DTM.getValueAt(row, 1));
        pro_telefono.setText("" + DTM.getValueAt(row, 2));
    }//GEN-LAST:event_proveedor_tabMouseClicked

    private void add_esp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_esp5ActionPerformed
        //AGREGAR PRECIOSVENTA
        String id = pre_id.getText();
        String desc = pre_desc.getText();
        String perdida = pre_perdida.getText();
        String tipo = pre_tipo.getText();
        String precio = pre_kilo.getText();

        if (!id.isEmpty() && !desc.isEmpty() && !perdida.isEmpty() && !tipo.isEmpty() && !precio.isEmpty()) {
            AgregarPrecio(Integer.parseInt(id), desc, Float.parseFloat(perdida), tipo, Float.parseFloat(precio));
            Limpiar(pre_id, pre_perdida, pre_tipo, pre_kilo);
            pre_desc.setText("");
            mostrar_esp5ActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_add_esp5ActionPerformed

    private void del_esp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_esp5ActionPerformed
        int row = pre_tab.getSelectedRow();
        EliminarPrecios("" + DTM.getValueAt(row, 0));
        DTM.removeRow(row);
    }//GEN-LAST:event_del_esp5ActionPerformed

    private void ed_esp5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_esp5ActionPerformed
        //EDITAR PRECIOS
        String id = pre_id.getText();
        String desc = pre_desc.getText();
        String perdida = pre_perdida.getText();
        String tipo = pre_tipo.getText();
        String precio = pre_kilo.getText();
        String oldID = "" + DTM.getValueAt(pre_tab.getSelectedRow(), 0);
        EditarPrecios(oldID, Integer.parseInt(id), desc, Float.parseFloat(perdida), tipo, Float.parseFloat(precio));
        Limpiar(pre_id, pre_perdida, pre_kilo, pre_tipo);
        pre_desc.setText("");
        mostrar_esp5ActionPerformed(evt);

    }//GEN-LAST:event_ed_esp5ActionPerformed

    private void pre_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pre_tabMouseClicked
        int row = pre_tab.getSelectedRow();
        pre_id.setText("" + DTM.getValueAt(row, 0));
        pre_desc.setText("" + DTM.getValueAt(row, 1));
        pre_perdida.setText("" + DTM.getValueAt(row, 2));
        pre_tipo.setText("" + DTM.getValueAt(row, 3));
        pre_kilo.setText("" + DTM.getValueAt(row, 4));
    }//GEN-LAST:event_pre_tabMouseClicked

    private void combo_estanque2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_estanque2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combo_estanque2ActionPerformed

    private void add_esp6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_esp6ActionPerformed
        String id = alimento_id.getText();
        String idpro = combo_pro.getSelectedItem() + "";
        String desc = alimento_desc.getText();
        String tipo = alimento_tipo.getText();
        if (!id.isEmpty() && !idpro.isEmpty() && !desc.isEmpty() && !tipo.isEmpty()) {
            AgregarAlimento(Integer.parseInt(id), Integer.parseInt(idpro), desc, tipo);
            Limpiar(alimento_id, alimento_tipo);
            alimento_desc.setText("");
            mostrar_esp6ActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }
    }//GEN-LAST:event_add_esp6ActionPerformed

    private void del_esp6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_esp6ActionPerformed
        int row = alimento_tab.getSelectedRow();
        EliminarAlimento("" + DTM.getValueAt(row, 0));
        DTM.removeRow(row);
        Limpiar(alimento_id, alimento_tipo);
        alimento_desc.setText("");
        mostrar_esp6ActionPerformed(evt);
    }//GEN-LAST:event_del_esp6ActionPerformed

    private void alimento_tabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alimento_tabMouseClicked
        //EVENTO ALIMENTO
        int row = alimento_tab.getSelectedRow();
        int x = 0;
        alimento_id.setText("" + DTM.getValueAt(row, 0));
        for (int i = 0; i < combo_pro.getItemCount(); i++) {
            int j = Integer.parseInt(combo_pro.getItemAt(i));
            if (((int) DTM.getValueAt(row, 1)) == j) {
                x = i;
            }
        }
        combo_pro.setSelectedIndex(x);
        alimento_tipo.setText("" + DTM.getValueAt(row, 3));
        alimento_desc.setText("" + DTM.getValueAt(row, 2));
    }//GEN-LAST:event_alimento_tabMouseClicked

    private void ed_esp6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ed_esp6ActionPerformed
        int row = alimento_tab.getSelectedRow();
        String id = alimento_id.getText();
        String idpro = combo_pro.getSelectedItem() + "";
        String desc = alimento_desc.getText();
        String tipo = alimento_tipo.getText();
        String oldid = "" + DTM.getValueAt(row, 0);
        EditarAlimento(oldid, Integer.parseInt(id), Integer.parseInt(idpro), desc, tipo);
        Limpiar(alimento_id, alimento_tipo);
        alimento_desc.setText("");
        mostrar_esp6ActionPerformed(evt);

    }//GEN-LAST:event_ed_esp6ActionPerformed

    private void add_esp7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_esp7ActionPerformed
        // Agregar venta
        String idestanque = combo_estanque.getSelectedItem() + "";
        String idespecie = combo_especie.getSelectedItem() + "";
        String fecha = venta_fecha.getText();
        String idprecio = combo_precio.getSelectedItem() + "";
        String peso = venta_peso.getText();
        String valor = venta_valor.getText();

        if (!idestanque.isEmpty() && !idespecie.isEmpty() && !fecha.isEmpty() && !idprecio.isEmpty() && !peso.isEmpty() && !valor.isEmpty()) {
            AgregarVenta(Integer.parseInt(idestanque), Integer.parseInt(idespecie), Integer.parseInt(idprecio), Float.parseFloat(idprecio), Float.parseFloat(peso), fecha);
            Limpiar(venta_fecha, venta_peso, venta_valor);
            mostrar_esp7ActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }

    }//GEN-LAST:event_add_esp7ActionPerformed

    private void add_esp8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_esp8ActionPerformed
        //AGREGAR ALIMENTA
        String idespecie = combo_especie1.getSelectedItem() + "";
        String idestanque = combo_estanque1.getSelectedItem() + "";
        String fecha = alimenta_fecha.getText();
        String idalimento = combo_alimento2.getSelectedItem() + "";
        String racion = alimenta_racion.getText();
        String precio = alimenta_precio.getText();
        if (!idestanque.isEmpty() && !idespecie.isEmpty() && !fecha.isEmpty() && !idalimento.isEmpty() && !racion.isEmpty() && !precio.isEmpty()) {
            AgregarAlimenta(fecha, Float.parseFloat(precio), Integer.parseInt(idespecie), Integer.parseInt(idestanque), Integer.parseInt(idalimento), Integer.parseInt(racion));
            Limpiar(alimenta_fecha, alimenta_racion, alimenta_precio);
            mostrar_esp8ActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }

    }//GEN-LAST:event_add_esp8ActionPerformed

    private void add_esp3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_esp3ActionPerformed
        //AGREGAR MUESTREO
        String idespecie = combo_especie3.getSelectedItem() + "";
        String idestanque = combo_estanque3.getSelectedItem() + "";
        String fecha = muestreo_fecha.getText();
        String peso = muestreo_peso.getText();
        if (!idestanque.isEmpty() && !idespecie.isEmpty() && !fecha.isEmpty() && !peso.isEmpty()) {
            AgregarMuestreo(Integer.parseInt(idestanque), Integer.parseInt(idespecie), fecha, Float.parseFloat(peso));
            mostrar_esp3ActionPerformed(evt);
            Limpiar(muestreo_fecha, muestreo_peso);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }

    }//GEN-LAST:event_add_esp3ActionPerformed

    private void add_esp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_esp2ActionPerformed
        // AGREGAR SIEMBRA
        String idestanque = combo_estanque2.getSelectedItem() + "";
        String idespecie = combo_especie2.getSelectedItem() + "";
        String fecha = siembra_fecha.getText();
        String cantidad = siembra_cant.getText();
        String peso = siembra_peso.getText();
        String precio = siembra_compra.getText();
        if (!idestanque.isEmpty() && !idespecie.isEmpty() && !fecha.isEmpty() && !peso.isEmpty() && !precio.isEmpty() && !cantidad.isEmpty()) {
            AgregarSiembra(Integer.parseInt(idespecie), Integer.parseInt(idestanque), Integer.parseInt(cantidad), Float.parseFloat(peso), Float.parseFloat(precio), fecha);
            Limpiar(siembra_cant, siembra_compra, siembra_fecha, siembra_peso);
            mostrar_esp2ActionPerformed(evt);
        } else {
            JOptionPane.showMessageDialog(null, "Debes llenar todos los campos");
        }

    }//GEN-LAST:event_add_esp2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_esp;
    private javax.swing.JButton add_esp1;
    private javax.swing.JButton add_esp2;
    private javax.swing.JButton add_esp3;
    private javax.swing.JButton add_esp4;
    private javax.swing.JButton add_esp5;
    private javax.swing.JButton add_esp6;
    private javax.swing.JButton add_esp7;
    private javax.swing.JButton add_esp8;
    private javax.swing.JTextField alimenta_fecha;
    private javax.swing.JTextField alimenta_precio;
    private javax.swing.JTextField alimenta_racion;
    private javax.swing.JTable alimenta_tab;
    private javax.swing.JTextArea alimento_desc;
    private javax.swing.JTextField alimento_id;
    private javax.swing.JTable alimento_tab;
    private javax.swing.JTextField alimento_tipo;
    private javax.swing.JComboBox<String> combo_alimento2;
    private javax.swing.JComboBox<String> combo_especie;
    private javax.swing.JComboBox<String> combo_especie1;
    private javax.swing.JComboBox<String> combo_especie2;
    private javax.swing.JComboBox<String> combo_especie3;
    private javax.swing.JComboBox<String> combo_estanque;
    private javax.swing.JComboBox<String> combo_estanque1;
    private javax.swing.JComboBox<String> combo_estanque2;
    private javax.swing.JComboBox<String> combo_estanque3;
    private javax.swing.JComboBox<String> combo_precio;
    private javax.swing.JComboBox<String> combo_pro;
    private javax.swing.JButton del_esp;
    private javax.swing.JButton del_esp1;
    private javax.swing.JButton del_esp2;
    private javax.swing.JButton del_esp3;
    private javax.swing.JButton del_esp4;
    private javax.swing.JButton del_esp5;
    private javax.swing.JButton del_esp6;
    private javax.swing.JButton del_esp7;
    private javax.swing.JButton del_esp8;
    private javax.swing.JTextArea desc_especie_ta;
    private javax.swing.JButton ed_esp;
    private javax.swing.JButton ed_esp1;
    private javax.swing.JButton ed_esp2;
    private javax.swing.JButton ed_esp3;
    private javax.swing.JButton ed_esp4;
    private javax.swing.JButton ed_esp5;
    private javax.swing.JButton ed_esp6;
    private javax.swing.JButton ed_esp7;
    private javax.swing.JButton ed_esp8;
    private javax.swing.JTable especie_tab;
    private javax.swing.JTextField estanque_area;
    private javax.swing.JTextField estanque_cantidad;
    private javax.swing.JTextArea estanque_desc;
    private javax.swing.JTextField estanque_id;
    private javax.swing.JTable estanque_tab;
    private javax.swing.JTextField id_especie_tf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton mostrar_esp;
    private javax.swing.JButton mostrar_esp1;
    private javax.swing.JButton mostrar_esp2;
    private javax.swing.JButton mostrar_esp3;
    private javax.swing.JButton mostrar_esp4;
    private javax.swing.JButton mostrar_esp5;
    private javax.swing.JButton mostrar_esp6;
    private javax.swing.JButton mostrar_esp7;
    private javax.swing.JButton mostrar_esp8;
    private javax.swing.JTable mues_tab;
    private javax.swing.JTextField muestreo_fecha;
    private javax.swing.JTextField muestreo_peso;
    private javax.swing.JTextArea pre_desc;
    private javax.swing.JTextField pre_id;
    private javax.swing.JTextField pre_kilo;
    private javax.swing.JTextField pre_perdida;
    private javax.swing.JTable pre_tab;
    private javax.swing.JTextField pre_tipo;
    private javax.swing.JTextField pro_id;
    private javax.swing.JTextField pro_nombre;
    private javax.swing.JTextField pro_telefono;
    private javax.swing.JTable proveedor_tab;
    private javax.swing.JTable siem_tab;
    private javax.swing.JTextField siembra_cant;
    private javax.swing.JTextField siembra_compra;
    private javax.swing.JTextField siembra_fecha;
    private javax.swing.JTextField siembra_peso;
    private javax.swing.JTextField venta_fecha;
    private javax.swing.JTextField venta_peso;
    private javax.swing.JTable venta_tab;
    private javax.swing.JTextField venta_valor;
    // End of variables declaration//GEN-END:variables
}
