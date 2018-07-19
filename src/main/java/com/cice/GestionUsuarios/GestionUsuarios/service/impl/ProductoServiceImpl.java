package com.cice.GestionUsuarios.GestionUsuarios.service.impl;

import com.cice.GestionUsuarios.GestionUsuarios.controller.dto.ProductoDTO;
import com.cice.GestionUsuarios.GestionUsuarios.entity.ProductoEntity;
import com.cice.GestionUsuarios.GestionUsuarios.repository.IProductoRepository;
import com.cice.GestionUsuarios.GestionUsuarios.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements IProductoService {

    @Autowired
    IProductoRepository productoRepository;

    @Override
    public List<ProductoDTO> getAllProductos() {
        List<ProductoDTO> collect = productoRepository.findAll()
                .stream()
                .map(entity -> new ProductoDTO(entity.getIdProducto(),
                entity.getIdUsuario(),
                entity.getNombre(),
                entity.getCodigo()))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<ProductoDTO> getProductoByIdUsuario(long idUsuario) {
        List<ProductoDTO> collect = productoRepository.findByIdUsuario(idUsuario)
                .stream()
                .map(entity -> new ProductoDTO(entity.getIdProducto(),entity.getIdUsuario(),entity.getNombre(),entity.getCodigo())).collect(Collectors.toList());
        return collect;
    }

    @Override
    public ProductoDTO crearProductoByUsuario(long idUsuario, ProductoDTO producto) {
        ProductoEntity entity = new ProductoEntity(producto.getIdProducto(), idUsuario, producto.getNombre(), producto.getCodigo());
        entity = productoRepository.save(entity);
        ProductoDTO result = new ProductoDTO(entity.getIdProducto(), entity.getIdUsuario(), entity.getNombre(), entity.getCodigo());
        return result;
    }

    @Override
    public List<ProductoDTO> eliminarProductosByUsuario(long idUsuario) {
        List<ProductoEntity> productosEliminados = productoRepository.deleteByIdUsuario(idUsuario);
        return productosEliminados.stream().map(entity -> new ProductoDTO(entity.getIdProducto(), entity.getIdUsuario(), entity.getNombre(), entity.getCodigo())).collect(Collectors.toList());
    }
}
