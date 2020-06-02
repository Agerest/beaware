package be.aware.mapper;

import org.mapstruct.Mapper;

import java.util.Collection;
import java.util.List;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <D> - DTO type parameter.
 * @param <E> - Entity type parameter.
 */
@Mapper(componentModel = "spring")
public interface AbstractEntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(Collection<D> dtos);

    List<D> toDto(Collection<E> entities);
}
