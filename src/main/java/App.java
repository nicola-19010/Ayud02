import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        iniciar();

    }

    public static void iniciar() { //crea lo necesario para empezar a jugar
        List<String> baraja = crearBaraja();
        System.out.println("Baraja Generada: "+baraja); //para visualizar-borrable
        barajar(baraja);
        System.out.println("Baraja Barajada: "+baraja); //para visualizar-borrable

        List<String> manoJugador = crearMano();
        List<String> manoDealer = crearMano();

        mostrarNumeroCartasEnBaraja(baraja);
        repartir(baraja, manoJugador);
        System.out.println("manoJugador inicial: "+manoJugador); //para visualizar-borrable
        repartir(baraja, manoDealer);
        System.out.println("manoDealer inicial: "+manoDealer); //para visualizar-borrable

        mostrarNumeroCartasEnBaraja(baraja);

        jugar(baraja, manoJugador, manoDealer);
    }

    private static void mostrarNumeroCartasEnBaraja(List<String> baraja) {
        System.out.println("Numero de cartas en baraja: " + baraja.size());
    }

    private static void jugar(List<String> baraja, List<String> manoJugador, List<String> manoDealer) {
        System.out.println("--------------BLACKJACK--------------");

        while (true){
            mostrarManos(manoJugador, manoDealer);
            System.out.print("\nEscriba (P) para pedir carta o (B) para bajarse.\n> ");
            String opcion = leerOpcion();
            if (opcion.equals("P")) {
                pedirCarta(baraja, manoJugador);
                System.out.println();
                mostrarNumeroCartasEnBaraja(baraja); //borrar
            }
            if (opcion.equals("B")) {
                bajarse(baraja, manoJugador, manoDealer);
                break;
            }
        }

    }

    private static void bajarse(List<String> baraja, List<String> manoJugador, List<String> manoDealer) {
    }

    private static String leerOpcion() {
        Scanner scanner = new Scanner(System.in);
        String opcion = scanner.next();
        return opcion;
    }


    private static void mostrarManos(List<String> manoJugador, List<String> manoDealer) {
        System.out.println("manoDealer = " + manoDealer); //buscar como ocultar solo una carta del dealer
        System.out.println("manoJugador = " + manoJugador);
    }

    private static void repartir(List<String> baraja, List<String> mano) { //pide la carta inicial para el jugador y el de dealer
        pedirCarta(baraja, mano);
        pedirCarta(baraja, mano);
    }

    private static void pedirCarta(List<String> baraja, List<String> mano) {
        String carta;
        //buscar como obtener el primer elemento arraylist
        carta = baraja.get(0);
        //System.out.println(carta);
        mano.add(carta);
        baraja.remove(carta);
    }

    private static List<String> crearMano() {
        List<String> mano = new ArrayList<>();
        return mano;
    }

    private static void barajar(List<String> baraja) {
        Collections.shuffle(baraja);
    }

    public static List<String> crearBaraja() {

        var pintas = new String[] {"CORAZON", "TREBOL", "DIAMANTE", "PICA"};
        var numerosCartas = new String[] {"AS", "DOS", "TRES", "CUATRO", "CINCO", "SEIS", "SIETE", "OCHO", "NUEVE", "DIEZ", "JOTA", "QUINA", "KAISER"};

        List<String> baraja = new ArrayList<>();

        for (String p : pintas) {
            for (String n : numerosCartas) {
                baraja.add(p + " " + n);
            }
        }

        return baraja;
    }

    public static int obtenerValorDeMano(List<String> mano){
        int valorTotal = 0;

        for (String carta: mano) {
            valorTotal += obtenerValorDeCarta(carta);
        }

        return valorTotal;
    }
    public static int obtenerValorDeCarta(String carta){
        String valor = carta.split(" ")[1];

        return switch (valor) {
            case "AS" -> 1;
            case "DOS" -> 2;
            case "TRES" -> 3;
            case "CUATRO" -> 4;
            case "CINCO" -> 5;
            case "SEIS" -> 6;
            case "SIETE" -> 7;
            case "OCHO" -> 8;
            case "NUEVE" -> 9;
            case "DIEZ", "JOTA", "QUINA", "KAISER" -> 10;
            default -> 0;
        };


    }




}
