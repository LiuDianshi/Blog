package cn.dianshi.service.Impl;

import cn.dianshi.dao.TypeReposiory;
import cn.dianshi.domain.Type;
import cn.dianshi.exception.NotFoundException;
import cn.dianshi.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeReposiory typeReposiory;

    @Override
    public Type saveType(Type type) {
        return typeReposiory.save(type);
    }

    @Override
    public Type getType(Long id) {
        return typeReposiory.getOne(id);
    }

    @Override
    public Type getTypeByName(String name){
        return typeReposiory.findTypeByName(name);
    }

    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeReposiory.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeReposiory.findAll();
    }

    @Override
    public Type updateType(Long id, Type type) throws NotFoundException {
        Type t = typeReposiory.getOne(id);
        if (t == null){
            throw new NotFoundException("Type Not Found");
        }
        BeanUtils.copyProperties(type,t);
        return typeReposiory.save(t);
    }

    @Override
    public void deleteType(Long id) {
        typeReposiory.deleteById(id);
    }
}
