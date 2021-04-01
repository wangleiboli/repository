package org.boli.myspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

public class H2Test {

	private static final Logger logger = LoggerFactory.getLogger(H2Test.class);

	public static void main(String[] args) throws SQLException {

		DataSource dataSource = dataSource();

		embeddedByFile("jdbc:h2:~/myspring");

		embeddedByMem(dataSource, "jdbc:h2:mem:dataSource");

		startH2Server();

		embeddedByFile("jdbc:h2:tcp://localhost:9092/~/myspring");

		embeddedByMem(dataSource, "jdbc:h2:tcp://localhost:9092/mem:dataSource");

	}

	private static String driver = "org.h2.Driver";
	private static String username = "sa";
	private static String password = "";

	public static void embeddedByFile(String url) {

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			logger.info("{}", conn);

			Statement statement = conn.createStatement();

			ResultSet rs = statement.executeQuery("select * from user");

			while (rs.next()) {
				logger.info("id:[{}] name:[{}] address:[{}]", rs.getObject(1), rs.getObject(2), rs.getObject(3));
			}

			rs.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			logger.error("error:", e);
		}
	}

	public static void embeddedByMem(DataSource dataSource, String url) {

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username, password);
			logger.info("{}", conn);
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery("select * from user");
			while (rs.next()) {
				logger.info("id:[{}] name:[{}] address:[{}]", rs.getObject(1), rs.getObject(2), rs.getObject(3));
			}

			rs.close();
			statement.close();
			conn.close();

			conn = dataSource.getConnection("sa", "");
			logger.info("{}", conn);
			statement = conn.createStatement();
			rs = statement.executeQuery("select * from user");
			while (rs.next()) {
				logger.info("id:[{}] name:[{}] address:[{}]", rs.getObject(1), rs.getObject(2), rs.getObject(3));
			}

			rs.close();
			statement.close();
			conn.close();

		} catch (Exception e) {
			logger.error("error:", e);
		}

	}

	/**
	 * 使用JavaConfig，则可以使用EmbeddedDatabaseBuilder构建嵌入式数据源
	 * 
	 * @return
	 */
//	@Bean
	public static DataSource dataSource() {
		return new EmbeddedDatabaseBuilder().setName("dataSource").setType(EmbeddedDatabaseType.H2)
				.setScriptEncoding("UTF-8").addScript("classpath:db/h2/schema.sql")
				.addScript("classpath:db/h2/data.sql").build();
	}

	/**
	 * tcpServer depends-on webServer
	 * 
	 * @throws SQLException
	 */
	public static void startH2Server() throws SQLException {

		Server webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082");
		Server tcpServer = Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092");

		webServer.start();
		tcpServer.start();
	}
}
