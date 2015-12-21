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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.eclipse.persistence.annotations.CascadeOnDelete;

@Entity
@Table( name = "warehouses" )
public class Warehouse {
	
	public Warehouse() {
		super();
	}

	public Warehouse(String name, Integer capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column( name = "id" )
	private Integer id;
	
	@Column( name = "name", nullable = false, length = 100 )
	private String name;
	
	@Column( name = "capacity", nullable = false )
	private Integer capacity = 0;
	
	@OneToMany( mappedBy = "warehouse", fetch = FetchType.LAZY, cascade = CascadeType.ALL )
	@CascadeOnDelete
	private List< Product > products = new ArrayList<>( );	
	
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

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
		
}
