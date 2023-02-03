/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distribuidos.gestor.model;

/**
 *
 * @author fabian
 */
public class ProductoDTO {
    private int codigo;
    private String nombre;
    private int valorInicial;

    public ProductoDTO(int codigo, String nombre, int valorInicial) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valorInicial = valorInicial;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }
    
    
}
