package filmarkiv.impl;

import java.util.Objects;

public class Film {

    private int filmnr;
    private String filmskaper;
    private String tittel;
    private int ar;
    private String filmselskap;
    private Sjanger sjanger;

    public Film () {
    }

    public Film (int filmnr, String filmskaper, String tittel, int ar, String filmselskap, Sjanger sjanger) {
        this.filmnr = filmnr;
        this.filmskaper = filmskaper;
        this.tittel = tittel;
        this.ar = ar;
        this.filmselskap = filmselskap;
        this.sjanger = sjanger;
    }

        public int getFilmnr(){
        return filmnr;
        }
        public void setFilmnr(int filmnr){
        this.filmnr=filmnr;
        }

        public String getFilmskaper(){
            return filmskaper;
        }

        public void setFilmskaper(String filmskaper){
            this.filmskaper=filmskaper;
        }

        public String getTittel(){
            return tittel;
        }

        public void setTittel(String tittel){
            this.tittel=tittel;
        }

        public int getAr(){
            return ar;
        }
        public void setAr(int ar){
            this.ar=ar;
        }

        public String getFilmselskap(){
            return filmselskap;
        }

        public void setFilmselskap(String filmselskap){
            this.filmselskap=filmselskap;
        }

        public Sjanger getSjanger(){
            return sjanger;
        }

        public void setSjanger(Sjanger sjanger){
            this.sjanger=sjanger;
        }

        @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Film film = (Film) obj;
        return filmnr == film.filmnr;
        }

        @Override
    public int hashCode() {
        return Objects.hash(filmnr);
        }
    }



