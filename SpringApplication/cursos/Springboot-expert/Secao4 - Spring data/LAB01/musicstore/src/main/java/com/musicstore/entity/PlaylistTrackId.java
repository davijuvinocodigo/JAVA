package com.musicstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class PlaylistTrackId implements Serializable {
    @Column(name = "playlist_id")
    private Integer playlistId;
    @Column(name = "track_id")
    private Integer trackId;
}
