/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huevosaj;

/**
 *
 * @author JohanF
 */
public class Proveedores {
    String id_proveedor;
    String primernombre_proveedor;
    String segundonombre_proveedor;
    String primerapellido_proveedor;
    String segundoapellido_proveedor;
    String direccion_proveedor;
    String telefono_proveedor;
    String correo_proveedor;
    
    public Proveedores(){
    id_proveedor = "";
    primernombre_proveedor = "";
    segundonombre_proveedor = "";
    primerapellido_proveedor = "";
    segundoapellido_proveedor = "";
    direccion_proveedor = "";
    telefono_proveedor = "";
    correo_proveedor = "";
    }

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getPrimernombre_proveedor() {
        return primernombre_proveedor;
    }

    public void setPrimernombre_proveedor(String primernombre_proveedor) {
        this.primernombre_proveedor = primernombre_proveedor;
    }

    public String getSegundonombre_proveedor() {
        return segundonombre_proveedor;
    }

    public void setSegundonombre_proveedor(String segundonombre_proveedor) {
        this.segundonombre_proveedor = segundonombre_proveedor;
    }

    public String getPrimerapellido_proveedor() {
        return primerapellido_proveedor;
    }

    public void setPrimerapellido_proveedor(String primerapellido_proveedor) {
        this.primerapellido_proveedor = primerapellido_proveedor;
    }

    public String getSegundoapellido_proveedor() {
        return segundoapellido_proveedor;
    }

    public void setSegundoapellido_proveedor(String segundoapellido_proveedor) {
        this.segundoapellido_proveedor = segundoapellido_proveedor;
    }

    public String getDireccion_proveedor() {
        return direccion_proveedor;
    }

    public void setDireccion_proveedor(String direccion_proveedor) {
        this.direccion_proveedor = direccion_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    public String getCorreo_proveedor() {
        return correo_proveedor;
    }

    public void setCorreo_proveedor(String correo_proveedor) {
        this.correo_proveedor = correo_proveedor;
    }
}
