package rest;

public class Job {
	private String title;
	private int minSalary;

	public Job() {
		super();
	}

	public Job(String title, int minSalary) {
		super();
		this.title = title;
		this.minSalary = minSalary;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

}
