package com.cice.GestionUsuarios.GestionUsuarios.service;

import com.cice.GestionUsuarios.GestionUsuarios.controller.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    List<ProductoDTO> getAllProductos();
    List<ProductoDTO> getProductoByIdUsuario(long idUsuario);
    ProductoDTO crearProductoByUsuario(long idUsuario, ProductoDTO producto);
    List<ProductoDTO> eliminarProductosByUsuario(long idUsuario);

}
