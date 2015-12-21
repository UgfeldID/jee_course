package ru.ugfeld.id.lec4.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ugfeld.id.lec4.model.entities.Product;

public interface IProductRepository extends JpaRepository< Product, Integer >{

	  @Query( "select p from Product p where LOWER(p.name) = LOWER(:name) " )
	    public List< Product > getProductsByName( @Param( "name" ) String name );
}
