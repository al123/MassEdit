package faa.gov.tfms.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import faa.gov.tfms.application.entity.MassEditEntity;



@Transactional(readOnly = true)
public interface MassEditRepository extends JpaRepository<MassEditEntity, Long> {

	@Transactional(timeout = 10)
	MassEditEntity findByCarId(Integer carId);
	
	@Transactional(timeout = 10)
	List<MassEditEntity> findAll();
	
//	@Transactional
//	<S extends Car> S save(Car car);
	
	void delete(MassEditEntity car);
}
