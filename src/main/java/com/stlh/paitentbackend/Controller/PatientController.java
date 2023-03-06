package com.stlh.paitentbackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stlh.paitentbackend.jwt.JwtUtils;
import com.stlh.paitentbackend.Model.Patient;
import com.stlh.paitentbackend.Service.PatientService;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin("http://localhost:3000")
public class PatientController {
	private PatientService patientService;
	
	@Autowired
	AuthenticationManager authmanage;
	
	@Autowired
	JwtUtils jwtUtils;
	
	public PatientController(PatientService patientService) {
		super();
		this.patientService = patientService;
	}
	
	
	//build create employee REST API
	@PostMapping("/add")
	public ResponseEntity<Patient>savePatient(@RequestBody Patient patient){
		String pass =patient.getPassword();
		patient.setPassword(new BCryptPasswordEncoder().encode(pass));
		return new ResponseEntity<Patient>(patientService.savePatient(patient),HttpStatus.CREATED);
	}
	

	//Build get all Doctors REST API
	@GetMapping("/allpaitents")
	public List<Patient> getAllPatients(){
		return patientService.getAllPatients();	
	}
	
	@GetMapping("/get/{email}")
	//http://localhost:8091/api/doctors/1 for @pathvariable
	public ResponseEntity<Patient> getPatientId(@PathVariable("email") String email){
		return new ResponseEntity<Patient>(patientService.getPatientById(email),HttpStatus.OK);
	}
		
	//Build Update employee REST API
	//http://localhost:8091/api/doctors/1/ for @pathvariable
	@PutMapping("/update/{email}")
	public ResponseEntity<Patient> updatePatient(@PathVariable("email") String email
			                                    ,@RequestBody Patient patient){
		return new ResponseEntity<Patient>(patientService.updatePatient(patient,email),HttpStatus.OK);
	}
	
	
	//Build delete employee REST API
	//http://localhost:8091/api/doctors/1/ for @pathvariable
	@DeleteMapping("/delete/{email}")
	public ResponseEntity<String> deletePatient(@PathVariable("email") String email){
		
		patientService.deletePatient(email);
		return new ResponseEntity<String>("Patient Deleted Successfull!.",HttpStatus.OK);
	}
	
	@PostMapping("/authenticate")
	public String authPatient(@RequestBody Patient patient){
		try {
			@SuppressWarnings("unused")
			Authentication authtoken=  authmanage.authenticate(
					new UsernamePasswordAuthenticationToken(patient.getEmail(), patient.getPassword()));
			String token = jwtUtils.generateToken(patient.getEmail());
			return token;
			
		} catch (Exception e) {
			// TODO: handle exception
			return e.toString();
		}
		
		
	}
	
}
