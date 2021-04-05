package org.fundacionjala.JalaConverter.model;

import org.fundacionjala.JalaConverter.model.empleado.Autor;
import org.fundacionjala.JalaConverter.model.empleado.Libros;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AutorDB {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("modelPersistence");

    public static void main(String[] args) {

        crearDatos();
        imprimirDatos();

    }

    static void crearDatos() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();

        Autor autor1 = new Autor(1,"Pablo Perez", "Espaniola");
        Autor autor2 = new Autor(2,"Elena Gomez", "Mexicana");
        Autor autor3 = new Autor(3,"Miguel Lopez", "Chilena");

        manager.persist(autor1);
        manager.persist(autor2);
        manager.persist(autor3);

        Libros libro1 = new Libros(1,"Programar Java es facil",autor2);
        Libros libro2 = new Libros(2,"Como vestirce con estilo",autor3);
        Libros libro3 = new Libros(3,"Como cocinar la cocina sin quemar la cocina",autor1);
        Libros libro4 = new Libros(4,"Programar en cobol es divertido",autor2);
        Libros libro5 = new Libros(5,"Programar en cobol no es divertido",autor2);

        manager.persist(libro1);
        manager.persist(libro2);
        manager.persist(libro3);
        manager.persist(libro4);
        manager.persist(libro5);

        manager.getTransaction().commit();
        manager.close();
    }

    static void imprimirDatos() {
        EntityManager manager = emf.createEntityManager();

        Autor autor = manager.find(Autor.class, 3);

        List<Libros> libros = autor.getLibros();

        System.out.println("--------------------------------------");
        for (Libros libs: libros) {
            System.out.println("* " + libs.toString());
        }

        System.out.println("--------------------------------------");
        System.out.println(autor.toString());

        manager.close();
    }

}
