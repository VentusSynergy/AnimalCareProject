package com.petcare.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Appointment {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;

	@Column(name = "time_of_appointment")
	private LocalDate timeOfAppointment;

	private String type;

	private String urgency;

	private String status;

	@JsonIgnoreProperties({"user" , "appt"})
	@ManyToOne
	@JoinColumn(name = "pet_id")
	private Pet pet;

	public Appointment() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getTimeOfAppointment() {
		return timeOfAppointment;
	}

	public void setTimeOfAppointment(LocalDate timeOfAppointment) {
		this.timeOfAppointment = timeOfAppointment;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrgency() {
		return urgency;
	}

	public void setUrgency(String urgency) {
		this.urgency = urgency;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((pet == null) ? 0 : pet.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((timeOfAppointment == null) ? 0 : timeOfAppointment.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((urgency == null) ? 0 : urgency.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appointment other = (Appointment) obj;
		if (id != other.id)
			return false;
		if (pet == null) {
			if (other.pet != null)
				return false;
		} else if (!pet.equals(other.pet))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (timeOfAppointment == null) {
			if (other.timeOfAppointment != null)
				return false;
		} else if (!timeOfAppointment.equals(other.timeOfAppointment))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		if (urgency == null) {
			if (other.urgency != null)
				return false;
		} else if (!urgency.equals(other.urgency))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", timeOfAppointment=" + timeOfAppointment + ", type=" + type + ", urgency="
				+ urgency + ", status=" + status + ", pet=" + pet + "]";
	}

}
