package motor;

public class Colo {

    int r;
    int g;
    int b;

    public Colo(int r, int g, int b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "Color{" + "r=" + r + ", g=" + g + ", b=" + b + '}';
    }
    
}
