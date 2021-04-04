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

        /**
         * otra forma de modificar
         */
//        EntityManager manager = emf.createEntityManager();
//        Empleado empleado1 = new Empleado(10, "Perez", "pepito");
//        manager.getTransaction().begin();
//        manager.persist(empleado1);
//        manager.getTransaction().commit();
//        manager.close();
//
//        imprimirTodo();
//
//        manager = emf.createEntityManager();
//        manager.getTransaction().begin();
//        empleado1 = manager.merge(empleado1);
//        empleado1.setNombre("nuevo");
//        manager.getTransaction().commit();
//        manager.close();



        /**
         * modificar un dato
         */

//        insertInicial();

//        imprimirTodo();
//        EntityManager manager = emf.createEntityManager();
//        manager.getTransaction().begin();
//        Empleado empleado = manager.find(Empleado.class, 11);
//        empleado.setNombre("Davod");
//        empleado.setApellidos("lopez");
//        manager.getTransaction().commit();
//        manager.close();

        imprimirTodo();

    }

    private static void insertInicial() {
        EntityManager manager = emf.createEntityManager();
        Empleado empleado1 = new Empleado(10, "Perez", "pepito");
        Empleado empleado2 = new Empleado(11, "Martinez", "freddy");
        manager.getTransaction().begin();
        manager.persist(empleado1);
        manager.persist(empleado2);
        manager.getTransaction().commit();
        manager.close();
    }

    @SuppressWarnings("unchecked")
    private static void imprimirTodo() {
        EntityManager man = emf.createEntityManager();
        List<Empleado> empleados = (List<Empleado>) man.createQuery("FROM Empleado").getResultList();
        System.out.println("\nHay " + empleados.size() + " empleados en el sistema\n\n");
        for (Empleado empleado : empleados) {
            System.out.println(empleado.toString());
        }
        man.close();
    }

}
