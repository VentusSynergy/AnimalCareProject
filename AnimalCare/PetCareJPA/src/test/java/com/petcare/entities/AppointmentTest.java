package com.petcare.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AppointmentTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Appointment appt;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("PetPU");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		appt = em.find(Appointment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		appt = null;
	}

	@Test
	@DisplayName("Testing entity")
	void test1() {
		assertEquals("2019-04-03", appt.getTimeOfAppointment().toString());
		assertEquals("Exam - Has hurt foot", appt.getType());
		assertEquals("Moderate", appt.getUrgency());
		assertEquals("Luna", appt.getPet().getName());
	}

}
