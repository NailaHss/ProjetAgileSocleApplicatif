package ubo.fr.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ubo.fr.entities.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Integer> {

}