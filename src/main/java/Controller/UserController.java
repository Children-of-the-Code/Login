package Controller;

import Model.User;
import Service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.HttpCode;

public class UserController {
    public UserController(){

    }
    public void start(){
        Javalin app = Javalin.create();
        UserService loginService = new UserService();
        app.start(5000);

        app.get("login", anything-> {
            /*
            ctx and context are arbitrary - just like how the name of a variable
            in a parameter is arbitrary as well-
            this is because ctx is just what is actually being used as a parameter
            once the lambda function is passed in

            this is a bit hard to wrap your head around...
            but luckily this is the only instance in which we really need
            lambdas
             */
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(anything.body(), User.class);
            User u = loginService.login(user.getUsername(), user.getPassword());
            if(u == null) {
                anything.status(HttpCode.INTERNAL_SERVER_ERROR);
            }else{
                anything.json(u);
            }
        });

        app.get("register", context -> {
            /*
            Mapper is using Jackson databind, which is allowing us
            to convert from JSON to java object and back
            so, it's parsing JSON
             */
            ObjectMapper mapper = new ObjectMapper();
            User user = mapper.readValue(context.body(), User.class);
            int userID = loginService.register(user.getUsername(), user.getPassword());
            if(userID == 0){
                context.status(HttpCode.INTERNAL_SERVER_ERROR);
            }
            else{
                context.result(""+userID);
            }
        });
    }
}
