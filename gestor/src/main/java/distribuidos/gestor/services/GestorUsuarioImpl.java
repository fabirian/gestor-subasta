/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distribuidos.gestor.services;

import distribuidos.gestor.model.ProductoEntity;
import distribuidos.gestor.model.UsuarioEntity;
import distribuidos.gestor.repositories.AdminRepository;
import distribuidos.gestor.repositories.UsuarioRepository;
import distribuidos.gestor.services.DTO.ProductoDTO;
import distribuidos.gestor.services.DTO.UsuarioDTO;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rivera
 */
@Service
public class GestorUsuarioImpl implements IGestorUsuario{
    @Autowired
    private UsuarioRepository servicioAccesoBaseDatos;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO usuario) {
        UsuarioEntity usuEn = this.modelMapper.map(usuario, UsuarioEntity.class);
        UsuarioEntity objUsu = this.servicioAccesoBaseDatos.registrarUsuario(usuEn);
        UsuarioDTO usu = this.modelMapper.map(objUsu, UsuarioDTO.class);
        return usu;
    }

    @Override
    public List<ProductoDTO> findAll() {
        Iterable<ProductoEntity> prodEnti = this.servicioAccesoBaseDatos.findAll();
        List<ProductoDTO> prodDTO = this.modelMapper.map(prodEnti, new TypeToken<List<ProductoDTO>>() {
        }.getType());
        return prodDTO;
    }

    @Override
    public ProductoDTO detallesProdcuto(String nombre) {
        ProductoEntity objPrd = this.servicioAccesoBaseDatos.detalles(nombre);
        ProductoDTO proDTO = this.modelMapper.map(objPrd, ProductoDTO.class);
        return proDTO;
    }

    @Override
    public UsuarioDTO IniciarSesion(UsuarioDTO login) {
        UsuarioEntity cliente = this.modelMapper.map(login, UsuarioEntity.class);
        UsuarioEntity objCliente = this.servicioAccesoBaseDatos.IniciarSesion(cliente);
        UsuarioDTO objUsuario = this.modelMapper.map(objCliente, UsuarioDTO.class);
        return objUsuario;
    }

    @Override
    public List<UsuarioDTO> findUsuario() {
        List<UsuarioEntity> clientList = this.servicioAccesoBaseDatos.findUsu();
        List<UsuarioDTO> clientDTO = this.modelMapper.map(clientList, new TypeToken<List<UsuarioDTO>>() {
        }.getType());
        return clientDTO;
    }

    @Override
    public ProductoDTO cambiarEstadoSubasta(Integer codigo, String estado) {
        ProductoEntity objPrd = this.servicioAccesoBaseDatos.cambiarEstadoSubasta(codigo, estado);
        ProductoDTO proDTO = this.modelMapper.map(objPrd, ProductoDTO.class);
        return proDTO;
    }  
    
}
