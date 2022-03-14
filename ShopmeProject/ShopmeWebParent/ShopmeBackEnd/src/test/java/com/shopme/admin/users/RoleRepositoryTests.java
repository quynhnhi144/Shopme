package com.shopme.admin.users;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.shopme.common.entity.Role;

@DataJpaTest
// ứng dụng dùng datasource thì chạy lên test sẽ dùng db đó
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
	@Autowired
	private RoleRepository repo;

	/*
	 * Thư viện hay dùng để test: Dùng để verify khi dev sửa code hoặc làm thêm gì
	 * đó nó sẽ đảm bảo ko làm ảnh hưởng đến những phần đó hoặc phần khác liên quan
	 * + testng
	 * + junittest
	 * + mockito
	 */
	@Test
	public void testCreateNewRoles() {
		Role role = new Role();
		role.setName("Admin");
		role.setDescription("Manage Everything");

		Role saveRole = repo.save(role);
		
		System.out.println("saveRole: " + saveRole);
		assertThat(saveRole).isNotNull();
		assertThat(saveRole.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateRestRoles() {
		Role roleSalesperson = new Role("Salesperson", "manage product price, "
				+ "customers, shipping, orders and sales report");
		
		Role roleEditor = new Role("Editor", "manage categories, brands, "
				+ "products, articles and menus");
		
		Role roleShipper = new Role("Shipper", "view products, view orders "
				+ "and update order status");
		
		Role roleAssistant = new Role("Assistant", "manage questions and reviews");
		
		repo.saveAll(Arrays.asList(roleSalesperson, roleEditor, roleShipper, roleAssistant));
	}

}
