package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.UnitFloor;
import sample.spring.security.models.UnitPaymentDetails;
import sample.spring.security.repositories.UPDRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UPDController {
    @Autowired
    UPDRepository updRepository;

    public UPDController(UPDRepository updRepository) {
        this.updRepository = updRepository;
    }
    @GetMapping("/upd")
    Iterable<UnitPaymentDetails> all() {
        return updRepository.findAll();
    }

    @RequestMapping(value = "/upd/{payment_code}", method = RequestMethod.GET)
    public Optional<UnitPaymentDetails> findByIds(@PathVariable @NotNull Long payment_code) {

        return updRepository.findById(payment_code);
    }

    @PostMapping("/upd")
    UnitPaymentDetails newUPD(@RequestBody UnitPaymentDetails newUPD) {
        return updRepository.save(newUPD);
    }

    @DeleteMapping("/upd/{payment_code}")
    void deleteUPD(@PathVariable Long payment_code) {
        updRepository.deleteById(payment_code);
    }

    @PutMapping("/upd/{payment_code}")
    UnitPaymentDetails updateUPD(@RequestBody UnitPaymentDetails newUPD, @PathVariable Long payment_code) {

        return updRepository.findById(payment_code).map(unitPaymentDetails -> {
            unitPaymentDetails.setPayment_code(newUPD.getPayment_code());
            unitPaymentDetails.setPaymentID(newUPD.getPaymentID());
            unitPaymentDetails.setAmount(newUPD.getAmount());
            unitPaymentDetails.setValidFrom(newUPD.getValidFrom());
            return updRepository.save(newUPD);
        }).orElseGet(() -> {
            newUPD.setPayment_code(payment_code);
            return updRepository.save(newUPD);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/upd/search")
    @ResponseBody
    public List<UnitPaymentDetails> Search(@RequestParam String keyword) {

        return updRepository.search(keyword);
    }
}
