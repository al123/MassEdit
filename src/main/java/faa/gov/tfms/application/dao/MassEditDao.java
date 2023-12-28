package faa.gov.tfms.application.dao;

import java.util.List;
import java.util.Map;

import faa.gov.tfms.application.entity.MassEditEntity;


public interface MassEditDao {

    public MassEditEntity findById(int id);

    public void remove(int id);

    public void add(MassEditEntity car);

    public void update(int id, MassEditEntity car);

    public List<Map<String, Object>> findAll();
}
