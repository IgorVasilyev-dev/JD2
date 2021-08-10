package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.model.DiseaseHistory;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDiseaseHistoryRepository extends JpaRepository<DiseaseHistory, String> {
    //long countDiseaseHistoryByUserLogin(String login);
    List<DiseaseHistory> findAllByUserLogin(String login, Pageable pageable);
    DiseaseHistory getDiseaseHistoryById(Long id);
    void deleteDiseaseHistoryById(Long id);
}
