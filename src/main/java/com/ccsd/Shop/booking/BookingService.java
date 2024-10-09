package com.ccsd.Shop.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class BookingService {
    
    @Autowired
    private BookingRepository bookingRepository;

    // Getting all users
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Getting a single user by ID
    public Optional<Booking> getBookingById(String id) {
        return bookingRepository.findById(id);
    }

    // Adding a new user
    public Booking addBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking registerBooking(Booking booking) {
        // Check if the username already exists
        if (bookingRepository.findById(booking.getId()) != null) {
            throw new RuntimeException("Time Taken");
        }

        return bookingRepository.save(booking);
    }

    // Updating a user
    public Booking updateBooking(String id, Booking bookingDetails) {
        Optional<Booking> bookingOpt = bookingRepository.findById(id);
        if (bookingOpt.isPresent()) {
            Booking booking = bookingOpt.get();
            booking.setDate(bookingDetails.getDate());
            booking.setTime(bookingDetails.getTime());
            booking.setPackageType(bookingDetails.getPackageType());
            booking.setStyle(bookingDetails.getStyle());
            return bookingRepository.save(booking);
        }
        return null;
    }

    // Deleting a user
    public void deleteBooking(String id) {
        bookingRepository.deleteById(id);
    }

    // // Login validation
    // public Booking loginUser(String username, String password) {
    //     User user = userRepository.findByUsername(username);
    //     if (user != null && user.getPassword().equals(password)) {
    //         return user;
    //     }
    //     return null;
    // }
}