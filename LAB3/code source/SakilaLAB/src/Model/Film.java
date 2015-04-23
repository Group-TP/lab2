package Model;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.annotations.LazyToOne;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the film database table.
 * 
 */
@Entity
@Table(name="film")
public class Film implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="film_id")
	private int filmId;

    @Lob()
	private String description;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	private int length;

	private String rating;

    @Temporal( TemporalType.DATE)
	@Column(name="release_year")
	private Date releaseYear;

	@Column(name="rental_duration")
	private byte rentalDuration;

	@Column(name="rental_rate")
	private BigDecimal rentalRate;

	@Column(name="replacement_cost")
	private BigDecimal replacementCost;

	@Column(name="special_features")
	private String specialFeatures;

	private String title;

	//bi-directional many-to-one association to Language
    @ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="language_id")
	private Language language1;

	//bi-directional many-to-one association to Language
    @ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="original_language_id")
	private Language language2;

	//bi-directional many-to-one association to FilmActor
	@OneToMany( mappedBy="film",cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	private Set<FilmActor> filmActors;

	//bi-directional many-to-one association to FilmCategory
	@OneToMany(mappedBy="film",cascade=CascadeType.ALL)
	private Set<FilmCategory> filmCategories;

	//bi-directional many-to-one association to Inventory
	@OneToMany( mappedBy="film",cascade=CascadeType.ALL, fetch= FetchType.EAGER)
	private Set<Inventory> inventories;

    public Film() {
    }

	public int getFilmId() {
		return this.filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public int getLength() {
		return this.length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getRating() {
		return this.rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public Date getReleaseYear() {
		return this.releaseYear;
	}

	public void setReleaseYear(Date releaseYear) {
		this.releaseYear = releaseYear;
	}

	public byte getRentalDuration() {
		return this.rentalDuration;
	}

	public void setRentalDuration(byte rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public BigDecimal getRentalRate() {
		return this.rentalRate;
	}

	public void setRentalRate(BigDecimal rentalRate) {
		this.rentalRate = rentalRate;
	}

	public BigDecimal getReplacementCost() {
		return this.replacementCost;
	}

	public void setReplacementCost(BigDecimal replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getSpecialFeatures() {
		return this.specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Language getLanguage1() {
		return this.language1;
	}

	public void setLanguage1(Language language1) {
		this.language1 = language1;
	}
	
	public Language getLanguage2() {
		return this.language2;
	}

	public void setLanguage2(Language language2) {
		this.language2 = language2;
	}
	
	public Set<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(Set<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}
	
	public Set<FilmCategory> getFilmCategories() {
		return this.filmCategories;
	}

	public void setFilmCategories(Set<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}
	
	public Set<Inventory> getInventories() {
		return this.inventories;
	}

	public void setInventories(Set<Inventory> inventories) {
		this.inventories = inventories;
	}
	
}