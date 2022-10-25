/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.modelo;

import ventas.controlador.clsTipo_de_documentos;
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
public class daoTipo_de_documentos {

    private static final String SQL_SELECT = "SELECT Id_documento, Material, Tipo, Vista, Uso FROM tbl_tipo_de_documentos";
    private static final String SQL_INSERT = "INSERT INTO tbl_tipo_de_documentos(Material, Tipo, Vista, Uso) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE tbl_tipo_de_documentos SET Material=?, Tipo=?, Vista=?, Uso=? WHERE Id_documento = ?";
    private static final String SQL_DELETE = "DELETE FROM tbl_tipo_de_documentos WHERE Id_documento=?";
    private static final String SQL_QUERY = "SELECT Id_documento, Material, Tipo, Vista, Uso FROM tbl_tipo_de_documentos WHERE Id_documento = ?";


    public List<clsTipo_de_documentos> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clsTipo_de_documentos documento = null;
        List<clsTipo_de_documentos> documentos = new ArrayList<clsTipo_de_documentos>();

        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_documento = rs.getInt("Id_documento");
                String sMaterial = rs.getString("Material");
                String sTipo = rs.getString("Tipo");
                String sVista = rs.getString("Vista");
                String sUso = rs.getString("Uso");

                documento = new clsTipo_de_documentos();
                documento.fSetid_Documentos(iId_documento);
                documento.fSetmaterial_Documentos(sMaterial);
                documento.fSettipo_Documentos(sTipo);
                documento.fSetvista_Documentos(sVista);
                documento.fSetuso_Documentos(sUso);

                
                documentos.add(documento);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            clsConexion.close(rs);
            clsConexion.close(stmt);
            clsConexion.close(conn);
        }

        return documentos;
    }

    public int insert(clsTipo_de_documentos documento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = clsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, documento.fGetmaterial_Documentos());
            stmt.setString(2, documento.fGettipo_Documentos());
            stmt.setString(3, documento.fGetvista_Documentos());
            stmt.setString(4, documento.fGetuso_Documentos());


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

    public int update(clsTipo_de_documentos documento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, documento.fGetmaterial_Documentos());
            stmt.setString(2, documento.fGettipo_Documentos());
            stmt.setString(3, documento.fGetvista_Documentos());
            stmt.setString(4, documento.fGetuso_Documentos());

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

    public int delete(clsTipo_de_documentos documento) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, documento.fGetid_Documentos());
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
    public clsTipo_de_documentos query(clsTipo_de_documentos documento) {    
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<clsTipo_de_documentos> vendedores = new ArrayList<clsTipo_de_documentos>();
        int rows = 0;

        try {
            conn = clsConexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_QUERY);
            stmt = conn.prepareStatement(SQL_QUERY);
            stmt.setInt(1, documento.fGetid_Documentos());
            rs = stmt.executeQuery();
            while (rs.next()) {
                int iId_documento = rs.getInt("Id_documento");
                String sMaterial = rs.getString("Material");
                String sTipo = rs.getString("Tipo");
                String sVista = rs.getString("Vista");
                String sUso = rs.getString("Uso");

                documento = new clsTipo_de_documentos();
                documento.fSetid_Documentos(iId_documento);
                documento.fSetmaterial_Documentos(sMaterial);
                documento.fSettipo_Documentos(sTipo);
                documento.fSetvista_Documentos(sVista);
                documento.fSetuso_Documentos(sUso);
                
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
        return documento;
    }
   
}
