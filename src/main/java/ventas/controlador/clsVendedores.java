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
public class clsVendedores {
    //declaracion de variable para Vendedores 
    int iId_vendedor;
    int iTelefono;
    String sNombre;
    String sDireccion;
    String sCorreo;
    String sEstado;
    String sTipo;

    public clsVendedores() {
    }

    public clsVendedores(int iId_vendedor) {
    this.iId_vendedor = iId_vendedor;
    }

     public clsVendedores(String sNombre, String sDireccion, String sCorreo, String sEstado, String sTipo, int iId_vendedor,  int iTelefono) {
        this.iId_vendedor = iId_vendedor;
        this.iTelefono = iTelefono;
        this.sNombre = sNombre;
        this.sDireccion = sDireccion;
        this.sCorreo = sCorreo;
        this.sEstado = sEstado;
        this.sTipo = sTipo;
    }



public int fGetid_Vendedores() {
        return iId_vendedor;
    }

    public void fSetid_Vendedores(int iId_vendedor) {
        this.iId_vendedor = iId_vendedor;
    }


    public String fGetnombre_Vendedores() {
        return sNombre;
    }

    public void fSetnombre_Vendedores(String sNombre) {
        this.sNombre = sNombre;
    }

    public String fGetdireccion_Vendedores() {
        return sDireccion;
    }

    public void fSetdireccion_Vendedores(String sDireccion) {
        this.sDireccion = sDireccion;
    }

public int fGettelefono_Vendedores() {
        return iTelefono;
    }

    public void fSettelefono_Vendedores(int iTelefono) {
        this.iTelefono = iTelefono;
    }


    public String fGetcorreo_Vendedores() {
        return sCorreo;
    }

    public void fSetcorreo_Vendedores(String sCorreo) {
        this.sCorreo = sCorreo;
    }

    public String fGetestado_Vendedores() {
        return sEstado;
    }

    public void fSetestado_Vendedores(String sEstado) {
        this.sEstado = sEstado;
    }

    public String fGettipo_Vendedores() {
        return sTipo;
    }

    public void fSettipo_Vendedores(String sTipo) {
        this.sTipo = sTipo;
    }

 



    @Override
    public String toString() {
         return "tbl_vendedores{" + "Id_vendedor =" + iId_vendedor + ", Nombre=" + sNombre + ", Direccion=" + sDireccion + ", Telefono=" + iTelefono +", Correo=" + sCorreo +", Estado=" + sEstado +", Tipo=" + sTipo + '}';
    }
    
}
