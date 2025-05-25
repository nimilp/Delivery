package com.keralakitchen.delivery.service.service;

import com.keralakitchen.delivery.model.Items;
import lombok.NonNull;

import java.util.List;
import java.util.Optional;

public interface IItemService {

    Optional<Items> create(Items item);
    List<Items> getItems(String id);
    Items getCategory(String id);

}
