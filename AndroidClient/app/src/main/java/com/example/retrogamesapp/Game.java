package com.example.retrogamesapp;

import com.google.gson.annotations.SerializedName;

public class Game {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("platform")
    private String platform;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("description")
    private String description;

    @SerializedName("image")
    private String image;

    @SerializedName("youtube_url")
    private String youtubeUrl;

    public Game() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }
}
