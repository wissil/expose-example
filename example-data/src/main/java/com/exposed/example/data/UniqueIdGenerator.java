package com.exposed.example.data;

import javax.inject.Inject;

import java.util.Base64;

import com.google.common.primitives.Longs;
import com.relops.snowflake.Snowflake;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UniqueIdGenerator {

  private static final Logger logger = LoggerFactory.getLogger(UniqueIdGenerator.class);

  private final Snowflake snowflake;

  @Inject
  public UniqueIdGenerator(UniqueIdSeeder seeder) {
    String seed = seeder.getSeed();
    logger.info("Seeding Snowflake with seed '{}'.", seed);
    this.snowflake = new Snowflake(Math.abs(seed.hashCode() % 1024));
  }

  public long nextLong() {
    return snowflake.next();
  }

  public String next() {
    return Base64.getEncoder().encodeToString(Longs.toByteArray(nextLong()));
  }
}
