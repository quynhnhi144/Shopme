package com.shopme.admin.users;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@DataJpaTest
// ứng dụng dùng datasource thì chạy lên test sẽ dùng db đó
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	@Autowired
	private UserRepository repo;

	@Autowired
	private TestEntityManager entityManager;

	/*
	 * Thư viện hay dùng để test: Dùng để verify khi dev sửa code hoặc làm thêm gì
	 * đó nó sẽ đảm bảo ko làm ảnh hưởng đến những phần đó hoặc phần khác liên quan
	 * + testng + junittest + mockito
	 */
	@Test
	public void testCreateUserWithOneRole() {
		User user = new User("celita@yahoo.com", "Ali", "Adam", "aliam2022");
		Role roleAdmin = new Role(1);
		user.addRoles(roleAdmin);

		User savedUser = repo.save(user);
		System.out.println(savedUser);
		assertThat(savedUser).isNotNull();
	}

	@Test
	public void testCreateUserWithTwoRoles() {
		User user = new User("maicon@gmail.com", "MaiCon", "Honda", "honda2022");
		Role roleSalesPerson = new Role(2);
		Role roleShipper = new Role(4);
		user.addRoles(roleSalesPerson, roleShipper);

		User savedUser = repo.save(user);
		System.out.println(savedUser);
		assertThat(savedUser).isNotNull();
	}
}
