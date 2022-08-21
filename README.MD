**This is top level directory for _UI test scenario for NHS Costs Checker tool_.**
---
---
**Checkforhelp project framework** is in Java language using java libraries; bonigarcia (for Webdriver Manager) its help to run cross browser testing and Cucumber (for BDD styled),  hamcrust (for assertion) along with Maven as a build tool.

I used Selenium version “4.0.0” for framework and its included Positive and Negative scenario. firstly, I had gone through manual testing and then automation testing. Equivalent class partitioning technique used for age group. Age group devided into two parts 1. under age 16 and 2. above age 16

**Table of Contents Overview**

**1. How to setup**
>Git client and Maven are required to setup to run test cases

**2. How to run tests and generate reports and Where to find Reports**

>* Test will run according to feature files - which is stored under “./src/test/java/resources/GetHelp.feature” 

>* Cross browser testing will run through properties file  - which is stored under  “./src/test/java/resources/Configration.properties” and need to change browser name ether "firefox" or "chrome"

>* Outputs and reports (Json) will be produced under “./target/cucumber-reports” folder

>* For cross OS testing I included "maven.yml" file in framework for git action CI/CD pipeline. 




**How to run tests**
>* For command line execution

Open terminal and execute below commands
1.	mvn clean install  
2.	mvn test  // run test through command line

**How to Generate Report**

Open terminal and execute below commands

1.	mvn cluecumber-report:reporting

2.	Report stored location - "target/generated-report/index.html"

3. Execute the report - open "/index.html" file with chrome or firefox browser

Please find the attached report link - http://localhost:63342/CheckForHelp/target/generated-report/index.html?_ijt=9td6b6fp7b34rsrshs1gb8p4rr&_ij_reload=RELOAD_ON_SAVE


 
