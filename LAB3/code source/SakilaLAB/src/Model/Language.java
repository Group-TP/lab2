package Model;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.Set;


/**
 * The persistent class for the language database table.
 * 
 */
@Entity
@Table(name="language")
public class Language implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="language_id")
	private byte languageId;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	private String name;

	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="language1", fetch= FetchType.EAGER)
	private Set<Film> films1;

	//bi-directional many-to-one association to Film
	@OneToMany(mappedBy="language2", fetch= FetchType.EAGER)
	private Set<Film> films2;

    public Language() {
    }

	public byte getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(byte languageId) {
		this.languageId = languageId;
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

	public Set<Film> getFilms1() {
		return this.films1;
	}

	public void setFilms1(Set<Film> films1) {
		this.films1 = films1;
	}
	
	public Set<Film> getFilms2() {
		return this.films2;
	}

	public void setFilms2(Set<Film> films2) {
		this.films2 = films2;
	}
	
}