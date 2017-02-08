package com.uran.rest_gambling_station.service;

import com.uran.rest_gambling_station.domain.Role;
import com.uran.rest_gambling_station.domain.User;
import com.uran.rest_gambling_station.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static com.uran.rest_gambling_station.data.UserTestData.USERS;
import static com.uran.rest_gambling_station.data.UserTestData.USERS_SORTED_ASC;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest {
    @Autowired
    private UserRepository repository;
    
    @Test // list in natural order
    public void shouldReturnAllUsersAsList() {
        List<User> users = this.repository.findAll();
        assertThat(users.containsAll(USERS));
    }
    
    @Test // sorted list
    public void shouldReturnAllUsersAsSortedList() {
        List<User> users = this.repository.findAll(new Sort(Sort.Direction.ASC, "name"));
        String users1 = USERS_SORTED_ASC.toString();
        String users2 = users.toString();
        Assert.assertEquals(users.toString(), USERS_SORTED_ASC.toString());
        //assertThat(users).contains(ADMIN, STATION, USER_1, USER_2);
        //Assert.assertThat(users, is(USERS_S));
    }
    
    @Test // first page of users in natural order
    public void shouldReturnFirstPageOfUsers() {
        Page<User> page = this.repository.findAll(new PageRequest(0, 10));
        assertThat(page.getTotalPages()).isEqualTo(1);
        assertThat(page.getTotalElements()).isGreaterThan(1L);
        assertThat(page.getContent().size()).isEqualTo(4);
    }
    
    @Test // user with specified email
    public void shouldReturnUserWithSpecifiedEmail() {
        User user = this.repository.findByEmailIgnoringCase("admin@gmail.com");
        assertThat(user.getName().compareTo("admin"));
        assertThat(user.getEmail().compareToIgnoreCase("admin@gmail.com"));
        assertThat(user. isEnabled());
    }
    
    @Test
    @Transactional
    public void shouldUpdateUserRoles() {
        User user = this.repository.findByEmailIgnoringCase("admin@gmail.com");
        assertThat(user.getRoles()).containsExactly(Role.ROLE_ADMIN);
        user.setRoles(Arrays.asList(Role.ROLE_ADMIN, Role.ROLE_USER));
        User updated = this.repository.save(user);
        assertThat(updated.getRoles()).contains(Role.ROLE_ADMIN, Role.ROLE_USER);
    }
}
