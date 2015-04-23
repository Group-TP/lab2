package Model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the customer_list database table.
 * 
 */
@Entity
@Table(name="customer_list")
public class CustomerList implements Serializable {
	private static final long serialVersionUID = 1L;

	private String address;

	private String city;

	private String country;

	@Id
	@Column(name="ID")
	private int id;

	private String name;

	private String notes;

	private String phone;

	@Column(name="SID")
	private byte sid;

	@Column(name="zip code")
	private String _zip_code_;

    public CustomerList() {
    }

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public byte getSid() {
		return this.sid;
	}

	public void setSid(byte sid) {
		this.sid = sid;
	}

	public String get_zip_code_() {
		return this._zip_code_;
	}

	public void set_zip_code_(String _zip_code_) {
		this._zip_code_ = _zip_code_;
	}

}