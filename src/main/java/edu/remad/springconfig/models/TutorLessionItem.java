package edu.remad.springconfig.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class TutorLessionItem {

	private String title;
	private String description;
	private LocalDateTime lessionDate = LocalDateTime.now();

	public TutorLessionItem() {
		super();
	}

	public TutorLessionItem(String title, String description, LocalDateTime lessionDate) {
		super();
		this.title = title;
		this.description = description;
		this.lessionDate = lessionDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getLessionDate() {
		return lessionDate;
	}

	public void setLessionDate(LocalDateTime lessionDate) {
		this.lessionDate = lessionDate;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(description, lessionDate, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TutorLessionItem other = (TutorLessionItem) obj;
		return Objects.equals(description, other.description) && Objects.equals(lessionDate, other.lessionDate)
				&& Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "TutorLessionItem [title=" + title + ", description=" + description + ", lessionDate=" + lessionDate
				+ "]";
	}
}
