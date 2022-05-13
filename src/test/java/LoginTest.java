import Model.User;
import Service.UserService;
import org.junit.*;

public class LoginTest {

    UserService userService;

    @BeforeClass
    public static void initialSetUp(){
//        something like a database connection, which we only need 1 of
    }
    @Before
    public void setUp(){
//        runs before every test method : it's good for initial setup
//        something like setting up initial objects or test data
        userService = new UserService();
    }
    @After
    public void tearDown(){
//        something like removing initial objects or test data
    }
    @AfterClass
    public static void finalTearDown(){
//        something like closing existing web connections
    }

//    We expect to be unable to register when a user with the name already exists.
    @Test
    public void canRegisterWhenUserExistsTest(){
        userService.register("alreadyExistingUser", "testPassword");
        int userIdShouldBe0 = userService.register("alreadyExistingUser", "testPassword");
        Assert.assertEquals(userIdShouldBe0 , 0);
    }
//    We expect to be able to register when a user with the name does not exist.
    @Test
    public void canRegisterWhenUserDoesNotExistTest(){
        int userIdShouldBe1 = userService.register("newUser", "password");
        Assert.assertEquals(userIdShouldBe1, 1);
    }
//    We expect to be able to login when login credentials are correct
    @Test
    public void canLoginWhenUserExistsAndPasswordCorrect(){
        userService.register("newUser", "password");
        User u = userService.login("newUser", "password");
        Assert.assertNotEquals(u, null);
    }
    @Test
    public void cannotLoginWhenUserExistsAndPasswordIncorrect(){
        userService.register("newUser", "password");
        User u = userService.login("newUser", "wrong");
        Assert.assertEquals(u, null);
    }
    @Test
    public void cannotLoginWhenUserDoesNotExist(){
        userService.register("newUser", "password");
        User u = userService.login("notExists", "password");
        Assert.assertEquals(u, null);
    }

}
