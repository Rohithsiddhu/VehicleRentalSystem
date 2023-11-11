package com.example.vehiclerentalsystem.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalsystem.dto.VehicleDTO;
import com.example.vehiclerentalsystem.entity.Vehicle;
import com.example.vehiclerentalsystem.repository.VehicleRepository;
import com.example.vehiclerentalsystem.service.IVehicleService;

@Service
public class VehicleServiceImpl implements IVehicleService {

	@Autowired
	private VehicleRepository repository;

	

	@Override
	public VehicleDTO findById(Long id) throws Exception {
		VehicleDTO vehicleDTO = new VehicleDTO();
		Vehicle vehicle =  repository.findById(id).orElseThrow(() -> new Exception("Vehicle not found - " + id));
		BeanUtils.copyProperties(vehicle, vehicleDTO);
		return vehicleDTO;
		// return repository.findById(id).orElse(null);

	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public VehicleDTO addVehicle(VehicleDTO vehicleDto) {
		
		Vehicle vehicle = new Vehicle();
		BeanUtils.copyProperties(vehicleDto, vehicle);
		vehicle = repository.save(vehicle);
		BeanUtils.copyProperties(vehicle,vehicleDto);
		return vehicleDto;
	}

	@Override
	public VehicleDTO updateVehicle(VehicleDTO vehicleDto) {
		Vehicle vehicle = new Vehicle();
		BeanUtils.copyProperties(vehicleDto, vehicle);
		vehicle = repository.save(vehicle);
		BeanUtils.copyProperties(vehicle,vehicleDto);
		return vehicleDto;
	}

}
