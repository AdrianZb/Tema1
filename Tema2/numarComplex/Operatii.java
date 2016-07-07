/**
 * Created by azburatura on 7/7/2016.
 */
public class Operatii {

    public static float calculeaza(NumarComplex numarComplex){
        return numarComplex.getRe() + numarComplex.getIm();
    }

    public static float scadere(NumarComplex numarComplex){
        return numarComplex.getRe() - numarComplex.getIm();
    }

    public static float inmultire(NumarComplex numarComplex){
        return numarComplex.getRe() * numarComplex.getIm();
    }

    public static float impartire(NumarComplex numarComplex){
        return numarComplex.getRe() / numarComplex.getIm();
    }

}
