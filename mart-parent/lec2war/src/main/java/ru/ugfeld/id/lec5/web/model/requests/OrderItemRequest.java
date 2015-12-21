package ru.ugfeld.id.lec5.web.model.requests;

public class OrderItemRequest extends Request{		
	
	private Integer productId;
	private String quantity; 
	
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
