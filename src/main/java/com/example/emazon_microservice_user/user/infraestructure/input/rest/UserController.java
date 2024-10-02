package com.example.emazon_microservice_user.user.infraestructure.input.rest;

import com.example.emazon_microservice_user.user.application.dto.UserRequest;
import com.example.emazon_microservice_user.user.application.dto.UserResponse;
import com.example.emazon_microservice_user.user.application.handler.IUserHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;

@RestController
@RequestMapping("/user")
public class UserController {

    private final IUserHandler userHandler;

    public UserController(IUserHandler userHandler) {
        this.userHandler = userHandler;
    }

    @Operation(summary = "Add a new Warehouse Assistant")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "1 Warehouse Assistant added",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Book.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid arguments supplied",
                    content = @Content)
    })
    @PostMapping("/warehouse-assistant")
    public ResponseEntity<UserResponse> createArticle(@RequestBody UserRequest userRequest){
        UserResponse articleResponse = userHandler.saveWarehouseAssistant(userRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(articleResponse);
    }

}
