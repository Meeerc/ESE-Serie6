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
// TODO: ... return eines exemplarischen Petri-Netzes
    }
    public static boolean validate(PetriNetz netz) {
// TODO...return true wenn das Petri-Netz valide ist; ansonsten false
    }
    public static boolean isSchaltbereit(Transition transition) {
// TODO...return true falls die Transition schaltbereit ist; ansonsten false
    }
    public static List<Transition> alleSchaltbereitenTransitionen(PetriNetz netz) {
// TODO: ...return alle schaltbereiten Transitionen oder eine leere Liste
    }
    public static void schalteTransition(Transition transition) {
// TODO: ... bewegen der Tokens
    }
}
