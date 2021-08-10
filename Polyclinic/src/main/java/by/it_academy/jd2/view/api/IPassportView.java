package by.it_academy.jd2.view.api;

import by.it_academy.jd2.model.Passport;

import java.util.List;

public interface IPassportView {

    List<Passport> getPassport(Long id);
}
