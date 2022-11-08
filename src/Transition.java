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
}
