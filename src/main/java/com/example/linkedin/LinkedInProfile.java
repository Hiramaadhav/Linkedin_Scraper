package com.example.linkedin;

public class LinkedInProfile {
	private String name;
	private String currentDesignation;
	private String location;
	private String about;
	private String skills;
	private String experience;
	private String education;

	// Getters & Setters
	public String getName() { 
		return name; 
	}

	public void setName(String name) { 
		this.name = name; 
	}

	public String getCurrentDesignation() { 
		return currentDesignation;
	}

	public void setCurrentDesignation(String currentDesignation) { 
		this.currentDesignation = currentDesignation; 
	}

	public String getLocation() { 
		return location;
	}

	public void setLocation(String location) { 
		this.location = location; 
	}

	public String getAbout() { 
		return about; 
	}

	public void setAbout(String about) { 
		this.about = about; 
	}

	public String getSkills() { 
		return skills; 
	}

	public void setSkills(String skills) { 
		this.skills = skills;
	}
	
	public String getExperience() { 
		return experience; 
	}

	public void setExperience(String experience) { 
		this.experience = experience; 
	}
	
	public String getEducation() {
		return education;
	}
	
	public void setEducation(String education) {
		this.education=education;
	}

	@Override
	public String toString() {
		return "\n==================== LINKEDIN PROFILE ====================\n" +
				" Name: " + name + "\n\n" +
				" Current Designation: " + currentDesignation + "\n\n" +
				" Location: " + location + "\n\n" +
				" About: " + about + "\n\n" +
				" Skills: " + skills + "\n\n" +
				" Experience: " + experience + "\n\n" +
				" Education: " + education + "\n\n" +
				"===========================================================\n";
	}
}