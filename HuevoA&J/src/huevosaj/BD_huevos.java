package huevosaj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class BD_huevos {

    static Connection contacto = null;
    int Activo = 0;

    //CONEXION BASE DE DATOS----------------------------------------------------------------------
    public static Connection getConexion() {
        String url = "jdbc:sqlserver://bdhuevos.mssql.somee.com;databaseName=bdhuevos";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            System.out.println("Conectado.");
        } catch (ClassNotFoundException e) {

            System.out.println("error driver.");
        }
        try {
            contacto = DriverManager.getConnection(url, "JohanFZ_SQLLogin_1", "4so2rpfdrs");
        } catch (SQLException e) {
            System.out.println("error conexion.");
        }
        return contacto;
    }

    public void desconectar() {
        try {
            contacto.close();
            System.out.println("desconcetado");
        } catch (SQLException ex) {
            System.out.println("Error en el cierre" + ex.getMessage());
        }
    }

    public static ResultSet Consulta(String Consulta) {
        Connection con = getConexion();
        Statement declara;
        try {
            declara = con.createStatement();
            ResultSet respuesta = declara.executeQuery(Consulta);
            return respuesta;
        } catch (SQLException e) {
            System.out.println("error conexion.");
        }
        return null;
    }

    public int Val_Usu_log(String Usu, String Pas) {
        int estado = 0;
        ResultSet result;
        String PasRes;

        try {
            PreparedStatement st = contacto.prepareStatement("select * from Usuario where username =?");
            st.setString(1, Usu);
            result = st.executeQuery();
            while (result.next()) {
                PasRes = result.getString("contraseña");
                if (PasRes.equals(Pas) && !result.getString("username").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }
    //TABLA USUARIOS

    public int Agre_Usu(String primernombre_usuario, String segundonombre_usuario, String primerapellido_usuario,
            String segundoapellido_usuario, String corrreo_cliente, String username, String contraseña) {
        int estado;
        try {

            PreparedStatement st = contacto.prepareStatement("insert Usuario (primernombre_usuario,segundonombre_usuario,primerapellido_usuario,segundoapellido_usuario,corrreo_cliente,username,contraseña) values (?,?,?,?,?,?,?)");
            st.setString(1, primernombre_usuario);
            st.setString(2, segundonombre_usuario);
            st.setString(3, primerapellido_usuario);
            st.setString(4, segundoapellido_usuario);
            st.setString(5, corrreo_cliente);
            st.setString(6, username);
            st.setString(7, contraseña);
            st.execute();
            estado = 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }

    public int Val_Usu_CO(String Usua) {
        int estado = 0;
        ResultSet result;
        try {
            PreparedStatement st = contacto.prepareStatement("select * from Usuario where username=?");
            st.setString(1, Usua);
            result = st.executeQuery();
            while (result.next()) {
                if (!result.getString("username").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }

    // metodo de validadr q no sean el mismo correo
    public int Val_Usu_Correo(String corr) {
        int estado = 0;
        ResultSet result;
        try {
            PreparedStatement st = contacto.prepareStatement("select * from Usuario where corrreo_cliente=?");
            st.setString(1, corr);
            result = st.executeQuery();
            while (result.next()) {
                if (!result.getString("corrreo_cliente").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }

    //VISTA PROVEEDOR
    public int Val_Pro_Correo(String corr) {
        int estado = 0;
        ResultSet result;
        try {
            PreparedStatement st = contacto.prepareStatement("select * from Proveedor where corrreo_proveedor=?");
            st.setString(1, corr);
            result = st.executeQuery();
            while (result.next()) {
                if (!result.getString("corrreo_proveedor").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }

    public int Agre_Pro(String primernombre_proveedor, String segundonombre_proveedor, String primerapellido_proveedor,
            String segundoapellido_proveedor, String direccion_proveedor, String telefono_proveedor, String corrreo_proveedor) {
        int estado;
        try {

            PreparedStatement st = contacto.prepareStatement("insert Proveedor (primernombre_proveedor,segundonombre_proveedor,primerapellido_proveedor,segundoapellido_proveedor,corrreo_proveedor,telefono_proveedor,direccion_proveedor) values (?,?,?,?,?,?,?)");
            st.setString(1, primernombre_proveedor);
            st.setString(2, segundonombre_proveedor);
            st.setString(3, primerapellido_proveedor);
            st.setString(4, segundoapellido_proveedor);
            st.setString(5, direccion_proveedor);
            st.setString(6, telefono_proveedor);
            st.setString(7, corrreo_proveedor);
            st.execute();
            estado = 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }

    public DefaultTableModel Lista_prov() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 9) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        ResultSet result;
        try {

            PreparedStatement st = contacto.prepareStatement("select * from Proveedor ");

            result = st.executeQuery();
            ResultSetMetaData rmsd = result.getMetaData();
            int canCol = rmsd.getColumnCount();
            canCol += 1;
            for (int i = 1; i < canCol; i++) {
                String title[] = {"", "ID", "P Nombre", "S Nombre", "P Apellido", "S Apellido", "Dirección", "Telefono", "Correo"};
                modelo.addColumn(title[i]);
            }
            canCol = canCol - 1;
            while (result.next()) {
                Object[] fila = new Object[canCol];
                for (int i = 0; i < canCol; i++) {
                    fila[i] = result.getObject(i + 1);
                }
//                modelo.addRow(new Object[]{fila[0],new JLabel(this.view_img(3)),fila[2],fila[3]});
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {

        }
        return modelo;
    }

    public String[] ModifiPro(int dato, int combo) {
        String resultado[] = new String[11], campoDB = "";
        ResultSet result;
        try {

            if (Activo == 0) {
                campoDB = "select * from Proveedor where id_proveedor";
            }
            PreparedStatement st
                    = contacto.prepareStatement(campoDB + "=?");
            st.setInt(1, dato);
            result = st.executeQuery();
            while (result.next()) {
                resultado[0] = result.getString("primernombre_proveedor");
                resultado[1] = result.getString("segundonombre_proveedor");
                resultado[2] = result.getString("primerapellido_proveedor");
                resultado[3] = result.getString("segundoapellido_proveedor");
                resultado[4] = result.getString("direccion_proveedor");
                resultado[5] = result.getString("telefono_proveedor");
                resultado[6] = result.getString("corrreo_proveedor");
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultado;
    }

    public int Act_Pro(int id_proveedor, String primernombre_proveedor, String segundonombre_proveedor, String primerapellido_proveedor, String segundoapellido_proveedor, String direccion_proveedor, String telefono_proveedor, String corrreo_proveedor) {
        int estado2;
        try {
            PreparedStatement st = contacto.prepareStatement("update Proveedor set primernombre_proveedor=?, segundonombre_proveedor=?,primerapellido_proveedor=?,segundoapellido_proveedor=?,direccion_proveedor=?,telefono_proveedor=?, corrreo_proveedor=? where id_proveedor=?");
            st.setString(1, primernombre_proveedor);
            st.setString(2, segundonombre_proveedor);
            st.setString(3, primerapellido_proveedor);
            st.setString(4, segundoapellido_proveedor);
            st.setString(5, direccion_proveedor);
            st.setString(6, telefono_proveedor);
            st.setString(7, corrreo_proveedor);
            st.setInt(8, id_proveedor);
            st.execute();
            estado2 = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado2 = 0;
        }
        return estado2;
    }
    //VISTA CLIENTES

//    public ArrayList<Clientes> listarcliente() {
//
//        ArrayList listarclientes = new ArrayList();
//        Clientes vv;
//        try {
//
//            PreparedStatement st = contacto.prepareStatement("select c.id_cliente,  c.primernombre_cliente,c.segundonombre_cliente,c.primerapellido_cliente,\n"
//                    + "c.segundoapellido_cliente,c.direccion_cliente,c.telefono_cliente,c.corrreo_cliente\n"
//                    + "from Cliente c\n"
//                    + "order by c.primernombre_cliente asc ");
//
//            ResultSet rs = st.executeQuery();
//            while (rs.next()) {
//
//                vv = new Clientes();
//                vv.setId_cliente(rs.getString(1));
//                vv.setPrimernombre(rs.getString(2));
//                vv.setSegundonombre(rs.getString(3));
//                vv.setPrimerapellido(rs.getString(4));
//                vv.setSegundoapellido(rs.getString(5));
//                vv.setDireccion(rs.getString(6));
//                vv.setTelefono(rs.getString(7));
//                vv.setCorreo(rs.getString(8));
//                listarclientes.add(vv);
//            }
//
//        } catch (Exception e) {
//        }
//        return listarclientes;
//    }
    public DefaultTableModel Lista_clie() {

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if (column == 9) {
                    return true;
                } else {
                    return false;
                }
            }

        };
        ResultSet result;
        try {

            PreparedStatement st = contacto.prepareStatement("select * from Cliente ");

            result = st.executeQuery();
            ResultSetMetaData rmsd = result.getMetaData();
            int canCol = rmsd.getColumnCount();
            canCol += 1;
            for (int i = 1; i < canCol; i++) {
                String title[] = {"", "ID Cliente", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido", "Dirección", "Telefono", "Correo"};
                modelo.addColumn(title[i]);
            }
            canCol = canCol - 1;
            while (result.next()) {
                Object[] fila = new Object[canCol];
                for (int i = 0; i < canCol; i++) {
                    fila[i] = result.getObject(i + 1);
                }
//                modelo.addRow(new Object[]{fila[0],new JLabel(this.view_img(3)),fila[2],fila[3]});
                modelo.addRow(fila);
            }
        } catch (SQLException ex) {

        }
        return modelo;
    }

    public int Val_clie_Correo(String corr) {
        int estado = 0;
        ResultSet result;
        try {
            PreparedStatement st = contacto.prepareStatement("select * from Cliente where corrreo_cliente=?");
            st.setString(1, corr);
            result = st.executeQuery();
            while (result.next()) {
                if (!result.getString("corrreo_cliente").isEmpty()) {
                    estado = 1;
                } else {
                    estado = 0;
                }
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return estado;
    }

    public int Agre_clientes(String primernombre_clientes, String segundonombre_clientes, String primerapellido_cliente,
            String segundoapellido_cliente, String direccion_cliente, String telefono_cliente, String correo_cliente) {
        int estado;
        try {

            PreparedStatement st = contacto.prepareStatement("insert Cliente (primernombre_cliente,segundonombre_cliente,primerapellido_cliente,segundoapellido_cliente,direccion_cliente,telefono_cliente,corrreo_cliente) values (?,?,?,?,?,?,?)");
            st.setString(1, primernombre_clientes);
            st.setString(2, segundonombre_clientes);
            st.setString(3, primerapellido_cliente);
            st.setString(4, segundoapellido_cliente);
            st.setString(5, direccion_cliente);
            st.setString(6, telefono_cliente);
            st.setString(7, correo_cliente);
            st.execute();
            estado = 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }

    public int Borrarproveedor(int id_proveedor) {
        int estado;
        try {
            PreparedStatement st = contacto.prepareStatement("delete from Proveedor where id_proveedor = ?");

            st.setInt(1, id_proveedor);
            st.executeUpdate();

            st.execute();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }

    public int Actualizarcliente(int id_cliente, String primernombre_clientes, String segundonombre_clientes, String primerapellido_cliente,
            String segundoapellido_cliente, String direccion_cliente, String telefono_cliente, String correo_cliente) {
        int estado;

        try {
            PreparedStatement st = contacto.prepareStatement(" Update Cliente (primernombre_cliente,segundonombre_cliente,primerapellido_cliente,segundoapellido_cliente,direccion_cliente,telefono_cliente,corrreo_cliente) values (?,?,?,?,?,?,?)");
            st.setInt(1, id_cliente);
            st.setString(1, primernombre_clientes);
            st.setString(2, segundonombre_clientes);
            st.setString(3, primerapellido_cliente);
            st.setString(4, segundoapellido_cliente);
            st.setString(5, direccion_cliente);
            st.setString(6, telefono_cliente);
            st.setString(7, correo_cliente);
            st.execute();
            estado = 1;

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }
/////////BORRAR PROVEEDOR

    public int Borrarcliente(int id_cliente) {
        int estado;
        try {
            PreparedStatement st = contacto.prepareStatement("delete from Cliente where id_cliente = ?");

            st.setInt(1, id_cliente);
            st.executeUpdate();

            st.execute();
            estado = 1;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            estado = 0;
        }

        return estado;
    }

}
