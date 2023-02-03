package Vista;

import Controlador.AdminController;
import Modelo.AdministradorDTO;

/**
 *
 * @author fabian
 */
public class Administrador {

    public static void main(String[] args) {
        
        AdminController objAdminServices= new AdminController();
        
        System.out.println("\n registrando un administrador");
        AdministradorDTO objAdmin = new AdministradorDTO();
        objAdmin.setUsuario("fsfs");
        objAdmin.setNombre("andrea");
        objAdmin.setApellido("perez");
        objAdmin.setContraseña("fdfdf");
        AdministradorDTO objAdminRegister = objAdminServices.registrarAdmin(objAdmin);
    }
}
