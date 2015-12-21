package ru.ugfeld.id.lec5.web.model.requests;

import ru.ugfeld.id.lec5.web.model.entities.Category;

public class CategoryRequest extends Request{

	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
