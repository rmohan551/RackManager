package com.example.rackmanager


import java.util.Date


data class RackBooking(
    val rackId: String,  // Unique identifier for the rack
    val bookingDate: Date    // Date for the booking
)
