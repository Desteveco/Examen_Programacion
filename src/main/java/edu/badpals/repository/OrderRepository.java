package edu.badpals.repository;

import edu.badpals.domain.Order;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrderRepository implements  PanacheRepositoryBase<Order, String>{
}
