package API.book_tracker.model.dto;

import API.book_tracker.model.Livro;
import API.book_tracker.model.StatusLivro;

public record DadosDetalharLivro(String titulo, String autor, int numeroPaginas, StatusLivro status) {

    public DadosDetalharLivro(Livro livro){
        this(livro.getTitulo(), livro.getAutor(), livro.getNumeroPaginas(), livro.getStatus());
    }
}
