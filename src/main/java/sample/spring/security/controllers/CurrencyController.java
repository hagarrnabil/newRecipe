package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Currency;
import sample.spring.security.repositories.CurrencyRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class CurrencyController {
    @Autowired
    CurrencyRepository currencyRepository;

    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }
    @GetMapping("/currency")
    Iterable<Currency> all() {
        return currencyRepository.findAll();
    }

    @RequestMapping(value = "/currency/{currency_code}", method = RequestMethod.GET)
    public Optional<Currency> findByIds(@PathVariable @NotNull Long currency_code) {

        return currencyRepository.findById(currency_code);
    }

    @PostMapping("/currency")
    Currency newCurrency(@RequestBody Currency newCurrency) {
        return currencyRepository.save(newCurrency);
    }

    @DeleteMapping("/currency/{currency_code}")
    void deleteCurrency(@PathVariable Long currency_code) {
        currencyRepository.deleteById(currency_code);
    }

    @PutMapping("/currency/{currency_code}")
    Currency updateCurrency(@RequestBody Currency newCurrency, @PathVariable Long currency_code) {

        return currencyRepository.findById(currency_code).map(currency -> {
            currency.setCurrency_code(newCurrency.getCurrency_code());
            currency.setCurrencyDescription(newCurrency.getCurrencyDescription());
            currency.setCurrencyID(newCurrency.getCurrencyID());
            return currencyRepository.save(newCurrency);
        }).orElseGet(() -> {
            newCurrency.setCurrency_code(currency_code);
            return currencyRepository.save(newCurrency);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/currency/search")
    @ResponseBody
    public List<Currency> Search(@RequestParam String keyword) {

        return currencyRepository.search(keyword);
    }
}
