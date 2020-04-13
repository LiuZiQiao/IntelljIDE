package com.lxk.demo.controller;

import com.lxk.demo.config.PaginationUtil;
import com.lxk.demo.mapper.PersonsMapper;
import com.lxk.demo.model.PageInfo;
import com.lxk.demo.model.Persons;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    @Autowired
    private PersonsMapper personsMapper;
    @Value("$(com.lxk.paginatin.max-pre-page)")
    Integer maxPerPage;

    @RequestMapping(value = "/sex",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getSexAll(){
        ArrayList<Map<String,String>> results = new ArrayList<>();
        for (Object value: personsMapper.findSex()
             ) {
            Map<String,String> sex = new HashMap<>();
            sex.put("label",value.toString());
            sex.put("label",value.toString());
            results.add(sex);
        }
        ResponseEntity<ArrayList<Map<String,String>>> responseEntity = new ResponseEntity<>(results, HttpStatus.OK);
        return responseEntity;

    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, PageInfo> getPersonAll(@RequestParam(value = "page",required = false) Integer pages, @RequestParam("sex") String sex,@RequestParam("email") String email){

        if (pages == null) pages = 1;

        Sort sort = new Sort(Sort.Direction.ASC,"id");
        Pageable pageable = new PageRequest(pages-1,maxPerPage,sort);

        PaginationUtil paginationUtil = new PaginationUtil();
        return paginationUtil.filterQuery(sex,email,pageable);
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Persons> getUserDetail(@PathVariable Long id){
        Persons person = personsMapper.findById(id);
        return new ResponseEntity<>(person,HttpStatus.OK);
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Persons updateUser(@PathVariable Long id, @RequestBody Persons data){
        Persons user = personsMapper.findById(id);
        user.setPhone(data.getPhone());
        user.setZone(data.getZone());
        return personsMapper.save(user);
    }
}
