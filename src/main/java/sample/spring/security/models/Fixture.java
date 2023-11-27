package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Table(name = "fixture")
public class Fixture implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fixture_code")
    private Long fixture_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String fixtureID;

    @NotNull
    private String fixtureDescription;

    public Fixture(Long fixture_code, String fixtureID, String fixtureDescription) {
        this.fixture_code = fixture_code;
        this.fixtureID = fixtureID;
        this.fixtureDescription = fixtureDescription;
    }

    public Fixture() {

    }

    public Long getFixture_code() {
        return fixture_code;
    }

    public void setFixture_code(Long fixture_code) {
        this.fixture_code = fixture_code;
    }

    public String getFixtureID() {
        return fixtureID;
    }

    public void setFixtureID(String fixtureID) {
        this.fixtureID = fixtureID;
    }

    public String getFixtureDescription() {
        return fixtureDescription;
    }

    public void setFixtureDescription(String fixtureDescription) {
        this.fixtureDescription = fixtureDescription;
    }
}
