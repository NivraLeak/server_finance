package com.example.crud_fiscal.persistence.mapper;

import java.util.List;

public interface SuperMapper<Entity, EntityDto>  {
    public EntityDto toDto(Entity entity);

    public Entity toEntity(EntityDto entityDto);

    public List<EntityDto> toDtoList(List<Entity> list);
}
