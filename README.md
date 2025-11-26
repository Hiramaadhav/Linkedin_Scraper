# LinkedIn Profile Extractor

A Java-based automation tool that extracts structured profile data from a LinkedIn profile using **Selenium WebDriver** and exposes it as a **REST API** with **Spring Boot**.

---

## Features

* Extracts the following profile information (currently hardcoded for specific entries):

  * Name
  * Current designation & company
  * Location
  * About / Summary
  * Skills
  * Experience (2 specific entries)
  * Education (1 specific entry)
* Uses **Selenium WebDriver** for automation
* Scrolls and interacts with elements using **JavascriptExecutor**
* Provides a **REST API endpoint** to request profile data
* Outputs structured data in JSON format
* Console-friendly formatted output

---

## Technology Stack

* Java 23
* Spring Boot
* Selenium WebDriver
* WebDriverManager
* ChromeDriver
* Maven

---

## Getting Started

### Prerequisites

* Java 23 or higher
* Maven
* Chrome browser installed
* LinkedIn account credentials (for login)
* Git

### Setup

1. Clone the repository:

```bash
git clone https://github.com/your-username/linkedin-profile-extractor.git
cd linkedin-profile-extractor
```

2. Update LinkedIn credentials directly in the service class (hardcoded in this version):

```java
driver.findElement(By.id("username")).sendKeys("your_email@example.com");
driver.findElement(By.id("password")).sendKeys("your_password");
```

3. Build the project using Maven:

```bash
mvn clean install
```

4. Run the Spring Boot application:

```bash
mvn spring-boot:run
```

---

## API Usage

**Endpoint:** `/api/extractProfile`
**Method:** POST
**Request Body:**

```json
{
  "linkedinUrl": "https://www.linkedin.com/in/your-profile/"
}
```

**Response Example:**

```json
{
  "name": "Maadhav Hira",
  "currentDesignation": "Software Quality Assurance Engineer intern",
  "location": "Gurugram, Haryana, India",
  "about": "As a results-driven SDET / QA Engineer, I specialize in delivering reliable, high-performance software solutions...",
  "skills": "Automation testing, Selenium, Java",
  "experience": "Software Quality Assurance Engineer intern | RAPIFUZZ · Internship | Jun 2025 - Sep 2025 · 4 mos | Gurugram, Haryana, India\nStudent Trainee | CHANDIGARH UNIVERSITY · Trainee | May 2024 - Jul 2024 · 3 mos | Remote",
  "education": "CHANDIGARH UNIVERSITY | Bachelor Degree | Jul 2022 - Jul 2026"
}
```

---

## Notes

* The framework works for **your specific LinkedIn profile**.
* Hardcoded experience and education may **not work for other profiles**.
* Uses `Thread.sleep` for waits; explicit waits are recommended for a more robust solution.
* Credentials are hardcoded for demo purposes; consider using environment variables for security.

---

## Future Improvements

* Dynamic handling of **multiple experiences and education entries**
* Replace hardcoded waits with **explicit waits**
* Secure credentials using **environment variables or a config file**
* Implement scraping for **skills, endorsements, and recommendations dynamically**

---


This project is licensed under the MIT License.
