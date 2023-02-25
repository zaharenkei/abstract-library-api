package demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class Application {

    public static void main(String[] args) {
        String pass = System.getenv("Mongo_Password");
        String dbName = System.getenv("Mondo_DBName_Library");
        System.setProperty(
                "spring.data.mongodb.uri",
                "mongodb+srv://master:" + pass + "@corecluster.ag6i0.mongodb.net/" + dbName + "?retryWrites=true&w=majority");

        SpringApplication.run(Application.class, args);
    }
}
