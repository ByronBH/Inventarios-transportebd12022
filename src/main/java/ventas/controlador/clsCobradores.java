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
public class clsCobradores {
    //declaracion de variable para Cobradores 
    int iId_cobrador;
    int iTelefono;
    String sNombre;
    String sDireccion;
    String sCorreo;
    String sEstado;
    String sTipo;

    public clsCobradores() {
    }

    public clsCobradores(int iId_cobrador) {
    this.iId_cobrador = iId_cobrador;
    }

     public clsCobradores(String sNombre, String sDireccion, String sCorreo, String sEstado, String sTipo, int iId_cobrador,  int iTelefono) {
        this.iId_cobrador = iId_cobrador;
        this.iTelefono = iTelefono;
        this.sNombre = sNombre;
        this.sDireccion = sDireccion;
        this.sCorreo = sCorreo;
        this.sEstado = sEstado;
        this.sTipo = sTipo;
    }



public int fGetid_Cobradores() {
        return iId_cobrador;
    }

    public void fSetid_Cobradores(int iId_cobrador) {
        this.iId_cobrador = iId_cobrador;
    }


    public String fGetnombre_Cobradores() {
        return sNombre;
    }

    public void fSetnombre_Cobradores(String sNombre) {
        this.sNombre = sNombre;
    }

    public String fGetdireccion_Cobradores() {
        return sDireccion;
    }

    public void fSetdireccion_Cobradores(String sDireccion) {
        this.sDireccion = sDireccion;
    }

public int fGettelefono_Cobradores() {
        return iTelefono;
    }

    public void fSettelefono_Cobradores(int iTelefono) {
        this.iTelefono = iTelefono;
    }


    public String fGetcorreo_Cobradores() {
        return sCorreo;
    }

    public void fSetcorreo_Cobradores(String sCorreo) {
        this.sCorreo = sCorreo;
    }

    public String fGetestado_Cobradores() {
        return sEstado;
    }

    public void fSetestado_Cobradores(String sEstado) {
        this.sEstado = sEstado;
    }

    public String fGettipo_Cobradores() {
        return sTipo;
    }

    public void fSettipo_Cobradores(String sTipo) {
        this.sTipo = sTipo;
    }

 



    @Override
    public String toString() {
         return "tbl_cobradores{" + "Id_cobrador =" + iId_cobrador + ", Nombre=" + sNombre + ", Direccion=" + sDireccion + ", Telefono=" + iTelefono +", Correo=" + sCorreo +", Estado=" + sEstado +", Tipo=" + sTipo + '}';
    }
    
}
