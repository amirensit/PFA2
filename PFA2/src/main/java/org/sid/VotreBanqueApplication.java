package org.sid;

import java.util.Date;

import org.sid.dao.AdminRepository;
import org.sid.dao.ScoreRepository;
import org.sid.dao.UniversiteRepository;
import org.sid.entities.Admin;
import org.sid.entities.Score;
import org.sid.entities.Universite;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class VotreBanqueApplication implements CommandLineRunner {
	
		
	
	
	@Autowired
	private UniversiteRepository universiteRepository;
	@Autowired
	private ScoreRepository scoreRepository;
	@Autowired AdminRepository adminRepository;
	public static void main(String[] args) {
		  SpringApplication.run(VotreBanqueApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		
	/*	
	Universite v1=universiteRepository.save(new Universite("université_Tunis","tunis"));
	Universite v2=universiteRepository.save(new Universite("université_mestir","mestir"));	
	Score sc1=scoreRepository.save( new Score(140.2,140.5,140.4,140.9, 120, v2) );
	Admin d1=adminRepository.save(new Admin("amir","amir"));
	Admin d2=adminRepository.save(new Admin("sofiene","sofiene"));
	*/
		
	}
}
