package by.it_academy.jd2.config;

import by.it_academy.jd2.service.AuthUser;
import by.it_academy.jd2.service.UserService;
import by.it_academy.jd2.service.api.IAuthUser;
import by.it_academy.jd2.service.api.IUserService;
import by.it_academy.jd2.storage.api.IDiseaseHistoryRepository;
import by.it_academy.jd2.storage.api.IPassportRepository;
import by.it_academy.jd2.storage.api.IUsersRepository;
import by.it_academy.jd2.view.DiseaseHistoryView;
import by.it_academy.jd2.view.PassportView;
import by.it_academy.jd2.view.UsersView;
import by.it_academy.jd2.view.api.IDiseaseHistoryView;
import by.it_academy.jd2.view.api.IPassportView;
import by.it_academy.jd2.view.api.IUsersView;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.it_academy.jd2.config")
public class RootConfig {

    @Bean
    IUsersView usersView(IUsersRepository repository) {
        return new UsersView(repository);
    }

    @Bean
    IPassportView passportView(IPassportRepository repository) {
        return new PassportView(repository);
    }

    @Bean
    IDiseaseHistoryView diseaseHistoryView(IDiseaseHistoryRepository repository) {
        return new DiseaseHistoryView(repository);
    }

    @Bean
    IAuthUser authUser(IUserService userService) {
        return new AuthUser(userService);
    }

    @Bean
    IUserService userService (IUsersView usersView) {
        return new UserService(usersView);
    }
}
