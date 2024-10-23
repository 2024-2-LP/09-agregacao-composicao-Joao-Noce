package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas) {
        if (descricao != null && !descricao.isBlank() && qtdEstrelas != null && qtdEstrelas <= 5.0 && qtdEstrelas >= 0.0) {
            Avaliacao avaliacao = new Avaliacao(descricao, qtdEstrelas);
            avaliacoes.add(avaliacao);
        }
    }

    public Double calcularMediaAvaliacoes() {
        Double soma = 0.0;
        if (avaliacoes.isEmpty()) return 0.0;
        for (Avaliacao avaliacaoAtual : avaliacoes) {
            soma += avaliacaoAtual.getQtdEstrelas();
        }
        return soma/avaliacoes.size();
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
