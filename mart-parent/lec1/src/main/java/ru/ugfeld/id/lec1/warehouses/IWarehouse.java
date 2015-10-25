package ru.ugfeld.id.lec1.warehouses;

import java.util.List;

import ru.ugfeld.id.lec1.products.IProduct;
/**
 * Интерфейс склада.
 * @author Ирина
 *
 */
public interface IWarehouse {
	/**
	 * Добавить товар на склад.
	 * @param product добавляемый товар.
	 * @param quantity количество товара.
	 */
	void addProduct( IProduct product, double quantity );
	/**
	 * Удалить товар со склада.
	 * @param product удаляемый товар.
	 * @return количество товара, удаленного со склада.
	 */
	double removeProduct( IProduct product );
	/**
	 * Получить список наименований товаров на складе.
	 * @return список наименований товаров на складе.
	 */
	List< String > listProducts( );
	
	
}
