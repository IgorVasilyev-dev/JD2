package by.it_academy.jd2.storage.api;

import by.it_academy.jd2.model.Passport;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPassportRepository extends JpaRepository<Passport, String> {

    List<Passport> getPassportById(Long id);
}
