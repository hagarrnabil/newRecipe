package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
@Entity
@Table(name = "priceType")
public class PriceType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "priceType_code")
    private Long priceType_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String priceTypeID;
    @NotNull
    private String priceTypeDescription;

    public PriceType() {
    }

    public PriceType(Long priceType_code, String priceTypeID, String priceTypeDescription) {
        this.priceType_code = priceType_code;
        this.priceTypeID = priceTypeID;
        this.priceTypeDescription = priceTypeDescription;
    }

    public Long getPriceType_code() {
        return priceType_code;
    }

    public void setPriceType_code(Long priceType_code) {
        this.priceType_code = priceType_code;
    }

    public String getPriceTypeID() {
        return priceTypeID;
    }

    public void setPriceTypeID(String priceTypeID) {
        this.priceTypeID = priceTypeID;
    }

    public String getPriceTypeDescription() {
        return priceTypeDescription;
    }

    public void setPriceTypeDescription(String priceTypeDescription) {
        this.priceTypeDescription = priceTypeDescription;
    }
}
