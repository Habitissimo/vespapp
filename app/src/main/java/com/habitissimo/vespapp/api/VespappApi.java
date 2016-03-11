package com.habitissimo.vespapp.api;

import java.io.File;
import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface VespappApi {
    @GET("/sightings") void getSightings(Callback</* TODO */Void> callback);

    @GET("/sightings" + "/{sightingId}") void getSightingById(@Path("sightingId") String sightingId, Callback</* TODO */Void> callback);

    @POST("/sightings") void createSighting(@Body /* TODO */ Void sighting, Callback</* TODO */Void> callback);

    /**
     * @see VespappApiHelper#buildPhotoApiParameter(File)
     */
    @Multipart @POST("/sightings/{sightingId}/photos")
    void addPhoto(@Path("sightingId") String sightingId, @Part("file\"; filename=\"photo.png\" ") RequestBody photo);

    @GET("/sightings/{sightingId}/photos") void getPhotos(@Path("sightingId") String sightingId, Callback</* TODO */Void> callback);

    @GET("/sightings/{sightingId}/questions")
    void getQuestions(@Path("sightingId") String sightingId, Callback</* TODO*/List<Void>> callback);

    @GET("/sightings/{sightingId}/questions/{questionId}")
    void getQuestionById(@Path("sightingId") String sightingId, @Path("questionId") String questionId, Callback</* TODO */Void> callback);

    @PATCH("/sightings/{sightingId}/questions/{questionId}")
    void updateQuestion(@Path("sightingId") String sightingId, @Path("questionId") String questionId, @Body /* TODO */ Void question,
                        Callback</* TODO */Void> callback);

    @GET("/sightings/{sightingId}/expert_comments")
    void getExpertComments(@Path("sightingId") String sightingId, Callback</* TODO */Void> callback);

    @POST("/sightings/{sightingId}/expert_comments")
    void createExpertComment(@Path("sightingId") String sightingId, @Body /* TODO */ Void comment, Callback</* TODO */Void> callback);

    @GET("/sightings/{sightingId}/expert_comments/{commentId}")
    void getExpertCommentById(@Path("sightingId") String sightingId, @Path("commentId") String commentId, Callback</* TODO */Void> callback);

    @GET("/locations") void getLocations(Callback</* TODO */Void> callback);
}
