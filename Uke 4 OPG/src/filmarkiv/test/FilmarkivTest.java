package filmarkiv.test;

import filmarkiv.adt.FilmarkivADT;
import filmarkiv.impl.Film;
import filmarkiv.impl.Filmarkiv;
import filmarkiv.impl.Sjanger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilmarkivTest {

    // tester film.java
    @Test
    public void testKonstruktørOgGet() {
        Film film = new Film(1,"Nolan", "Inception", 2000, "Disney", Sjanger.SCIFI);

        assertEquals(1, film.getFilmnr());
        assertEquals("Nolan", film.getFilmskaper());
        assertEquals("Inception", film.getTittel());
        assertEquals(2000, film.getAr());
        assertEquals("Disney", film.getFilmselskap());
        assertEquals(Sjanger.SCIFI, film.getSjanger());
    }
    @Test
    public void testEqualsLikFilmnr() {
        Film f1 = new Film(1, "Nolan", "Inception", 2000, "Disney", Sjanger.SCIFI);
        Film f2 = new Film(1, "Jen", "Mulan", 2020, "Pixar", Sjanger.DRAMA);

        assertEquals(f1, f2);
    }

    @Test
    public void testEqualsUlikFilmnr() {
        Film f1 = new Film(1, "Nolan", "Inception", 2000, "Disney", Sjanger.SCIFI);
        Film f2 = new Film(2, "Nolan", "Inception", 2000, "Disney", Sjanger.SCIFI);

        assertNotEquals(f1, f2);
    }

    @Test
    public void testHashCode() {
        Film f1 = new Film(1, "Nolan", "Inception", 2000, "Disney", Sjanger.SCIFI);
        Film f2 = new Film(1, "Jen", "Mulan", 2020, "Pixar", Sjanger.DRAMA);

        assertEquals(f1.hashCode(), f2.hashCode());
    }

    // tester filmarkiv.java
   private FilmarkivADT arkiv;

    @BeforeEach
    public void setup() {
        arkiv = new Filmarkiv(2);
    }

    @Test
    public void testLeggTilFinnFilm() {
        Film film = new Film(1, "Nolan", "Inception", 2000, "Disney", Sjanger.SCIFI);
        arkiv.leggTilFilm(film);

        Film funnet = arkiv.finnFilm(1);
        assertNotNull(funnet);
        assertEquals(film, funnet);
    }

    @Test
    public void testFinnesIkke() {
        assertNull(arkiv.finnFilm(10));
    }
    @Test
    public void testAntallFilmer() {
        arkiv.leggTilFilm(new Film(1, "Nolan", "Inception", 2000, "Disney", Sjanger.SCIFI));
        arkiv.leggTilFilm(new Film(2, "Jen", "Mulan", 2020, "Pixar", Sjanger.DRAMA));

        assertEquals(2, arkiv.antall());
    }

    @Test
    public void testSlettFilm() {
        Film f1 = new Film(1, "Nolan", "Inception", 2000, "Disney", Sjanger.SCIFI);
        Film f2 = new Film(2, "Nolan", "Inception", 2000, "Disney", Sjanger.SCIFI);

        arkiv.leggTilFilm(f1);
        arkiv.leggTilFilm(f2);

        assertTrue(arkiv.slettFilm(1));
        assertEquals(1, arkiv.antall());
        assertNull(arkiv.finnFilm(1));
        assertNotNull(arkiv.finnFilm(2));
    }
}
