package cn.dianshi.service;

import cn.dianshi.domain.Type;
import cn.dianshi.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {

    public abstract Type saveType(Type type);

    public abstract Type getType(Long id);

    public abstract Type getTypeByName(String name);

    public abstract Page<Type> listType(Pageable pageable);

    public abstract List<Type> listType();

    public abstract Type updateType(Long id, Type type) throws NotFoundException;

    public abstract void deleteType(Long id);
}
