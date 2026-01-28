package filmarkiv.klient;

import filmarkiv.adt.FilmarkivADT;
import filmarkiv.impl.Film;
import filmarkiv.impl.Sjanger;
import filmarkiv.impl.Filmarkiv;

import java.util.Scanner;

public class Tekstgrensesnitt {
    Scanner scanner = new Scanner(System.in);

    // Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
    public Film lesFilm(){
        System.out.print("Filmnr: ");
        int nr = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Filmskaper: ");
        String filmskaper = scanner.nextLine();

        System.out.print("Tittel: ");
        String tittel = scanner.nextLine();

        System.out.print("År: ");
        int ar = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Filmselskap: ");
        String filmselskap = scanner.nextLine();

        System.out.print("Sjanger: ");
        String sjangerTekst = scanner.nextLine();
        Sjanger sjanger = Sjanger.finnSjanger(sjangerTekst);

        Film film = new Film(nr, filmskaper, tittel, ar, filmselskap, sjanger);
        System.out.println(film.getFilmnr() + ", "
        + film.getTittel() + ", "
        + film.getFilmskaper() + ", "
        + film.getAr() + ", "
        + film.getFilmselskap() + ", "
        + film.getSjanger());
        return  film;
    }


    // Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
    public void skrivUtFilm(Film film) {

        if (film == null) {
            System.out.println("Film finnes ikke");
            return;
        }
        else {
            System.out.println(film.getFilmnr() + ", "
                    + film.getTittel() + ", "
                    + film.getFilmskaper() + ", "
                    + film.getAr() + ", "
                    + film.getFilmselskap() + ", "
                    + film.getSjanger());
        }
    }

    // Skriver ut alle filmer med en spesiell delstreng i tittelen
    public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekTittel(delstreng);

        if ( filmer.length == 0) {
            System.out.println("Fant ikke film");
            return;
        }

        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }

    // Skriver ut alle Filmer av en produsent (produsent er delstreng)
    public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
        Film[] filmer = arkiv.soekProdusent(delstreng);

        if (filmer.length == 0) {
            System.out.println("Fant ikke film");
            return;
        }
        for (Film film : filmer) {
            skrivUtFilm(film);
        }
    }


    // Skriver ut en enkel statistikk som inneholder antall filmer totalt
// og hvor mange det er i hver sjanger.
    public void skrivUtStatistikk(FilmarkivADT arkiv) {
        System.out.println("Antall filmer: " + arkiv.antall());

        for(Sjanger sjanger : Sjanger.values()) {
            System.out.println(sjanger + ": " + arkiv.antall(sjanger));
        }
    }

// osv ... andre metoder

    public int valg(String tekst) {
        System.out.print(tekst + " ");
        int tall = scanner.nextInt();
        scanner.nextLine();
        return tall;
    }
}
