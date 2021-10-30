package com.backpacker.userapi.auth;

import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/v1/oauth", produces = MediaTypes.HAL_JSON_VALUE)
public class AuthController {

    //login
    //logout

}
