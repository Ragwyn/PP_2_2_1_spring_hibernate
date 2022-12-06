package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.dao.UserDaoImp;
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

        User user1;
        user1 = new User("sdfkj","hdbc","djasbc");
        user1.setCar(new Car("Mazda", 111));
        userService.add(user1);

        user1 = new User("scd","hdqwbc","djascdwbc");
        user1.setCar(new Car("Mazda", 222));
        userService.add(user1);

        user1 = new User("sdfkj23","hddsabc","djasdfsbc");
        user1.setCar(new Car("Mazda", 333));
        userService.add(user1);

        user1 = new User("sdfkj23","hdbc","djaSAsbc");
        user1.setCar(new Car("Mazda", 444));
        userService.add(user1);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Email = "+user.getEmail());
            System.out.println("Car = "+user.getCar().toString());
            System.out.println();


        }
        System.out.println(userService.findByCar("Mazda", 111));
        context.close();
    }
}