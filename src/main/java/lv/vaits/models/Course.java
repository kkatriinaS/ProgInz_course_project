package lv.vaits.models;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Setter;
import java.util.Collection;
import lv.vaits.models.users.Student;


public class Course {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idc")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idc;
	
	@Column(name = "Title")
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	@Size(min = 5, max = 25)
	private String title;
	
	@Min(value = 1)
	@Max(value = 20)
	@Column(name = "CreditPoints")
	private int creditPoints;
	
	private Collection<Student> debtStudents = new ArrayList<Student>();
	
	
	
	
	public Course(
			@NotNull @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") @Size(min = 5, max = 25) String title,
			@Min(1) @Max(20) int creditPoints) {
		this.title = title;
		this.creditPoints = creditPoints;
	}

}
