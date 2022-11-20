//package myboot.manager.security;
//
//import lombok.var;
//import myboot.app1.dao.XUserRepository;
//import myboot.app1.model.XUser;
//import myboot.manager.dao.PersonRepository;
//import myboot.manager.model.Person;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Profile;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpServletRequest;
//
//@Service
//@Profile("usejwt")
//public class UserService {
//
//	@Autowired
//	private PersonRepository userRepository;
//
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//
//	@Autowired
//	private JwtProvider jwtTokenProvider;
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	public String login(String email, String password) {
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
//			var user = userRepository.findById(email).get();
//			return jwtTokenProvider.createToken(user);
//		} catch (AuthenticationException e) {
//			throw new MyJwtException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//	}
//
//	public String signup(Person user) {
//		if (userRepository.findById(user.getEmail()).isPresent()) {
//			throw new MyJwtException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
//		}
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		userRepository.save(user);
//		return jwtTokenProvider.createToken(user);
//	}
//
//	public void delete(String username) {
//		userRepository.deleteById(email);
//	}
//
//	public Person search(String username) {
//		return userRepository.findById(username)
//				.orElseThrow(() -> new MyJwtException("The user doesn't exist", HttpStatus.NOT_FOUND));
//	}
//
//	public Person whoami(HttpServletRequest req) {
//		return search(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
//	}
//
//	public String refresh(String username) {
//		return jwtTokenProvider.createToken(userRepository.findById(username).get());
//	}
//
//}
