package ru.ugfeld.id.lec4.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.ugfeld.id.lec4.model.entities.Warehouse;

public interface IWarehouseRepository extends JpaRepository< Warehouse, Integer >{

	 @Query( "select w from Warehouse w where LOWER(w.name) = LOWER(:name) " )
	public List <Warehouse> getWarehousesByName( @Param( "name" ) String name );
}
