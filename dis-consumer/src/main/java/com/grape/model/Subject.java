package com.grape.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Subject implements Serializable {
    private String name;
    private Integer mark;
    private LocalDateTime localDateTime;
}
