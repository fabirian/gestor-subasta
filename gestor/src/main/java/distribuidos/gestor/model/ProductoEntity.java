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
@Table(name = "Producto")
public class ProductoEntity {

    private int codigo;
    private String nombre;
    private int valorInicial;  
    private boolean estado;
 }
