package com.exposed.example.data;

import java.util.UUID;

public class RandomUniqueIdSeeder implements UniqueIdSeeder {

  private final String uuid;

  public RandomUniqueIdSeeder() {
    uuid = UUID.randomUUID().toString();
  }

  @Override
  public String getSeed() {
    return uuid;
  }
}
