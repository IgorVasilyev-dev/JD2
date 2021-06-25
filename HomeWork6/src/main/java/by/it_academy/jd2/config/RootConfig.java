package by.it_academy.jd2.config;

import by.it_academy.jd2.storage.api.IMessageRepository;
import by.it_academy.jd2.storage.api.IUsersRepository;
import by.it_academy.jd2.view.AuthUser;
import by.it_academy.jd2.view.MessageService;
import by.it_academy.jd2.view.UserService;
import by.it_academy.jd2.view.api.IAuthUser;
import by.it_academy.jd2.view.api.IMessageService;
import by.it_academy.jd2.view.api.IUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("by.it_academy.jd2.config")
public class RootConfig {

    @Bean
    public IMessageService messageService(IMessageRepository repository) {
        return new MessageService(repository);
    }

    @Bean
    public IUserService userService(IUsersRepository repository) {
        return new UserService(repository);
    }

    @Bean
    public IAuthUser authUser (IUserService userService) {
        return new AuthUser(userService);
    }
}
