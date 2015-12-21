package ru.ugfeld.id.lec5.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import ru.ugfeld.id.lec4.model.services.ICategoryService;
import ru.ugfeld.id.lec4.model.services.IProductService;
import ru.ugfeld.id.lec4.model.services.IWarehouseService;
import ru.ugfeld.id.lec5.web.model.entities.Product;
import ru.ugfeld.id.lec5.web.model.requests.ProductRequest;
import ru.ugfeld.id.lec5.web.model.responses.IdResponse;
import ru.ugfeld.id.lec5.web.model.responses.ProductsResponse;
import ru.ugfeld.id.lec5.web.model.responses.Response;

@Controller
@RequestMapping( "/rest/warehouses" )
public class WarehouseController extends BaseController{

	@Autowired
	@Qualifier( "WarehouseService" )
	private IWarehouseService warehouseService;
	
	@Autowired
	@Qualifier( "ProductService" )
	private IProductService productService;
	
	@Autowired
	@Qualifier( "CategoryService" )
	private ICategoryService categoryService;
	
	
	@RequestMapping( value = "/{warehouse_id}/products", method = RequestMethod.GET )
	public @ResponseBody ProductsResponse getProducts( 
			@PathVariable( "warehouse_id" ) Integer warehouseId) throws Exception{
		
		ru.ugfeld.id.lec4.model.entities.Warehouse dbWarehouse = warehouseService.findById(warehouseId);
		if( dbWarehouse == null )
			throw new Exception(String.format( "Склад с идентификатором %d не найден", warehouseId ));
		
		List<ru.ugfeld.id.lec4.model.entities.Product> dbProducts = dbWarehouse.getProducts();	
		
		ProductsResponse response = new ProductsResponse();
		for (ru.ugfeld.id.lec4.model.entities.Product dbProduct : dbProducts) {
			Product product = Product.map(dbProduct);
			
			if( product != null )
				response.getProducts().add(product);
		}
		return response;
	}
	
	
	@RequestMapping( value = "/{warehouse_id}/products", method = RequestMethod.POST )
	public @ResponseBody IdResponse createProduct( @PathVariable( "warehouse_id" ) Integer warehouseId,
			@RequestBody ProductRequest productRequest) throws Exception{
		
		ru.ugfeld.id.lec4.model.entities.Warehouse dbWarehouse = warehouseService.findById(warehouseId);
		if( dbWarehouse == null )
			throw new Exception(String.format( "Склад с идентификатором %d не найден", warehouseId ));		
		
		String categoryName = productRequest.getCategory().getName();
		ru.ugfeld.id.lec4.model.entities.Category dbCategory = categoryService.getOrCreateByName(categoryName);					
		
		ru.ugfeld.id.lec4.model.entities.Product dbProduct = productRequest.getProduct().createDbEntity();
		dbProduct.setWarehouse(dbWarehouse);
		dbProduct.setCategory(dbCategory);
		productService.create(dbProduct);	
		
		IdResponse response = new IdResponse( );
		response.setId( dbProduct.getId( ) );
		
		return response;
	}

	@RequestMapping( value = "/{warehouse_id}/products/{product_id}", method = RequestMethod.DELETE )
	public @ResponseBody Response deleteProduct(  @PathVariable( "warehouse_id" ) Integer warehouseId,
			@PathVariable( "product_id" ) Integer productId) throws Exception{
		
		ru.ugfeld.id.lec4.model.entities.Warehouse dbWarehouse = warehouseService.findById(warehouseId);
		if( dbWarehouse == null )
			throw new Exception(String.format( "Склад с идентификатором %d не найден", warehouseId ));
		
		ru.ugfeld.id.lec4.model.entities.Product dbProduct = findProductById( productId, dbWarehouse.getProducts());
		if( dbProduct == null )
			throw new Exception(String.format( "Товар с идентификатором %d не найден", productId ));
		
		productService.delete(productId);
		return new Response();		
	}


	@RequestMapping( value = "/{warehouse_id}/products/{product_id}", method = RequestMethod.PUT )
	public @ResponseBody Response updateProduct(  @PathVariable( "warehouse_id" ) Integer warehouseId,
			@PathVariable( "product_id" ) Integer productId, @RequestBody ProductRequest request) throws Exception{
		
		ru.ugfeld.id.lec4.model.entities.Warehouse dbWarehouse = warehouseService.findById(warehouseId);
		if( dbWarehouse == null )
			throw new Exception(String.format( "Склад с идентификатором %d не найден", warehouseId ));
		
		ru.ugfeld.id.lec4.model.entities.Product dbProduct = findProductById( productId, dbWarehouse.getProducts());
		if( dbProduct == null )
			throw new Exception(String.format( "Товар с идентификатором %d не найден", productId));
		
		String categoryName = request.getCategory().getName();
		ru.ugfeld.id.lec4.model.entities.Category dbCategory = categoryService.getOrCreateByName(categoryName );
		request.getProduct().updateDbEntity(dbProduct);
		dbProduct.setCategory(dbCategory);
		
		productService.update(dbProduct);
		return new Response();
	}
	
	private ru.ugfeld.id.lec4.model.entities.Product findProductById( Integer productId,
			List<ru.ugfeld.id.lec4.model.entities.Product> products) {
		
		for (ru.ugfeld.id.lec4.model.entities.Product product : products) {
			if( product.getId() == productId )
				return product;
		}
		return null;
	}	
	
}
