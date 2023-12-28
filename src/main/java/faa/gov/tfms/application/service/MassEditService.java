package faa.gov.tfms.application.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import faa.gov.tfms.application.dao.MassEditDao;
import faa.gov.tfms.application.entity.MassEditEntity;



@Service
@Transactional
public class MassEditService {

	@Autowired
    private MassEditDao massEditDao;

    public MassEditService() {
    	
    }

    public MassEditEntity findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID cannot be 0 or < 0");
        }
        return massEditDao.findById(id);
    }

    public void remove(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID cannot be 0 or < 0 or this id do not exist");
        }
        massEditDao.remove(id);
    }

    public List<Map<String, Object>> findAll() {

        List<Map<String, Object>> result = massEditDao.findAll();
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }

    public void add(MassEditEntity car) {
        if (car == null) {
            throw new IllegalArgumentException("The passed object cannot be null.");
        }
        massEditDao.add(car);
    }

    public void update(int id, MassEditEntity car) {
        if (id <= 0 && car == null) {
            throw new IllegalArgumentException("The passed object cannot be null.");
        }
        massEditDao.update(id, car);
    }

}
