package faa.gov.tfms.application.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import faa.gov.tfms.application.dao.MassEditDao;
import faa.gov.tfms.application.entity.MassEditEntity;
import faa.gov.tfms.application.repository.MassEditRepository;



@Repository
public class MassEditDaoImpl implements MassEditDao {

	private static final Logger logger = LoggerFactory.getLogger(MassEditDaoImpl.class);
	
	@Autowired
	private MassEditRepository massEditRepository;
	
    public MassEditDaoImpl() {
    	
    }

    @Override
    public MassEditEntity findById(int id) {
    	
    	try {
            return massEditRepository.findByCarId(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    	return null;
    }

    @Override
    public void remove(int id) {
    	try {
    		MassEditEntity car = new MassEditEntity();
    		car.setCarId(id);
    		massEditRepository.delete(car);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }

    @Override
    public void add(MassEditEntity car) {
    	try {
    		massEditRepository.save(car);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }

    @Override
    public void update(int id, MassEditEntity car) {
    	try {
    		car.setCarId(id);
    		massEditRepository.save(car);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    }

    @Override
    public List<Map<String, Object>> findAll() {
    	try {
    		List<Map<String, Object>> list = new ArrayList<>();
        	Map<String, Object> map = new HashMap<>();
        	List<MassEditEntity> result = massEditRepository.findAll();
            for (MassEditEntity car : result) {
            	map = new HashMap<>();
            	map.put(car.getCarId().toString(), car);
            	list.add(map);
            }
            return list;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
    	return null;
    }

}
