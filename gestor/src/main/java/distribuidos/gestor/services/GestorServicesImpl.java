/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distribuidos.gestor.services;


import distribuidos.gestor.model.AdministradorEntity;
import distribuidos.gestor.model.ProductoEntity;
import distribuidos.gestor.model.UsuarioEntity;
import distribuidos.gestor.repositories.UsuarioRepository;
import distribuidos.gestor.services.DTO.AdministradorDTO;
import distribuidos.gestor.services.DTO.ProductoDTO;
import distribuidos.gestor.services.DTO.UsuarioDTO;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
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

    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public AdministradorDTO registrarAdmin(AdministradorDTO administrador) {
        AdministradorEntity adminEnti = this.modelMapper.map(administrador, AdministradorEntity.class);
        AdministradorEntity objAdmin = this.servicioAccesoBaseDatos.registrarAdministrador(adminEnti);
        AdministradorDTO admin = this.modelMapper.map(objAdmin, AdministradorDTO.class);
        return admin;
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuario) {
       UsuarioEntity usuEn = this.modelMapper.map(usuario, UsuarioEntity.class);
       UsuarioEntity objUsu = this.servicioAccesoBaseDatos.registrarUsuario(usuEn);
       UsuarioDTO usu = this.modelMapper.map(objUsu, UsuarioDTO.class);
       return usu;
    }

    @Override
    public ProductoDTO registrarProducto(ProductoDTO producto) {
        ProductoEntity prod = this.modelMapper.map(producto, ProductoEntity.class);
        ProductoEntity objProd =this.servicioAccesoBaseDatos.registrarProducto(prod);
        ProductoDTO produc = this.modelMapper.map(objProd, ProductoDTO.class);
        return produc;
    }

    @Override
    public List<ProductoDTO> findAll() {
        Iterable<ProductoEntity> prodEnti = this.servicioAccesoBaseDatos.findAll();
        List<ProductoDTO> prodDTO = this.modelMapper.map(prodEnti, new TypeToken<List<ProductoDTO>>(){}.getType());
        return prodDTO;
    }

    @Override
    public ProductoDTO detalles(Integer codigo) {
        ProductoEntity objPrd = this.servicioAccesoBaseDatos.detalles(codigo);
        ProductoDTO proDTO = this.modelMapper.map(objPrd, ProductoDTO.class);
        return proDTO;
    }

    @Override
    public AdministradorDTO IniciarSesion(AdministradorDTO login) {
        AdministradorEntity admin = this.modelMapper.map(login, AdministradorEntity.class);
        AdministradorEntity objAdmin = this.servicioAccesoBaseDatos.IniciarSesion(admin);
        AdministradorDTO adminDTO = this.modelMapper.map(objAdmin, AdministradorDTO.class);
        return adminDTO;
    }

    @Override
    public List<AdministradorDTO> findAdmin() {
        List<AdministradorEntity> adminList = this.servicioAccesoBaseDatos.findAdmin();
        List<AdministradorDTO> adminDTO = this.modelMapper.map(adminList, new TypeToken<List<AdministradorDTO>>(){}.getType());
        return adminDTO;
    }

    
}
