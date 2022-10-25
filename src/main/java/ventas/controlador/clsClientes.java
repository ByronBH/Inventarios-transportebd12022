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
public class clsClientes {
    //declaracion de variable para Vendedores 
    int iId_cliente;
    int iTelefono;
    int iId_vendedor;
    int iId_cobrador;
    int iId_documento;
    String sNombre;
    String sDireccion;
    String sCorreo;
    String sEstado;
    String sTipo;

    public clsClientes() {
    }

    public clsClientes(int iId_cliente) {
    this.iId_cliente = iId_cliente;
    }

     public clsClientes(String sNombre, String sDireccion, String sCorreo, String sEstado, String sTipo, int iId_cliente,  int iTelefono, int iId_vendedor, int iId_cobrador,int iId_documento ) {
        this.iId_cliente = iId_cliente;
        this.iTelefono = iTelefono;
        this.iId_vendedor = iId_vendedor;
        this.iId_cobrador = iId_cobrador;
        this.iId_documento = iId_documento;
        this.sNombre = sNombre;
        this.sDireccion = sDireccion;
        this.sCorreo = sCorreo;
        this.sEstado = sEstado;
        this.sTipo = sTipo;
        
    }



public int fGetid_Clientes() {
        return iId_cliente;
    }

    public void fSetid_Clientes(int iId_cliente) {
        this.iId_cliente = iId_cliente;
    }


    public String fGetnombre_Clientes() {
        return sNombre;
    }

    public void fSetnombre_Clientes(String sNombre) {
        this.sNombre = sNombre;
    }

    public String fGetdireccion_Clientes() {
        return sDireccion;
    }

    public void fSetdireccion_Clientes(String sDireccion) {
        this.sDireccion = sDireccion;
    }

public int fGettelefono_Clientes() {
        return iTelefono;
    }

    public void fSettelefono_Clientes(int iTelefono) {
        this.iTelefono = iTelefono;
    }


    public String fGetcorreo_Clientes() {
        return sCorreo;
    }

    public void fSetcorreo_Clientes(String sCorreo) {
        this.sCorreo = sCorreo;
    }

    public String fGetestado_Clientes() {
        return sEstado;
    }

    public void fSetestado_Clientes(String sEstado) {
        this.sEstado = sEstado;
    }

    public String fGettipo_Clientes() {
        return sTipo;
    }

    public void fSettipo_Clientes(String sTipo) {
        this.sTipo = sTipo;
    }

    public int fGetid_Vendedor() {
        return iId_vendedor;
    }

    public void fSetid_Vendedor(int iId_vendedor) {
        this.iId_vendedor = iId_vendedor;
    }

    
    public int fGetid_Cobrador() {
        return iId_cobrador;
    }

    public void fSetid_Cobrador(int iId_cobrador) {
        this.iId_cobrador = iId_cobrador;
    }
    
    
    
    public int fGetid_Documento() {
        return iId_documento;
    }

    public void fSetid_Documento(int iId_documento) {
        this.iId_documento = iId_documento;
    }



    @Override
    public String toString() {
         return "tbl_clientes{" + "Id_cliente =" + iId_cliente + ", Nombre=" + sNombre + ", Direccion=" + sDireccion + ", Telefono=" + iTelefono +", Correo=" + sCorreo +", Estado=" + sEstado +", Tipo=" + sTipo +", Id_vendedor=" + iId_vendedor +", Id_cobrador=" + iId_cobrador +", Id_documento=" + iId_documento +'}';
    }
    
}
