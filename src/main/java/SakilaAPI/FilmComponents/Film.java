package SakilaAPI.FilmComponents;

import SakilaAPI.ActorComponents.Actor;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="film")
public class Film {

    //region Attributes
    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    Set <Actor> filmActor;

    @Id @Column(name = "film_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmID;

    @Column(name = "title")
    private String filmTitle;

    @Column(name = "description")
    private String filmDescription;

    @Column(name = "language_id")
    private int filmLanguageID;

    @Column(name = "rental_duration")
    private int filmRentalDuration;

    @Column(name = "rental_rate")
    private float filmRentalPrice;

    @Column(name = "length")
    private int filmLength;

    @Column(name = "replacement_cost")
    private float filmReplacementCost;

    @Column(name = "rating")
    private String filmRating;

    @Column(name = "special_features")
    private String filmFeatures;




    //endregion

    //region Constructors
    public Film(int myID, String myTitle, String myDescription, int myLanguageID, int myFilmRentalDuration, float myRentalPrice, int myLength, float myReplacementCost, String myRating, String myFeatures)
    {
        filmID = myID;
        filmTitle = myTitle;
        filmDescription = myDescription;
        filmLanguageID = myLanguageID;
        filmRentalDuration = myFilmRentalDuration;
        filmRentalPrice = myRentalPrice;
        filmLength = myLength;
        filmReplacementCost = myReplacementCost;
        filmRating = myRating;
        filmFeatures = myFeatures;
    }

    public Film()
    {

    }
    //endregion

    //region Methods
    //region Getters

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

    //region Setters

    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }

    public void setFilmTitle(String filmTitle) {
        this.filmTitle = filmTitle;
    }

    public void setFilmDescription(String filmDescription) {
        this.filmDescription = filmDescription;
    }

    public void setFilmLanguageID(int filmLanguageID) {
        this.filmLanguageID = filmLanguageID;
    }

    public void setFilmRentalDuration(int filmRentalDuration) {
        this.filmRentalDuration = filmRentalDuration;
    }

    public void setFilmRentalPrice(float filmRentalPrice) {
        this.filmRentalPrice = filmRentalPrice;
    }

    public void setFilmLength(int filmLength) {
        this.filmLength = filmLength;
    }

    public void setFilmReplacementCost(float filmReplacementCost) {
        this.filmReplacementCost = filmReplacementCost;
    }

    public void setFilmRating(String filmRating) {
        this.filmRating = filmRating;
    }

    public void setFilmFeatures(String filmFeatures) {
        this.filmFeatures = filmFeatures;
    }

    //endregion
    //endregion

}
