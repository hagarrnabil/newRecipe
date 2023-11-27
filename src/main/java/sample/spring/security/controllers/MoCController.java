package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.MoC;
import sample.spring.security.models.UnitFloor;
import sample.spring.security.repositories.MoCRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class MoCController {
    @Autowired
    MoCRepository moCRepository;

    public MoCController(MoCRepository moCRepository) {
        this.moCRepository = moCRepository;
    }
    @GetMapping("/moc")
    Iterable<MoC> all() {
        return moCRepository.findAll();
    }

    @RequestMapping(value = "/moc/{methodOfCalc_code}", method = RequestMethod.GET)
    public Optional<MoC> findByIds(@PathVariable @NotNull Long methodOfCalc_code) {

        return moCRepository.findById(methodOfCalc_code);
    }

    @PostMapping("/moc")
    MoC newMoC(@RequestBody MoC newMoC) {
        return moCRepository.save(newMoC);
    }

    @DeleteMapping("/moc/{methodOfCalc_code}")
    void deleteMoC(@PathVariable Long methodOfCalc_code) {
        moCRepository.deleteById(methodOfCalc_code);
    }

    @PutMapping("/moc/{methodOfCalc_code}")
    MoC updateMoC(@RequestBody MoC newMoC, @PathVariable Long methodOfCalc_code) {

        return moCRepository.findById(methodOfCalc_code).map(moC -> {
            moC.setMethodOfCalcID(newMoC.getMethodOfCalcID());
            moC.setMethodOfCalcDescription(newMoC.getMethodOfCalcDescription());
            moC.setMethodOfCalc_code(newMoC.getMethodOfCalc_code());
            return moCRepository.save(newMoC);
        }).orElseGet(() -> {
            newMoC.setMethodOfCalc_code(methodOfCalc_code);
            return moCRepository.save(newMoC);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/moc/search")
    @ResponseBody
    public List<MoC> Search(@RequestParam String keyword) {

        return moCRepository.search(keyword);
    }
}

