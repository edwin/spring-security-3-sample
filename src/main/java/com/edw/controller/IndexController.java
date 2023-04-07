package com.edw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * <pre>
 *     com.edw.controller.IndexController
 * </pre>
 *
 * @author Muhammad Edwin < edwin at redhat dot com >
 * 07 Apr 2023 16:21
 */
@RestController
public class IndexController {

    @GetMapping(path = "/")
    public HashMap index() {
        return new HashMap(){{
            put("hello", "world");
        }};
    }

}
