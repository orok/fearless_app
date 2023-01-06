package com.item.crud.service;

import com.item.crud.domain.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    Item save(Item item);
    List<Item> findAll();
    Optional<Item> findOne(Long id);
    void delete(Long id);
}
