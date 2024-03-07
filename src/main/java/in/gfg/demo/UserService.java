package in.gfg.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
    private UserRepository userRepository;
	
	 public User createUser(User user) {
	        return userRepository.save(user);
	    }

	    public User updateUser(String id, User user) {
	        if (userRepository.existsById(id)) {
	            user.setId(id);
	            return userRepository.save(user);
	        }
	        return null; // Or throw an exception indicating user not found
	    }

	    public void deleteUser(String id) {
	        userRepository.deleteById(id);
	    }

}
