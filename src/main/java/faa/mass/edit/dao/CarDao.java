package faa.mass.edit.dao;

import java.util.List;
import java.util.Map;

import faa.mass.edit.entities.Car;


public interface CarDao {

    public Car findById(int id);

    public void remove(int id);

    public void add(Car car);

    public void update(int id, Car car);

    public List<Map<String, Object>> findAll();
}