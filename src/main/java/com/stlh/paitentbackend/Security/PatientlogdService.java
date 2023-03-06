package com.stlh.paitentbackend.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stlh.paitentbackend.Model.Patient;
import com.stlh.paitentbackend.Repository.PatientRepository;

@Service
public class PatientlogdService implements UserDetailsService{
	@Autowired
	PatientRepository patientRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Patient patient = patientRepository.findById(username).get();
		if(patient == null) {
			return null;
		}
		
		return new Patientlogd(patient);
	}
	
}