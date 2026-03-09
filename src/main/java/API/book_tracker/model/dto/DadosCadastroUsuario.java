package API.book_tracker.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DadosCadastroUsuario(
        @NotBlank(message = "O login não pode ser vazio")
        String login,

        @NotBlank(message = "A senha não pode ser vazio")
        @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
        String senha) {

}
