package lv.vaits;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lv.vaits.models.Course;
import lv.vaits.models.Thesis;
import lv.vaits.models.users.AcademicPersonel;
import lv.vaits.models.users.Degree;
import lv.vaits.models.users.Student;
import lv.vaits.models.users.User;
import lv.vaits.repos.ICourseRepo;
import lv.vaits.repos.IThesisRepo;
import lv.venta.repos.users.IAcademicPersonelRepo;
import lv.venta.repos.users.IPersonRepo;
import lv.venta.repos.users.IStudentRepo;
import lv.venta.repos.users.IUserRepo;

@SpringBootApplication
public class ProgInzCourseProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgInzCourseProjectApplication.class, args);
	}
	public CommandLineRunner testModelLayer(IUserRepo userRepo, IPersonRepo personRepo, IStudentRepo studentRepo,
			IAcademicPersonelRepo personelRepo, ICourseRepo courseRepo, IThesisRepo thesisRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception{
				User us1 = new User("123", "karina.skirmante@venta.lv");
				User us2 = new User("123", "janis.berzins@venta.lv");
				User us3 = new User("123", "karlis.immers@venta.lv");
				User us4 = new User("123", "ieva.lapina@venta.lv.lv");
				userRepo.save(us1);
				userRepo.save(us2);
				userRepo.save(us3);
				userRepo.save(us4);
				
				Course c1 = new Course("Javaa", 4);
				Course c2 = new Course("Datastr", 2);
				courseRepo.save(c1);
				courseRepo.save(c2);
				
				AcademicPersonel ac1 = new AcademicPersonel(10000, "Karina","Skirmante","121212-11222", us1, Degree.mg);
				AcademicPersonel ac2 = new AcademicPersonel(10001, "Karlis","Immers","121212-11222", us2, Degree.mg);
				Student s1 = new Student(1, "Janis", "Berzins", "211111-11222", us3, "12345678", false);
				Student s2 = new Student(2, "Ieva", "Lapina", "211111-11222", us4, "12349848", true);
				
				s2.addDebtCourse(c1);
				s2.addDebtCourse(c2);
				studentRepo.save(s1);
				studentRepo.save(s2);
				c1.addStudent(s2);
				c2.addStudent(s2);
				courseRepo.save(c1);
				courseRepo.save(c2);
				
				Thesis th1 = new Thesis("Sistēmas izstrāde", "Development of System",
						"Development", "1...2.3..4", s1, ac1);
				Thesis th2 = new Thesis("Pētījums", "Research",
						"Research", "1...2.3..4", s2, ac2);
				
				th1.addReviewer(ac2);
				th2.addReviewer(ac1);
				thesisRepo.save(th1);
				thesisRepo.save(th2);
				ac1.addThesisForReviews(th2);
				ac2.addThesisForReviews(th1);
				personelRepo.save(ac1);
				personelRepo.save(ac2);
	
				
				
			
			
			
			}
		};
	}

}
