package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Person;
import by.it_academy.jd2.core.model.Model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;

/**
 * Cервлет для добавления данных в Model
 */
@WebServlet(name = "AddPersonServlet", urlPatterns = "/addPerson")
public class AddPersonServlet extends HttpServlet {

    private static final String FIRST_NAME_PARAM_NAME = "firstName";
    private static final String LAST_NAME_PARAM_NAME = "lastName";
    private static final String AGE_PARAM_NAME = "age";
    private static final String DATA_PROVIDER = "switch";

    /**
     * Метод обрабатывает запросы GET (получение данных)
     * @param req хранит информацию о запросе
     * @param resp управляет ответом на запрос
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String firstNameVal = getValue(req, FIRST_NAME_PARAM_NAME);
        String lastNameVal = getValue(req, LAST_NAME_PARAM_NAME);
        int ageVal = Integer.parseInt(getValue(req, AGE_PARAM_NAME));

        if(!req.getParameter(DATA_PROVIDER).isEmpty()) {
            Person person = new Person(firstNameVal, lastNameVal, ageVal);
            Model model = Model.getInstance();
            model.add(person);
            resp.sendRedirect(req.getContextPath() + "/printPerson");
        }
    }

    /**
     * Получение данных из куки
     * @param req http запрос
     * @param key ключ запроса
     * @return значение key из куки
     */
    public static String getValueFromCookies(HttpServletRequest req, String key) {
        String val = req.getParameter(key);
            if (val == null) {
                Cookie[] cookies = req.getCookies();
                if (cookies != null) {
                    val = Arrays.stream(cookies)
                            .filter(c -> key.equalsIgnoreCase(c.getName()))
                            .map(Cookie::getValue)
                            .findFirst()
                            .orElse(null);
                }
            }
        if (val == null) {
            throw new IllegalArgumentException("Не переданны параметры");
        }
        return val;
    }

    /**
     * Метод получает данные из сессии
     * @param req запрос
     * @param key ключ запроса
     * @return значение key из сессии
     */
    public static String getValueFromSessions(HttpServletRequest req, String key) {
        String val = req.getParameter(key);
        if(val == null) {
            HttpSession session = req.getSession();
            if(!session.isNew()) {
                val = (String) session.getAttribute(key);
            }
            if(val == null) {
                throw new IllegalArgumentException("Не переданны параметры");
            }
        }
        return val;
    }

    /**
     * Метод выбора поставщика данных
     * @param req запрос
     * @param key ключ запроса
     * @return данные из cookie или sessions
     */
    public static String getValue (HttpServletRequest req, String key) {
        String value = "no data provider selected";
        String switchParams = req.getParameter(DATA_PROVIDER);
        if (switchParams.equalsIgnoreCase("cookies")) {
            value = getValueFromCookies(req, key);
        } else if (switchParams.equalsIgnoreCase("sessions")) {
            value = getValueFromSessions(req,key);
        }
        return value;
    }
}
