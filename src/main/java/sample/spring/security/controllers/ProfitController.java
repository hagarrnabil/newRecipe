package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Profit;
import sample.spring.security.models.UnitFloor;
import sample.spring.security.repositories.ProfitRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ProfitController {
    @Autowired
    ProfitRepository profitRepository;

    public ProfitController(ProfitRepository profitRepository) {
        this.profitRepository = profitRepository;
    }
    @GetMapping("/profit")
    Iterable<Profit> all() {
        return profitRepository.findAll();
    }

    @RequestMapping(value = "/profit/{profit_code}", method = RequestMethod.GET)
    public Optional<Profit> findByIds(@PathVariable @NotNull Long profit_code) {

        return profitRepository.findById(profit_code);
    }

    @PostMapping("/profit")
    Profit newProfit(@RequestBody Profit newProfit) {
        return profitRepository.save(newProfit);
    }

    @DeleteMapping("/profit/{profit_code}")
    void deleteProfit(@PathVariable Long profit_code) {
        profitRepository.deleteById(profit_code);
    }

    @PutMapping("/profit/{profit_code}")
    Profit updateProfit(@RequestBody Profit newProfit, @PathVariable Long profit_code) {

        return profitRepository.findById(profit_code).map(profit -> {
            profit.setProfit_code(newProfit.getProfit_code());
            profit.setProfitDescription(newProfit.getProfitDescription());
            profit.setProfitID(newProfit.getProfitID());
            return profitRepository.save(newProfit);
        }).orElseGet(() -> {
            newProfit.setProfit_code(profit_code);
            return profitRepository.save(newProfit);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profit/search")
    @ResponseBody
    public List<Profit> Search(@RequestParam String keyword) {

        return profitRepository.search(keyword);
    }
}
