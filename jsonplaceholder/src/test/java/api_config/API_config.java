package api_config;

import java.io.InputStream;
import java.util.Properties;

public class API_config {
	private static Properties properties = new Properties();

	static {
		try (InputStream input = API_config.class.getClassLoader().getResourceAsStream("config.properties")) {
			if (input == null) {
				throw new RuntimeException("config.properties not found in classpath");
			}
			properties.load(input);
		} catch (Exception e) {
			throw new RuntimeException("Failed to load config.properties", e);
		}
	}

	public static String getBaseUrl() {
		return properties.getProperty("base.url");
	}

	public static int getConnectionTimeout() {
		return Integer.parseInt(properties.getProperty("connection.timeout", "5000"));
	}

	public static int getSocketTimeout() {
		return Integer.parseInt(properties.getProperty("socket.timeout", "5000"));
	}

	// For debugging - print loaded config
	public static void printConfig() {
		System.out.println("Loaded config:");
		System.out.println("base.url=" + getBaseUrl());
		System.out.println("connection.timeout=" + getConnectionTimeout());
	}
}
