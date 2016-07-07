/**
 * Created by azburatura on 7/7/2016.
 */

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Carte carte = new Carte();
        Carte carte2 = new Carte("Morometii", "Marin Perda", "Hamangiu", 1100);

            System.out.println("Introduceti titlul:");
            String titlu = scanner.nextLine();
            System.out.println("Introduceti autorul:");
            String autor = scanner.nextLine();
            System.out.println("Introduceti editura:");
            String editura = scanner.nextLine();
            System.out.println("Introduceti numarul de pagini:");
            int numarPagini = scanner.nextInt();
            carte.setTitlu(titlu);
            carte.setAutor(autor);
            carte.setEditura(editura);
            carte.setNumarPagini(numarPagini);

            verificaNumarPagini(numarPagini);

            System.out.println(carte);

            if(!verificaDuplicat(carte, carte2)){
                comparaGrosimeDouaCarti(carte, carte2);
            }else{
                System.out.println("Cartile sunt duplicate!!!");
            }



    }

    private static void verificaNumarPagini(int numarPagini) {
        if (numarPagini <= 0) {
            throw new NumberFormatException(Keys.MESAJ_NUMAR_PAGINI);
        }
    }

    private static void comparaGrosimeDouaCarti(Carte c1, Carte c2) {
        if (c1.getNumarPagini() > c2.getNumarPagini()) {
            System.out.println(Keys.CARTEA + c1 + Keys.MAI_GROASA);
        } else if (c1.getNumarPagini() == c2.getNumarPagini()) {
            System.out.println(Keys.NUMAR_PAGINI_EGALE);
        } else {
            System.out.println(Keys.CARTEA + c2 + Keys.MAI_GROASA);
        }
    }

    private static boolean verificaDuplicat(Carte c1, Carte c2){
        return c1.equals(c2);
    }

}
