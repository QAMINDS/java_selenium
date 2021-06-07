package module1.java_basic;

import org.openqa.selenium.NotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

public class PhoneBook {

    Map<Integer, String> directorioTel = new LinkedHashMap<>();

    public void insert(Integer numero, String nombre) {
        directorioTel.put(numero, nombre);
        System.out.println("Contacto agregado: " + numero + ". Nombre: " + nombre);
    }


    public String lookUp(Integer numero) {
        System.out.println("Buscando contacto: " + numero);
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
            System.out.println("Contacto eliminado: " + numero + ": " + nombre);
            directorioTel.remove(numero);
        }
    }


    public void updateName(Integer numero, String nuevoNombre) {
        String nombre = directorioTel.getOrDefault(numero, null);
        if (nombre == null) {
            throw new NotFoundException("Número no encontrado. No se puede actualizar.");
        } else {
            System.out.println("Contacto actualizado: " + numero + ". Nuevo nombre: " + nuevoNombre);
            directorioTel.replace(numero, nuevoNombre);
        }
    }

    public void mostrarDirectorio() {
        System.out.println("Todos sus contactos:");

        directorioTel.forEach((key, value) -> {
            System.out.println("Número: " + key + " Nombre: " + value);
        });

    }

}
