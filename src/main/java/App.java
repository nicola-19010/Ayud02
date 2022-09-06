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

        repartir(baraja, manoJugador); //saca 2 cartas y se las da al jugador
        System.out.println("manoJugador inicial: "+manoJugador); //para visualizar-borrable
        repartir(baraja, manoDealer); //
        System.out.println("manoDealer inicial: "+manoDealer); //para visualizar-borrable

        jugar(baraja, manoJugador, manoDealer);
    }

    private static void jugar(List<String> baraja, List<String> manoJugador, List<String> manoDealer) {
        System.out.println("--------------BLACKJACK--------------");
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




}
