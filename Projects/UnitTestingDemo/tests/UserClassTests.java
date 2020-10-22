import com.telerikacademy.users.User;
import com.telerikacademy.users.UserConstants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserClassTests {

    private User user;

    @Test
    public void constructor_should_throw_when_usernameIsLongerThanAllowed() {
        //Act Assert
        Assertions.assertThrows(IllegalArgumentException.class , () -> new User("aaaaaaaaaaaaaaaaaaaaa") );
    }

    @Test
    public void constructor_should_throw_when_usernameIsLesserThanAllowed() {
        // Act Assert
        Assertions.assertThrows(IllegalArgumentException.class , () -> new User(""));
    }

    @Test
    public void constructour_should_throw_when_usernameIsNull() {
        // Act Assert
        Assertions.assertThrows(NullPointerException.class , () -> new User(null));
    }

    @Test
    public void getUsername_should_return_when_usernameIsValid() {
        // Arrange
        user = new User("Rafael");
        // Act
        String checker = user.getUsername();
        // Assert
        Assertions.assertEquals(checker,user.getUsername());

    }
}
