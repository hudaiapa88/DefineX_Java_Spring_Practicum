package com.uc.repo.base;

import com.uc.model.base.BaseId;

import java.util.List;

public interface BaseRepository<Model extends BaseId ,Id> {

    List<Model> findAll();
    Model findById(Id id);
    void deleteById(Id  id);
    Model save(Model value);

}
