package org.sid;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.sid.dao.EtudiantRepository;
import org.sid.entities.Etudiant;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;



@SpringBootApplication
public class SecuriteApplication {

	public static void main(String[] args) throws ParseException {
		ApplicationContext ctx = SpringApplication.run(SecuriteApplication.class, args);
	    EtudiantRepository etudiantRepository=ctx.getBean(EtudiantRepository.class);
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	    etudiantRepository.save(new Etudiant("Mohamed","Neji",df.parse("1999-12-11")));
	    etudiantRepository.save(new Etudiant("Salah","Ben Salem",df.parse("1998-1-11")));
	    etudiantRepository.save(new Etudiant("Saloua","Zouheir",df.parse("2000-12-12")));
	    etudiantRepository.save(new Etudiant("Atef","Mejri",df.parse("2003-06-17")));
	    etudiantRepository.save(new Etudiant("Mohamed","Ben Ali",df.parse("2010-12-27")));
	    etudiantRepository.save(new Etudiant("Omar","Jlassi",df.parse("1979-12-18")));
	
	java.util.List<Etudiant> etds = etudiantRepository.findAll();
	etds.forEach(e->System.out.println(e.getNom()));
	
	}
	
	
	
	

}
