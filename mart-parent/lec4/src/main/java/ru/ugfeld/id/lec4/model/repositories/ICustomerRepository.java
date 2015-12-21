package ru.ugfeld.id.lec4.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.ugfeld.id.lec4.model.entities.Customer;

public interface ICustomerRepository extends JpaRepository< Customer, Integer >{

}
