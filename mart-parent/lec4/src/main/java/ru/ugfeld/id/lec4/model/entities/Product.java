package ru.ugfeld.id.lec4.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table( name = "products" )
public class Product {
	
	public Product() {
		super();
	}

	public Product(String name, String description, Float price, Float quantity, 
			Float discount, Category category, Warehouse warehouse) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.discount = discount;
		this.category = category;
		this.warehouse = warehouse;
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Integer id;
	
	@Column( name = "name", nullable = false, length = 100)
	private String name;
	
	@Column( name = "description", nullable = true)
	private String description;
	
	@Column( name = "price", nullable = false)
	private Float price;
	
	@Column( name = "quantity", nullable = true)
	private Float quantity;
	
	@Column( name = "discount", nullable = true)
	private Float discount = 0.f;
	
	@ManyToOne
	@JoinColumn( name = "id_category", nullable = false )
	private Category category;
	
	@ManyToOne
	@JoinColumn( name = "id_warehouse", nullable = false )
	private Warehouse warehouse;
	
	@OneToMany( mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@CascadeOnDelete
	private List< OrderItem > orderItems = new ArrayList<>( );

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getQuantity() {
		return quantity;
	}

	public void setQuantity(Float quantity) {
		this.quantity = quantity;
	}

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
