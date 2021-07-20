package com.example.retailer.service;

import com.example.retailer.entity.Rewards;
import org.springframework.stereotype.Service;

public interface RewardsService {
    public Rewards getRewardsByCustomerId(Long customerId);
}
