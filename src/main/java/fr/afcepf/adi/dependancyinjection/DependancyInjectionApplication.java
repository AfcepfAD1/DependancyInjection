package fr.afcepf.adi.dependancyinjection;

import fr.afcepf.adi.dependancyinjection.controllers.*;
import fr.afcepf.adi.dependancyinjection.exemplebeans.FakeDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"services", "fr"})
public class DependancyInjectionApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(DependancyInjectionApplication.class, args);

        MyController myController = (MyController) context.getBean("myController");
        System.out.println(myController.sayHello());

        System.out.println("--------- Property");
        PropertyInjectedController propertyInjectedController = (PropertyInjectedController) context.getBean("propertyInjectedController");
        System.out.println(propertyInjectedController.getGreeting());

        System.out.println("--------- Setter");
        SetterInjectedController setterInjectedController = (SetterInjectedController) context.getBean("setterInjectedController");
        System.out.println(setterInjectedController.getGreeting());

        System.out.println("--------- Constructor");
        ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) context.getBean("constructorInjectedController");
        System.out.println(constructorInjectedController.getGreeting());

        I18nController i18nController = (I18nController) context.getBean("i18nController");
        System.out.println(i18nController.sayHello());

        FakeDataSource fakeDataSource = (FakeDataSource) context.getBean("fakeDataSource");
        System.out.println(fakeDataSource.getUser());
        System.out.println(fakeDataSource.getPassword());
    }

}
