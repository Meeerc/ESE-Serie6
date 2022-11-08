import java.util.ArrayList;

public abstract class Element {

    private String name;
    private ArrayList<Pfeil> incomingArrows = new ArrayList<>();
    private ArrayList<Pfeil> outgoingArrows = new ArrayList<>();

    public Element (String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addIncomingArrow(Pfeil arrow) {
        incomingArrows.add(arrow);
    }

    public void addOutgoingArrow(Pfeil arrow) {
        outgoingArrows.add(arrow);
    }

    public abstract boolean isValid();

    public ArrayList<Pfeil> getOutgoingArrows() {
        return this.outgoingArrows;
    }

    public ArrayList<Pfeil> getIncomingArrows() {
        return incomingArrows;
    }
    public abstract boolean isTransition();
    public abstract boolean isStelle();

    public boolean readyToReceiveTokens(int gewicht) {
        return true;
    }

    public boolean readyToSendTokens(int gewicht) {
        return true;
    }
}