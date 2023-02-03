/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distribuidos.gestor.controller;

import distribuidos.gestor.model.AdministradorDTO;
import distribuidos.gestor.model.ProductoDTO;
import distribuidos.gestor.model.UsuarioDTO;
import distribuidos.gestor.services.IGestorServices;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author fabian
 */
@RestController
@RequestMapping("/api")
public class ClientRestController {

    @Autowired
    private IGestorServices gestorService;

    @GetMapping("/productos")
    public List<ProductoDTO> index() {
        return gestorService.findAll();
    }

    @GetMapping("/productos/{codigo}")
    public ProductoDTO show(@PathVariable Integer codigo) {
        ProductoDTO objProdu = null;
        objProdu = gestorService.detalles(codigo);
        return objProdu;
    }

    @PostMapping("/login")
    public AdministradorDTO login(@RequestBody AdministradorDTO login) {
        AdministradorDTO objAdmin = null;
        objAdmin = gestorService.IniciarSesion(login);
        return objAdmin;
    }

    @PostMapping("/administrador")
    public AdministradorDTO create(@RequestBody AdministradorDTO administrador) {
        AdministradorDTO objAdmin = null;
        objAdmin = gestorService.registrarAdmin(administrador);
        return objAdmin;
    }
    
    @PostMapping("/usuario")
    public UsuarioDTO create(@RequestBody UsuarioDTO usuario) {
        UsuarioDTO objUsua = null;
        objUsua = gestorService.registrarUsuario(usuario);
        return objUsua;
    }
    
    @PostMapping("/producto")
    public ProductoDTO create(@RequestBody ProductoDTO producto) {
        ProductoDTO objProd = null;
        objProd = gestorService.registrarProducto(producto);
        return objProd;
    }
}
