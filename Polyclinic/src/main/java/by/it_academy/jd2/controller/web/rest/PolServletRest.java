package by.it_academy.jd2.controller.web.rest;

import by.it_academy.jd2.model.Passport;
import by.it_academy.jd2.model.User;
import by.it_academy.jd2.model.views.Views;
import by.it_academy.jd2.utils.CopyProperties;
import by.it_academy.jd2.view.api.IPassportView;
import by.it_academy.jd2.view.api.IUsersView;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class PolServletRest {

    private final IUsersView userView;
    private final IPassportView passportView;

    public PolServletRest(IUsersView userView, IPassportView passportView) {
        this.userView = userView;
        this.passportView = passportView;
    }

    @JsonView(Views.Public.class)
    @GetMapping(consumes = {"application/json"}, produces = {"application/json"})
    protected List<User> getAllUserJson() {
        return this.userView.getAll();
    }

    @JsonView(Views.Public.class)
    @GetMapping(value = "/{login}", consumes = {"application/json"}, produces = {"application/json"})
    protected User getUserId(@PathVariable String login) {
        return this.userView.getById(login);
    }

    @GetMapping(value = "/passport/{id}", produces = {"application/json"})
    protected List<Passport> getPassport(@PathVariable Long id) {
        return this.passportView.getPassport(id);
    }


    @PostMapping(consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    protected ResponseEntity<?> create(@RequestBody User user) {
        this.userView.addUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{login}", consumes = {"application/json"})
    @ResponseStatus(HttpStatus.CREATED)
    protected ResponseEntity<?> update(@RequestBody User user, @PathVariable String login) {
        if(user == null || CopyProperties.getNullPropertyNames(user).length == CopyProperties.getNullPropertyNames(new User()).length) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        this.userView.updateUser(user, login);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
