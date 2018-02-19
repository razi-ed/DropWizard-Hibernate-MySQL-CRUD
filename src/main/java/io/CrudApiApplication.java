package io;

import io.core.Employee;
import io.CrudApiConfiguration;
import io.dao.EmployeeDAO;
import io.resource.EmployeeResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class CrudApiApplication extends Application<CrudApiConfiguration> {

    public static void main(String[] args) throws Exception {
        new CrudApiApplication().run(args);
    }

    private final HibernateBundle<CrudApiConfiguration> hibernate = new HibernateBundle<CrudApiConfiguration>(Employee.class) {
        public DataSourceFactory getDataSourceFactory(CrudApiConfiguration configuration) {
            return configuration.getDatabaseAppDataSourceFactory();
        }
    };

    @Override
    public String getName() {
        return "dropwizard-hibernate";
    }

    @Override
    public void initialize(Bootstrap<CrudApiConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(CrudApiConfiguration configuration, Environment environment) throws ClassNotFoundException {
        final EmployeeDAO employeeDAO = new EmployeeDAO(hibernate.getSessionFactory());
        System.out.println(employeeDAO);
        final EmployeeResource employeeResource = new EmployeeResource(employeeDAO);
        System.out.println(employeeResource);
        environment.jersey().register(employeeResource);
    }
}
