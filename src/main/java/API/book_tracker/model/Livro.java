package API.book_tracker.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private int numeroPaginas;

    @Enumerated(EnumType.STRING)
    private StatusLivro status;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
