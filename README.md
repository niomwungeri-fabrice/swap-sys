# About
Ampersand is Africa’s first and leading integrated electric motorcycle and transport energy solution. We offer East Africa's five million taxi motorcyclists a commercial electric motorcycle that is cheaper from day one, provides  better overall user experience and requires minimal customer behaviour change.

# SwapSys
SwapSys is a system that helps Ampersand Rwanda to manage their drivers, batteries, swapping station in all-in-one system.

## Access application online
Deployed On Heroku [SwapSys](https://swap-sys.herokuapp.com/)

## Access Application locally

    ## Before Getting Started Install

- `mvn 3.x.x`
- `JDK 11`
- `PostGreSQl 13.x.x`

## Getting started

```sh
$ git clone git@github.com:niomwungeri-fabrice/swap-sys.git
$ cd swap-sys
$ mvn spring-boot:run
```
    ## After cloning repository

- `Create a .env file and copy/paste the environment variables from the sample_env.txt file that's already existent in the root project directory.`
- `Create database and replace the the credintials in .env`
## API Documentation

[![Run in Postman](https://run.pstmn.io/button.svg)](https://documenter.getpostman.com/view/11352687/UUy1fnHK)

## Available Functionalities
We arranged the functions as someone would be explaining or telling a story of how it works:
1. Register new Driver
2. Register new MotorBike
3. Register new Battery
4. Create new Station
5. Assign a battery to MotorBike
6. Assign MotorBike to the Driver
7. Swap at any Station
    ## Required EndPoints

| EndPoint                     | Functionality             |
| ---------------------------- | ------------------------- |
| `POST /v1/drivers`            | Register new Driver      |
| `POST /v1/motors`             | Register new MotorBike   |
| `POST /v1/batteries`          | Register new Battery |
| `POST /v1/stations`           | Register new Station |
| `POST /v1/batteries/assign`   | Assign a battery to MotorBike |
| `POST /v1/bikes/assign`   | Assign a battery to MotorBike |
| `POST /v1/swaps`   | Swap at any Station |

### `Note`: you can find more information
[![Run in Postman](https://run.pstmn.io/button.svg)](https://documenter.getpostman.com/view/11352687/UUy1fnHK)


## Questions
### 1. Design & Implement
 - `Design and implement a system that will track the assets in motion`
   - I have designed a simple system that takes care of the basic actions and actors involved in this scenario that includes drivers, motorbikes, batteries, stations and swapping
 - `How would you organize the data?`
   - I organized data using relational databases(postgres) and stored in data in well organized tables for easy of using while coding
 - `What technologies would you use?`
   - We can use a number of technologies any modern programming language can achieve easily including python backed django and flask. I have used Spring Boot and PostgreSQL.
 - `Where would you see key risks?`
   - These are critical information regarding the business vision towards achieving its goal, It would be risky to not get this information right or on time
### 2. Calculate
- `How would you calculate the distance travelled by each driver?`
  - We can use the odometer to calculate the distance since the last swap of the battery was made, it could be the first swap, but it can still work if the battery stated at zero(0) mileage, depending on the price set for one mile then we can calculate at swap station and bill the bikers.
- `Total energy theoretically consumed by each driver`
  - I don’t fully understand the concept of how we could achieve those, but I think with Telematics data we can get information regarding battery usage, and we could get how the battery is being used and what energy is being used.

### 3. Predict & Optimization
- `What's a good way to predict and optimize for how many batteries should be at a given station?`
    - Based on the information gathered on the swapping stations, we can leverage machine learning to understand the data and predict where it's mostly busy in terms of swapping and give that station priority.

## Project built with:

- [`Java`](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible.
- [`Spring Boot`](https://spring.io/projects/spring-boot) The Spring Framework is an application framework and inversion of control container for the Java platform. The framework's core features can be used by any Java application, but there are extensions for building web applications on top of the Java EE platform.
- [`Hibernate`](https://hibernate.org/) Hibernate ORM is an object–relational mapping tool for the Java programming language. It provides a framework for mapping an object-oriented domain model to a relational database.
- [`PostgreSql`](https://www.postgresql.org/) PostgreSQL, also known as Postgres, is a free and open-source relational database management system emphasizing extensibility and SQL compliance.

## Application Structure
    ## Packages
```sh
solar.ampersand.batterySwap.controllers # Handles HTTP Request and Response
solar.ampersand.batterySwap.dao # Handles Database related actions
solar.ampersand.batterySwap.exceptions # Handles exceptions/errors
solar.ampersand.batterySwap.generics # Handles anything generic to most packages/class e.g. timestamp
solar.ampersand.batterySwap.helpers # handles generic helper functions
solar.ampersand.batterySwap.models # handles data modeling
solar.ampersand.batterySwap.services # handles business logic of the application
```
## Reference:
- `AMPERSAND`
