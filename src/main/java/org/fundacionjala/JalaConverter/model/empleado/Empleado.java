package org.fundacionjala.JalaConverter.model.empleado;


import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "EMPLEADO")

public class Empleado implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "COD_EMPLEADO")
    private int codigo;
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Column(name = "NOMBRE")
    private String nombre;

    @OneToOne
    @JoinColumn(name = "ID_DIRECCION")
    private Direccion direccion;

    public Empleado() {

    }

    public Empleado(int codigo, String apellidos, String nombre) {
        this.codigo = codigo;
        this.apellidos = apellidos;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "codigo=" + codigo +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion=" + direccion + '\'' +
                '}';
    }
}

