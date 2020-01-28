package com.petcare.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petcare.entities.Appointment;

public interface AppointmentRepo  extends JpaRepository<Appointment, Integer>{

}
