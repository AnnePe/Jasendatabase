package kevat22.Jasendatabase.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Jasenyys {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy ="jasenyys")
	
	private List<Jasen> jasenet;
	
	public Jasenyys() {}
		

	public Jasenyys(String name) {
		super();
		this.name = name;
		}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Jasen> getJasenet() {
		return jasenet;
	}

	public void setJasenet(List<Jasen> jasenet) {
		this.jasenet = jasenet;
	}



	@Override
	public String toString() {
		return "Jasenyys [id=" + id + ", name=" + name + "]";
	}
	
	
}
