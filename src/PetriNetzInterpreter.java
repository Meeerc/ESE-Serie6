import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PetriNetzInterpreter {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        PetriNetz petrinetz = erzeugeBeispielPetriNetz();
        if (!validate(petrinetz)) {
            throw new Exception("> Das Petri Netz enthält syntaktische Fehler.");
        }
        while (true) {
            for (Stelle stelle : petrinetz.getStellen()) {
                System.out.println(stelle.getName() + ": token=" + stelle.getTokens());
            }
            List<Transition> schaltbereite = alleSchaltbereitenTransitionen(petrinetz);
            if (!schaltbereite.isEmpty()) {
                for (int i = 0; i < schaltbereite.size(); ++i) {
                    System.out.println("#" + i + " : " + schaltbereite.get(i).getName());
                }
                System.out.print("> Wählen Sie eine Transition aus: ");
                Transition transition = schaltbereite.get(scanner.nextInt());
                schalteTransition(transition);
            } else {
                System.out.print("> Das Petri-Netz ist terminiert.");
                break;
            }
        }
    }

    public static PetriNetz erzeugeBeispielPetriNetz() {

        PetriNetz example = new PetriNetz();

        Stelle stelle1 = new Stelle("S0", 10, 5);
        Stelle stelle2 = new Stelle("S1", 3, 0);
        Stelle stelle3 = new Stelle("S2", 6, 0);

        Pfeil pfeil1 = new Pfeil(1);
        Pfeil pfeil2 = new Pfeil(1);
        Pfeil pfeil3 = new Pfeil(2);

        example.addStelle(stelle1);
        example.addStelle(stelle2);
        example.addStelle(stelle3);

        Transition transition1 = new Transition("TO");
        example.addTransition(transition1);

        pfeil1.connectElements(stelle1, transition1);
        pfeil2.connectElements(transition1, stelle2);
        pfeil3.connectElements(transition1, stelle3);

        return example;
    }

    public static boolean validate(PetriNetz netz) {
        return netz.isValid();
    }

    public static boolean isSchaltbereit(Transition transition) {
        return transition.isReady();
    }

    public static List<Transition> alleSchaltbereitenTransitionen(PetriNetz netz) {
// TODO: ...return alle schaltbereiten Transitionen oder eine leere Liste
    }

    public static void schalteTransition(Transition transition) {
// TODO: ... bewegen der Tokens
    }
}
