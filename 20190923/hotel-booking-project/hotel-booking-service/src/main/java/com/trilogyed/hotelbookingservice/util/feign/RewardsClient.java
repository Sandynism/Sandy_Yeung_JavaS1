package com.trilogyed.hotelbookingservice.util.feign;

import com.trilogyed.hotelbookingservice.model.Rewards;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name="rewards-service")
public interface RewardsClient {

    @RequestMapping(value = "/rewards/type/{roomType}", method = RequestMethod.GET)
    Rewards getRewards(@PathVariable String roomType);

    @RequestMapping(value = "/rewards", method = RequestMethod.GET)
    List<Rewards> getAllRewards();
}

