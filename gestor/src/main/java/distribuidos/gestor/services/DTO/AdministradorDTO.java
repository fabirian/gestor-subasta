/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distribuidos.gestor.services.DTO;


import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author fabian
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
public class AdministradorDTO {

    @NotNull
    @Size(min =10, max=20, message="El usuario debe tener un tamaño entre 10 y 20 caracteres")
    private String usuario;
    @NotNull
    @Size(min =5, max=50, message="El nombre debe tener un tamaño entre 5 y 50 caracteres")
    private String nombre;
    @NotNull
    @Size(min =5, max=50, message="El apellido debe tener un tamaño entre 5 y 50 caracteres")
    private String apellido;
    @NotNull
    @Size(min =10, max=20, message="La contraseña debe tener un tamaño entre 10 y 20 caracteres")
    private String contraseña;       
    
}
