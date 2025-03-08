package com.musicstore.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "playlistTrack")
public class PlaylistTrack {
    @EmbeddedId
    private PlaylistTrackId id;

    @ManyToOne
    @MapsId("playlist_id")
    @JoinColumn(name = "playlist_id", referencedColumnName = "playlist_id")
    private Playlist playlist;

    @ManyToOne
    @MapsId("track_id")
    @JoinColumn(name = "track_id", referencedColumnName = "track_id")
    private Track track;
}
