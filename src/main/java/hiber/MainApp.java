package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("BoJack", "Horseman", "greatdepression@mail.ru", new Car("Омепразол", 233546)));
        userService.add(new User("Tinky", "Winky", "tinky_winky87@mail.ru", new Car("Супер-пупер 2.0 ЭКО ВЕГАН", 234546)));
        userService.add(new User("Sponge Bob", "SquarePants", "penpineappleapplepen@mail.ru", new Car("Супер-пупер 2.0 ЭКО ВЕГАН", 235546)));
        userService.add(new User("Arania", "Gradne", "yah@mail.ru", new Car("Ultra Deluxe Rich", 235786)));


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car Model = " + user.getCar().getModel());
            System.out.println();
        }

        User user = userService.getUserByCar("Омепразол", 233546);
        System.out.println("GET USER BY CAR: " + user.toString());

        context.close();
    }
}
