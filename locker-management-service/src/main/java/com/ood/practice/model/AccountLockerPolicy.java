package com.ood.practice.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountLockerPolicy {

  private Integer freeUsageDays;

  private Integer maxUsageDays;

  public AccountLockerPolicy(Integer freeUsageDays, Integer maxUsageDays) {
      this.freeUsageDays = freeUsageDays;
      this.maxUsageDays = maxUsageDays;
  }

}
