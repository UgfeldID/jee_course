package ru.ugfeld.id.lec4.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.ugfeld.id.lec4.model.entities.Category;
import ru.ugfeld.id.lec4.model.repositories.ICategoryRepository;

public class CategoryService implements ICategoryService{
	
	@Autowired
	private ICategoryRepository categoryRepository;
	
	@Override
	@Transactional( rollbackFor = Exception.class )
	public Category create(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Category delete(int id) throws Exception {
		Category deletedCategory = categoryRepository.findOne(id);
		
		if( deletedCategory == null)
			throw new Exception("Category not found");
				
		categoryRepository.delete(deletedCategory);
		return deletedCategory;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	@Transactional( rollbackFor = Exception.class )
	public Category update(Category category) throws Exception {
		Category updatedCategory = categoryRepository.findOne(category.getId());
		
		if( updatedCategory == null )
			throw new Exception("Category not found");
		
		updatedCategory.setName(category.getName());
		
		categoryRepository.save(updatedCategory);
		return updatedCategory;
	}

	@Override
	public Category findById(int id) {
		return categoryRepository.findOne(id);
	}

	@Override
	public List<Category> findByName( String name) {
		return categoryRepository.getCategoriesByName(name);
	}

	@Override
	public Category getOrCreateByName(String name) {	
		
		List<Category> categories = findByName( name );
		if( (categories == null) || (categories.isEmpty()) )
			return create(new Category(name));		
		
		return categories.get(0);
	}

}
