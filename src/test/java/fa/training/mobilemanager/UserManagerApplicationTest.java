package fa.training.mobilemanager;/*
 *
 *
 * Project ProductManager
 * Copyright (C) $year by Fanglong-it. All Rights Reserved.
 * For more information : Fang.longpc@gmail.com
 * Example project exist at : https://github.com/fanglong-it/
 * 10/21/21, 4:35 PM
 *
 *
 */


import fa.training.mobilemanager.entity.User;
import fa.training.mobilemanager.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 *
 *
 * Project ProductManager
 * Copyright (C) $year by Fanglong-it. All Rights Reserved.
 * For more information : Fang.longpc@gmail.com
 * Example project exist at : https://github.com/fanglong-it/
 * 10/23/21, 7:29 PM
 *
 *
 */

@SpringBootTest
public class UserManagerApplicationTest {

    @Autowired
    private UserRepository repo;


    @Test
    public void findUserbyEmailAndPassword() {
        String email = "admin";
        String password = "admin";

        User newUser = repo.loginUser(email, password);
        Assertions.assertThat(newUser).isNotNull();


    }

}
