package API.book_tracker.model.dto;

import API.book_tracker.model.StatusLivro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DadosCadastroLivro(

        @NotBlank(message = "O titulo não pode ser vazioa")
        String titulo,

        @NotBlank(message = "O autor não pode ser vazio")
        @Size(max = 50)
        String autor,

        int numeroPaginas,

        @NotNull(message = "O status não pode ser nulo")
        StatusLivro status

) {
}
