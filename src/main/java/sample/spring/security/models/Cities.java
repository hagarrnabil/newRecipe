package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "cities")
public class Cities implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cities_code")
    private Long cities_code;

    @NotNull
    @Column(unique = true)
    private char citiesID;
    @NotNull
    private String regionalLocation;

    public Cities() {
    }

    public Cities(Long cities_code, char citiesID, String regionalLocation) {
        this.cities_code = cities_code;
        this.citiesID = citiesID;
        this.regionalLocation = regionalLocation;
    }

    public Long getCities_code() {
        return cities_code;
    }

    public void setCities_code(Long cities_code) {
        this.cities_code = cities_code;
    }

    public char getCitiesID() {
        return citiesID;
    }

    public void setCitiesID(char citiesID) {
        this.citiesID = citiesID;
    }

    public String getRegionalLocation() {
        return regionalLocation;
    }

    public void setRegionalLocation(String regionalLocation) {
        this.regionalLocation = regionalLocation;
    }

    @Override
    public String toString() {
        return "Cities{" +
                "cities_code=" + cities_code +
                ", citiesID=" + citiesID +
                ", regionalLocation='" + regionalLocation + '\'' +
                '}';
    }
}
