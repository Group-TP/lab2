package Model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the category database table.
 * 
 */
@Entity
@Table(name="category")
public class Category implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="category_id")
	private int categoryId;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	private String name;

	//bi-directional many-to-one association to FilmCategory
	@OneToMany(mappedBy="category", cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<FilmCategory> filmCategories;

    public Category() {
    }

	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<FilmCategory> getFilmCategories() {
		return this.filmCategories;
	}

	public void setFilmCategories(Set<FilmCategory> filmCategories) {
		this.filmCategories = filmCategories;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return new Integer(categoryId).hashCode() + name.hashCode();
	}
	
}