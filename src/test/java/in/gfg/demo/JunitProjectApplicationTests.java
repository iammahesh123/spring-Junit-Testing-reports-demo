package in.gfg.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JunitProjectApplicationTests {

	@Mock
	private UserRepository userRepository;

	@InjectMocks
	private UserService userService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void contextLoads() {
	}
	
	@Test
    public void testCreateUser() {
        User user = new User("dssbdbsd" ,"John", "john@example.com");
        when(userRepository.save(user)).thenReturn(user);
        User result = userService.createUser(user);
        assertEquals(user, result);
    }
	
	@Test
    public void testUpdateUser() {
        User existingUser = new User("dssbdbsd", "John", "john@example.com");
        User updatedUser = new User("dssbdbsd", "John Doe", "johndoe@example.com");
        when(userRepository.existsById("dssbdbsd")).thenReturn(true);
        when(userRepository.save(updatedUser)).thenReturn(updatedUser);
        User result = userService.updateUser("dssbdbsd", updatedUser);
        assertEquals(updatedUser, result);
    }

    @Test
    public void testDeleteUser() {
        userService.deleteUser("dssbdbsd");
    }

}
