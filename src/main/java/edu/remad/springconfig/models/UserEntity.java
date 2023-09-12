package edu.remad.springconfig.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;

import edu.remad.springconfig.appconstants.RegexAppConstants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = RegexAppConstants.USERNAME_REGEX)
	private String username;
	
	@Pattern(regexp = RegexAppConstants.EMAIL_REGEX)
	private String email;
	
	@org.hibernate.validator.constraints.NotBlank
	private String password;
	
	private Boolean enabled;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	@JoinTable(name = "user_rules", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
	private List<Role> roles = new ArrayList<>();
}
