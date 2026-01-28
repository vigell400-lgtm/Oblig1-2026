package filmarkiv.klient;

import filmarkiv.adt.FilmarkivADT;
import filmarkiv.impl.Film;
import filmarkiv.impl.Sjanger;

public class Meny {
    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;
    public Meny(FilmarkivADT filmarkiv){
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }
    public void start(){
        filmarkiv.leggTilFilm(new Film(1, "Nolan", "Inception", 2000, "Disney", Sjanger.SCIFI));
        filmarkiv.leggTilFilm(new Film(2, "Jen", "Mulan", 2020, "Pixar", Sjanger.DRAMA));
        filmarkiv.leggTilFilm(new Film(3, "Spielberg", "jaws", 1995, "Universal", Sjanger.ACTION));
        filmarkiv.leggTilFilm(new Film(4, "Tarantino", "Inglourious", 2009, "WB", Sjanger.HISTORY));

        System.out.println("1: Legg til film");
        System.out.println("2: Skriv ut statistikk");

        int valg = tekstgr.valg("Velg: ");

        if (valg == 1) {
            Film nyFilm = tekstgr.lesFilm();
            filmarkiv.leggTilFilm(nyFilm);
        }
        else if (valg == 2) {
            tekstgr.skrivUtStatistikk(filmarkiv);
        }
    }
}