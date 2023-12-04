package edu.remad.springconfig.models;

public class ExampleModel {

	private String title;
	private String viewExample;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getViewExample() {
		return viewExample;
	}

	public void setViewExample(String viewExample) {
		this.viewExample = viewExample;
	}

	@Override
	public String toString() {
		return "ExampleModel [title=" + title + ", viewExample=" + viewExample + "]";
	}
}
