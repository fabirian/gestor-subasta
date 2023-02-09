
package distribuidos.gestor.services;

import distribuidos.gestor.services.DTO.ProductoDTO;
import distribuidos.gestor.services.DTO.UsuarioDTO;
import java.util.List;

/**
 *
 * @author Rivera
 */
public interface IGestorUsuario {
    public UsuarioDTO registrarUsuario(UsuarioDTO usuario);
    public List<ProductoDTO> findAll();
    public ProductoDTO detallesProdcuto(String nombre);
    public UsuarioDTO IniciarSesion(UsuarioDTO login);
    public List<UsuarioDTO> findUsuario();
    public ProductoDTO cambiarEstadoSubasta(Integer codigo, String estado);
}
