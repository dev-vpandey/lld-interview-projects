package com.ood.practice.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class Site {

    Map<LockerSize, Set<Locker>> sizeToLockersMap = new HashMap<>();

    /**
     * Initialise the Site by setting different number of lockers for each size
     */
    public Site(Map<LockerSize, Integer> lockers) {
        for(Map.Entry<LockerSize, Integer> entry : lockers.entrySet() ) {
            LockerSize lockerSize = entry.getKey();
            int lockerCount = entry.getValue();

            Set<Locker> lockerSet = new HashSet<>();
            for(int i = 0; i < lockerCount; i++) {
                lockerSet.add(new Locker(lockerSize));
            }
            this.sizeToLockersMap.put(lockerSize, lockerSet);
        }
    }
    
}
