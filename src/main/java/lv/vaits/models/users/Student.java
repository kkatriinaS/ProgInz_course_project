package lv.vaits.models.users;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Collection;
import lv.vaits.models.Course;

@Table(name = "student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AttributeOverride (name = "Idp", column = @Column(name = "Ids"))
public class Student extends Person {
	
	//TODO izveidot data jpa anotācijas
	//TODO izveidot validāciju anotācijas
	//TODO izveidot sasaisti ar Course klasi
	@Column(name = "matriculaNo")
	@NotNull
	//@Size(min = 8, max = 20)
	@Pattern(regexp = "[0-9] {8,20}")
	private String matriculaNo;
	
	@Column(name = "financialDebt")
	private boolean financialDebt;

	@ManyToMany
	@JoinTable(name = "student_debt_courses_table",
	joinColumns = @JoinColumn(name = "Idc"),
	inverseJoinColumns = @JoinColumn(name = "Idp"))
	
	private Collection<Course> debtCourse = new ArrayList<Course>();
	
	
	
	
	public Student(long idp,
			@NotNull @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") @Size(min = 3, max = 15) String name,
			@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") String surname,
			@NotNull @Size(min = 12, max = 12) @Pattern(regexp = "[0-9]{6}[0-9]{5}+", message = "Neatbilstošs personas kods") String personcode,
			User user, @NotNull @Pattern(regexp = "[0-9] {8,20}") String matriculaNo, boolean financialDebt) {
		super(idp, name, surname, personcode, user);
		this.matriculaNo = matriculaNo;
		this.financialDebt = financialDebt;
	}
	
	
}
