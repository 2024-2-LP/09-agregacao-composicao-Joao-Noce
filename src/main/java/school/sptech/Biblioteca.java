package school.sptech;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca() {
    }

    public Biblioteca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro) {
        if (livro != null && livro.getTitulo() != null && !livro.getTitulo().isBlank() && livro.getAutor() != null && !livro.getAutor().isBlank() && livro.getDataPublicacao() != null)
            livros.add(livro);
    }

    public void removerLivroPorTitulo(String titulo) {
        for (int i = 0; i < livros.size(); i++) {
            Livro livroAtual = livros.get(i);
            if (livroAtual.getTitulo().toLowerCase().equals(titulo.toLowerCase())) livros.remove(livroAtual);
        }
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        if (titulo != null && !titulo.isBlank()) {
            for (Livro livroAtual : livros) {
                if (livroAtual.getTitulo().toLowerCase().equals(titulo.toLowerCase())) return livroAtual;
            }
        }
        return null;
    }

    public Integer contarLivros() {
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano) {
        List<Livro> livrosAteAno = new ArrayList<>();

        for (int i = 0; i < livros.size(); i++) {
            Livro livroAtual = livros.get(i);
            if (livroAtual.getDataPublicacao().getYear() <= ano) livrosAteAno.add(livroAtual);
        }
        return livrosAteAno;
    }

    public List<Livro> retornarTopCincoLivros() {
        livros.sort(Comparator.comparingDouble(Livro::calcularMediaAvaliacoes).reversed());
        if (livros.size() >= 5) return livros.subList(0, 5);
        else return livros;
    }
}