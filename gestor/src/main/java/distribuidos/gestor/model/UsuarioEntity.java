 
package distribuidos.gestor.model;

import javax.persistence.Entity;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Administrador")
 public class UsuarioEntity {


    private String usuario;
    private String nombre;
    private String apellido;
    private String contraseña;
    private String email;
    private String telefono;

}