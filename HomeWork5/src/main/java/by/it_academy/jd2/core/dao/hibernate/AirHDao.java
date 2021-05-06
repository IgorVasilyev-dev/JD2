package by.it_academy.jd2.core.dao.hibernate;

import by.it_academy.jd2.core.dao.api.IDao;
import by.it_academy.jd2.core.dto.Air;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class AirHDao implements IDao<Air>{

    private final Session session;

    public AirHDao () {
        this.session = HibernateCreator.getInstance().openSession();
    }

    @Override
    public List<Air> getRecords(int start, int total) throws SQLException {
        Query<Air> query = session.createQuery("FROM Air ORDER BY city", Air.class).setFirstResult(start).setMaxResults(total);
        return query.list();
    }

    @Override
    public int getCount() {
        return session.createQuery("FROM Air ", Air.class).list().size();
    }
}
