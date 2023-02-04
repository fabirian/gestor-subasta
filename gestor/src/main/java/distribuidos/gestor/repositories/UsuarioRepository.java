/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distribuidos.gestor.repositories;

/**
 *
 * @author fabian
 */

import org.springframework.stereotype.Service;

import distribuidos.gestor.services.DTO.AdministradorDTO;
import distribuidos.gestor.services.DTO.ProductoDTO;
import distribuidos.gestor.services.DTO.UsuarioDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioRepository {
    private ArrayList<ProductoDTO> listaProducto;
    private ArrayList<AdministradorDTO> listaAdministrador;
    private ArrayList<UsuarioDTO> listaUsuarios;

    public UsuarioRepository(ArrayList<ProductoDTO> listaProducto, ArrayList<AdministradorDTO> listaAdministrador, ArrayList<UsuarioDTO> listaUsuarios) {
        this.listaProducto = listaProducto;
        this.listaAdministrador = listaAdministrador;
        this.listaUsuarios = listaUsuarios;
    }
    
    public AdministradorDTO registrarAdministrador(AdministradorDTO administrador){
        System.out.println("Invocando a registrar admin");
        AdministradorDTO objAdmin = null;
        if(this.listaAdministrador.add(administrador)){
            objAdmin = administrador;
        }
        return objAdmin;
    }
    
    public UsuarioDTO registrarUsuario(UsuarioDTO usuario){
        UsuarioDTO objUsu = null;
        if(this.listaUsuarios.add(usuario)){
            objUsu = usuario;
        }
        return objUsu;
    }
    
    public ProductoDTO registrarProducto(ProductoDTO producto){
        ProductoDTO objPro = null;
        if(this.listaProducto.add(producto)){
            objPro = producto;
        }
        return objPro;
    }
    
    public List<ProductoDTO> findAll(){
        return this.listaProducto;
    }

    public List<AdministradorDTO> findAdmin(){
        return this.listaAdministrador;
    }

    public List<UsuarioDTO> findUsu(){
        return this.listaUsuarios;
    }
    
    public ProductoDTO detalles(Integer codigo){
        ProductoDTO objProducto = null;
        
        for(ProductoDTO producto: listaProducto){
            if(producto.getCodigo()==codigo){
                objProducto = producto;
                break;
            }
        }
        return objProducto;
    }

    public AdministradorDTO IniciarSesion(AdministradorDTO login){
        System.out.println("Invocando a iniciar sesion");
      AdministradorDTO objAdmins = null;  
        List<AdministradorDTO> listAdmin = findAdmin();
        for(AdministradorDTO admin : listAdmin){
            if(admin.getUsuario().equals(login.getUsuario())&&admin.getContraseña().equals(login.getContraseña())){
                objAdmins = admin;
                return objAdmins;
            }
        }
        return objAdmins;
    }

    
}
