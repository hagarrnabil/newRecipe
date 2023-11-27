package sample.spring.security.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "unitPaymentDetails")
public class UnitPaymentDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_code")
    private Long payment_code;
    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String paymentID;
    private Integer amount;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validFrom;
    public UnitPaymentDetails() {
    }

    public UnitPaymentDetails(Long payment_code, String paymentID, Integer amount, Date validFrom) {
        this.payment_code = payment_code;
        this.paymentID = paymentID;
        this.amount = amount;
        this.validFrom = validFrom;
    }

    public Long getPayment_code() {
        return payment_code;
    }

    public void setPayment_code(Long payment_code) {
        this.payment_code = payment_code;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }
}
