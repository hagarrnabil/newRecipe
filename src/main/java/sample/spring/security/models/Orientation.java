package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
@Entity
@Table(name = "orientation")
public class Orientation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orientation_code")
    private Long orientation_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String orientationID;
    @NotNull
    private String orientationDescription;

    public Orientation() {
    }

    public Orientation(Long orientation_code, String orientationID, String orientationDescription) {
        this.orientation_code = orientation_code;
        this.orientationID = orientationID;
        this.orientationDescription = orientationDescription;
    }

    public Long getOrientation_code() {
        return orientation_code;
    }

    public void setOrientation_code(Long orientation_code) {
        this.orientation_code = orientation_code;
    }

    public String getOrientationID() {
        return orientationID;
    }

    public void setOrientationID(String orientationID) {
        this.orientationID = orientationID;
    }

    public String getOrientationDescription() {
        return orientationDescription;
    }

    public void setOrientationDescription(String orientationDescription) {
        this.orientationDescription = orientationDescription;
    }
}
