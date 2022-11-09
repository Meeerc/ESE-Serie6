

public class Pfeil {

    private int gewicht = 1;
    private Element source;
    private Element target;


    public Pfeil(int gewicht) {
        this.gewicht = gewicht;
    }

    public void connectElements(Element source, Element target) {
        this.source = source;
        this.target = target;

        this.source.addOutgoingArrow(this);
        this.target.addIncomingArrow(this);
    }

    public boolean isValid() {
        return source != null && target != null && this.gewicht >= 1;
    }


    public int getGewicht() {
        return gewicht;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }


    public boolean targetIsTransition() {
        return target.isTransition();
    }

    public boolean targetIsStelle(){
        return target.isStelle();
    }

    public boolean isTargetReadyToReceive() {
        return this.target.readyToReceiveTokens(this.gewicht);
    }

    public boolean isSourceReadyToSend() {
        return this.source.readyToSendTokens(this.gewicht);
    }
    public Element getTarget(){
        return this.target;
    }
    public Element getSource() {
        return this.source;
    }


}
