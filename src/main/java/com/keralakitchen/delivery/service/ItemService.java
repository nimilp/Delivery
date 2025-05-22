package com.keralakitchen.delivery.service;

import com.keralakitchen.delivery.model.Items;
import com.keralakitchen.delivery.service.service.IItemService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ItemService implements IItemService {
    @Autowired
    MongoTemplate mongoTemplate;
    @Override
    public Optional<Items> create(Items item) {
        Optional<Items> optional = Optional.empty();
        return Optional.of(mongoTemplate.save(item));
    }

    @Override
    public List<Items> getItems(String id) {
        log.info(String.format("id is %s",id));
        Query query = new Query(Criteria.where("parentId").is(id));
        return mongoTemplate.find(query, Items.class);
    }

    @Override
    public Items getCategory(String id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findOne(query, Items.class);
    }
}
