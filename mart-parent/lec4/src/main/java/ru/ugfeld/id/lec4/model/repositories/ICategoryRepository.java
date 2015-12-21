package ru.ugfeld.id.lec4.model.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ru.ugfeld.id.lec4.model.entities.Category;

public interface ICategoryRepository extends JpaRepository< Category, Integer >{
	
    @Query( "select c from Category c where LOWER(c.name) = LOWER(:name) " )
    public List< Category > getCategoriesByName( @Param( "name" ) String name );

}
