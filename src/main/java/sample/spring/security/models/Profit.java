package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profit")
public class Profit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profit_code")
    private Long profit_code;
    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String profitID;
    @NotNull
    private String profitDescription;
    @ManyToMany(mappedBy = "profits", cascade = { CascadeType.ALL })
    private Set<Project> projects = new HashSet<Project>();


    public Profit(Long profit_code, String profitID, String profitDescription) {
        this.profit_code = profit_code;
        this.profitID = profitID;
        this.profitDescription = profitDescription;
    }

    public Profit() {

    }

    public Long getProfit_code() {
        return profit_code;
    }

    public void setProfit_code(Long profit_code) {
        this.profit_code = profit_code;
    }

    public String getProfitID() {
        return profitID;
    }

    public void setProfitID(String profitID) {
        this.profitID = profitID;
    }

    public String getProfitDescription() {
        return profitDescription;
    }

    public void setProfitDescription(String profitDescription) {
        this.profitDescription = profitDescription;
    }
}
