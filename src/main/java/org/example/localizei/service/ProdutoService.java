import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.example.localizei.dto.ProdutoRequestDto;
//import org.example.localizei.dto.ProdutoResponseDto;
//import org.example.localizei.entities.ProdutoEntity;
//import org.example.localizei.entities.UsuarioEntity;
//import org.example.localizei.mapper.ProdutoMapper;
//import org.example.localizei.mapper.UsuarioMapper;
//import org.example.localizei.repository.ProdutoRepository;
//import org.example.localizei.repository.UsuarioRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class ProdutoService {
//
//    private final ProdutoRepository produtoRepository;
//    private final UsuarioRepository usuarioRepository;
//    private final ProdutoMapper produtoMapper;
//    private final UsuarioMapper usuarioMapper;
//
//    @Transactional
//    public ProdutoResponseDto criarProduto(ProdutoRequestDto request) {
//        // Busca o usuário pelo ID do DTO
//        UsuarioEntity usuario = usuarioMapper.toEntity(usuarioRepository.findById(request.usuarioId()));
//
//        // Converte DTO para entidade (ignora "usuario")
//        ProdutoEntity produto = produtoMapper.toEntity(request);
//
//        // Associa o usuário manualmente
//        produto.setUsuario(usuario);
//
//        // Salva e retorna a resposta
//        ProdutoEntity salvo = produtoRepository.save(produto);
//        return produtoMapper.toResponse(salvo);
//    }
//}