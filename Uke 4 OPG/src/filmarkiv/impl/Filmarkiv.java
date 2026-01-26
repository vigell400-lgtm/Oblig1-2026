package filmarkiv.impl;

import filmarkiv.adt.FilmarkivADT;
import filmarkiv.impl.Sjanger;


public class Filmarkiv implements FilmarkivADT {
    private Film[] filmer;
    private int antall;

    public Filmarkiv(int storrelse) {
        filmer = new Film[storrelse];
        antall = 0;
    }

    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
           if (filmer[i].getFilmnr() == nr) {
               return filmer[i];
           }
        }
        return null;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i <antall; i++) {
            if (filmer[i].getFilmnr() == filmnr) {
                for (int j = i; j < antall-1; j++) {
                    filmer[j] = filmer[j+1];
                }

                filmer[--antall] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] temp = new Film[antall];
        int treff = 0;

        for (int i = 0; i < antall; i++) {
            if(filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
              temp[treff++] = filmer[i];
            }
        }

        return trimTab(temp, treff);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] temp = new Film[antall];
        int treff = 0;

        for (int i = 0; i < antall; i++) {
            if(filmer[i].getFilmskaper().toLowerCase().contains(delstreng.toLowerCase())) {
                temp[treff++] = filmer[i];
            }
        }

        return trimTab(temp, treff);
    }

    @Override
    public int antall() {
        return antall;
    }

    @Override
    public int antall(Sjanger sjanger) {
        int count = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getSjanger() == sjanger) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        if (antall == filmer.length) {
            utvid();
        }
        filmer[antall++] = nyFilm;
    }

    private Film[] trimTab(Film[] tab, int n) {
// n er antall elementer
        Film[] nytab = new Film[n];
        int i = 0;
        while (i < n) {
            nytab[i] = tab[i];
            i++;
        }
        return nytab;
    }

    private void utvid() {
        Film[] ny = new Film[filmer.length * 2];
        for (int i = 0; i < antall; i++) {
            ny[i] = filmer[i];
        }
        filmer = ny;
    }
}
