package org.fundacionjala.JalaConverter.model;

import org.fundacionjala.JalaConverter.model.empleado.Empleado;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("modelPersistence");;

    @SuppressWarnings("unchecked")
    public static void main(String [] args) {

//        insertInicial();
//        imprimirTodo();

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Empleado e = new Empleado(13, "Perez", "pepito");
        Empleado e2 = new Empleado(14, "Martinez", "freddy");


        em.persist(e);
        em.persist(e2);
        em.getTransaction().commit();

        em.close();


        imprimirTodo();

    }

    private static void insertInicial() {
        EntityManager man = emf.createEntityManager();

        Empleado e = new Empleado(10, "Perez", "pepito");
        Empleado e2 = new Empleado(11, "Martinez", "freddy");

        man.getTransaction().begin();
        man.persist(e);
        man.persist(e2);
//        man.getTransaction().commit();

        man.close();
    }

    @SuppressWarnings("unchecked")
    private static void imprimirTodo() {
        EntityManager man = emf.createEntityManager();
        List<Empleado> emps = (List<Empleado>) man.createQuery("FROM Empleado").getResultList();
        System.out.println("\nHay " + emps.size() + " empleados en el sistema\n\n");
        for (Empleado emp : emps) {
            System.out.println(emp.toString());
        }
        man.close();
    }

}

