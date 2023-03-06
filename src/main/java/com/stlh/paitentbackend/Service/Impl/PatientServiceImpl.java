package com.stlh.paitentbackend.Service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;

import com.stlh.paitentbackend.Exception.ResourceNotFoundException;
import com.stlh.paitentbackend.Model.Patient;
import com.stlh.paitentbackend.Repository.PatientRepository;
import com.stlh.paitentbackend.Service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{
	
	//inject EmployeeRepository dependency Doa
	private PatientRepository patientRepository;
	

	public PatientServiceImpl(PatientRepository patientRepository) {
		super();
		this.patientRepository = patientRepository;
	}


	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}


	@Override
	public List<Patient> getAllPatients() {
		return patientRepository.findAll();
	}


	@Override
	public Patient getPatientById(String email) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if(employee.isPresent()) {
//			return employee.get();
//		}else {
//			throw new ResourceNotFoundException("Employee","Id",id);
//		}
		//lambda representation
		//optional has orelsethrow
		return patientRepository.findById(email).orElseThrow(() -> new ResourceNotFoundException("Patient","Email",email));
		
	}


	@Override
	public Patient updatePatient(Patient patient, String email) {
		// we need to check whether employee with given id is exist in DB or not
		Patient existingPatient = patientRepository.findById(email).orElseThrow(() -> new ResourceNotFoundException("Patient","Email",email));
		existingPatient.setFirstname((patient).getFirstname());
		existingPatient.setLastname(patient.getLastname());
		existingPatient.setAge(patient.getAge());
		existingPatient.setPhnnumber(patient.getPhnnumber());
		existingPatient.setGender(patient.getGender());
		//save existing employee to DB
		patientRepository.save(existingPatient);
		return existingPatient;
	}


	@Override
	public void deletePatient(String email) {
		//check whether a employee exists in DB or not
		patientRepository.findById(email).orElseThrow(() -> new ResourceNotFoundException("Patient","Id",email));
		patientRepository.deleteById(email);
		
	}

}
