package dev.kurama.data;

import dev.kurama.model.Pregunta;
import dev.kurama.model.Usuario;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import javax.persistence.Query;

public class DataSource {


    private static Usuario[] usuarios = {
        new Usuario(1, "admin", "admin"),
        new Usuario(2, "a", "a"),
        new Usuario(3, "b", "b"),
        new Usuario(4, "c", "c"),
        new Usuario(5, "d", "d"),
        new Usuario(6, "e", "e")
    };

    public static Usuario[] getUsuarios() {
        return usuarios;
    }

    //    public static Optional<Usuario> getUsuario(String email, String pass) {
//        for (Usuario usuario : usuarios) {
//            if (usuario.getEmail().equals(email) && usuario.getPass().equals(pass))
//                return Optional.of(usuario);
//        }
//        return Optional.empty();
//    }
    public static Optional<Usuario> getUsuario(String email, String pass) {
        Query query = ConnectionFactory.getEntityManager().createNamedQuery("Usuario.findOne").setParameter("email", email).setParameter("pass", pass);
        try {
            Usuario usuario = (Usuario) query.getSingleResult();
            return Optional.of(usuario);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private static Pregunta[] preguntas = {
        new Pregunta("Pregunta 1", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5"),
        new Pregunta("Pregunta 2", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"),
        new Pregunta("Pregunta 3", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5", "Opcion 6"),
        new Pregunta("Pregunta 4", "Opcion 1", "Opcion 2"),
        new Pregunta("Pregunta 5", "Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4"),
        new Pregunta("Pregunta 6", "Opcion 1", "Opcion 2", "Opcion 3")
    };

    public static ArrayList<Pregunta> getPreguntas() {
        return new ArrayList<>(Arrays.asList(preguntas));
    }

    public static Usuario getUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id)
                return usuario;
        }
        return null;
    }
}
