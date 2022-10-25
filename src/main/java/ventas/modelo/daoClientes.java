/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import ventas.controlador.clsClientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import seguridad.modelo.clsConexion;

/**
 *
 * @author visitante
 */
public class daoClientes {

    private static final String SQL_SELECT = "SELECT Id_cliente, Nombre, Direccion, Telefono, Correo, Estado, Tipo, Id_vendedor, Id_cobrador, Id_documento FROM tbl_clientes";
    private static final String SQL_INSERT = "INSERT INTO tbl_clientes(Nombre, Direccion, Telefono, Correo, Estado, Tipo, Id_vendedor, Id_cobrador, Id_documento) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_clientes SET Nombre=?, Direccion=?, Telefono=?, Correo=?, Estado=?, Tipo=? Id_vendedor=? Id_cobrador=? AND Id_documento=? WHERE Id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_clientes WHERE Id_cliente=?";
    private static final String SQL_QUERY = "SELECT Id_cliente, Nombre, Direccion, Telefono, Correo, Estado, Tipo, Id_vendedor, Id_cobrador, Id_documento FROM tbl_clientes WHERE Id_cliente = ?";


    public List<clsClientes> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsClientes cliente = null;
        List<clsClientes> clientes = new ArrayList<clsClientes>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_cliente = rs.getInt("Id_cliente");
                int iId_vendedor = rs.getInt("Id_vendedor");
                int iId_cobrador = rs.getInt("Id_cobrador");
                int iId_documento = rs.getInt("Id_documento");
                String sNombre = rs.getString("Nombre");
                String sDireccion = rs.getString("Direccion");
                int iTelefono = rs.getInt("Telefono");
                String sCorreo = rs.getString("Correo");
                String sEstado = rs.getString("Estado");
                String sTipo = rs.getString("Tipo");

                cliente = new clsClientes();
                cliente.fSetid_Clientes(iId_cliente);
                cliente.fSetid_Vendedor(iId_vendedor);
                cliente.fSetid_Cobrador(iId_cobrador);
                cliente.fSetid_Documento(iId_documento);
                cliente.fSetnombre_Clientes(sNombre);
                cliente.fSetdireccion_Clientes(sDireccion);
                cliente.fSettelefono_Clientes(iTelefono);
                cliente.fSetcorreo_Clientes(sCorreo);
                cliente.fSetestado_Clientes(sEstado);
                cliente.fSettipo_Clientes(sTipo);
                
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return clientes;
    }

    public int insert(clsClientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.fGetnombre_Clientes());
            stmt.setString(2, cliente.fGetdireccion_Clientes());
            stmt.setInt(3, cliente.fGettelefono_Clientes());
            stmt.setString(4, cliente.fGetcorreo_Clientes());
            stmt.setString(5, cliente.fGetestado_Clientes());
            stmt.setString(6, cliente.fGettipo_Clientes());
            stmt.setInt(7, cliente.fGetid_Vendedor());
            stmt.setInt(8, cliente.fGetid_Cobrador());
            stmt.setInt(9, cliente.fGetid_Documento());
            


            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int update(clsClientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cliente.fGetnombre_Clientes());
            stmt.setString(2, cliente.fGetdireccion_Clientes());
            stmt.setInt(3, cliente.fGettelefono_Clientes());
            stmt.setString(4, cliente.fGetcorreo_Clientes());
            stmt.setString(5, cliente.fGetestado_Clientes());
            stmt.setString(6, cliente.fGettipo_Clientes());
            stmt.setInt(7, cliente.fGetid_Vendedor());
            stmt.setInt(8, cliente.fGetid_Cobrador());
            stmt.setInt(9, cliente.fGetid_Documento());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

    public int delete(clsClientes cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.fGetid_Clientes());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return rows;
    }

//    public List<Persona> query(Persona vendedor) { // Si se utiliza un ArrayList
    public clsClientes query(clsClientes cliente) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsClientes> clientes = new ArrayList<clsClientes>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cliente.fGetid_Clientes());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_cliente = rs.getInt("Id_cliente");
                int iId_vendedor = rs.getInt("Id_vendedor");
                int iId_cobrador = rs.getInt("Id_cobrador");
                int iId_documento = rs.getInt("Id_documento");
                String sNombre = rs.getString("Nombre");
                String sDireccion = rs.getString("Direccion");
                int iTelefono = rs.getInt("Telefono");
                String sCorreo = rs.getString("Correo");
                String sEstado = rs.getString("Estado");
                String sTipo = rs.getString("Tipo");
                
                cliente = new clsClientes();
                cliente.fSetid_Clientes(iId_cliente);
                cliente.fSetid_Vendedor(iId_vendedor);
                cliente.fSetid_Cobrador(iId_cobrador);
                cliente.fSetid_Documento(iId_documento);
                cliente.fSetnombre_Clientes(sNombre);
                cliente.fSetdireccion_Clientes(sDireccion);
                cliente.fSettelefono_Clientes(iTelefono);
                cliente.fSetcorreo_Clientes(sCorreo);
                cliente.fSetestado_Clientes(sEstado);
                cliente.fSettipo_Clientes(sTipo);
                
                //vendedores.add(vendedor); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + vendedor);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return vendedores;  // Si se utiliza un ArrayList
        return cliente;
    }
   
}
