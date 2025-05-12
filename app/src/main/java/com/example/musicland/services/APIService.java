//package com.example.musicland.services;
//
//import com.example.musicland.models.Album;
//import com.example.musicland.models.Artist;
//import com.example.musicland.models.ArtistResponse;
//import com.example.musicland.models.GenericResponse;
//import com.example.musicland.models.ListPlaylistResponse;
//import com.example.musicland.models.PlaylistRequest;
//import com.example.musicland.models.PlaylistResponse;
//import com.example.musicland.models.Song;
//import com.example.musicland.models.SongResponse;
//
//import java.util.List;
//
//import com.example.musicland.models.SongLikedRequest;
//import com.example.musicland.models.SongLikedResponse;
//
//import retrofit2.Call;
//import retrofit2.http.Body;
//import retrofit2.http.DELETE;
//import retrofit2.http.GET;
//import retrofit2.http.Multipart;
//import retrofit2.http.PATCH;
//import retrofit2.http.POST;
//import retrofit2.http.Path;
//import retrofit2.http.Query;
//
//public interface APIService {
//    // Songs API
//    @GET("song/most-views")
//    Call<GenericResponse<SongResponse>> getMostViewSong(@Query("page") int page, @Query("size") int size);
//
//    @GET("song/most-likes")
//    Call<GenericResponse<SongResponse>> getMostLikeSong(@Query("page") int page, @Query("size") int size);
//
//    @GET("song/new-released")
//    Call<GenericResponse<SongResponse>> getSongNewReleased(@Query("page") int page, @Query("size") int size);
//
//    @PATCH("song/{id}/view")
//    Call<GenericResponse<Song>> increaseViewOfSongBySongId(@Path("id") Long songId);
//
//    @GET("song/{songId}/artists")
//    Call<GenericResponse<List<Artist>>> getArtistsBySongId(@Path("songId") Long songId);
//
//    @PATCH("user/forgot-password")
//    Call<ResponseMessage> changePassword(@Body ResetPasswordRequest resetPasswordRequest);
//
//    @GET("user/{id_user}/playlists")
//    Call<ListPlaylistResponse> getPlaylistByIdUser(@Path("id_user") int id_user);
//
//    @GET("user/{id_user}/liked-songs")
//    Call<GenericResponse<List<Song>>> getSongLikedByIdUser(@Path("id_user") int id_user);
//
//    @GET("songs")
//    Call<GenericResponse<List<Song>>> getAllSongs();
//
//    @POST("playlist")
//    Call<PlaylistResponse> createPlaylist(@Body PlaylistRequest playlistRequest);
//
//    @GET("playlist/{id_playlist}")
//    Call<PlaylistResponse> getPlaylistById(@Path("id_playlist") int id_playlist);
//
//    @DELETE("playlist/{id_playlist}")
//    Call<ResponseMessage> deletePlaylist(@Path("id_playlist") int id_playlist);
//
//    @POST("songLiked/songs")
//    Call<ResponseMessage> addSongsToFavourite(@Body SongLikedRequest songLikedRequest);
//
//
//    @Multipart
//
//    @GET("songLiked/isUserLikedSong")
//    Call<SongLikedResponse> isUserLikedSong(@Query("songId") Long songId, @Query("userId") Long userId);
//
//    @POST("songLiked/toggle-like")
//    Call<SongLikedResponse> toggleLike(@Query("songId") Long songId, @Query("userId") Long userId);
//
//    @POST("playlistSong/{id_playlist}/{id_song}")
//    Call<ResponseMessage> addSongToPlaylist(@Path("id_playlist") Long id_playlist, @Path("id_song") Long id_song);
//
//    @GET("playlist")
//    Call<ResponseMessage> isPlaylistNameExists(@Query("name") String name);
//
//    @GET("song/{id_song}/comments")
//    Call<SongCommentResponse> getAllCommentsOfSong(@Path("id_song") Long idSong);
//
//    @POST("playlist/{id_playlist}")
//    Call<ResponseMessage> updatePlaylistName(@Path("id_playlist") int i, @Query("name") String name);
//
//    @DELETE("playlistSong/{id_playlist}/{id_song}")
//    Call<ResponseMessage> deleteSongFromPlaylist(@Path("id_playlist") Long id_playlist, @Path("id_song") Long id_song);
//
//    @POST("song/post-comment")
//    Call<ResponseMessage> postComment(@Body SongCommentRequest songCommentRequest);
//
//    @GET("songs/search")
//    Call<GenericResponse<List<Song>>> searchSong(@Query("query") String query);
//
//    @GET("artists")
//    Call<GenericResponse<ArtistResponse>> getAllArtists(@Query("page") int page, @Query("size") int size);
//
//    @GET("artist/{id}")
//    Call<GenericResponse<Artist>> getArtistById(@Path("id") int id);
//
//    @GET("artist/{idArtist}/songs/count")
//    Call<GenericResponse<Integer>> getSongCountByArtistId(@Path("idArtist") int idArtist);
//
//    @GET("artist/{artistId}/songs")
//    Call<GenericResponse<SongResponse>> getAllSongsByArtistId(@Path("artistId") int artistId, @Query("page") int page, @Query("size") int size);
//
//    @GET("/song/isUserLikedComment")
//    Call<GenericResponse<Boolean>> isUserLikedComment(@Query("commentId") Long commentId, @Query("userId") Long userId);
//
//    @POST("song/comment/like")
//    Call<GenericResponse<Boolean>> likeComment(@Query("commentId") Long commentId, @Query("userId") Long userId);
//
//    @GET("song/comment/countLikes")
//    Call<GenericResponse<Long>> countLikesOfComment(@Query("commentId") Long commentId);
//
//    @GET("song/{id}")
//    Call<GenericResponse<Song>> getSongById(@Path("id") Long id);
//
//    @GET("albums/artist/{id_artist}")
//    Call<GenericResponse<List<Album>>> getAlbumsByArtistId(@Path("id_artist") int id_artist);
//
//    @GET("album/{id_album}/songs")
//    Call<GenericResponse<List<Song>>> getSongsByAlbumId(@Path("id_album") int id_album);
//
//    @GET("album/{id_album}")
//    Call<GenericResponse<Album>> getAlbumById(@Path("id_album") int id_album);
//}
