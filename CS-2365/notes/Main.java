
public class Main {

    public static void main(String[] args) {
        System.out.print("success");
    }

    // parameterized constructor
    public Rectangle(double w, double l) {
        width = w;
        length = l;
    }

    // no-arg constructor
    public Rectangle() {
        width=1;
        length=1;
    }

    // copy constructor
    public Rectangle(Rectangle other) {
        width=other.width;
        length=other.length;
    }
}