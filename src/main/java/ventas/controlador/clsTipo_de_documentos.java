/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas.controlador;



/**
 *
 * @author visitante
 */
public class clsTipo_de_documentos {
    //declaracion de variable para Vendedores 
    int iId_documento;
    String sMaterial;
    String sTipo;
    String sVista;
    String sUso;

    public clsTipo_de_documentos() {
    }

    public clsTipo_de_documentos(int iId_documento) {
    this.iId_documento = iId_documento;
    }

     public clsTipo_de_documentos(String sMaterial, String sTipo, String sVista, String sUso,int iId_documento) {
        this.iId_documento = iId_documento;
        this.sMaterial = sMaterial;
        this.sTipo = sTipo;
        this.sVista = sVista;
        this.sUso = sUso;
    }



public int fGetid_Documentos() {
        return iId_documento;
    }

    public void fSetid_Documentos(int iId_documento) {
        this.iId_documento = iId_documento;
    }


    public String fGetmaterial_Documentos() {
        return sMaterial;
    }

    public void fSetmaterial_Documentos(String sMaterial) {
        this.sMaterial = sMaterial;
    }

    public String fGettipo_Documentos() {
        return sTipo;
    }

    public void fSettipo_Documentos(String sTipo) {
        this.sTipo = sTipo;
    }

public String fGetvista_Documentos() {
        return sVista;
    }

    public void fSetvista_Documentos(String sVista) {
        this.sVista = sVista;
    }


    public String fGetuso_Documentos() {
        return sUso;
    }

    public void fSetuso_Documentos(String sUso) {
        this.sUso = sUso;
    }

   

 



    @Override
    public String toString() {
         return "tbl_tipo_de_documentos{" + "Id_documento =" + iId_documento + ", Material=" + sMaterial + ", Tipo=" + sTipo + ", Vista=" + sVista +", Uso=" + sUso + '}';
    }
    
}
