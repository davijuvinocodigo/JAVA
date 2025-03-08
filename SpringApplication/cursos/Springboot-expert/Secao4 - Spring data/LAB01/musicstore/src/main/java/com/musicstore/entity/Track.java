package com.musicstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "track")
public class Track {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "track_id")
    private Integer trackId;
    private String name;
    @Column(name = "album_id")
    private Integer albumId;
    @Column(name = "media_type_id")
    private Integer mediaTypeId;
    @Column(name = "genre_id")
    private Integer genreId;
    private String composer;
    private Integer milliseconds;
    private Integer bytes;
    @Column(name = "unit_price")
    private Double unitPrice;

    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "album_id", insertable = false, updatable = false)
    private Album album;

    @ManyToOne
    @JoinColumn(name = "media_type_id", referencedColumnName = "media_type_id", insertable = false, updatable = false)
    private MediaType mediaType;

    @ManyToOne
    @JoinColumn(name = "genre_id", referencedColumnName = "genre_id", insertable = false, updatable = false)
    private Genre genre;
}
