package Modelo;

/**
 *
 * @author fabian
 */
public class ProductoDTO {
    private int codigo;
    private String nombre;
    private int valorInicial;
    private boolean estado;

    public ProductoDTO() {
    }
    
    
    public ProductoDTO(int codigo, String nombre, int valorInicial, boolean estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.valorInicial = valorInicial;
        this.estado = estado;
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

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
