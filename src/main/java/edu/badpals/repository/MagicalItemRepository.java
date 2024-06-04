package edu.badpals.repository;

import edu.badpals.domain.MagicalItem;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@ApplicationScoped
public class MagicalItemRepository implements PanacheRepositoryBase<MagicalItem, String> {
    public Optional<MagicalItem> findByUserName(String item_name) {
        List<MagicalItem> ordenes = this.listAll()
                .stream()
                .filter(o -> o.getName().equalsIgnoreCase(item_name))
                .collect(Collectors.toList());
        return Optional.ofNullable(ordenes.isEmpty()? null : ordenes.get(0));
    }
}

