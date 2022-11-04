/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compras.modelo;

import ventas.controlador.clsVendedores;
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
public class daoCompradores {

    private static final String SQL_SELECT = "SELECT Id_vendedor, Nombre, Direccion, Telefono, Correo, Estado, Tipo FROM tbl_vendedores";
    private static final String SQL_INSERT = "INSERT INTO tbl_vendedores(Nombre, Direccion, Telefono, Correo, Estado, Tipo) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_vendedores SET Nombre=?, Direccion=?, Telefono=?, Correo=?, Estado=?, AND Tipo=? WHERE Id_vendedor = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_vendedores WHERE Id_vendedor=?";
    private static final String SQL_QUERY = "SELECT Id_vendedor, Nombre, Direccion, Telefono, Correo, Estado, Tipo FROM tbl_vendedores WHERE Id_vendedor = ?";


    public List<clsVendedores> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsVendedores vendedor = null;
        List<clsVendedores> vendedores = new ArrayList<clsVendedores>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_vendedor = rs.getInt("Id_vendedor");
                String sNombre = rs.getString("Nombre");
                String sDireccion = rs.getString("Direccion");
                int iTelefono = rs.getInt("Telefono");
                String sCorreo = rs.getString("Correo");
                String sEstado = rs.getString("Estado");
                String sTipo = rs.getString("Tipo");

                vendedor = new clsVendedores();
                vendedor.fSetid_Vendedores(iId_vendedor);
                vendedor.fSetnombre_Vendedores(sNombre);
                vendedor.fSetdireccion_Vendedores(sDireccion);
                vendedor.fSettelefono_Vendedores(iTelefono);
                vendedor.fSetcorreo_Vendedores(sCorreo);
                vendedor.fSetestado_Vendedores(sEstado);
                vendedor.fSettipo_Vendedores(sTipo);
                
                vendedores.add(vendedor);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return vendedores;
    }

    public int insert(clsVendedores vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, vendedor.fGetnombre_Vendedores());
            stmt.setString(2, vendedor.fGetdireccion_Vendedores());
            stmt.setInt(3, vendedor.fGettelefono_Vendedores());
            stmt.setString(4, vendedor.fGetcorreo_Vendedores());
            stmt.setString(5, vendedor.fGetestado_Vendedores());
            stmt.setString(6, vendedor.fGettipo_Vendedores());


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

    public int update(clsVendedores vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, vendedor.fGetnombre_Vendedores());
            stmt.setString(2, vendedor.fGetdireccion_Vendedores());
            stmt.setInt(3, vendedor.fGettelefono_Vendedores());
            stmt.setString(4, vendedor.fGetcorreo_Vendedores());
            stmt.setString(5, vendedor.fGetestado_Vendedores());
            stmt.setString(6, vendedor.fGettipo_Vendedores());

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

    public int delete(clsVendedores vendedor) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, vendedor.fGetid_Vendedores());
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
    public clsVendedores query(clsVendedores vendedor) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsVendedores> vendedores = new ArrayList<clsVendedores>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, vendedor.fGetid_Vendedores());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_vendedor = rs.getInt("Id_vendedor");
                String sNombre = rs.getString("Nombre");
                String sDireccion = rs.getString("Direccion");
                int iTelefono = rs.getInt("Telefono");
                String sCorreo = rs.getString("Correo");
                String sEstado = rs.getString("Estado");
                String sTipo = rs.getString("Tipo");
                
                vendedor = new clsVendedores();
                vendedor.fSetid_Vendedores(iId_vendedor);
                vendedor.fSetnombre_Vendedores(sNombre);
                vendedor.fSetdireccion_Vendedores(sDireccion);
                vendedor.fSettelefono_Vendedores(iTelefono);
                vendedor.fSetcorreo_Vendedores(sCorreo);
                vendedor.fSetestado_Vendedores(sEstado);
                vendedor.fSettipo_Vendedores(sTipo);
                
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
        return vendedor;
    }
   
}
