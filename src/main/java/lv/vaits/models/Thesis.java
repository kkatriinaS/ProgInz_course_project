package lv.vaits.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.vaits.models.users.Student;

@Table(name = "thesis_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
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

}
