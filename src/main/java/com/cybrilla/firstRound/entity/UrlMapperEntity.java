package com.cybrilla.firstRound.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UrlMapperEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long urlId;
	
	private String shortUrl;
	private String longUrl;
	
	public String getShortUrl() {
		return shortUrl;
	}
	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
	public String getLongUrl() {
		return longUrl;
	}
	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}
	
	public UrlMapperEntity() {
		
	}
	public UrlMapperEntity( String shortUrl, String longUrl) {
		
		this.shortUrl = shortUrl;
		this.longUrl = longUrl;
	}
	
	
	
		
}
