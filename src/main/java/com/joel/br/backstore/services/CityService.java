package com.joel.br.backstore.services;

import com.joel.br.backstore.model.City;
import com.joel.br.backstore.repository.CityRepository;
import com.joel.br.backstore.services.IMPL.CityImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CityService implements CityImpl {

    private  final CityRepository  cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public List<City> getAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).get();
    }

    @Override
    public City save(City city) {
        return cityRepository.saveAndFlush(city);
    }

    @Override
    public City update(Long id, City city) {
        City city1 = findById(id);

        BeanUtils.copyProperties(city, city1, "id");
        return cityRepository.saveAndFlush(city1);
    }

    @Override
    public void delete(Long id) {
        cityRepository.deleteById(id);
    }
}
