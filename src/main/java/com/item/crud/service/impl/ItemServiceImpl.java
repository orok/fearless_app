package com.item.crud.service.impl;

import com.item.crud.domain.Item;
import com.item.crud.repository.ItemRepository;
import com.item.crud.service.ItemService;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    private final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);
    private final ItemRepository itemRepository;
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item save(Item item) {
        log.debug("Request to save Item : {}", item);
        return itemRepository.save(item);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Item> findAll() {
        log.debug("Request to get all Items");
        return itemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Item> findOne(Long id) {
        log.debug("Request to get Item : {}", id);
        return itemRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Item : {}", id);
        itemRepository.deleteById(id);
    }
}
