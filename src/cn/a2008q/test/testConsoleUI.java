package cn.a2008q.test;

import cn.a2008q.service.PersonManagerIF;
import cn.a2008q.ui.ConsoleUI;

import java.io.IOException;
import java.util.Properties;

public class testConsoleUI {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Properties properties = new Properties();
        properties.load(testConsoleUI.class.getClassLoader().getResourceAsStream("service-config.properties"));
        String serviceName = properties.getProperty("serviceName");
        new ConsoleUI((PersonManagerIF) Class.forName(serviceName).newInstance()).startApp();
    }
}
