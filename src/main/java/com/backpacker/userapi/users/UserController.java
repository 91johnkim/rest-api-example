package com.backpacker.userapi.users;

import com.backpacker.userapi.users.dto.UserRequest;
import com.backpacker.userapi.users.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping(value="/api/v1/users", produces = MediaTypes.HAL_JSON_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Integer id){
        Optional<User> optionalUser = userService.getUserById(id);
        if(optionalUser.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(EntityModel.of(UserResponse.create(optionalUser.get())));
    }


    @GetMapping
    public ResponseEntity queryUsers(Pageable pageable, PagedResourcesAssembler<User> assembler){
        //var pagedResource = assembler.to

        return ResponseEntity.ok(null);
    }


    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid UserRequest userDto , Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.badRequest().body(EntityModel.of(errors));
        }
        User user = userService.createUser(userDto.toEntity());
        if(user == null){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.created(URI.create("ab")).body(UserResponse.create(user));
    }

}
