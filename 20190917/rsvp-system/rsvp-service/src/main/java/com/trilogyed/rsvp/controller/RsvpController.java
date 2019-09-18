package com.trilogyed.rsvp.controller;

import com.trilogyed.rsvp.dao.RsvpDao;
import com.trilogyed.rsvp.model.Rsvp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CacheConfig(cacheNames = {"rsvps"})
public class RsvpController {

    @Autowired
    RsvpDao dao;

    public RsvpController(RsvpDao dao) {
        this.dao = dao;
    }

    //grabs the result and puts a cache on the matching id.
    @CachePut(key = "#result.getId()")
    @RequestMapping(value = "/rsvps", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Rsvp createRsvp(@RequestBody Rsvp rsvp) {
        System.out.println("CREATING RSVP");
        return dao.addRsvp(rsvp);
    }

    @Cacheable
    @RequestMapping(value = "/rsvps/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Rsvp getRsvp(@PathVariable int id) {
        System.out.println("GETTING RSVP ID = " + id);
        return dao.getRsvp(id);
    }

    @RequestMapping(value = "/rsvps", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Rsvp> getAllRsvps() {
        System.out.println("GETTING ALL RSVPS");
        return dao.getAllRsvps();
    }

    //cacheEvict uses the id as a key to delete the old values for the update.
    @CacheEvict(key = "#rsvp.getId()")
    @RequestMapping(value = "/rsvps", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateRsvp(@RequestBody Rsvp rsvp) {
        System.out.println("UPDATING RSVP ID = " + rsvp.getId());
        dao.updateRsvp(rsvp);
    }

    //does not require a key because it is fully evicting data for given id.
    @CacheEvict
    @RequestMapping(value = "/rsvps/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteRsvp(@PathVariable int id) {
        System.out.println("DELETING RSVP ID = " + id   );
        dao.deleteRsvp(id);
    }
}
