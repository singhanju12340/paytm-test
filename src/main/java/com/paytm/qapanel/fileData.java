package com.paytm.qapanel;

import javax.naming.ConfigurationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class fileData
{

   public static void main(String [] prefix) throws IOException, ConfigurationException {

       FileReader reader=new FileReader("/Users/mainishmishra/Automation_Repo/paytm-test/src/main/resources/environment.properties");
       Properties p=System.getProperties();
       p.load(reader);

       HashMap<String, String> value_from_file=new HashMap<>();
      for (final Map.Entry<Object, Object> entry : p.entrySet()) {
          if(entry.getKey().toString().trim().startsWith("IP"))
           value_from_file.put((String) entry.getKey(), (String) entry.getValue());

       }
       System.out.println("Map here is " + value_from_file);
   }


}
