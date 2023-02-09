/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distribuidos.gestor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import distribuidos.gestor.services.IGestorServices;
import distribuidos.gestor.services.DTO.AdministradorDTO;
import distribuidos.gestor.services.DTO.ProductoDTO;
import distribuidos.gestor.services.DTO.UsuarioDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author fabian
 */
@RestController
@RequestMapping("/api")
public class AdminRestController {

    @Autowired
    private IGestorServices gestorService;

    @GetMapping("/producto/lista")
    public List<ProductoDTO> index() {
        return gestorService.findAll();
    }

    @GetMapping("/producto/detalles/{nombre}")
    public ProductoDTO show(@Min(5) @PathVariable String nombre) {
        ProductoDTO objProdu = null;
        objProdu = gestorService.detallesProdcuto(nombre);
        return objProdu;
    }

    @PostMapping("/login")
    public AdministradorDTO login(@RequestBody AdministradorDTO login) {
        AdministradorDTO objAdmin = null;
        objAdmin = gestorService.IniciarSesion(login);
        return objAdmin;
    }

    @PostMapping("/administrador")
    public AdministradorDTO create(@Valid @RequestBody AdministradorDTO administrador) {
        AdministradorDTO objAdmin = null;
        objAdmin = gestorService.registrarAdmin(administrador);
        return objAdmin;
    }

    @PostMapping("/producto/registrar")
    public ProductoDTO create(@RequestBody ProductoDTO producto) {
        ProductoDTO objProd = null;
        objProd = gestorService.registrarProducto(producto);
        return objProd;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>("nombre del método y parametros erroneos: " + e.getMessage(),
                HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

    @PostMapping("/producto/estado/{codigo}/{estado}")
    public ProductoDTO cambiarEstadoSubasta(@Min(5) @PathVariable Integer codigo, @Min(5) @PathVariable String estado) {
        ProductoDTO objProdu = null;
        objProdu = gestorService.cambiarEstadoSubasta(codigo, estado);
        return objProdu;
    }
}
