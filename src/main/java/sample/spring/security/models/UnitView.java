package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Table(name = "unitview")
public class UnitView implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unitView_code")
    private Long unitView_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String unitViewID;
    @NotNull
    private String view;

    public UnitView() {
    }

    public UnitView(Long unitView_code, String unitViewID, String view) {
        this.unitView_code = unitView_code;
        this.unitViewID = unitViewID;
        this.view = view;
    }

    public Long getUnitView_code() {
        return unitView_code;
    }

    public void setUnitView_code(Long unitView_code) {
        this.unitView_code = unitView_code;
    }

    public String getUnitViewID() {
        return unitViewID;
    }

    public void setUnitViewID(String unitViewID) {
        this.unitViewID = unitViewID;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    @Override
    public String toString() {
        return "UnitView{" +
                "unitView_code=" + unitView_code +
                ", unitViewID='" + unitViewID + '\'' +
                ", view='" + view + '\'' +
                '}';
    }
}
