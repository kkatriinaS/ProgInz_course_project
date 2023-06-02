package lv.vaits.models.users;

import java.util.Collection;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lv.vaits.models.Course;
import lv.vaits.models.Thesis;
import java.util.ArrayList;

@Table(name = "academic_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AttributeOverride(name = "Idp", column = @Column(name = "Ida"))

public class AcademicPersonel extends Person {
	
	@Column(name = "Degree")
	private Degree degree;
	
	@OneToMany
	private Collection<Thesis> thesis;
	
	@ManyToMany(mappedBy = "reviewers")
	private Collection<Thesis> thesisForReviews = new ArrayList<>();
	
	public void addThesisForReviews (Thesis inputThesis) {
		if(!thesisForReviews.contains(inputThesis)) {
			thesisForReviews.add(inputThesis);
			
		}
	}

	public AcademicPersonel(long idp,
			@NotNull @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") @Size(min = 3, max = 15) String name,
			@NotNull @Size(min = 3, max = 15) @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") String surname,
			@NotNull @Size(min = 12, max = 12) @Pattern(regexp = "[0-9]{6}[0-9]{5}+", message = "Neatbilstošs personas kods") String personcode,
			User user, Degree degree) {
		super(idp, name, surname, personcode, user);
		this.degree = degree;
	}
	
}
