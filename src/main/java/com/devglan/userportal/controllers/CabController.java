package com.devglan.userportal.controllers;

import com.devglan.userportal.models.Cab;
import com.devglan.userportal.services.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/cab"})
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class CabController {
	
    @Autowired
    private CabService cabService;

    @GetMapping
    public List<Cab> findAll(){
        return cabService.findAll();
    }
    
    @RequestMapping(value = "/bycid", method = RequestMethod.POST)
	public List<Cab> findByCompny_id(@RequestBody Cab CompnyId) 
	{
		return cabService.findByCompnyId(CompnyId.getComanyId());
	}
    
    @PutMapping(path = {"/{cid}"})
    public Cab update(@PathVariable("cid") int cid, @RequestBody Cab cab){
        cab.setCid(cid);
        return cabService.update(cab);
    }
    
    @RequestMapping(value = "/viewusercab", method = RequestMethod.POST)
   	public Cab findBycid(@RequestBody Cab cid) 
   	{
   		return cabService.findBycid(cid.getCid());
   	}
 
     
}
