/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import ventas.controlador.clsCobradores;
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
public class daoCobradores {

    private static final String SQL_SELECT = "SELECT Id_cobrador, Nombre, Direccion, Telefono, Correo, Estado, Tipo FROM tbl_cobradores";
    private static final String SQL_INSERT = "INSERT INTO tbl_cobradores(Nombre, Direccion, Telefono, Correo, Estado, Tipo) VALUES(?, ?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_cobradores SET Nombre=?, Direccion=?, Telefono=?, Correo=?, Estado=?, AND Tipo=? WHERE Id_cobrador = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_cobradores WHERE Id_cobrador=?";
    private static final String SQL_QUERY = "SELECT Id_cobrador, Nombre, Direccion, Telefono, Correo, Estado, Tipo FROM tbl_cobradores WHERE Id_cobrador = ?";


    public List<clsCobradores> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsCobradores cobrador = null;
        List<clsCobradores> cobradores = new ArrayList<clsCobradores>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_cobrador = rs.getInt("Id_cobrador");
                String sNombre = rs.getString("Nombre");
                String sDireccion = rs.getString("Direccion");
                int iTelefono = rs.getInt("Telefono");
                String sCorreo = rs.getString("Correo");
                String sEstado = rs.getString("Estado");
                String sTipo = rs.getString("Tipo");

                cobrador = new clsCobradores();
                cobrador.fSetid_Cobradores(iId_cobrador);
                cobrador.fSetnombre_Cobradores(sNombre);
                cobrador.fSetdireccion_Cobradores(sDireccion);
                cobrador.fSettelefono_Cobradores(iTelefono);
                cobrador.fSetcorreo_Cobradores(sCorreo);
                cobrador.fSetestado_Cobradores(sEstado);
                cobrador.fSettipo_Cobradores(sTipo);
                
                cobradores.add(cobrador);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return cobradores;
    }

    public int insert(clsCobradores cobrador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cobrador.fGetnombre_Cobradores());
            stmt.setString(2, cobrador.fGetdireccion_Cobradores());
            stmt.setInt(3, cobrador.fGettelefono_Cobradores());
            stmt.setString(4, cobrador.fGetcorreo_Cobradores());
            stmt.setString(5, cobrador.fGetestado_Cobradores());
            stmt.setString(6, cobrador.fGettipo_Cobradores());


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

    public int update(clsCobradores cobrador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cobrador.fGetnombre_Cobradores());
            stmt.setString(2, cobrador.fGetdireccion_Cobradores());
            stmt.setInt(3, cobrador.fGettelefono_Cobradores());
            stmt.setString(4, cobrador.fGetcorreo_Cobradores());
            stmt.setString(5, cobrador.fGetestado_Cobradores());
            stmt.setString(6, cobrador.fGettipo_Cobradores());

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

    public int delete(clsCobradores cobrador) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cobrador.fGetid_Cobradores());
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
    public clsCobradores query(clsCobradores cobrador) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsCobradores> cobradores = new ArrayList<clsCobradores>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, cobrador.fGetid_Cobradores());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_cobrador = rs.getInt("Id_cobrador");
                String sNombre = rs.getString("Nombre");
                String sDireccion = rs.getString("Direccion");
                int iTelefono = rs.getInt("Telefono");
                String sCorreo = rs.getString("Correo");
                String sEstado = rs.getString("Estado");
                String sTipo = rs.getString("Tipo");
                
                cobrador = new clsCobradores();
                cobrador.fSetid_Cobradores(iId_cobrador);
                cobrador.fSetnombre_Cobradores(sNombre);
                cobrador.fSetdireccion_Cobradores(sDireccion);
                cobrador.fSettelefono_Cobradores(iTelefono);
                cobrador.fSetcorreo_Cobradores(sCorreo);
                cobrador.fSetestado_Cobradores(sEstado);
                cobrador.fSettipo_Cobradores(sTipo);
                
                //cobradores.add(cobrador); // Si se utiliza un ArrayList
            }
            //System.out.println("Registros buscado:" + cobrador);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        //return cobradores;  // Si se utiliza un ArrayList
        return cobrador;
    }
   
}
