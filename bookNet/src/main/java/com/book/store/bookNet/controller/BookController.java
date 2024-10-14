package com.book.store.bookNet.controller;

import com.book.store.bookNet.model.Books;
import com.book.store.bookNet.model.DadosCadastroBook;
import com.book.store.bookNet.model.book.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BooksRepository repository;

    @GetMapping("/formulario")
    public String carregaFormulario() {
        return "/books/formulario";
    }

    @GetMapping("/listagem")
    public String carregaListagem(Model model) {
        model.addAttribute("lista", repository.findAll());
        return "/books/listagem";
    }

    @PostMapping("/formulario")
    public String cadastraFilme(DadosCadastroBook dados) {
        Books book = new Books(dados);
        repository.save(book);
        return "redirect:/books/listagem";
    }
}
