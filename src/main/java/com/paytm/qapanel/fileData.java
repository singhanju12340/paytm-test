package com.paytm.qapanel;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

import java.sql.*;
import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class fileData
{

   public static void main(String [] ghfsh) throws IOException, ConfigurationException {

       FileReader reader=new FileReader("/Users/mainishmishra/Automation_Repo/paytm-test/src/main/resources/application.properties");
       Properties p=System.getProperties();
       p.load(reader);
       HashMap<String, String> value_from_file=new HashMap<>();
       for (final Map.Entry<Object, Object> entry : p.entrySet()) {
           value_from_file.put((String) entry.getKey(), (String) entry.getValue());
       }
       System.out.println(value_from_file.keySet());

       PropertiesConfiguration properties = new PropertiesConfiguration("/Users/mainishmishra/Automation_Repo/paytm-test/src/main/resources/application.properties");

       //System.out.println(properties.);
   }
}
