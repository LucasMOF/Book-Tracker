package API.book_tracker.controller;

import API.book_tracker.model.Usuario;
import API.book_tracker.model.dto.DadosCadastroUsuario;
import API.book_tracker.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class AutenticacaoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroUsuario dto) {
        String senhaCriptografada = passwordEncoder.encode(dto.senha());

        Usuario novoUsuario = new Usuario();
        novoUsuario.setLogin(dto.login());
        novoUsuario.setSenha(senhaCriptografada);

        usuarioRepository.save(novoUsuario);
        return ResponseEntity.ok().build();
    }
}
