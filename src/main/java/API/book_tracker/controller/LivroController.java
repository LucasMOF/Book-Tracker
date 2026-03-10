package API.book_tracker.controller;

import API.book_tracker.model.Livro;
import API.book_tracker.model.Usuario;
import API.book_tracker.model.dto.DadosCadastroLivro;
import API.book_tracker.model.dto.DadosDetalharLivro;
import API.book_tracker.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    @PostMapping
    public ResponseEntity cadastrarLivro(@RequestBody @Valid DadosCadastroLivro dto){
        Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Livro novoLivro = new Livro();

        novoLivro.setTitulo(dto.titulo());
        novoLivro.setAutor(dto.autor());
        novoLivro.setNumeroPaginas(dto.numeroPaginas());
        novoLivro.setStatus(dto.status());
        novoLivro.setUsuario(usuarioLogado);

        livroRepository.save(novoLivro);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalharLivro>> listarLivro(){
        Usuario usuarioLogado = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        var livros = livroRepository.findByUsuario(usuarioLogado);
        var dtoList = livros.stream()
                .map(DadosDetalharLivro::new)
                .toList();

        return ResponseEntity.ok(dtoList);
    }
}
