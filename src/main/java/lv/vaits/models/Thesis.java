package lv.vaits.models;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.vaits.models.users.AcademicPersonel;
import lv.vaits.models.users.Student;
import java.util.ArrayList;

@Table(name = "thesis_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
//@ToString
public class Thesis {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idt")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idt;
	
	
	//TODO pievienot nepieciešamās validācijas
	@Column (name= "TitleLv")
	private String titleLv;
		
	//TODO pievienot nepieciešamās validācijas
	@Column (name= "TitleEn")
	private String titleEn;
	
	//TODO pievienot nepieciešamās validācijas
	@Column (name= "Aim")
	private String aim;
	
	//TODO pievienot nepieciešamās validācijas
	@Column (name= "Tasks")
	private String tasks;
	
	//TODO Servisā vai konstruktorā pie jauna objekta izveides jāizmanto LocalDateTime 
	@Column(name = "submitDateTime")
	private LocalDateTime submitDateTime;
	
	@Column (name = "statusFromSupervisor")
	private boolean statusFromSupervisor;
	
	//TODO servisā vai konstruktorā uzlikt submit pēc noklusējuma
	@Column (name="accStatus")
	private AcceptanceStatus accStatus;
	
	@Column(name = "AccDateTime")
	private LocalDateTime accDateTime;
	
	@ManyToOne
	@JoinColumn(name = "Ids")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name="Ida")
	private AcademicPersonel supervisor;
	
	@ManyToMany
	@JoinTable(name = "thesis_reviewers",
	joinColumns = @JoinColumn(name = "Ida"),
	inverseJoinColumns = @JoinColumn(name = "Ida"))
	private Collection <AcademicPersonel> reviewers = new ArrayList<>();

	public Thesis(String titleLv, String titleEn, String aim, String tasks, boolean statusFromSupervisor,
			Student student, AcademicPersonel supervisor) {
		super();
		this.titleLv = titleLv;
		this.titleEn = titleEn;
		this.aim = aim;
		this.tasks = tasks;
		this.statusFromSupervisor = statusFromSupervisor;
		this.student = student;
		this.supervisor = supervisor;
		this.submitDateTime = LocalDateTime.now();
		this.accStatus = AcceptanceStatus.submitted;
	}
	
	

}
