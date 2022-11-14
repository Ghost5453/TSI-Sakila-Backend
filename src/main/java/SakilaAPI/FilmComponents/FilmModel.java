package SakilaAPI.FilmComponents;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class FilmModel {
    //region Attributes
    private int filmID;
    private String filmTitle;
    private String filmDescription;
    private int filmLanguageID;
    private int filmRentalDuration;
    private float filmRentalPrice;
    private int filmLength;
    private float filmReplacementCost;
    private String filmRating;
    private String filmFeatures;
    //endregion

    //region Methods

    public int getFilmID() {
        return filmID;
    }

    public String getFilmTitle() {
        return filmTitle;
    }

    public String getFilmDescription() {
        return filmDescription;
    }

    public int getFilmLanguageID() {
        return filmLanguageID;
    }

    public int getFilmRentalDuration() {
        return filmRentalDuration;
    }

    public float getFilmRentalPrice() {
        return filmRentalPrice;
    }

    public int getFilmLength() {
        return filmLength;
    }

    public float getFilmReplacementCost() {
        return filmReplacementCost;
    }

    public String getFilmRating() {
        return filmRating;
    }

    public String getFilmFeatures() {
        return filmFeatures;
    }

    //endregion
}
