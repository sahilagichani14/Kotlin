package com.sahil.kotlin_sb_mongodb_jwtauth.controllers

import com.sahil.kotlin_sb_mongodb_jwtauth.database.model.User
import com.sahil.kotlin_sb_mongodb_jwtauth.security.AuthService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.Pattern
import org.springframework.web.ErrorResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
@Tag(name = "Authorization Management", description = "APIs for managing user login, register, refresh token and to get auth token")
class AuthController(
    private val authService: AuthService
) {
    data class AuthRequest(
        @field:Email(message = "Invalid email format.")
        val email: String,
        @field:Pattern(
            regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{9,}\$",
            message = "Password must be at least 9 characters long and contain at least one digit, uppercase and lowercase character."
        )
        val password: String
    )

    data class RefreshRequest(
        val refreshToken: String
    )

    @Operation(summary = "Register as a new user", description = "Add a new user to the system")
//    @ApiResponses(value = {
//        @ApiResponse(
//            responseCode = "200",
//            description = "User created successfully",
//            content =
//                @Content(mediaType = "application/json", schema =
//                    @Schema(implementation = User.class))
//            ),
//            @ApiResponse(
//                responseCode = "400",
//                description = "Invalid request data",
//                content = @Content(schema = @Schema(implementation = ErrorResponse.class))
//            )
//    })
    @PostMapping("/register")
    fun register(
        @Valid @RequestBody body: AuthRequest
    ) {
        authService.register(body.email, body.password)
    }

    @PostMapping("/login")
    fun login(
        @RequestBody body: AuthRequest
    ): AuthService.TokenPair {
        return authService.login(body.email, body.password)
    }

    @PostMapping("/refresh")
    fun refresh(
        @RequestBody body: RefreshRequest
    ): AuthService.TokenPair {
        return authService.refresh(body.refreshToken)
    }
}