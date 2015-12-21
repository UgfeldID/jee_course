package ru.ugfeld.id.lec4.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.ugfeld.id.lec4.model.entities.Order;

public interface IOrderRepository extends JpaRepository< Order, Integer >{

}
