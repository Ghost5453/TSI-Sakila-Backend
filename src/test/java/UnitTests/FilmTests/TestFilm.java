package UnitTests.FilmTests;

import SakilaAPI.FilmComponents.Film;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestFilm {
    private Film myTestFilm = new Film(
            6,
            "TEST FILM",
            "This is a test film that is being unit tested",
            1,
            5,
            4.99f,
            100,
            79.99f,
            "PG",
            "Deleted Scenes"
    );

    private Film myTestBlankFilm = new Film();

    //region Get Tests
    @Test
    public void testGetID()
    {
        Assertions.assertEquals(6, myTestFilm.getFilmID(), "Couldn't get film ID");
    }

    @Test
    public void testBlankGetID()
    {
        Assertions.assertEquals(0, myTestBlankFilm.getFilmID(), "Error with get for blank film");
    }

    @Test
    public void testGetTitle()
    {
        Assertions.assertEquals("TEST FILM", myTestFilm.getFilmTitle(), "Couldn't get film title");
    }

    @Test
    public void testGetDescription()
    {
        Assertions.assertEquals("This is a test film that is being unit tested", myTestFilm.getFilmDescription(), "Couldn't get description");
    }

    @Test
    public void testGetLanguage()
    {
        Assertions.assertEquals(1, myTestFilm.getFilmLanguageID(), "Couldn't get language ID");
    }

    @Test
    public void testGetRentalDuration()
    {
        Assertions.assertEquals(5, myTestFilm.getFilmRentalDuration(), "Couldn't get rental duration");
    }

    @Test
    public void testGetRentalPrice()
    {
        Assertions.assertEquals(4.99f, myTestFilm.getFilmRentalPrice(), "Couldn't get rental price");
    }

    @Test
    public void testGetFilmLength()
    {
        Assertions.assertEquals(100, myTestFilm.getFilmLength(), "Couldn't get film length");
    }

    @Test
    public void testGetFilmReplacementCost()
    {
        Assertions.assertEquals(79.99f,myTestFilm.getFilmReplacementCost(), "Couldn't get film replacement cost");
    }

    @Test
    public void testGetFilmRating()
    {
        Assertions.assertEquals("PG", myTestFilm.getFilmRating(), "Couldn't get film rating");
    }

    @Test
    public void testGetFilmFeatures()
    {
        Assertions.assertEquals("Deleted Scenes", myTestFilm.getFilmFeatures(), "Couldn't get film features");
    }
    //endregion

    //region Set Tests
    @Test
    public void testSetID()
    {
        myTestFilm.setFilmID(30);
        Assertions.assertEquals(30, myTestFilm.getFilmID(), "Couldn't set film ID");
    }

    @Test
    public void testBlankSetID()
    {
        myTestBlankFilm.setFilmID(54);
        Assertions.assertEquals(54, myTestBlankFilm.getFilmID(), "Error in getting ID after setting a blank film");
    }

    @Test
    public void testSetTitle()
    {
        myTestFilm.setFilmTitle("NEW TITLE");
        Assertions.assertEquals("NEW TITLE", myTestFilm.getFilmTitle(), "Couldn't set film title");
    }

    @Test
    public void testSetDescription()
    {
        myTestFilm.setFilmDescription("This is a different description to before");
        Assertions.assertEquals("This is a different description to before", myTestFilm.getFilmDescription(), "Couldn't set description");
    }

    @Test
    public void testSetLanguage()
    {
        myTestFilm.setFilmLanguageID(2);
        Assertions.assertEquals(2, myTestFilm.getFilmLanguageID(), "Couldn't set language ID");
    }

    @Test
    public void testSetRentalDuration()
    {
        myTestFilm.setFilmRentalDuration(6);
        Assertions.assertEquals(6, myTestFilm.getFilmRentalDuration(), "Couldn't set rental duration");
    }

    @Test
    public void  testSetRentalPrice()
    {
        myTestFilm.setFilmRentalPrice(9.99f);
        Assertions.assertEquals(9.99f, myTestFilm.getFilmRentalPrice(), "Couldn't set rental price");
    }

    @Test
    public void testSetFilmLength()
    {
        myTestFilm.setFilmLength(150);
        Assertions.assertEquals(150, myTestFilm.getFilmLength(), "Couldn't set film length");
    }

    @Test
    public void testSetFilmReplacementCost()
    {
        myTestFilm.setFilmReplacementCost(29.99f);
        Assertions.assertEquals(29.99f,myTestFilm.getFilmReplacementCost(), "Couldn't set film replacement cost");
    }

    @Test
    public void testSetFilmRating()
    {
        myTestFilm.setFilmRating("R");
        Assertions.assertEquals("R", myTestFilm.getFilmRating(), "Couldn't set film rating");
    }

    @Test
    public void testSetFilmFeatures()
    {
        myTestFilm.setFilmFeatures("Behind the Scenes");
        Assertions.assertEquals("Behind the Scenes", myTestFilm.getFilmFeatures(), "Couldn't set film features");
    }
    //endregion
}
