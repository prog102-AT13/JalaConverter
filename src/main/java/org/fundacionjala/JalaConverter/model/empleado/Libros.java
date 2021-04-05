package org.fundacionjala.JalaConverter.model.empleado;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "LIBROS")
public class Libros {

    @Id
    @Column(name = "ID_LIBRO")
    private int id;

    @Column(name = "TITULO")
    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTOR_ID")
    private Autor autor;

    public Libros() {

    }

    public Libros(int id, String titulo, Autor autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libros libros = (Libros) o;
        return id == libros.id &&
                titulo.equals(libros.titulo) &&
                autor.equals(libros.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, autor);
    }

    @Override
    public String toString() {
        return "Libros{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                '}';
    }
}
