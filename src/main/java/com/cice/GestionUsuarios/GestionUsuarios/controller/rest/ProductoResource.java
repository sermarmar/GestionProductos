package com.cice.GestionUsuarios.GestionUsuarios.controller.rest;

import com.cice.GestionUsuarios.GestionUsuarios.controller.dto.ProductoDTO;
import com.cice.GestionUsuarios.GestionUsuarios.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;

@RestController("/")
public class ProductoResource {

    @Autowired
    IProductoService productoService;

    @RequestMapping(value = "producto", method = RequestMethod.GET)
    public ResponseEntity<List<ProductoDTO>> getAllProductos(){
        List<ProductoDTO> productos = productoService.getAllProductos();
        return ResponseEntity.ok(productos);
    }

    @RequestMapping(value = "producto/{idUsuario}", method = RequestMethod.GET)
    public ResponseEntity<List<ProductoDTO>> getProductosByIdUsuario(@PathVariable Long idUsuario){
        List<ProductoDTO> productos = productoService.getProductoByIdUsuario(idUsuario);
        return ResponseEntity.ok(productos);
    }

    @RequestMapping(value = "producto/{idUsuario}", method = RequestMethod.POST)
    public ResponseEntity<Void> crearProductoParaUsuario(@RequestBody ProductoDTO producto, @PathVariable Long idUsuario){
        productoService.crearProductoByUsuario(idUsuario, producto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "producto/{idUsuario}", method = RequestMethod.DELETE)
    public ResponseEntity<List<ProductoDTO>> eliminarProductosByIdUsuario(@PathVariable Long idUsuario){
        System.out.println("Entrado");
        List<ProductoDTO> productosEliminados = productoService.eliminarProductosByUsuario(idUsuario);
        return ResponseEntity.ok(productosEliminados);
    }
}
