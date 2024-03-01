package com.example.zenrea_backend;

import com.example.zenrea_backend.entity.User;
import com.example.zenrea_backend.repository.UserRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepo userRepo;


    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveItem(){
        User user= new User();

        user.setUsername("Testing username");
        user.setEmail("Testing  name");
        user.setPassword("123456");

        user=userRepo.save(user);

        Assertions.assertThat(user.getId()).isGreaterThan(0);


    }


    @Test
    @Order(2)
    public void findById(){
        User user= userRepo.findById(1).get();
        Assertions.assertThat(user.getId()).isEqualTo(1);
    }

    @Test
    @Order(3)
    public void findAllData(){
        List<User> itemList= userRepo.findAll();
        Assertions.assertThat(itemList.size()).isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void updateItem(){
        User user= userRepo.findById(1).get();
        user.setEmail("updated testing name");
        user=userRepo.save(user);

        Assertions.assertThat(user.getUsername()).isEqualTo("updated testing name");
    }

    @Test
    @Order(5)
    public void DeleteByID(){
        userRepo.deleteById(1);

        User item1=null;

        Optional<User> user=userRepo.findById(1);

        if(user.isPresent()){
            item1=user.get();
        }

        Assertions.assertThat(item1).isNull();

    }
}
