package org.example.airline.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.airline.domain.Flight;
import org.example.airline.domain.User;
import org.example.airline.repos.UserRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserEntityTest {
    @Autowired
    public TestEntityManager entityManager;

    @Autowired
    UserRepo userRepo;

    @Test
    public void delete_all_users() {
        entityManager.persist( new User("Josh", "vbn123") );
        entityManager.persist( new User("Bran", "ook123") );

        userRepo.deleteAll();

        assertThat( userRepo.findAll().isEmpty() );
    }

    @Test
    public void find_no_users_if_repo_is_empty() {
        Iterable<User> users = userRepo.findAll();

        assertThat(users).isEmpty();
    }

    @Test
    public void find_all_users() {
        User user1 = new User("Josh", "vbn123");
        entityManager.persist( user1 );
        User user2 = new User("Bran", "ook123");
        entityManager.persist( user2 );

        Iterable<User> users = userRepo.findAll();

        assertThat(users).hasSize(2).contains(user1, user1);
    }

    @Test
    public void find_user_by_username() {
        User user1 = new User("Josh", "vbn123");
        entityManager.persist( user1 );
        User user2 = new User("Bran", "ook123");
        entityManager.persist( user2 );

        User getUser = userRepo.findByUsername( "Josh" );

        assertThat( getUser ).isEqualTo( user1 );
    }
}
