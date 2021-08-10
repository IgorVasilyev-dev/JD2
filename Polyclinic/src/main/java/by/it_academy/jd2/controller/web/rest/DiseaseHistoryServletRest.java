package by.it_academy.jd2.controller.web.rest;
import by.it_academy.jd2.model.DiseaseHistory;
import by.it_academy.jd2.view.api.IDiseaseHistoryView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diseaseHistory")
public class DiseaseHistoryServletRest {

    private final IDiseaseHistoryView diseaseHistoryView;

    public DiseaseHistoryServletRest(IDiseaseHistoryView diseaseHistoryView) {
        this.diseaseHistoryView = diseaseHistoryView;
    }

    @GetMapping(produces = {"application/json"})
    protected List<DiseaseHistory> getAllDiseaseHistory() {
        return this.diseaseHistoryView.getAll();
    }

    @GetMapping(value = "/{login}", produces = {"application/json"})
    protected List<DiseaseHistory> getDiseaseHistories(@PathVariable String login,
                                                     @RequestParam(name = "page", defaultValue = "1", required = false) int currentPage) {
        IDiseaseHistoryView.DiseaseHistoryFilter filter = new IDiseaseHistoryView.DiseaseHistoryFilter(
                login.isBlank() ? null : login,
                currentPage
        );
        return this.diseaseHistoryView.getDiseaseHistories(filter);
    }

    @GetMapping(value = "/{login}/{id}", produces = {"application/json"})
    protected DiseaseHistory getDiseaseHistory(@PathVariable Long id) {
        return this.diseaseHistoryView.getDiseaseHistory(id);
    }

    @PostMapping(consumes = {"application/json"})
    protected ResponseEntity<?> create(@RequestBody DiseaseHistory diseaseHistory) {
        diseaseHistoryView.addDiseaseHistory(diseaseHistory);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = {"application/json"})
    protected ResponseEntity<?> update(@RequestBody DiseaseHistory diseaseHistory, @PathVariable Long id ) {
        if (diseaseHistory == null || diseaseHistory.equals(new DiseaseHistory())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        diseaseHistoryView.updateDiseaseHistory(diseaseHistory, id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value = "/{id}")
    protected ResponseEntity<?> delete(@PathVariable Long id) {
        diseaseHistoryView.deleteDiseaseHistory(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
