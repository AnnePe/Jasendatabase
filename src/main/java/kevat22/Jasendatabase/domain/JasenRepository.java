package kevat22.Jasendatabase.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface JasenRepository extends CrudRepository<Jasen, Long>{
	List<Jasen> findBySukunimi(String sukunimi);
}
