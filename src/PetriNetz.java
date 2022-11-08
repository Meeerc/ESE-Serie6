import java.util.ArrayList;

public class PetriNetz {

    private ArrayList<Transition> transitions = new ArrayList<>();
    private ArrayList<Stelle> stellen = new ArrayList<>();

    public PetriNetz(ArrayList<Transition> transitions, ArrayList<Stelle> stellen) {
        this.stellen = stellen;
        this.transitions = transitions;
    }

    public PetriNetz() {
    }


    public void addStelle(Stelle stelle) {
        stellen.add(stelle);
    }

    public void addTransition(Transition transition) {
        transitions.add(transition);
    }

    public ArrayList<Stelle> getStellen() {
        return this.stellen;
    }

    public void setStellen(ArrayList<Stelle> stellen) {
        this.stellen = stellen;
    }

    public ArrayList<Transition> getTransitions() {
        return this.transitions;
    }

    public void setTransitions(ArrayList<Transition> transitions) {
        this.transitions = transitions;
    }


    public boolean isValid() {
        return this.areArrowsValid() && this.areStellenValid() && this.areTransitionsValid();
    }

    private boolean areTransitionsValid() {
        for (Transition t : this.transitions) {
            if (!t.isValid()) {
                return false;
            }
        }
        return true;
    }

    private boolean areStellenValid() {
        for (Stelle s : this.stellen) {
            if (!s.isValid()) {
                return false;
            }
        }
        return true;
    }

    private boolean areArrowsValid() {
        ArrayList<Pfeil> pfeile = new ArrayList<>();

        for (Transition t : this.transitions) {
            pfeile.addAll(t.getIncomingArrows());
            pfeile.addAll(t.getOutgoingArrows());
        }

        for (Pfeil pfeil : pfeile) {
            if (!pfeil.isValid()) {
                return false;
            }
        }
        return true;
    }
}
