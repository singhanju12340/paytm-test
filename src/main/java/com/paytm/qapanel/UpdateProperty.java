package com.paytm.qapanel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class UpdateProperty {
    static UpdateProperty updateProperty;
    static Properties property;

    public static synchronized UpdateProperty getInstance(){
        if(updateProperty == null) {
            updateProperty = new UpdateProperty();
            return updateProperty;
        }
        else
            return updateProperty;
    }

    public void updateIP(Properties p,String env_name, String IP) {
        try {

            FileOutputStream file = new FileOutputStream(new File("/Users/mainishmishra/Automation_Repo/paytm-test/src/main/resources/environment.properties"));
            p.setProperty("IP_" + env_name, IP.toString());
            System.out.println("New : "+IP);
            updateProperty.property.store(file, null);
            file.close();
            System.out.println("config.properties updated Successfully!!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public  Properties loadProperty(String filename) {
        //Properties property = new Properties();
        try {
            InputStream input;
            input = getClass().getClassLoader().getResourceAsStream(filename);
            updateProperty.property.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateProperty.property;
    }

    public String getProperty(String propertyKey){
        return this.property.getProperty(propertyKey);
    }

    public void setProperty(String key, String val){
        this.setProperty(key, val);
    }



    public HashMap<String, String> getProprtyWithPrefix(String prefix){
        HashMap<String, String> value_from_file=new HashMap<>();
        for (final Map.Entry<Object, Object> entry : UpdateProperty.getInstance().property.entrySet()) {
            if(entry.getKey().toString().trim().startsWith("IP"))
                value_from_file.put((String) entry.getKey(), (String) entry.getValue());
        }
        return value_from_file;
    }

}
