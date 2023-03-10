package com.stlh.paitentbackend.Security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.stlh.paitentbackend.Model.Patient;

@SuppressWarnings("serial")
public class Patientlogd implements UserDetails{
	Patient patient = new Patient();
	
	public Patientlogd(Patient patient){
		this.patient=patient;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("PATIENT"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return patient.getPassword();
	}

	

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return patient.getEmail();
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
