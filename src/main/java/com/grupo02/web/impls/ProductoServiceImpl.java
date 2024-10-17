package com.grupo02.web.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo02.web.dto.ProductoDto;
import com.grupo02.web.mappers.DulceriaMapper;
import com.grupo02.web.mappers.ProductoMapper;
import com.grupo02.web.mappers.TipoProductoMapper;
import com.grupo02.web.models.Producto;
import com.grupo02.web.repos.ProductoRepository;
import com.grupo02.web.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    private final ProductoRepository actor;

    public ProductoServiceImpl(ProductoRepository actor) {
        this.actor = actor;
    }

    @Override
    public ProductoDto insertar(ProductoDto newBean) {
        return ProductoMapper.toDto(actor.save(ProductoMapper.toModel(newBean)));
    }

    @Override
    public Optional<ProductoDto> obtenerPorId(Long id) {
        return actor.findById(id).map(ProductoMapper::toDto);
    }

    @Override
    public List<ProductoDto> obtenerPorTipoProductoId(Long id) {
        return actor.findByTipoProductoId(id).stream()
                    .map(ProductoMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDto> obtenerPorDulceriaId(Long id) {
        return actor.findByDulceriaId(id).stream()
                    .map(ProductoMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<ProductoDto> obtenerTodos() {
        return actor.findAll().stream()
                    .map(ProductoMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public Optional<ProductoDto> actualizar(Long id, ProductoDto updBean) {
        Optional<Producto> actual = actor.findById(id);
        Producto saved = null;

        if (actual.isPresent()) {
            var actualRef = actual.get();
            actualRef.setNombre(updBean.getNombre());
            actualRef.setDescripcion(updBean.getDescripcion());
            actualRef.setPrecio(updBean.getPrecio());
            actualRef.setStock(updBean.getStock());
            actualRef.setTipoProd(TipoProductoMapper.toModel(updBean.getTipoProd()));
            actualRef.setDulceria(DulceriaMapper.toModel(updBean.getDulceria()));

            saved = actor.save(actualRef);
        }

        return Optional.ofNullable((saved == null) ? ProductoMapper.toDto(saved) : null);
    }

    @Override
    public boolean eliminar(Long id) {
        var toDelete = actor.findById(id);
        if (toDelete.isPresent()) {
            actor.deleteById(id);
            return true;
        }

        return false;
    }
}
