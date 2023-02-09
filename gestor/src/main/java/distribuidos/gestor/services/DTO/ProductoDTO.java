/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distribuidos.gestor.services.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author fabian
 */
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ProductoDTO {


    private int codigo;
    private String nombre;
    private int valorInicial;
    private boolean estado;
    
}
