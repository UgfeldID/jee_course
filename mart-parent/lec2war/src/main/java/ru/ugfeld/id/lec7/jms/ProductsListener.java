package ru.ugfeld.id.lec7.jms;

import java.util.List;

import javax.jms.BytesMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.ugfeld.id.lec4.model.services.ICategoryService;
import ru.ugfeld.id.lec4.model.services.IProductService;
import ru.ugfeld.id.lec4.model.services.IWarehouseService;
import ru.ugfeld.id.lec7.model.entities.Product;
import ru.ugfeld.id.lec7.model.responses.ProductsResponse;

public class ProductsListener implements MessageListener{

	private static final Logger log = LoggerFactory.getLogger( ProductsListener.class );
	
	
	private ICategoryService categoryService;
	private IProductService productService;
	private IWarehouseService warehouseService;
	
	@Override
	public void onMessage(Message message) {
		
		try {			
			String json = null;
			if ( message instanceof TextMessage )
				json = ( ( TextMessage )message ).getText( );
			else if ( message instanceof BytesMessage )
			{
				BytesMessage byteMessage = ( BytesMessage )message;
				
				byte[ ] data = new byte[ ( int )byteMessage.getBodyLength( ) ]; 
				int read = byteMessage.readBytes( data );
				json = new String( data, 0, read, "UTF-8" );
			}
			
			if ( null == json )
				throw new Exception( "Неправильное сообщение" );
			
			ObjectMapper jsonMapper = new ObjectMapper( );
			ProductsResponse response = jsonMapper.readValue( json, ProductsResponse.class );
			
			if( (response.getProducts() == null) || (response.getProducts().isEmpty()) )
				return;
			
			ru.ugfeld.id.lec4.model.entities.Warehouse dbWarehouse = warehouseService.getOrCreateByName("склад 7");
			for (Product product : response.getProducts()) {
				
				ru.ugfeld.id.lec4.model.entities.Product dbProduct = product.create();				
				dbProduct.setWarehouse(dbWarehouse);
				
				ru.ugfeld.id.lec4.model.entities.Category dbCategory = getOneCategory(product.getCategories());
				
				if( dbCategory == null ){
					log.info("Ошибка при чтении сообщения", "Список категорий пуст для товара с названием {}", product.getName());
					continue;
				}
				
				dbProduct.setCategory(dbCategory);
				productService.create(dbProduct);
			}
		
		} catch (Exception e){
			log.info("Ошибка при чтении сообщения",e);
		}
	}
	
	private ru.ugfeld.id.lec4.model.entities.Category getOneCategory ( 
			List<String> categoriesNames) {
		
		ru.ugfeld.id.lec4.model.entities.Category dbCategory = null;
		
		if( (categoriesNames == null) || (categoriesNames.isEmpty()) )
			return dbCategory;
		
		for (String categoryName : categoriesNames) {
			List<ru.ugfeld.id.lec4.model.entities.Category> dbCategories = categoryService.findByName(categoryName);
			
			if( (dbCategories != null) && (!dbCategories.isEmpty()) ){
				dbCategory = dbCategories.get(0);
				break;
			}						
		}
		
		if( dbCategory == null ){
			dbCategory = categoryService.getOrCreateByName(categoriesNames.get(0));
		}
		
		return dbCategory;
	}
	
	
	public ICategoryService getCategoryService() {
		return categoryService;
	}
	
	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	public IProductService getProductService() {
		return productService;
	}
	
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public IWarehouseService getWarehouseService() {
		return warehouseService;
	}


	public void setWarehouseService(IWarehouseService warehouseService) {
		this.warehouseService = warehouseService;
	}
	
}
