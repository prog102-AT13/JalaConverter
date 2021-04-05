package org.fundacionjala.JalaConverter.model.empleado;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "AUTORES")
public class Autor {

    @Id
    @Column(name = "AUTHOR_ID")
    private int id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "NACINALIDAD")
    private String nacinalidad;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libros> libros = new ArrayList<>();

    public Autor() {

    }

    public Autor(int id, String nombre, String nacinalidad) {
        this.id = id;
        this.nombre = nombre;
        this.nacinalidad = nacinalidad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacinalidad() {
        return nacinalidad;
    }

    public void setNacinalidad(String nacinalidad) {
        this.nacinalidad = nacinalidad;
    }

    public List<Libros> getLibros() {
        return libros;
    }

    public void setLibros(List<Libros> libros) {
        this.libros = libros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return id == autor.id &&
                Objects.equals(nombre, autor.nombre) &&
                Objects.equals(nacinalidad, autor.nacinalidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, nacinalidad);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nacinalidad='" + nacinalidad + '\'' +
                '}';
    }
}
