package Model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the actor database table.
 * 
 */
@Entity
@Table(name="actor")
public class Actor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="actor_id")
	private int actorId;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="last_update")
	private Timestamp lastUpdate;

	//bi-directional many-to-one association to FilmActor
	@OneToMany(mappedBy="actor", cascade=CascadeType.ALL)
	private Set<FilmActor> filmActors;

    public Actor() {
    }

	public int getActorId() {
		return this.actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Timestamp lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public Set<FilmActor> getFilmActors() {
		return this.filmActors;
	}

	public void setFilmActors(Set<FilmActor> filmActors) {
		this.filmActors = filmActors;
	}
	
}