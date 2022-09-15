package config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("repository")
public class DatabaseConfig {

	private static final Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean lfb = new LocalContainerEntityManagerFactoryBean();
		lfb.setDataSource(dataSource());
		lfb.setJpaVendorAdapter(getJpaVendorAdapter());
		lfb.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		lfb.setPackagesToScan("entity");
		lfb.setJpaProperties(hibernateProps());
		return lfb;
	}

	public JpaVendorAdapter getJpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean("dataSource")
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		String userName = "";
		String password = "";
		String driver = "";
		String url = "";
		String schema = "";

		dataSource.setDriverClassName(driver);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);

		dataSource.setUrl(url);
		dataSource.setSchema(schema);
		logger.info("Database Configured!");
		return dataSource;
	}

	Properties hibernateProps() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.setProperty("hibernate.show_sql", "false");
		properties.setProperty("hibernate.default_schema", "public");
		properties.setProperty("hibernate.jdbc.batch_size", "100");
		properties.setProperty("hibernate.order_inserts", "true");
		properties.setProperty("hibernate.order_updates", "true");
		return properties;
	}

	@Bean("transactionManager")
	JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return transactionManager;
	}

}
