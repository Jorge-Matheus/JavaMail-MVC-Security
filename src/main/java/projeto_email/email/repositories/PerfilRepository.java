package projeto_email.email.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import projeto_email.email.model.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {

	List<Perfil> findByDesc(String desc);
}
