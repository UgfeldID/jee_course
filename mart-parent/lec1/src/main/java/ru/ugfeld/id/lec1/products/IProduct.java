package ru.ugfeld.id.lec1.products;

import ru.ugfeld.id.lec1.categories.ICategory;
/**
 * Интерфейс товара.
 * @author Ирина
 *
 */
public interface IProduct {
	/**
	 * Получить наименование товара.
	 * @return наименование товара.
	 */
	String getName( );
	/**
	 * Получить категорию товара.
	 * @return категория товара.
	 */
	ICategory getCategory( );
	/**
	 * Получить стоимость товара.
	 * @return стоимость товара.
	 */
	double getPrice( );
}
