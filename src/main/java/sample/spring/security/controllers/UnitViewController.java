package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Cities;
import sample.spring.security.models.UnitView;
import sample.spring.security.repositories.UnitViewRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UnitViewController {
    @Autowired
    private final UnitViewRepository unitViewRepository;

    public UnitViewController(UnitViewRepository unitViewRepository) {
        this.unitViewRepository = unitViewRepository;
    }
    @GetMapping("/unitview")
    Iterable<UnitView> all() {
        return unitViewRepository.findAll();
    }

    @RequestMapping(value = "/unitview/{unitView_code}", method = RequestMethod.GET)
    public Optional<UnitView> findByIds(@PathVariable @NotNull Long unitView_code) {

        return unitViewRepository.findById(unitView_code);
    }

    @PostMapping("/unitview")
    UnitView newUnitView(@RequestBody UnitView newUnitView) {
        return unitViewRepository.save(newUnitView);
    }

    @DeleteMapping("/unitview/{unitView_code}")
    void deleteUnitView(@PathVariable Long unitView_code) {
        unitViewRepository.deleteById(unitView_code);
    }

    @PutMapping("/unitview/{unitView_code}")
    UnitView updateUnitView(@RequestBody UnitView newUnitView, @PathVariable Long unitView_code) {

        return unitViewRepository.findById(unitView_code).map(unitView -> {
            unitView.setUnitView_code(newUnitView.getUnitView_code());
            unitView.setUnitViewID(newUnitView.getUnitViewID());
            unitView.setView(newUnitView.getView());
            return unitViewRepository.save(newUnitView);
        }).orElseGet(() -> {
            newUnitView.setUnitView_code(unitView_code);
            return unitViewRepository.save(newUnitView);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/unitview/search")
    @ResponseBody
    public List<UnitView> Search(@RequestParam String keyword) {

        return unitViewRepository.search(keyword);
    }
}
