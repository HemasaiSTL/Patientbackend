package com.stlh.paitentbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stlh.paitentbackend.Model.Patient;

public interface PatientRepository extends JpaRepository<Patient,String>{
	

}