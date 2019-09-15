package web.api.model;

public class Restaurant {

	private String name;
	private String rating;
	private String userRatingsTotal;
	private String vicinity;
	
	public Restaurant() {
		super();
	}

	public Restaurant(String name, String rating, String userRatingsTotal, String vicinity) {
		super();
		this.name = name;
		this.rating = rating;
		this.userRatingsTotal = userRatingsTotal;
		this.vicinity = vicinity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getUserRatingsTotal() {
		return userRatingsTotal;
	}

	public void setUserRatingsTotal(String userRatingsTotal) {
		this.userRatingsTotal = userRatingsTotal;
	}

	public String getVicinity() {
		return vicinity;
	}

	public void setVicinity(String vicinity) {
		this.vicinity = vicinity;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", rating=" + rating + ", userRatingsTotal=" + userRatingsTotal
				+ ", vicinity=" + vicinity + "]";
	}
		
}
