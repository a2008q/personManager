package cn.a2008q.test;

import cn.a2008q.config.serviceConfig;
import cn.a2008q.service.PersonManagerIF;
import cn.a2008q.ui.ConsoleUI;

import java.io.IOException;
import java.util.Properties;

@serviceConfig(serviceName = "cn.a2008q.service.impl.PersonManagerSql")
public class testConsoleUI {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Properties properties = new Properties();
        properties.load(testConsoleUI.class.getClassLoader().getResourceAsStream("service-config.properties"));
        String serviceName = properties.getProperty("serviceName");
        serviceConfig annotation = testConsoleUI.class.getAnnotation(serviceConfig.class);
        String serviceNameAno = annotation.serviceName();
        //反射方式获取服务名
        //new ConsoleUI((PersonManagerIF) Class.forName(serviceName).newInstance()).startApp();
        // 注解方式获取服务名
        new ConsoleUI((PersonManagerIF) Class.forName(serviceNameAno).newInstance()).startApp();
    }
}
