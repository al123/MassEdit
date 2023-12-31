package faa.gov.tfms.application.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import faa.gov.tfms.application.entity.MassEditEntity;
import faa.gov.tfms.application.service.MassEditService;


@RestController
@RequestMapping(value = "/api/cars")
public class MassEditController {

	private static final Logger logger = LoggerFactory.getLogger(MassEditController.class);
	
	MassEditService massEditService;

	@Autowired
    public MassEditController(MassEditService massEditService) {
        this.massEditService = massEditService;
    }
	
	@RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody MassEditEntity car) {
        try {
        	logger.info(car.getCarBrand());
        	logger.info(car.getCarEngine());
        	logger.info(car.getCarModel());
        	logger.info(car.getHorsepower());
            massEditService.add(car);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<Map<String, Object>>> getAll() {
        try {
        	List<Map<String, Object>> result = massEditService.findAll();
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<MassEditEntity> getById(@PathVariable("id") int id) {
        try {
            MassEditEntity car = massEditService.findById(id);
            if (car != null) {
                return ResponseEntity.status(HttpStatus.OK).body(car);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
        	logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@PathVariable("id") int id, @RequestBody MassEditEntity car) {
        try {
            massEditService.update(id, car);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        try {
            massEditService.remove(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
