# Plivo and OpenWeather Automation

## Prerequisites
- Java 11+
- Maven
- Plivo and OpenWeather API credentials

## Setup
1. Clone the repository.
2. Update `pom.xml` with necessary dependencies.
3. Add your API keys and tokens in `PlivoAutomation.java` and `OpenWeatherAutomation.java`.
4. Place CSV files (`customer_message.csv`, `city.csv`) in the `data` folder.

## Running Tests
To run the tests, navigate to the project directory and execute:
```bash
mvn clean test
