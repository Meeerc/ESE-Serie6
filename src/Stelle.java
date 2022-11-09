

public class Stelle extends Element {

    private int kapazitaet = 1;
    private int tokens;

    public Stelle(String name, int kapazitaet, int tokens) {
        super(name);
        this.kapazitaet = kapazitaet;
        this.tokens = tokens;
    }

    @Override
    public boolean isValid() {

        for (Pfeil pfeil : super.getOutgoingArrows()){
            if(!pfeil.targetIsTransition()){
                return false;
            }
        }
        return tokens <= kapazitaet && kapazitaet >= 1 && tokens >= 0;
    }

    @Override
    public boolean isTransition() {
        return false;
    }

    @Override
    public boolean isStelle() {
        return true;
    }

    public boolean readyToSendTokens(int number) {
        return this.tokens >= number;
    }

    public boolean readyToReceiveTokens(int number) {
        return this.kapazitaet - this.tokens >= number;
    }

    public int getTokens() {
        return this.tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public int getKapazitaet(){
        return this.kapazitaet;
    }

    public void setKapazitaet(int kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    public int getDiff() {
        return this.kapazitaet - this.tokens;
    }

}
