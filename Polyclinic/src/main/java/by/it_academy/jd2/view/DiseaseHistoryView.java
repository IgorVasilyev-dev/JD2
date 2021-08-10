package by.it_academy.jd2.view;

import by.it_academy.jd2.model.DiseaseHistory;
import by.it_academy.jd2.storage.api.IDiseaseHistoryRepository;
import by.it_academy.jd2.utils.CopyProperties;
import by.it_academy.jd2.view.api.IDiseaseHistoryView;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public class DiseaseHistoryView implements IDiseaseHistoryView {

    private final IDiseaseHistoryRepository repository;

    public DiseaseHistoryView(IDiseaseHistoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DiseaseHistory> getAll() {
        return repository.findAll();
    }

    @Override
    public DiseaseHistory getDiseaseHistory(Long id) {
       return repository.getDiseaseHistoryById(id);
    }

    @Override
    public List<DiseaseHistory> getDiseaseHistories(DiseaseHistoryFilter filter) {
        return repository.findAllByUserLogin(
                filter.getLogin(),
                PageRequest.of(filter.getPage() - 1, 20)
        );
    }

    @Override
    public void addDiseaseHistory(DiseaseHistory diseaseHistory) {
        repository.save(diseaseHistory);

    }

    @Override
    public void updateDiseaseHistory(DiseaseHistory diseaseHistory, Long id) {
        if(repository.getDiseaseHistoryById(id) != null) {
            repository.save(CopyProperties.insertAllProperties(diseaseHistory, repository.getDiseaseHistoryById(id)));
        }
    }

    @Override
    public void deleteDiseaseHistory(Long id) {
        repository.deleteDiseaseHistoryById(id);
    }
}
