package API.book_tracker.repository;

import API.book_tracker.model.Livro;
import API.book_tracker.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByUsuario(Usuario usuario);


}
