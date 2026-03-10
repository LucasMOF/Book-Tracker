package API.book_tracker.model;

import API.book_tracker.model.dto.DadosAtualizadoLivro;
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

    public void atualizarDados(DadosAtualizadoLivro dados) {
        if (dados.titulo() != null) {
            this.titulo = dados.titulo();
        }

        if (dados.autor() != null) {
            this.autor = dados.autor();
        }

        if (dados.status() != null) {
            this.status = dados.status();
        }
    }
}
