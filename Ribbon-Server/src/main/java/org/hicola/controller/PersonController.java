package org.hicola.controller;

import org.hicola.model.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/9/2
 * @
 */
@RestController
@RequestMapping(value = "/Ribbon-server-api/")
public class PersonController {

    @RequestMapping(value = "getPerson", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person getPersonInfo(HttpServletRequest request) {
        Person p = new Person();
        p.setId(1);
        p.setName("Willis.Bai");
        p.setMessage("Call successfully");
        p.setUrl(request.getRequestURL().toString());
        return p;
    }
}
