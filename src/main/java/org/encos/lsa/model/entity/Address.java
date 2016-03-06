package org.encos.lsa.model.entity;

import javax.persistence.*;

/**
 * @author Enrico Costanzi
 */
@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "STREET_NAME")
    private String streetName;

    @Column(name = "STREET_NUMBER")
    private String streetNumber;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "ID_DISTRICT", foreignKey = @ForeignKey(name="fk_address_district"))
    private District district;

    @ManyToOne
    @JoinColumn(name = "ID_CITY", foreignKey = @ForeignKey(name="fk_address_city"))
    private City city;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
