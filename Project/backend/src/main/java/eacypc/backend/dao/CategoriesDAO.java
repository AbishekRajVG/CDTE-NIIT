package eacypc.backend.dao;

import java.util.List;

import org.springframework.context.annotation.Bean;

import eacypc.backend.dto.Categories;

public interface CategoriesDAO {

	@Bean
	List<Categories> list();
}
