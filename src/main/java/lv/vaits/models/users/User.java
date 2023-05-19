package lv.vaits.models.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user_table")
@Entity
@Getter
@Setter
@NoArgsConstructor

public class User {
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idu")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idu;
	
	//TODO data JPA anotācijas
	//TODO validāciju anotācijas
	@Column(name = "Username")
	@NotNull
	
	private String username;
	
	@Column(name = "Password")
	@NotNull
	//TODO papildinat ar validaciju kad ir zinams passwordEncoder
	private String password; //TODO kad pievienos Spring Security, jāuzliek passwordEncoder
	
	@Column(name = "Email")
	@NotNull
	@Email
	private String email;


public User (@NotNull String password, @NotNull String username, @NotNull String email ) {
}

}
