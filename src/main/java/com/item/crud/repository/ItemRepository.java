package com.item.crud.repository;

import com.item.crud.domain.Item;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@SuppressWarnings("unused")
@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {}
