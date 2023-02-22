package com.springboot.jpa;

import com.springboot.jpa.dao.UserRepository;
import com.springboot.jpa.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringbootJpaCurdApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringbootJpaCurdApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

        User user = new User();
        user.setId(111);
        user.setName("RAMESH KUMAR");
        user.setCity("RANCHI");
        user.setStatus("SINGLE");

        User user2 = new User();
        user2.setId(333);
        user2.setName("RAJ KUMAR");
        user2.setCity("PUNE");
        user2.setStatus("MARRID");

        /*User firstuser = userRepository.save(user);
        User seconduser = userRepository.save(user2);
        System.out.println("The Details of First User is    : " + firstuser);
        System.out.println("The Details of Second User is   : " + seconduser);*/

        //Save all User
        List<User> users = List.of(user, user2);
        Iterable<User> result = userRepository.saveAll(users);
        result.forEach(u->System.out.println(u));

        //userRepository.deleteById(111);

        //Find All User
        /*Iterable<User> alluser = userRepository.findAll();
        alluser.forEach(a->System.out.println(a));*/

        List<User> userName = userRepository.findByName("RAMESH KUMAR");
        userName.forEach(n->System.out.println(n));

        //userRepository.deleteAll(alluser);
        System.out.println("Done");


        //https://www.youtube.com/watch?v=uQWYAA7hpVU&list=PL0zysOflRCelmjxj-g4jLr3WKraSU_e8q&index=14&ab_channel=LearnCodeWithDurgesh
    }

}
