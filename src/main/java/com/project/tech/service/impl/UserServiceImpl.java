package com.project.tech.service.impl;

import com.project.tech.dao.UserDao;
import com.project.tech.dto.ApiResponse;
import com.project.tech.dto.AuthToken;
import com.project.tech.dto.LoginUser;
import com.project.tech.dto.TokenDto;
import com.project.tech.dto.UserDto;
import com.project.tech.model.TblUser;
import com.project.tech.service.TokenService;
import com.project.tech.service.UserService;

import jar.security.config.JwtTokenUtil;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
@Service
public class UserServiceImpl implements UserDetailsService, UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private TokenService tokenService;

	@Autowired()
	private BCryptPasswordEncoder bcryptEncoder;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TblUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new User(user.getUsername(), user.getPassword(), getAuthority());
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}

	public List<TblUser> findAll() {
		List<TblUser> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		userDao.deleteById(id);
	}

	@Override
	public TblUser findOne(String username) {
		return userDao.findByUsername(username);
	}

	@Override
	public TblUser findById(int id) {
		TblUser user = userDao.findById(id);
		return user;
	}

	@Override
	public UserDto update(UserDto userDto) {
		TblUser user = findById(userDto.getId());
		if (user != null) {
			BeanUtils.copyProperties(userDto, user, "password");
			userDao.save(user);
		}
		return userDto;
	}

	@Override
	public TblUser save(UserDto user) {
		TblUser newUser = new TblUser();
		newUser.setUsername(user.getUsername());
		newUser.setFirstName(user.getFirstName());
		newUser.setLastName(user.getLastName());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setAge(user.getAge());
		return userDao.save(newUser);
	}

	@Override
	public ApiResponse<AuthToken> login(LoginUser loginUser) {
		final TblUser user = findOne(loginUser.getUsername());
		final String token = jwtTokenUtil.generateToken(user.getUsername());
		TokenDto tokenObject = new TokenDto();
		tokenObject.setToken(token);
		ApiResponse<String> result = tokenService.inserTokens(tokenObject, user.getId());
		return new ApiResponse<AuthToken>(result.getStatus(), result.getMessage(),
				new AuthToken(token, loginUser.getUsername()));
	}
}
