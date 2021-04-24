package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.dao.DataSourceCreator;
import by.it_academy.jd2.core.dao.api.IDaoMessage;
import by.it_academy.jd2.core.dto.Message;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessagesStorage implements IDaoMessage<Message> {

    private static Connection connection;
    private static MessagesStorage instance;

    /**
     * singleton pattern
     * получаем коннект к БД
     * @return new MessagesStorage() если instance == null
     */
    public static MessagesStorage getInstance() {
        if (instance == null) {
            try {
                DataSource dataSource = DataSourceCreator.getInstance();
                connection = dataSource.getConnection();
            } catch (PropertyVetoException | SQLException e) {
                e.printStackTrace();
            }
            instance = new MessagesStorage();
        }
        return instance;
    }

    /**
     * Метод сохраняет объект message в БД
     * @param message объект типа Message
     */
    @Override
    public void add(Message message, String login) {
        String sql = "INSERT INTO chat.message (sent_from, send_date,send_text,recipient) \n" +
                "values (?,?,?,?);";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            java.sql.Timestamp sqlTS = new java.sql.Timestamp((new java.util.Date()).getTime());
            ps.setString(1, message.getSentFrom());
            ps.setTimestamp(2, sqlTS);
            ps.setString(3, message.getSendText());
            ps.setString(4, login);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    /**
     * Получаем записи из БД и помещает в список
     * @param login парамет получения записей
     * @return возвращает список объектов класса Message
     */
    @Override
    public List<Message> getList(String login) {
        List<Message> list = new ArrayList<>();
        String sql = "SELECT send_date, sent_from, send_text \n" +
                "From chat.message WHERE recipient = '" + login + "'";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Message message = new Message();
                message.setSendDate(rs.getString(1));
                message.setSentFrom(rs.getString(2));
                message.setSendText(rs.getString(3));
                list.add(message);
            } rs.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }
}
