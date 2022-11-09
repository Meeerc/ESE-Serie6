import java.util.ArrayList;

public class Transition extends Element {


    public Transition(String name) {
        super(name);
    }

    @Override
    public boolean isValid() {
        for (Pfeil pfeil : super.getOutgoingArrows()) {
            if (!pfeil.targetIsStelle()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isTransition() {
        return true;
    }

    @Override
    public boolean isStelle() {
        return false;
    }


    public boolean isReady() {
        return this.areSourcesReadyToSend() && this.areTargetsReadyToSend();
    }

    private boolean areTargetsReadyToSend() {
        for (Pfeil pfeil : super.getOutgoingArrows()) {
            if (!pfeil.isTargetReadyToReceive()) {
                return false;
            }
        }
        return true;
    }

    private boolean areSourcesReadyToSend() {
        for (Pfeil pfeil : super.getIncomingArrows()) {
            if (!pfeil.isSourceReadyToSend()) {
                return false;
            }
        }
        return true;
    }

    public void opperate() {
        int number = 0;
        for (Pfeil pfeil: super.getIncomingArrows()){
            Stelle temp =  (Stelle) pfeil.getSource();
            number += temp.getTokens() - pfeil.getGewicht();
        }
        for (Pfeil pfeil : super.getOutgoingArrows()) {
            Stelle temp = (Stelle) pfeil.getTarget();
            if (number > 0) {
                number -= Math.min(temp.getDiff(), pfeil.getGewicht());
            }
        }
    }


}
