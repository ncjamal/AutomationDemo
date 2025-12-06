Selenium Test Automation Framework (Java + TestNG + Maven + POM + data driven testing)

This repository contains a Page Object Model (POM) based Test Automation Framework built using
Java, Selenium WebDriver, TestNG, and Maven with data driven technique.
It supports data-driven testing, cross-browser execution, and provides a clean, scalable structure.

Features
Page Object Model (POM) structure
Cross-browser execution (Chrome, Edge, Firefox)
Maven-based build & dependency management
TestNG for test execution
Data-driven testing (Excel sheet)
Reusable utility classes
Configurable via config.properties (taking URL and data sheet path)
Driver factory utility method used to enable cross browser
Git-friendly project structure

Project Structure
Project Root
│
├── src/test/java
│   ├── testcases        # All test classes
│   ├── pages            # Page Object classes
│   ├── utility          # BrowserFactory, Excel utilities, Helpers
│   └── base             # BaseTest class (setup + teardown)
│
├── src/test/resources
│   ├── config.properties # Environment / browser settings
│   └── testdata.xlsx     # Test data file (if applicable)
│
├── testng.xml            # Master TestNG suite
├── pom.xml               # Maven build file
└── README.md             # Project documentation

Tech Stack
Component	                        Technology
Programming Language	              Java
Test Framework	                    TestNG
Automation Tool	                    Selenium WebDriver
Build Tool	                        Maven
Design Pattern	                    Page Object Model (POM)
Data Handling	                      Excel (Apache POI), Properties file
Reporting	                          TestNG default

How to Run Tests
1️⃣ Run using Maven
Run all tests: mvn clean test

2️⃣ Run with specific browser
Pass browser value from command line: mvn clean test -Dbrowser=chrome
Supported values: chrome, edge, firefox

3️⃣ Run using TestNG XML
Update browser parameter inside testng.xml: <parameter name="browser" value="chrome"/>
Execute: mvn clean test -DsuiteXmlFile=testng.xml

Data-Driven Testing
Data is read from: config.properties and Excel file (testdata.xlsx) using Apache POI

Utility classes in utility package handle reading data.

🔧 How to Update Code & Push to GitHub
Add all new changes: git add .

Commit: git commit -m "Updated automation framework"

Push:
git push

Contributing
Create a new feature branch: git checkout -b feature/new-module

Work on your changes
Push and create Pull Request (PR)

📄 License
This project is for e-commerce website and automation practice purposes.
