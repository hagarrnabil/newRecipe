package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
@Entity
@Table(name = "moc")
public class MoC implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "methodOfCalc_code")
    private Long methodOfCalc_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String methodOfCalcID;
    @NotNull
    private String methodOfCalcDescription;

    public MoC() {
    }

    public MoC(Long methodOfCalc_code, String methodOfCalcID, String methodOfCalcDescription) {
        this.methodOfCalc_code = methodOfCalc_code;
        this.methodOfCalcID = methodOfCalcID;
        this.methodOfCalcDescription = methodOfCalcDescription;
    }

    public Long getMethodOfCalc_code() {
        return methodOfCalc_code;
    }

    public void setMethodOfCalc_code(Long methodOfCalc_code) {
        this.methodOfCalc_code = methodOfCalc_code;
    }

    public String getMethodOfCalcID() {
        return methodOfCalcID;
    }

    public void setMethodOfCalcID(String methodOfCalcID) {
        this.methodOfCalcID = methodOfCalcID;
    }

    public String getMethodOfCalcDescription() {
        return methodOfCalcDescription;
    }

    public void setMethodOfCalcDescription(String methodOfCalcDescription) {
        this.methodOfCalcDescription = methodOfCalcDescription;
    }
}
