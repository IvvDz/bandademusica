package interfaz;

import dominio.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

public class Interfaz {
    private Scanner scanner;

    public Interfaz() {
        this.scanner = new Scanner(System.in);
    }

    public String obtenerInput(String mensaje) {
        System.out.print(mensaje + " ");
        return scanner.nextLine();
    }

    public int elegirMetodo(String opcion) {
        try {
            return Integer.parseInt(opcion);
        } catch (NumberFormatException e) {
            return -1; // Código de error para opción no válida
        }
    }

    public Actuacion crearActuacion() {
        System.out.print("Ingrese la fecha de la actuación (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(obtenerInput(""));
        Actuacion actuacion = new Actuacion(fecha);

        System.out.print("Ingrese el nombre del director: ");
        String nombreDirector = obtenerInput("");
        Director director = new Director(nombreDirector);
        actuacion.annadirParticipante(director);

        System.out.print("Ingrese el nombre del músico socio: ");
        String nombreMusicoSocio = obtenerInput("");
        System.out.print("Ingrese el instrumento del músico socio: ");
        String instrumentoMusicoSocio = obtenerInput("");
        System.out.print("Ingrese el número de socio del músico socio: ");
        int numeroSocio = Integer.parseInt(obtenerInput(""));
        MusicoSocio musicoSocio = new MusicoSocio(nombreMusicoSocio, instrumentoMusicoSocio, numeroSocio);
        actuacion.annadirParticipante(musicoSocio);

        System.out.print("Ingrese el nombre del músico de refuerzo: ");
        String nombreMusicoRefuerzo = obtenerInput("");
        System.out.print("Ingrese el instrumento del músico de refuerzo: ");
        String instrumentoMusicoRefuerzo = obtenerInput("");
        System.out.print("Ingrese la cantidad pagada al músico de refuerzo: ");
        BigDecimal cantidadRefuerzo = new BigDecimal(obtenerInput(""));
        MusicoRefuerzo musicoRefuerzo = new MusicoRefuerzo(nombreMusicoRefuerzo, instrumentoMusicoRefuerzo, cantidadRefuerzo);
        actuacion.annadirParticipante(musicoRefuerzo);

        return actuacion;
    }
}
