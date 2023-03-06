package com.stlh.paitentbackend.Service;

import java.util.List;

import com.stlh.paitentbackend.Model.Patient;

public interface PatientService {
	
	Patient savePatient(Patient patient);
	
	List<Patient> getAllPatients();
	Patient getPatientById(String email);
	Patient updatePatient(Patient patient,String email);
	void deletePatient(String email);

}
