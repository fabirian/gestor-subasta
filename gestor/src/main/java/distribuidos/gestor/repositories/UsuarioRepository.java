/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distribuidos.gestor.repositories;

/**
 *
 * @author Rivera
 */

import distribuidos.gestor.model.ProductoEntity;
import distribuidos.gestor.model.UsuarioEntity;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UsuarioRepository {
    
    private ArrayList<ProductoEntity> listaProducto;
    private ArrayList<UsuarioEntity> listaUsuarios;

    public UsuarioRepository(ArrayList<ProductoEntity> listaProducto, ArrayList<UsuarioEntity> listaUsuarios) {
        this.listaProducto = new ArrayList<ProductoEntity>();
        this.listaUsuarios = new ArrayList<UsuarioEntity>();
    }

    public UsuarioEntity registrarUsuario(UsuarioEntity usuario) {
        System.out.println("Invocando registrar usuario");
        UsuarioEntity objUsu = null;
        if (this.listaUsuarios.add(usuario)) {
            objUsu = usuario;
        }
        return objUsu;
    }

    public List<ProductoEntity> findAll() {
        System.out.println("Invocando listar productos");
        return this.listaProducto;
    }

    public List<UsuarioEntity> findUsu() {
        return this.listaUsuarios;
    }

    public ProductoEntity detalles(String nombre) {
        System.out.println("Invocando a consultar producto");
        ProductoEntity objProducto = null;

        for (ProductoEntity producto : listaProducto) {
            if (producto.getNombre()== nombre) {
                objProducto = producto;
                break;
            }
        }
        return objProducto;
    }

    public UsuarioEntity IniciarSesion(UsuarioEntity login) {
        System.out.println("Invocando a iniciar sesion");
        UsuarioEntity objCliente = null;
        List<UsuarioEntity> listCliente = findUsu();
        for (UsuarioEntity client : listCliente) {
            if (client.getUsuario().equals(login.getUsuario()) && client.getContraseña().equals(login.getContraseña())) {
                objCliente = client;
                return objCliente;
            }
        }
        return objCliente;
    }

    

    public ProductoEntity cambiarEstadoSubasta(Integer codigo, String estado) {
        System.out.println("Invocando a cambiando el producto");
        ProductoEntity objProducto = null;

        for (ProductoEntity producto : listaProducto) {
            if (producto.getCodigo() == codigo) {
                if("Abierta".equals(estado))
                {
                    producto.setEstado(true);
                }else
                {
                    producto.setEstado(false);
                }
                objProducto = producto;
                break;
            }
        }
        return objProducto;
    }

    
}
