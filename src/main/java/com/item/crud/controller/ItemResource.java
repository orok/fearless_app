package com.item.crud.controller;

import com.item.crud.domain.Item;
import com.item.crud.repository.ItemRepository;
import com.item.crud.service.ItemService;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api")
public class ItemResource {
    private final Logger log = LoggerFactory.getLogger(ItemResource.class);

    private final ItemService itemService;
    private final ItemRepository itemRepository;

    public ItemResource(ItemService itemService, ItemRepository itemRepository) {
        this.itemService = itemService;
        this.itemRepository = itemRepository;
    }

    @PostMapping("/items")
    public ResponseEntity<Item> createItem(@RequestBody Item item) throws URISyntaxException {
        log.debug("REST request to save Item : {}", item);
        if (item.getId() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "A new item cannot already have an ID");
        }
        Item result = itemService.save(item);
        return ResponseEntity
            .created(new URI("/api/items/" + result.getId()))
            .body(result);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "id", required = false) final Long id, @RequestBody Item item)
        throws URISyntaxException {
        log.debug("REST request to update Item : {}, {}", id, item);
        if (item.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "");
        }
        if (!Objects.equals(id, item.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "");
        }

        if (!itemRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "");
        }

        Item result = itemService.save(item);
        return ResponseEntity
            .ok()
            .body(result);
    }

}
