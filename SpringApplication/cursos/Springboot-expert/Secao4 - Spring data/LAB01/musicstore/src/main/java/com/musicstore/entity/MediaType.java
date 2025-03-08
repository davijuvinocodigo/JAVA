package com.musicstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "mediatype")
public class MediaType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "media_type_id")
    private Integer mediaTypeId;
    private String name;
}
