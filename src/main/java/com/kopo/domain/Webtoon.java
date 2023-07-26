package com.kopo.domain;
//퍼시스턴스계층..?
import org.springframework.web.multipart.MultipartFile;
public class Webtoon {

		private String name;
		private String imgPath;
		private String ranking;
		private String publisher;
		private String author;
		private String description;
		private int hits;
		private String releaseDay;
		private String condition;
		private String genre;
		private MultipartFile imgFile;
		
		
		
		
		// 기본 생성자
		public Webtoon() { 
			super();
		
		}
	
		//일반 생성자
		public Webtoon(String name, String imgPath) {
			super();
			
			this.name = name;
			this.imgPath = imgPath;
	
		}
		//Getter Setter
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public String getImgPath() {
			return imgPath;
		}
	
		public void setImgPath(String imgPath) {
			this.imgPath = imgPath;
		}
		public String getRanking() {
			return ranking;
		}
		public void setRanking(String ranking) {
			this.ranking = ranking;
		}
		
		public String getPublisher() {
			return publisher;
		}

		public void setPublisher(String publisher) {
			this.publisher = publisher;
		}

		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getHits() {
			return hits;
		}
		public void setHits(int hits) {
			this.hits = hits;
		}
		public String getReleaseDay() {
			return releaseDay;
		}
		public void setReleaseDay(String releaseDay) {
			this.releaseDay = releaseDay;
		}
		public String getCondition() {
			return condition;
		}
		public void setCondition(String condition) {
			this.condition = condition;
		}
	
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		
		public MultipartFile getImgFile() {
			return imgFile;
		}
		public void setImgFile(MultipartFile imgFile) {
			this.imgFile = imgFile;
		}
}
