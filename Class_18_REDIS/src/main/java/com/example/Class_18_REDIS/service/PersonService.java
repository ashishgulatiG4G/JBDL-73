package com.example.Class_18_REDIS.service;

import com.example.Class_18_REDIS.model.Person;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PersonService {

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    RedisTemplate<String, Person> redisTemplate;

    public String createAsAString(Person person) {
        String key = "person:" + person.getId();
        this.redisTemplate.opsForValue().set(key, person);
        return key;
    }

    public String createAsHash(Person person) {
        String key = getKeysForHash(person.getId());
        this.redisTemplate.opsForHash().putAll(
                key,
                objectMapper.convertValue(person, Map.class)
        );
        return key;
    }


    public void lpush(Person person) {
        redisTemplate.opsForList().leftPush("person_list", person);
    }


    String getKeysForHash(String personId) {
        return "person_hash::" + personId;
    }





}
