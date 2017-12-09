package easypc.backend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "easypc.backend.dto" })
@EnableTransactionManagement
public class HibernateConfig {

	// h2 configs
	private static final String DB_url = "jdbc:h2:tcp://localhost/~/easypc";
	private static final String DB_driver = "org.h2.Driver";
	private static final String DB_dialect = "org.hibernate.dialect.H2Dialect";
	private static final String DB_uname = "sa";
	private static final String DB_psw = "";

	// 1.DataSource Bean
	@Bean("dataSource")
	public DataSource getDatasource() {

		BasicDataSource dataSrc = new BasicDataSource();

		// passing DB config
		dataSrc.setDriverClassName(DB_driver);
		dataSrc.setUrl(DB_url);
		dataSrc.setUsername(DB_uname);
		dataSrc.setPassword(DB_psw);

		return dataSrc;
	}

	// 2.SessionFactory Bean
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSrc) {

		// builds SessionFactory using DB config
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSrc);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("easypc.backend.dto");// scans all entity/pojo classes in DTO

		return builder.buildSessionFactory();
	}

	// Hibernate Properties
	private Properties getHibernateProperties() {
		Properties props = new Properties();
		props.put("hibernate.dialect", DB_dialect);
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.format_sql", "true");

		return props;
	}

	// 3. TransactionManager Bean
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessFac) {
		HibernateTransactionManager txManager = new HibernateTransactionManager(sessFac);

		return txManager;
	}

}
