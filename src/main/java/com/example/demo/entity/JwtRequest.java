package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author tamvo
 * @created 14/03/2020 - 9:35 PM
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtRequest {
    private String username;
    private String password;
}
