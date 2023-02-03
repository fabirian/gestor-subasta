/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package distribuidos.gestor.services;


import java.util.List;

import distribuidos.gestor.services.DTO.AdministradorDTO;
import distribuidos.gestor.services.DTO.ProductoDTO;
import distribuidos.gestor.services.DTO.UsuarioDTO;

/**
 *
 * @author fabian
 */
public interface IGestorServices {
    public AdministradorDTO registrarAdmin(AdministradorDTO administrador);
    public UsuarioDTO registrarUsuario(UsuarioDTO usuario);
    public ProductoDTO registrarProducto(ProductoDTO producto);
    public List<ProductoDTO> findAll();
    public ProductoDTO detalles(Integer codigo);
    public Boolean IniciarSesion(AdministradorDTO login);
    public List<AdministradorDTO> findAdmin();
}
