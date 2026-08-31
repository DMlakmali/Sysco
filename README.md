# Sysco

Automated test and utility project (Java, Maven) containing test suites built with Cucumber, Selenium, Rest-Assured, and TestNG. The project uses Lombok and SLF4J for logging.

## Requirements

- Java 11 or later (JDK)
- Apache Maven 3.6+
- A modern browser (Chrome/Firefox) for browser-based tests

## Build

Install dependencies and build the project:

mvn clean compile

## Run tests

Run the full test suite (unit + integration/Cucumber):

mvn test

Run only Cucumber tests (if configured via surefire/failsafe profiles):

mvn -Dtest=*Cucumber* test

If tests require WebDriver binaries, WebDriverManager is included to manage driver binaries automatically.

## Project layout (conventional Maven)

- src/main/java - application code
- src/test/java - test classes and step definitions
- src/test/resources - test resources (feature files, test data, config)
- pom.xml - Maven project file (contains dependencies for Cucumber, Selenium, Rest-Assured, Lombok, TestNG, etc.)

## Notes

- Lombok is used; ensure your IDE has the Lombok plugin enabled to avoid compilation/IDE issues.
- Check pom.xml for dependency versions and properties (cucumber.version, selenium.version).

## Contributing

Feel free to open issues or pull requests with improvements or fixes. Include steps to reproduce when reporting test failures.

## License

Add a LICENSE file if you want to publish this repository under an open-source license.
