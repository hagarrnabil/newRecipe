package sample.spring.security.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "buildings")
public class Building implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "building_code")
    private Long building_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String buildingID;
    @NotNull
    private String buildingDescription;
    @Column(length = 8, columnDefinition = "char(8)")
    @Length(max = 8)
    private String oldNumber;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validFrom;
    private Integer numberOfFloors;
    @OneToMany(mappedBy = "building")
    private final Set<Unit> units;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_code", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonProperty("project_code")
    private Project project;



    public Building(Long building_code, String buildingID, String buildingDescription, String oldNumber, Date validFrom, Integer numberOfFloors, Set<Unit> units, Project project) {
        this.building_code = building_code;
        this.buildingID = buildingID;
        this.buildingDescription = buildingDescription;
        this.oldNumber = oldNumber;
        this.validFrom = validFrom;
        this.numberOfFloors = numberOfFloors;
        this.units = units;
        this.project = project;
    }

    public Building(Set<Unit> units) {
        this.units = units;
    }

    public Building() {

        units = null;
    }

    public Long getBuilding_code() {
        return building_code;
    }

    public void setBuilding_code(Long building_code) {
        this.building_code = building_code;
    }

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }

    public void setBuildingDescription(String buildingDescription) {
        this.buildingDescription = buildingDescription;
    }

    public String getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(String oldNumber) {
        this.oldNumber = oldNumber;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
    @JsonBackReference
    public Project getProject() {
        return project;
    }
    @JsonBackReference
    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Building{" +
                "building_code=" + building_code +
                ", buildingID='" + buildingID + '\'' +
                ", buildingDescription='" + buildingDescription + '\'' +
                ", oldNumber='" + oldNumber + '\'' +
                ", validFrom=" + validFrom +
                ", numberOfFloors=" + numberOfFloors +
                '}';
    }
}
