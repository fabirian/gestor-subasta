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

    private String endPoint;
    private String endPointPro;
    private Client objAdminPeticiones;

    public AdminController() {
        this.endPoint = "http://localhost:8080/api/administrador";
        this.endPointPro = "http://localhost:8080/api/login";
        this.objAdminPeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public AdministradorDTO consultarCliente(Integer id) {
        AdministradorDTO objCliente = null;

        WebTarget target = this.objAdminPeticiones.target(this.endPoint + "/" + id);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objCliente = objPeticion.get(AdministradorDTO.class);

        return objCliente;
    }

    public List<ProductoDTO> listarProductos() {
        List<ProductoDTO> listaProdu = null;

        WebTarget target = this.objAdminPeticiones.target(this.endPoint);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);

        listaProdu = objPeticion.get(new GenericType<List<ProductoDTO>>() {
        });

        return listaProdu;
    }

    public AdministradorDTO registrarAdmin(AdministradorDTO objAdmin) {
        AdministradorDTO objAdminis = null;

        WebTarget target = this.objAdminPeticiones.target(this.endPoint);

        Entity<AdministradorDTO> data = Entity.entity(objAdmin, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objAdminis = objPeticion.post(data, AdministradorDTO.class);

        return objAdminis;
    }
    
    public Boolean IniciarSesion(String usuario, String contraseña) {
        boolean objAdminis = false;
        boolean obj;

        WebTarget target = this.objAdminPeticiones.target(this.endPoint + "/login" + usuario + contraseña);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objAdminis = Boolean.parseBoolean(objPeticion.toString());

        return objAdminis;
    }

}
