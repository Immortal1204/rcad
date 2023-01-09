package com.mrf.Rcad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.mrf.Rcad.entity.Speciality;
import com.mrf.Rcad.repository.SpecialityRepository;
import com.mrf.Rcad.securityModels.Role;
import com.mrf.Rcad.securityModels.UserEntity;
import com.mrf.Rcad.securityRepository.RoleRepository;
import com.mrf.Rcad.securityRepository.UserRepository;

import jakarta.persistence.EntityManager;

@Component
public class SpecialityCommandLineRunner implements CommandLineRunner {
  @Autowired
  private SpecialityRepository specialityRepository;
  
  @Autowired
  private RoleRepository roleRepo;
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Autowired
  private UserRepository userRepo;

  @Override
  public void run(String... args) throws Exception {
	  if(roleRepo.count()==0) {
//		  roleRepo.save(new Role("ADMINISTRATOR"));
		  roleRepo.save(new Role("CLINIC"));
		  roleRepo.save(new Role("SECRETARY"));
		  roleRepo.save(new Role("USER"));
	  }
	  
		if(userRepo.count()==0) {
			UserEntity administrator1 = new UserEntity();
			UserEntity administrator2 = new UserEntity();
	        administrator1.setUsername("ahmed12");
	        administrator1.setPassword(passwordEncoder.encode(("password")));
	        administrator2.setUsername("dah13");
	        administrator2.setPassword(passwordEncoder.encode(("password")));

	        Role roles = new Role("ADMINISTRATOR");
	        administrator1.setRoles(Collections.singletonList(roles));
//	        Role roles2 = new Role("ADMINISTRATOR");
	        
//	        administrator2.setRoles(Collections.singletonList(roles2));

	        userRepo.save(administrator1);
//	        userRepo.save(administrator2);
	}
	  
	  if(specialityRepository.count()==0) {
	  List<Speciality> specialities = new ArrayList<>();
	  specialities.add(new Speciality("Allergologie", "Spécialité médicale s'occupant de réponses anormales de l'organisme à des facteurs environnementaux normalement tolérés"));
	  specialities.add(new Speciality("Andrologie", "Spécialité médicale s'occupant de la santé masculine, en particulier des problèmes du système reproducteur masculin et des problèmes urologiques spécifiques aux individus mâles"));
	  specialities.add(new Speciality("Cardiologie", "Branche de la médecine s'occupant des troubles du cœur et des vaisseaux sanguins","heart.png"));
	  specialities.add(new Speciality("Chirurgie cardiaque", "Spécialité chirurgicale s'occupant des troubles du cœur et des gros vaisseaux thoraciques"));
	  specialities.add(new Speciality("Chirurgie plastique", "Spécialité chirurgicale principalement concernée par la réparation et la reconstruction des défauts de forme et de fonction de la peau et de ses structures sous-jacentes, en particulier de la tête et du cou, des membres supérieurs et inférieurs, du sein et des organes génitaux externes"));
	  specialities.add(new Speciality("Chirurgie général", "Partie de la thérapeutique qui implique des opérations ou des manœuvres sur les tissus, en particulier par incision et suture"));
	  specialities.add(new Speciality("Chirurgie gynécologique", "Chirurgie concernant les organes génitaux de la femme : vulve, vagin, utérus et ses annexes, seins"));
	  specialities.add(new Speciality("Chirurgie ophtalmique", "Chirurgie exécutée sur l'œil et ses annexes, généralement par un ophtalmologue"));
	  specialities.add(new Speciality("Chirurgie buccale", "Spécialité médicale et chirurgicale couvrant l'étude de la cavité buccale, des dents, des maxillaires, de l'appareil manducateur et des tissus attenants"));
	  specialities.add(new Speciality("Chirurgie pédiatrique", "Branche de la chirurgie limitée à une tranche d'âge s'étendant des nouveau-nés à l'adolescence"));
	  specialities.add(new Speciality("Chirurgie vasculaire", "Chirurgie des vaisseaux sanguins, artères et veines, à l'exclusion des vaisseaux intracrâniens et coronaires"));
	  specialities.add(new Speciality("Neurochirurgie", "Spécialité chirurgicale concernée par le traitement chirurgical des troubles du système nerveux central et périphérique"));
	  specialities.add(new Speciality("Dermatologie", "Spécialité médicale s'occupant de la peau, des muqueuses et des phanères"));
	  specialities.add(new Speciality("Gastro-entérologie", "Spécialité médicale s'occupant du système digestif et de ses maladies"));
	  specialities.add(new Speciality("Hépatologie", "Branche de la médecine s'intéressant aux maladies hépatobiliaires, c'est-à-dire aux maladies du foie (hépar) et des voies biliaires et de la rate"));
	  specialities.add(new Speciality("Urologie", "Domaine de la médecine s'appliquant aux reins, aux voies urinaires et au système reproducteur masculin"));
	  specialities.add(new Speciality("Podologie", "Spécialité paramédicale étudiant le pied et ses pathologies"));
	  specialities.add(new Speciality("Radiologie", "Ensemble des modalités diagnostiques et thérapeutiques utilisant les rayons X ou d'autres rayonnements"));
	  specialities.add(new Speciality("Radiothérapie", "Méthode de traitement locorégional des cancers en utilisant des radiations"));
	  specialities.add(new Speciality("Rhumatologie", "Spécialité traitant des maladies de l'appareil locomoteur, c'est-à-dire des os, articulations, muscles, tendons et ligaments"));
	  specialities.add(new Speciality("Immunologie", "Branche de la biologie s'occupant de l'étude du système immunitaire"));
	  specialities.add(new Speciality("Infectiologie", "Spécialité traitant du diagnostic, du contrôle et du traitement des infections"));
	  specialities.add(new Speciality("Médecine générale", "Spécialité souvent consultée pour diagnostiquer les symptômes avant de référer le patient à un autre spécialiste"));
	  specialities.add(new Speciality("Médecine physique et de réadaptation", "Spécialité orientée vers la récupération de capacités fonctionnelles et de qualité de vie de patients atteints de handicap"));
	  specialities.add(new Speciality("Médecine préventive", "Branche donnant des conseils d'hygiène et de dépistage de maladie"));
	  specialities.add(new Speciality("Neurologie", "Spécialité étudiant l'ensemble des maladies du système nerveux, en particulier du cerveau"));
	  specialities.add(new Speciality("Obstétrique", "Spécialité médico-chirurgicale étudiant et prenant en charge la grossesse et l'accouchement"));
	  specialities.add(new Speciality("Oncologie", "Spécialité d'étude, de diagnostic et de traitement des cancers"));
	  specialities.add(new Speciality("La pédiatrie","Spécialité médicale s'occupant de la santé des enfants."));
	  specialities.add(new Speciality("L'ophtalmologie","Spécialité médicale s'intéressant aux maladies des yeux."));
	  specialities.add(new Speciality("Dentiste","Spécialité médicale s'occupant de la santé des dents.","Dentist.png"));
	  specialities.add(new Speciality("La rhumatologie","Spécialité médicale s'intéressant aux maladies des os, des articulations et des muscles."));
	  specialities.add(new Speciality("La psychiatrie","Spécialité médicale s'occupant du diagnostic, du traitement et de la prévention des troubles mentaux."));
	  specialities.add(new Speciality("La pneumologie","Spécialité médicale s'intéressant aux maladies des poumons et des voies respiratoires."));
    specialities.forEach(s -> specialityRepository.save(s));
	  }
  }
}
