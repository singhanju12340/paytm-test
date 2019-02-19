package com.paytm.qapanel;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.io.FileInputStream;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.*;

public class updateProperty {


    public void updateIP(Properties p,String env_name, String IP) {
        try {

            FileOutputStream file = new FileOutputStream(new File("/Users/mainishmishra/Automation_Repo/paytm-test/src/main/resources/environment.properties"));
            p.setProperty("IP_" + env_name, IP.toString());
            System.out.println("New : "+IP);
            p.store(file, null);
            file.close();
//            properties.setProperty("IP_"+env_name,IP.toString());
//            properties.save();
            System.out.println("config.properties updated Successfully!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Properties getProperty() {
        Properties p = new Properties();
        try {
            FileInputStream file = new FileInputStream(new File("/Users/mainishmishra/Automation_Repo/paytm-test/src/main/resources/environment.properties"));
            p.load(file);
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }

}
