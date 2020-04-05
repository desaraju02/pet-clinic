package com.nag.services.map;

import com.nag.model.Owner;
import com.nag.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements CrudService<Owner,Long> {

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(),object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }
}
