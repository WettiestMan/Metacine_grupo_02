package com.grupo02.web.impls;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.grupo02.web.models.Promocion;
import com.grupo02.web.dto.PromocionDto;
import com.grupo02.web.mappers.CineMapper;
import com.grupo02.web.mappers.PromocionMapper;
import com.grupo02.web.repos.PromocionRepository;
import com.grupo02.web.services.PromocionService;

@Service
public class PromocionServiceImpl implements PromocionService {
    
    private final PromocionRepository actor;

    public PromocionServiceImpl(PromocionRepository actor) {
        this.actor = actor;
    }

    @Override
    public PromocionDto insertar(PromocionDto newBean) {
        return PromocionMapper.toDto(actor.save(PromocionMapper.toModel(newBean)));
    }

    @Override
    public Optional<PromocionDto> obtenerPorId(Long id) {
        return actor.findById(id).map(PromocionMapper::toDto);
    }

    @Override
    public List<PromocionDto> obtenerPorCineId(Long id) {
        return actor.findByCineId(id).stream()
                    .map(PromocionMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<PromocionDto> obtenerPorStock(Integer stock) {
        return actor.findByStock(stock).stream()
                    .map(PromocionMapper::toDto)
                    .collect(Collectors.toList());
    }

    @Override
    public List<PromocionDto> obtenerTodos() {
        List<Promocion> ret = actor.findAll();
        return ret.stream().map(PromocionMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<PromocionDto> actualizar(Long id, PromocionDto updBean) {
        Optional<Promocion> actual = actor.findById(id);
        Promocion saved = null;

        if (actual.isPresent()) {
            var actualRef = actual.get();
            actualRef.setNombre(updBean.getNombre());
            actualRef.setDescripcion(updBean.getDescripcion());
            actualRef.setStock(updBean.getStock());
            actualRef.setFechaInicio(updBean.getFechaInicio());
            actualRef.setFechaFin(updBean.getFechaFin());
            actualRef.setCine(CineMapper.toModel(updBean.getCine()));

            saved = actor.save(actualRef);
        }

        return Optional.ofNullable((saved == null) ? PromocionMapper.toDto(saved) : null);
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
