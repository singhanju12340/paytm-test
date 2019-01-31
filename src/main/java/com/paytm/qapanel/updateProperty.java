package com.paytm.qapanel;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
public class updateProperty
{
    public static void main(String[] args) {
        try {
            PropertiesConfiguration properties = new PropertiesConfiguration("/Users/mainishmishra/Automation_Repo/paytm-test/src/main/resources/application.properties");
            properties.setProperty("Qa7_IP", "QA7 IP changed.");
            //properties.setProperty("jdbc.url", "jdbc:mysql://localhost:3306/technicalkeeda");
            //properties.setProperty("jdbc.username", "root");
            //properties.setProperty("jdbc.password", "password");
            properties.save();
            System.out.println("config.properties updated Successfully!!");
        } catch (ConfigurationException e) {
            System.out.println(e.getMessage());
        }
    }

}
