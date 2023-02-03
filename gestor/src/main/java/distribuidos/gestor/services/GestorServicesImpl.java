/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distribuidos.gestor.services;

import distribuidos.gestor.model.AdministradorDTO;
import distribuidos.gestor.model.ProductoDTO;
import distribuidos.gestor.model.UsuarioDTO;
import distribuidos.gestor.repositories.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author fabian
 */
@Service
public class GestorServicesImpl implements IGestorServices{

    @Autowired
    private UsuarioRepository servicioAccesoBaseDatos;
    
    @Override
    public AdministradorDTO registrarAdmin(AdministradorDTO administrador) {
        return  this.servicioAccesoBaseDatos.registrarAdministrador(administrador);
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuario) {
       return this.servicioAccesoBaseDatos.registrarUsuario(usuario);
    }

    @Override
    public ProductoDTO registrarProducto(ProductoDTO producto) {
        return this.servicioAccesoBaseDatos.registrarProducto(producto);
    }

    @Override
    public List<ProductoDTO> findAll() {
        return this.servicioAccesoBaseDatos.findAll();
    }

    @Override
    public ProductoDTO detalles(Integer codigo) {
        return this.servicioAccesoBaseDatos.detalles(codigo);
    }

    @Override
    public AdministradorDTO IniciarSesion(AdministradorDTO login) {
        return this.servicioAccesoBaseDatos.IniciarSesion(login);
    }

    @Override
    public List<AdministradorDTO> findAdmin() {
        return this.servicioAccesoBaseDatos.findAdmin();
    }

    
}
