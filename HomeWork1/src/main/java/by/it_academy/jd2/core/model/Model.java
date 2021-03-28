package by.it_academy.jd2.core.model;

import by.it_academy.jd2.core.dto.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс добавляет и хранит объекты Person
 */
public class Model {

    private static Model instance;

    private final List<Person> model;


        public static Model getInstance() {
            if (instance == null) {
                instance = new Model();
            }
            return instance;
        }

        private Model() {
            model = new ArrayList<>();
        }

        public void add(Person person) {
            model.add(person);
        }

        public List<String> list() {
            return model.stream()
                    .map(Person::toString)
                    .collect(Collectors.toList());
        }

}

