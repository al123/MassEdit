package faa.mass.edit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import faa.mass.edit.entities.Car;

@Transactional(readOnly = true)
public interface CarRepository extends JpaRepository<Car, Long> {

	@Transactional(timeout = 10)
	Car findByCarId(Integer carId);
	
	@Transactional(timeout = 10)
	List<Car> findAll();
	
//	@Transactional
//	<S extends Car> S save(Car car);
	
	void delete(Car car);
}
