public class Main {

    public static void main(String[] args) {

        NumarComplex nc = new NumarComplex(2f, 3f);

        System.out.println(Operatii.calculeaza(nc));
        System.out.println(Operatii.scadere(nc));
        System.out.println(Operatii.inmultire(nc));
        System.out.println(Operatii.impartire(nc));

    }
}
