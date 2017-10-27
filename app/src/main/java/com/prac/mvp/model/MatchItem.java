package com.prac.mvp.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchItem {

    private AlbumMatches albummatches;

    private ArtistMatcher artists;

    private TrackMatches  tracks;



    @JsonCreator
    public MatchItem(@JsonProperty(value = "albummatches") AlbumMatches albums, @JsonProperty(value = "artistmatches")ArtistMatcher artists,  @JsonProperty(value = "trackmatches")TrackMatches tracks) {
        this.albummatches = albums;
        this.artists = artists;
        this.tracks = tracks;
    }



    public AlbumMatches getAlbummatches() throws NullPointerException
    {
        return albummatches;
    }

    public ArtistMatcher getArtists() throws NullPointerException{
        return artists;
    }

    public TrackMatches getTracks()  throws NullPointerException {
        return tracks;
    }

}
