package com.plutora.utils;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesCache
{
	WebGenericUtilLib webGenericUtilLib = new WebGenericUtilLib();
    private static Map<String, Properties> map = new HashMap<>();

    public PropertiesCache(List<String> fileNames,String domain)
    {
        for (String f : fileNames)
        {
            Properties props = new Properties();
            try
            {
            	switch(domain){
            	case "DemoPS":
            	case "DemoAU":
            	case "DemoUS":
            	case "DemoUK":
            	case "Demo":
            	case "Demoa":
            		props.load(webGenericUtilLib.loadPropertiesPath(f,"plutora"));
            		break;
            	case "DemoPS-PlutoraTest":
            	case "DemoAU-PlutoraTest":
            	case "DemoUK-PlutoraTest":
            	case "DemoUS-PlutoraTest":
            	case "Demo-PlutoraTest":
            		props.load(webGenericUtilLib.loadPropertiesPath(f,"plutoratest"));
            		break;
            	case "PlutoraAPI":
            		props.load(webGenericUtilLib.loadPropertiesPath(f,"plutoraapi"));
            		break;
            	case "Demo-Integrations":
            		try {
            		props.load(webGenericUtilLib.loadPropertiesPath(f,"integrations"));
            		}
            		catch (Exception e) {  }
            		try {
                		props.load(webGenericUtilLib.loadPropertiesPath(f,"plutora"));
            		} catch (Exception e) {  }
            		break;
            	case "DemoPS-Analytics":
            		try {
            		props.load(webGenericUtilLib.loadPropertiesPath(f,"reports"));
            		}
            		catch (Exception e) {  }
            		try {
                		props.load(webGenericUtilLib.loadPropertiesPath(f,"plutora"));
            		} catch (Exception e) {  }
            		break;
            	}
                map.put(f, props);
            }
            catch (IOException ex)
            {
            	System.out.println(ex.getMessage());
                // handle error
            }
        }

    }

    public static String getProperty(String file, String key) {
        Properties props = map.get(file);
        
        if (props != null) {
        	
            return props.getProperty(key);
        }

        return null;
    }
    
    public Set<String> getAllPropertyNames()
    {

        Set<String> values = new HashSet<>();

        for (Properties p : map.values())
        {
            values.addAll(p.stringPropertyNames()); 
        }

        return values;

    }

    public boolean containsKey(String key)
    {
        for (@SuppressWarnings("unused") Properties p : map.values())
        {
            if (map.containsKey(key))
            {
                return true;
            }
        }

        return false;
    }
    
    public static String setProperty(String file, String key) {
    	
    	String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    	SecureRandom rnd = new SecureRandom();
    	StringBuilder sb = new StringBuilder();
    	for( int i = 0; i < 8; i++ ) 
    	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
    	
        Properties props = map.get(file);
        if (props != null) {
        	//String value =key + "_" +new Random().nextInt(9999 - 1)+ 1;
        	String value =key + "_" + sb;
        	props.put(key, value);
        }
        return props.getProperty(key);
    }
    public static String setProperty(String file, String key,String value) {

        Properties props = map.get(file);
        if (props != null) {
        	props.put(key, value);
        }
        return props.getProperty(key);
    }
}