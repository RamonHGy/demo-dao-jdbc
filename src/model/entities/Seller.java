package model.entities;

import java.time.LocalDate;
import java.util.Objects;

public class Seller {
	private Integer Id;
	private String name;
	private String email;
	private LocalDate birthDate;
	private Double baseSalary;
	
	public Seller() {
	}

	public Seller(Integer id, String name, String email, LocalDate birthDate, Double baseSalary) {
		Id = id;
		this.name = name;
		this.email = email;
		this.birthDate = birthDate;
		this.baseSalary = baseSalary;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Id, baseSalary, birthDate, email, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Seller other = (Seller) obj;
		return Objects.equals(Id, other.Id) && Objects.equals(baseSalary, other.baseSalary)
				&& Objects.equals(birthDate, other.birthDate) && Objects.equals(email, other.email)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Seller [Id=" + Id + ", name=" + name + ", email=" + email + ", birthDate=" + birthDate + ", baseSalary="
				+ baseSalary + "]";
	}
	
	
	
	
	

}
