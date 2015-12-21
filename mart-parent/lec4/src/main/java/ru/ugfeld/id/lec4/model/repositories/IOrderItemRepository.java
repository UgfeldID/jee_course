package ru.ugfeld.id.lec4.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.ugfeld.id.lec4.model.entities.OrderItem;

public interface IOrderItemRepository extends JpaRepository< OrderItem, Integer >{

}
