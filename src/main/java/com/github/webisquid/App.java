package com.github.webisquid;

import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.context.ServletContextAware;

import javax.faces.webapp.FacesServlet;
import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableTransactionManagement
public class App implements ServletContextAware {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
    @Bean
    public static CustomScopeConfigurer viewScope() {

        CustomScopeConfigurer configurer = new CustomScopeConfigurer ();
        Map<String, Object> workflowScope = new HashMap<String, Object>();
        workflowScope.put("view", new ViewScope ());
        configurer.setScopes(workflowScope);

        return configurer;

    }

    @Bean
    public ServletRegistrationBean<FacesServlet> servletRegistrationBean() {
        ServletRegistrationBean<FacesServlet> servletRegistrationBean = new ServletRegistrationBean<>(
                new FacesServlet(), "*.xhtml");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        // http://stackoverflow.com/a/25509937/1199132
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.setInitParameter("javax.faces.FACELETS_SKIP_COMMENTS", "true");
    }
}
