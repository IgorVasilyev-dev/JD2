package by.it_academy.jd2.view;

import by.it_academy.jd2.model.Passport;
import by.it_academy.jd2.storage.api.IPassportRepository;
import by.it_academy.jd2.view.api.IPassportView;

import java.util.List;

public class PassportView implements IPassportView{

    private final IPassportRepository repository;

    public PassportView(IPassportRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Passport> getPassport(Long id) {
        return repository.getPassportById(id);
    }
}
