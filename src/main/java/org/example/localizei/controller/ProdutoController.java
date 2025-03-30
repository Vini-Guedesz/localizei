//package org.example.localizei.controller;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import org.example.localizei.dto.ProdutoRequestDto;
//import org.example.localizei.dto.ProdutoResponseDto;
//import org.example.localizei.service.ProdutoService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("api/produtos")
//@RequiredArgsConstructor
//public class ProdutoController {
//
//    private final ProdutoService produtoService;
//
//    @PostMapping("/criar")
//    public ResponseEntity<ProdutoResponseDto> criarProduto(@Valid @RequestBody ProdutoRequestDto produtoRequestDto) {
//        ProdutoResponseDto produtoResponseDto = produtoService.criarProduto(produtoRequestDto);
//
//    }
//
//}
