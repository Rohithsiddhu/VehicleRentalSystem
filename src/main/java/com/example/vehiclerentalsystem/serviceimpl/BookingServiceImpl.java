package com.example.vehiclerentalsystem.serviceimpl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclerentalsystem.dto.BookingDTO;
import com.example.vehiclerentalsystem.entity.Booking;
import com.example.vehiclerentalsystem.repository.BookingRepository;
import com.example.vehiclerentalsystem.service.IBookingService;
@Service
public class BookingServiceImpl implements IBookingService {
	
	@Autowired
	BookingRepository repository;
	

	@Override
	public BookingDTO addBooking(BookingDTO bookingDto) {
		Booking booking = new Booking();
		BeanUtils.copyProperties(bookingDto, booking);
		booking =  repository.save(booking);
		BeanUtils.copyProperties(booking,bookingDto);
		return bookingDto;
	}

	@Override
	public BookingDTO updateBooking(BookingDTO bookingDto) {

		Booking booking = new Booking();
		BeanUtils.copyProperties(bookingDto, booking);
		booking =  repository.save(booking);
		BeanUtils.copyProperties(booking,bookingDto);
		return bookingDto;
	}

	@Override
	public BookingDTO findById(Long id)throws Exception {
		Booking booking = new Booking();
		BookingDTO bookingDTO = new BookingDTO();
		booking =  repository.findById(id).orElseThrow(() -> new Exception("Booking  not found - " + id));
		BeanUtils.copyProperties(booking,bookingDTO);
		return bookingDTO;
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

}
