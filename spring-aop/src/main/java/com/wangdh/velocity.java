package com.wangdh;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @Auther: dw_wanghonghong
 * @Date: 2018/7/26 17:37
 * @Description:
 */
public class velocity {
    static {
        Properties prop = new Properties();
        prop.put("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        prop.setProperty(Velocity.ENCODING_DEFAULT, "utf-8");
        prop.setProperty(Velocity.INPUT_ENCODING, "utf-8");
        prop.setProperty(Velocity.OUTPUT_ENCODING, "utf-8");
        Velocity.init(prop);
    }

    public static void main(String[] args){
        Long start = System.currentTimeMillis();
        for(int i=0;i<1000;i++) {
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("anchorUid", "123");
            param.put("monthStart", "2018-07-26");
            getSql("anchor/anchorCard.vm", param);
        }

        System.out.println(System.currentTimeMillis() - start);
    }

    public static Map<String,Template> templateMap = new HashMap<String, Template>();

    public static String getSql(String templatePath, Map<String, Object> dataMap){
        VelocityContext context = new VelocityContext();

        for(String key : dataMap.keySet()){
            context.put(key, dataMap.get(key));
        }

        Template template = null;

        try {
            if(templateMap.containsKey(templatePath)){
                template = templateMap.get(templatePath);
            }else{
                template = Velocity.getTemplate(templatePath);
                templateMap.put(templatePath,template);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Read template error", e);
        }

        StringWriter sw = new StringWriter();

        template.merge(context, sw);

        return sw.toString();
    }
}
