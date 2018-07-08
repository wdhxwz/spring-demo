package com.wangdh.custom.tag.parser;

import com.wangdh.custom.tag.defination.UserDefination;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.w3c.dom.Element;

public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
    @Override
    protected Class<?> getBeanClass(Element element) {
        return UserDefination.class;
    }

    @Override
    protected void doParse(Element element, BeanDefinitionBuilder builder) {
        String name = element.getAttribute("name");
        String sex = element.getAttribute("sex");
        String id = element.getAttribute("id");
        int age = Integer.parseInt(element.getAttribute("age"));

        builder.addPropertyValue("name",name);
        builder.addPropertyValue("sex",sex);
        builder.addPropertyValue("id",id);
        builder.addPropertyValue("age",age);
    }
}