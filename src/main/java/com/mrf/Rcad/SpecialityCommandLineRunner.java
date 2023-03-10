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
	  specialities.add(new Speciality("Allergologie", "Sp??cialit?? m??dicale s'occupant de r??ponses anormales de l'organisme ?? des facteurs environnementaux normalement tol??r??s"));
	  specialities.add(new Speciality("Andrologie", "Sp??cialit?? m??dicale s'occupant de la sant?? masculine, en particulier des probl??mes du syst??me reproducteur masculin et des probl??mes urologiques sp??cifiques aux individus m??les"));
	  specialities.add(new Speciality("Cardiologie", "Branche de la m??decine s'occupant des troubles du c??ur et des vaisseaux sanguins","heart.png"));
	  specialities.add(new Speciality("Chirurgie cardiaque", "Sp??cialit?? chirurgicale s'occupant des troubles du c??ur et des gros vaisseaux thoraciques"));
	  specialities.add(new Speciality("Chirurgie plastique", "Sp??cialit?? chirurgicale principalement concern??e par la r??paration et la reconstruction des d??fauts de forme et de fonction de la peau et de ses structures sous-jacentes, en particulier de la t??te et du cou, des membres sup??rieurs et inf??rieurs, du sein et des organes g??nitaux externes"));
	  specialities.add(new Speciality("Chirurgie g??n??ral", "Partie de la th??rapeutique qui implique des op??rations ou des man??uvres sur les tissus, en particulier par incision et suture"));
	  specialities.add(new Speciality("Chirurgie gyn??cologique", "Chirurgie concernant les organes g??nitaux de la femme : vulve, vagin, ut??rus et ses annexes, seins"));
	  specialities.add(new Speciality("Chirurgie ophtalmique", "Chirurgie ex??cut??e sur l'??il et ses annexes, g??n??ralement par un ophtalmologue"));
	  specialities.add(new Speciality("Chirurgie buccale", "Sp??cialit?? m??dicale et chirurgicale couvrant l'??tude de la cavit?? buccale, des dents, des maxillaires, de l'appareil manducateur et des tissus attenants"));
	  specialities.add(new Speciality("Chirurgie p??diatrique", "Branche de la chirurgie limit??e ?? une tranche d'??ge s'??tendant des nouveau-n??s ?? l'adolescence"));
	  specialities.add(new Speciality("Chirurgie vasculaire", "Chirurgie des vaisseaux sanguins, art??res et veines, ?? l'exclusion des vaisseaux intracr??niens et coronaires"));
	  specialities.add(new Speciality("Neurochirurgie", "Sp??cialit?? chirurgicale concern??e par le traitement chirurgical des troubles du syst??me nerveux central et p??riph??rique"));
	  specialities.add(new Speciality("Dermatologie", "Sp??cialit?? m??dicale s'occupant de la peau, des muqueuses et des phan??res"));
	  specialities.add(new Speciality("Gastro-ent??rologie", "Sp??cialit?? m??dicale s'occupant du syst??me digestif et de ses maladies"));
	  specialities.add(new Speciality("H??patologie", "Branche de la m??decine s'int??ressant aux maladies h??patobiliaires, c'est-??-dire aux maladies du foie (h??par) et des voies biliaires et de la rate"));
	  specialities.add(new Speciality("Urologie", "Domaine de la m??decine s'appliquant aux reins, aux voies urinaires et au syst??me reproducteur masculin"));
	  specialities.add(new Speciality("Podologie", "Sp??cialit?? param??dicale ??tudiant le pied et ses pathologies"));
	  specialities.add(new Speciality("Radiologie", "Ensemble des modalit??s diagnostiques et th??rapeutiques utilisant les rayons X ou d'autres rayonnements"));
	  specialities.add(new Speciality("Radioth??rapie", "M??thode de traitement locor??gional des cancers en utilisant des radiations"));
	  specialities.add(new Speciality("Rhumatologie", "Sp??cialit?? traitant des maladies de l'appareil locomoteur, c'est-??-dire des os, articulations, muscles, tendons et ligaments"));
	  specialities.add(new Speciality("Immunologie", "Branche de la biologie s'occupant de l'??tude du syst??me immunitaire"));
	  specialities.add(new Speciality("Infectiologie", "Sp??cialit?? traitant du diagnostic, du contr??le et du traitement des infections"));
	  specialities.add(new Speciality("M??decine g??n??rale", "Sp??cialit?? souvent consult??e pour diagnostiquer les sympt??mes avant de r??f??rer le patient ?? un autre sp??cialiste"));
	  specialities.add(new Speciality("M??decine physique et de r??adaptation", "Sp??cialit?? orient??e vers la r??cup??ration de capacit??s fonctionnelles et de qualit?? de vie de patients atteints de handicap"));
	  specialities.add(new Speciality("M??decine pr??ventive", "Branche donnant des conseils d'hygi??ne et de d??pistage de maladie"));
	  specialities.add(new Speciality("Neurologie", "Sp??cialit?? ??tudiant l'ensemble des maladies du syst??me nerveux, en particulier du cerveau"));
	  specialities.add(new Speciality("Obst??trique", "Sp??cialit?? m??dico-chirurgicale ??tudiant et prenant en charge la grossesse et l'accouchement"));
	  specialities.add(new Speciality("Oncologie", "Sp??cialit?? d'??tude, de diagnostic et de traitement des cancers"));
	  specialities.add(new Speciality("La p??diatrie","Sp??cialit?? m??dicale s'occupant de la sant?? des enfants."));
	  specialities.add(new Speciality("L'ophtalmologie","Sp??cialit?? m??dicale s'int??ressant aux maladies des yeux."));
	  specialities.add(new Speciality("Dentiste","Sp??cialit?? m??dicale s'occupant de la sant?? des dents.","Dentist.png"));
	  specialities.add(new Speciality("La rhumatologie","Sp??cialit?? m??dicale s'int??ressant aux maladies des os, des articulations et des muscles."));
	  specialities.add(new Speciality("La psychiatrie","Sp??cialit?? m??dicale s'occupant du diagnostic, du traitement et de la pr??vention des troubles mentaux."));
	  specialities.add(new Speciality("La pneumologie","Sp??cialit?? m??dicale s'int??ressant aux maladies des poumons et des voies respiratoires."));
    specialities.forEach(s -> specialityRepository.save(s));
	  }
  }
}
