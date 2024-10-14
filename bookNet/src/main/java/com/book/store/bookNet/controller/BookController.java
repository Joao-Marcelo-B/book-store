package com.book.store.bookNet.controller;

import com.book.store.bookNet.model.Books;
import com.book.store.bookNet.model.DadosAlteracaoBook;
import com.book.store.bookNet.model.DadosCadastroBook;
import com.book.store.bookNet.model.book.BooksRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BooksRepository repository;

    @GetMapping("/formulario")
    public String carregaFormulario(Long id, Model model) {
        if(id != null){
            Books book = repository.getReferenceById(id);
            model.addAttribute("book", book);
        }
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

    @PutMapping("/formulario")
    @Transactional
    public String alterarBooks(@RequestParam Long id, DadosAlteracaoBook dados) {
        Books book = repository.getReferenceById(id);
        book.atualizarDados(dados);
        repository.save(book);
        return "redirect:/books/listagem";
    }

    @DeleteMapping
    @Transactional
    public String deleteBook(@RequestParam Long id) {
        repository.deleteById(id);
        return "redirect:/books/listagem";
    }
}
