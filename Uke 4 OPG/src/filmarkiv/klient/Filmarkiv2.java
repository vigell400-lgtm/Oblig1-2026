package filmarkiv.klient;

import filmarkiv.adt.FilmarkivADT;
import filmarkiv.impl.Film;
import filmarkiv.impl.Sjanger;

public class Filmarkiv2 implements FilmarkivADT {

    private int antall;
    private LinearNode<Film> start;

    public Filmarkiv2() {
        antall = 0;
        start = null;
    }


    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> p = start;

        while (p != null) {
            if (p.getData().getFilmnr() == nr) {
                return p.getData();
            }
            p = p.getNeste();
        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> ny = new LinearNode<>(nyFilm);
        ny.setNeste(start);
        start = ny;
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        if(start == null) {
            return false;
        }

        if (start.getData().getFilmnr() == filmnr) {
            start = start.getNeste();
            antall--;
            return true;
        }

        LinearNode<Film> forrige = start;
        LinearNode<Film> aktuell = start.getNeste();

        while (aktuell != null) {
            if (aktuell.getData().getFilmnr() == filmnr) {
                forrige.setNeste(aktuell.getNeste());
                antall--;
                return true;
            }
            forrige = aktuell;
            aktuell = aktuell.getNeste();
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] temp = new Film[antall];
        int i = 0;

        LinearNode<Film> p = start;
        while (p != null) {
            if (p.getData().getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                temp[i++] = p.getData();
            }
            p = p.getNeste();
        }
        return trimTab(temp, i);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] temp = new Film[antall];
        int i = 0;

        LinearNode<Film> p = start;
        while (p != null) {
            if (p.getData().getFilmskaper().toLowerCase().contains(delstreng.toLowerCase())) {
                temp[i++] = p.getData();
            }
            p = p.getNeste();
        }
        return trimTab(temp, i);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        LinearNode<Film> p = start;

        while(p != null) {
            if (p.getData().getSjanger() == sjanger) {
                teller ++;
            }
            p = p.getNeste();
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }

    private Film[] trimTab(Film[] tab, int n) {
        Film[] ny = new Film[n];
        for (int i = 0; i < n; i++) {
            ny[i] = tab[i];
        }
        return ny;
    }
}
