/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distribuidos.gestor.services.DTO;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author fabian
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {

    private Integer id;
    @NotNull(message = "{user.name.empty}")
    @Size(min =10, max=20, message="El usuario debe tener un tamaño entre 10 y 20 caracteres")
    private String usuario;
    @NotNull(message = "{user.name.empty}")
    @Size(min =5, max=50, message="El nombre debe tener un tamaño entre 5 y 50 caracteres")
    private String nombre;
    @NotNull(message = "{user.lastname.emply}")
    @Size(min =5, max=50, message="El apellido debe tener un tamaño entre 5 y 50 caracteres")
    private String apellido;
    @NotNull(message = "user.password.emply")
    @Size(min =10, max=20, message="La contraseña debe tener un tamaño entre 10 y 20 caracteres")
    private String contraseña;    
    @NotNull(message = "{user.email.emply}")
	@Email(message = "{user.email.mask}")
    private String email;
    @Pattern(message = "{user.telephone.pattern}",regexp = "[5][0-9]{10}")
    private String telefono;

    private List<ProductoDTO> producto;
}
