package dev.deepak.movies_ms.pojo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DocumentReference;

public class MovieDTO {

    private  String imdbId;

    private String title;

    private String releaseDate;

    private String trailerLink;

    private String poster;

    private List<String> genres;

    private  List<String> backDrops;

    @DocumentReference
    private List<Review> reviewIds;

	

    
	public MovieDTO(String imdbId, String title, String releaseDate, String trailerLink, String poster,
			List<String> genres, List<String> backDrops, List<Review> reviewIds) {
		super();
		this.imdbId = imdbId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.trailerLink = trailerLink;
		this.poster = poster;
		this.genres = genres;
		this.backDrops = backDrops;
		this.reviewIds = reviewIds;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getTrailerLink() {
		return trailerLink;
	}

	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getBackdrops() {
		return backDrops;
	}

	public void setBackdrops(List<String> backdrops) {
		this.backDrops = backdrops;
	}

	public List<Review> getReviewIds() {
		return reviewIds;
	}

	public void setReviewIds(List<Review> reviewIds) {
		this.reviewIds = reviewIds;
	}
}
