package kevat22.Jasendatabase;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


import kevat22.Jasendatabase.domain.Jasen;
import kevat22.Jasendatabase.domain.JasenRepository;
import kevat22.Jasendatabase.domain.Jasenyys;
import kevat22.Jasendatabase.domain.JasenyysRepository;
import kevat22.Jasendatabase.domain.Tapahtuma;
import kevat22.Jasendatabase.domain.TapahtumaRepository;
import kevat22.Jasendatabase.domain.Yhdistys;
import kevat22.Jasendatabase.domain.YhdistysRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class JasenRepositoryTest {
	@Autowired
	private JasenRepository repository;
	
	@Autowired
	private TapahtumaRepository trepository;
	
	@Autowired
	private JasenyysRepository jrepository;
	
	@Autowired
	private YhdistysRepository yrepository;
	
		
	@Test
	public void findBySukunimiShouldReturnEtunimi() {//toimii
		List<Jasen> jasenet = repository.findBySukunimi("Ankka");
		assertThat(jasenet.get(0).getEtunimi()).isEqualTo("Kalle");
		}
	//@Test
	/*public void findSukunimiShouldReturnSize() {//toimii, etsii montako tällä sukunimellä on 2
		List<Jasen> jasenet = repository.findByPostinumero("00500");
		assertThat(jasenet).hasSize(3);
		
		}*/
	@Test
	public void findPonoShouldReturnSize() {//toimii, etsii montako tällä postinumerolla on 3
		List<Jasen> jasenet = repository.findByPostinumero("00500");
		assertThat(jasenet).hasSize(3);
		
		}
	@Test
	public void findTapahtumaShouldReturnName() {
		List<Tapahtuma> tapahtumat = trepository.findByName("Kevät");
		assertThat(tapahtumat).hasSize(1);
		
		}
		
	@Test
	public void findJasenyysShouldReturnName() {
		List<Jasenyys> jasenyydet = jrepository.findByName("Nuoriso");
		assertThat(jasenyydet).hasSize(1);
		
		}
	@Test
	public void findYhdistysShouldReturnName() {
		List<Yhdistys> yhdistykset = yrepository.findByName("Helsinki");
		assertThat(yhdistykset).hasSize(1);
		
		}
	
	@Test
	public void createNewJasen() {
	Jasen jasen= new Jasen("Testi", "jasen", "o1","00520","987", "anne@anne.fi",new Yhdistys("Helsinki"),new Jasenyys("Jasen"));
	 
	 repository.save(jasen);
	 assertThat(jasen.getId()).isNotNull();
}
	 @Test
	    public void deleteJasen() {
			List<Jasen> jasenet = repository.findBySukunimi("Ankka");
			Jasen jasen = jasenet.get(0);
			repository.delete(jasen);
			List<Jasen> newJasen = repository.findBySukunimi("Ankka");
			assertThat(newJasen).hasSize(0);
	     }
}
