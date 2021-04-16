package by.it_academy.jd2.core.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.awt.color.ProfileDataException;
import java.beans.PropertyVetoException;

public class DataSourceCreator {
    private static DataSourceCreator instance;
    private final ComboPooledDataSource cpds;

    private DataSourceCreator() throws ProfileDataException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("org.postgresql.Driver");
        cpds.setJdbcUrl("jdbc:postgresql://localhost:5432/demo");
        cpds.setUser("postgres");
        cpds.setPassword("Simpat9Lga");
        cpds.setMinPoolSize(2);
        cpds.setAcquireIncrement(2);
        cpds.setMaxPoolSize(20);
        cpds.setMaxStatements(180);
    }

    public static DataSource getInstance() throws PropertyVetoException {
        if (instance == null) {
            synchronized (DataSourceCreator.class) {
                instance = new DataSourceCreator();
            }
        }
        return instance.cpds;
    }
}
