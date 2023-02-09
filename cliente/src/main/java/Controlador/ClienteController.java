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

import Modelo.UsuarioDTO;
import Modelo.ProductoDTO;
import java.util.List;

public class ClienteController {

    private final String endPoint;
    private final String endPointLogin;
    private final String endPointPro;
    private final Client objClientPeticiones;

    public ClienteController() {
        this.endPoint = "http://localhost:8080/apiUser/usuario";
        this.endPointLogin = "http://localhost:8080/apiUser/login";
        this.endPointPro = "http://localhost:8080/api/producto";
        this.objClientPeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

        public List<ProductoDTO> listarProductos() {
        List<ProductoDTO> listaProdu = null;

        WebTarget target = this.objClientPeticiones.target(this.endPointPro +"/lista");

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON);

        listaProdu = objPeticion.get(new GenericType<List<ProductoDTO>>(){});

        return listaProdu;
    }

    public ProductoDTO registrarProducto(UsuarioDTO objAdmin) {
        ProductoDTO objProd = null;

        WebTarget target = this.objClientPeticiones.target(this.endPointPro + "/registrar");

        Entity<ProductoDTO> data = Entity.entity(objProd, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objProd = objPeticion.post(data, ProductoDTO.class);

        return objProd;
    }
    
    public UsuarioDTO registrarCliente(UsuarioDTO objCliente) {
        UsuarioDTO objClientes = null;

        WebTarget target = this.objClientPeticiones.target(this.endPoint);

        Entity<UsuarioDTO> data = Entity.entity(objCliente, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objClientes = objPeticion.post(data, UsuarioDTO.class);

        return objClientes;
    }
    
    public UsuarioDTO IniciarSesion(UsuarioDTO objClient) {
        
        UsuarioDTO objClientes = null;

        WebTarget target = this.objClientPeticiones.target(this.endPointLogin);

        Entity<UsuarioDTO> data = Entity.entity(objClient, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request();

        objClientes = objPeticion.post(data, UsuarioDTO.class);

        return objClientes;
    }
    
    public ProductoDTO DetallesProducto(String nombre) {
        ProductoDTO objProd = null;

        WebTarget target = this.objClientPeticiones.target(this.endPointPro +"/detalles/"+ nombre );

        Entity<ProductoDTO> data = Entity.entity(objProd, MediaType.APPLICATION_JSON_TYPE);

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objProd = objPeticion.get(new GenericType<ProductoDTO>(){});

        return objProd;
    }
}
