package fa.training.mobilemanager.repository;/*
 *
 *
 * Project ProductManager
 * Copyright (C) $year by Fanglong-it. All Rights Reserved.
 * For more information : Fang.longpc@gmail.com
 * Example project exist at : https://github.com/fanglong-it/
 * 10/20/21, 9:22 PM
 *
 *
 */

import fa.training.mobilemanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("SELECT u from User u where u.email = ?1 and u.password = ?2")
    User loginUser(String email, String password);

    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
}
