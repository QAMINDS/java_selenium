package module1.java_basic;

import org.openqa.selenium.NotFoundException;

//import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneBook {

    //HashMap<Integer, String> directorioTel = new HashMap<>();
    Map<Integer, String> directorioTel = new LinkedHashMap<>();

    public void insert(Integer numero, String nombre) {
        directorioTel.put(numero, nombre);
        System.out.println("Contacto agregado: " + numero + ". Nombre: " + nombre);
    }


    public String lookUp(Integer numero) {
        System.out.println("\nBuscando contacto: " + numero);
        String nombre = directorioTel.getOrDefault(numero, null);
        if (nombre == null) {
            throw new NotFoundException("Número no encontrado.");
        } else {
            System.out.println("El nombre del contacto es: " + nombre);
            return nombre;
        }
    }


    public void delete(Integer numero) {
        String nombre = directorioTel.getOrDefault(numero, null);
        if (nombre == null) {
            throw new NotFoundException("Número no encontrado. No se puede borrar.");
        } else {
            System.out.println("\nContacto eliminado: " + numero + ": " + nombre);
            directorioTel.remove(numero);
        }
    }


    public void updateName(Integer numero, String nuevoNombre) {
        String nombre = directorioTel.getOrDefault(numero, null);
        if (nombre == null) {
            throw new NotFoundException("Número no encontrado. No se puede actualizar.");
        } else {
            System.out.println("\nContacto actualizado: " + numero + ". Nuevo nombre: " + nuevoNombre);
            directorioTel.replace(numero, nuevoNombre);
        }
    }

    public void mostrarDirectorio() {
        System.out.println("\nTodos sus contactos:");

        directorioTel.forEach((key, value) -> {
            System.out.println("Número: " + key + " Nombre: " + value);
        });

    }

}
