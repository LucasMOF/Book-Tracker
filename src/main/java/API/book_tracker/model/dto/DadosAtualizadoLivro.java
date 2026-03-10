package API.book_tracker.model.dto;

import API.book_tracker.model.StatusLivro;

public record DadosAtualizadoLivro(Long id, String titulo, String autor, int numeroPaginas, StatusLivro status) {
}
