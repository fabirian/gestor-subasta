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

import distribuidos.gestor.model.AdministradorEntity;
import distribuidos.gestor.model.ProductoEntity;
import distribuidos.gestor.model.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioRepository {
    private ArrayList<ProductoEntity> listaProducto;
    private ArrayList<AdministradorEntity> listaAdministrador;
    private ArrayList<UsuarioEntity> listaUsuarios;

    public UsuarioRepository(ArrayList<ProductoEntity> listaProducto, ArrayList<AdministradorEntity> listaAdministrador, ArrayList<UsuarioEntity> listaUsuarios) {
        this.listaProducto = new ArrayList<ProductoEntity>();
        this.listaAdministrador = new ArrayList<AdministradorEntity>();
        this.listaUsuarios = new ArrayList<UsuarioEntity>();
        cargarProductos();
    }
    
    public AdministradorEntity registrarAdministrador(AdministradorEntity administrador){
        System.out.println("Invocando a registrar admin");
        AdministradorEntity objAdmin = null;
        if(this.listaAdministrador.add(administrador)){
            objAdmin = administrador;
        }
        return objAdmin;
    }
    
    public UsuarioEntity registrarUsuario(UsuarioEntity usuario){
        System.out.println("Invocando registrar usuario");
        UsuarioEntity objUsu = null;
        if(this.listaUsuarios.add(usuario)){
            objUsu = usuario;
        }
        return objUsu;
    }
    
    public ProductoEntity registrarProducto(ProductoEntity producto){
        System.out.println("Invocando registrar producto");
        ProductoEntity objPro = null;
        if(this.listaProducto.add(producto)){
            objPro = producto;
        }
        return objPro;
    }
    
    public List<ProductoEntity> findAll(){
            System.out.println("Invocando listar productos");
        return this.listaProducto;
    }

    public List<AdministradorEntity> findAdmin(){
        return this.listaAdministrador;
    }

    public List<UsuarioEntity> findUsu(){
        return this.listaUsuarios;
    }
    
    public ProductoEntity detalles(Integer codigo){
        System.out.println("Invocando a consultar producto");
        ProductoEntity objProducto = null;
        
        for(ProductoEntity producto: listaProducto){
            if(producto.getCodigo()==codigo){
                objProducto = producto;
                break;
            }
        }
        return objProducto;
    }

    public AdministradorEntity IniciarSesion(AdministradorEntity login){
        System.out.println("Invocando a iniciar sesion");
      AdministradorEntity objAdmins = null;  
        List<AdministradorEntity> listAdmin = findAdmin();
        for(AdministradorEntity admin : listAdmin){
            if(admin.getUsuario().equals(login.getUsuario())&&admin.getContraseña().equals(login.getContraseña())){
                objAdmins = admin;
                return objAdmins;
            }
        }
        return objAdmins;
    }

    private void cargarProductos(){
        ProductoEntity objProductoEntity1 = new ProductoEntity(12, "Mesa", 60000);
        this.listaProducto.add(objProductoEntity1);
    }
}
