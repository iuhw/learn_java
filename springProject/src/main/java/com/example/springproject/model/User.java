package com.example.springproject.model;

import lombok.Builder;
import lombok.Data;

/**
 * @author:
 */
@Data
@Builder
public class User {

    private String name;

    private Integer age;
}
