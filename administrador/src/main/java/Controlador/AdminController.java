/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author fabian
 */
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

import Modelo.AdministradorDTO;
import Modelo.ProductoDTO;
import java.util.List;

public class AdminController {

    private final String endPoint;
    private final String endPointLogin;
    private final String endPointPro;
    private final Client objAdminPeticiones;

    public AdminController() {
        this.endPoint = "http://localhost:8080/api/administrador";
        this.endPointLogin = "http://localhost:8080/api/login";
        this.endPointPro = "http://localhost:8080/api/producto";
        this.objAdminPeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public List<ProductoDTO> listarProductos() {
        List<ProductoDTO> listaProdu = null;

        WebTarget target = this.objAdminPeticiones.target(this.endPointPro + "/lista");

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);

        listaProdu = objPeticion.get(new GenericType<List<ProductoDTO>>() {
        });

        return listaProdu;
    }

    public ProductoDTO registrarProducto(ProductoDTO objAdmin) {
        ProductoDTO objProd = null;

        WebTarget target = this.objAdminPeticiones.target(this.endPointPro + "/registrar");

        Entity<ProductoDTO> data = Entity.entity(objAdmin, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objProd = objPeticion.post(data, ProductoDTO.class);

        return objProd;
    }

    public AdministradorDTO registrarAdmin(AdministradorDTO objAdmin) {
        AdministradorDTO objAdminis = null;

        WebTarget target = this.objAdminPeticiones.target(this.endPoint);

        Entity<AdministradorDTO> data = Entity.entity(objAdmin, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objAdminis = objPeticion.post(data, AdministradorDTO.class);

        return objAdminis;
    }

    public AdministradorDTO IniciarSesion(AdministradorDTO objAdmin) {

        AdministradorDTO objAdminis = null;

        WebTarget target = this.objAdminPeticiones.target(this.endPointLogin);

        Entity<AdministradorDTO> data = Entity.entity(objAdmin, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request();

        objAdminis = objPeticion.post(data, AdministradorDTO.class);

        return objAdminis;
    }

    public ProductoDTO cambiarEstadoSubasta(Integer codigoAcambiar, String abiertoCerrado) {
        ProductoDTO objProd = null;

        WebTarget target = this.objAdminPeticiones.target(this.endPointPro + "/estado/" + codigoAcambiar + "/" + abiertoCerrado);

        Entity<ProductoDTO> data = Entity.entity(objProd, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objProd = objPeticion.post(data, ProductoDTO.class);

        return objProd;
    }

}
