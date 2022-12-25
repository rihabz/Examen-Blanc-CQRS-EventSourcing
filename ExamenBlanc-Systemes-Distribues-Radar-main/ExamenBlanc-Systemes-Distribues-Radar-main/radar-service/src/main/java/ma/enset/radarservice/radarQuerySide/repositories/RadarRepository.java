package ma.enset.radarservice.radarQuerySide.repositories;

import ma.enset.radarservice.radarQuerySide.entities.Radar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarRepository extends JpaRepository<Radar,String> {

}
