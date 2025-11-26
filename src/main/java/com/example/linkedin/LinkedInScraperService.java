package com.example.linkedin;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.stereotype.Service;
import io.github.bonigarcia.wdm.WebDriverManager;

@Service
public class LinkedInScraperService {

	public LinkedInProfile scrapeProfile(String url) {

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-blink-features=AutomationControlled");
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		LinkedInProfile profile = new LinkedInProfile();

		try {

			//LOGIN TO LINKEDIN FIRST

			driver.get("https://www.linkedin.com/login");
			Thread.sleep(3000);

			driver.findElement(By.id("username")).sendKeys("hiramaadhav@gmail.com");
			driver.findElement(By.id("password")).sendKeys("Maadhav@1608");

			driver.findElement(By.xpath("//button[@type='submit']")).click();
			Thread.sleep(5000); // wait for homepage

			driver.findElement(By.xpath("//img[contains(@class,'profile-card-profile-picture')]")).click();
			Thread.sleep(2000);

			//NOW OPEN PROFILE URL

			driver.get(url);
			Thread.sleep(5000);

			// SCRAPING STARTS

			// NAME
			profile.setName(driver.findElement(By.cssSelector("h1.inline.t-24.v-align-middle.break-words")).getText());

			// HEADLINE / DESIGNATION
			profile.setCurrentDesignation(driver.findElement(By.cssSelector("div.text-body-medium.break-words")).getText());

			// LOCATION
			profile.setLocation(driver.findElement(By.cssSelector("span.text-body-small.inline.t-black--light.break-words")).getText());

			//ABOUT
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 500);");
			Thread.sleep(2000);
			profile.setAbout(driver.findElement(By.xpath("//span[contains(@aria-hidden,'true')][contains(text(),'As a results-driven SDET / QA Engineer, I speciali')]")).getText());

			// SKILLS
			js.executeScript("window.scrollBy(0,200);");
			profile.setSkills(driver.findElement(By.xpath("//span[@aria-hidden='true' and contains(text(),'Automation testing')]")).getText());

			// EXPERIENCE
			js.executeScript("window.scrollBy(0,500);");
			String exp1 = driver.findElement(By.xpath("//span[@aria-hidden='true' and contains(text(),'Software Quality Assurance Engineer intern')]")).getText();
			String com1=driver.findElement(By.xpath("//span[@aria-hidden='true'][normalize-space()='RAPIFUZZ · Internship']")).getText();
			String dur1=driver.findElement(By.xpath("//span[@class='pvs-entity__caption-wrapper' and normalize-space()='Jun 2025 - Sep 2025 · 4 mos']")).getText();
			String loc1=driver.findElement(By.xpath("//span[@aria-hidden='true'][normalize-space()='Gurugram, Haryana, India · On-site']")).getText();

			String exp2 = driver.findElement(By.xpath("//span[@aria-hidden='true' and contains(text(),'Student Trainee')]")).getText();
			String com2=driver.findElement(By.xpath("//span[@aria-hidden='true'][normalize-space()='CHANDIGARH UNIVERSITY · Trainee']")).getText();
			String dur2=driver.findElement(By.xpath("//span[@class='pvs-entity__caption-wrapper' and normalize-space()='May 2024 - Jul 2024 · 3 mos']")).getText();
			String loc2=driver.findElement(By.xpath("//span[@aria-hidden='true'][normalize-space()='Remote']")).getText();
			String Experience1 = exp1 + " | " + com1 + " | " + dur1 + " | " + loc1;
			String Experience2 = exp2 + " | " + com2 + " | " + dur2 + " | " + loc2;

			String finalExperience= Experience1 + "\n" + Experience2;
			profile.setExperience(finalExperience);

			// EDUCATION
			js.executeScript("window.scrollBy(0,100);");
			String university = driver.findElement( By.xpath(".//span[@aria-hidden='true' and normalize-space()='CHANDIGARH UNIVERSITY']")).getText();
			String degree = driver.findElement(By.xpath(".//span[@aria-hidden='true' and contains(normalize-space(),'Bachelor')]")	).getText();
			String duration = driver.findElement(By.xpath("//span[@class='pvs-entity__caption-wrapper' and normalize-space()='Jul 2022 - Jul 2026']")).getText();
			profile.setEducation(university + " | " + degree + " | " + duration); 

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

		System.out.println(profile);
		return profile;
	}
}
