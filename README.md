# 📏 QuantityMeasurementApp

> A Java-based **Spring Boot REST application** built using Test-Driven Development (TDD) to iteratively design and enhance a multi-category quantity measurement system. The project focuses on step-by-step development, strong object-oriented principles, and continuous refactoring to create a scalable, flexible, and maintainable domain model. :contentReference[oaicite:0]{index=0}

### 📖 Overview

- A modular **Spring Boot Java application** designed to handle measurements across multiple domains (length, weight, volume, and temperature) with complete unit conversion and controlled arithmetic operations.
- Structured around progressive Use Cases that evolve from simple equality checks into a **scalable, capability-driven, layered (N-Tier) architecture**.
- Prioritizes clarity, consistency, and long-term maintainability through **Test-Driven Development (TDD)** and ongoing refactoring.

### ✅ Implemented Features

> _New features are introduced incrementally as Use Cases are implemented._

- 🧩 **UC1 – Feet Equality :**
  - Provides value-based comparison for feet using an overridden `equals()` method.
  - Establishes the base concept of equality for measurement objects.

- 🧩 **UC2 – Inches Equality :**
  - Expands equality comparison to inches through a dedicated `Inches` class.
  - Ensures independent validation while maintaining consistent comparison logic.

- 🧩 **UC3 – Generic Length :**
  - Replaces unit-specific implementations with a unified `Length` abstraction using a `LengthUnit` enum.
  - Removes duplicated logic (DRY) and enables comparison across different units.

- 🧩 **UC4 – Extended Unit Support :**
  - Adds **Yards** and **Centimeters** with proper conversion definitions.
  - Demonstrates extensibility without requiring additional classes.

- 🧩 **UC5 – Unit-to-Unit Conversion :**
  - Introduces conversion operations between supported length units using centralized enum logic.
  - Ensures precision and mathematical correctness across conversions.

- 🧩 **UC6 – Length Addition Operation :**
  - Enables addition between length values with automatic normalization of units.
  - Returns an immutable `Length` result in the unit of the first operand.

- 🧩 **UC7 – Addition with Target Unit Specification :**
  - Allows specifying the desired output unit independently of input units.
  - Improves flexibility while maintaining immutability and accuracy.

- 🧩 **UC8 – Standalone Unit Refactor :**
  - Extracts `LengthUnit` into a dedicated enum responsible for all conversion logic.
  - Enhances separation of concerns and reduces coupling.

- 🧩 **UC9 – Weight Measurement Support :**
  - Introduces weight handling via `Weight` and `WeightUnit` (kg, g, pounds).
  - Supports equality, conversion, and arithmetic while remaining isolated from length.

- 🧩 **UC10 – Generic Quantity Architecture :**
  - Implements a generic `Quantity<U extends IMeasurable>` abstraction.
  - Consolidates logic for equality, conversion, and arithmetic across categories.

- 🧩 **UC11 – Volume Measurement Support :**
  - Adds volume units (Litre, Millilitre, Gallon) using the generic architecture.
  - Confirms that new categories integrate without altering existing logic.

- 🧩 **UC12 – Subtraction and Division Operations :**
  - Adds subtraction with automatic unit normalization.
  - Introduces division producing a dimensionless result for comparison.

- 🧩 **UC13 – Centralized Arithmetic Logic (DRY Refactor) :**
  - Centralizes arithmetic operations into a shared helper.
  - Eliminates duplicate logic and improves maintainability.

- 🧩 **UC14 – Temperature Measurement (Selective Arithmetic Support) :**
  - Adds temperature handling (Celsius, Fahrenheit, Kelvin) within the generic model.
  - Supports equality and conversion using non-linear formulas.
  - Restricts unsupported operations via validation and exceptions.
  - Demonstrates capability-based design and interface segregation.

- 🧩 **UC15 – N-Tier Architecture Refactoring :**
  - Transforms the application into a structured **N-Tier architecture**.
  - Introduces layers: Controller, Service, Repository, Model, Entity, DTO, Interfaces, Units.
  - Moves business logic into the Service layer and interaction handling into Controller.
  - Adds a cache-based Repository layer for storing operations.
  - Standardizes data flow using DTO, Model, and Entity layers.
  - Improves modularity, scalability, and testability.

- 🧩 **UC16 – Database Integration with JDBC for Quantity Measurement Persistence :**
  - Extends architecture with persistent storage using JDBC.
  - Replaces in-memory storage with a database-backed repository.
  - Introduces configuration management and connection pooling utilities.
  - Adds repository enhancements and structured exception handling.
  - Uses prepared statements for security and logging frameworks for monitoring.
  - Supports H2 (default) with optional MySQL/PostgreSQL.
  - Includes integration and unit testing with enterprise-grade practices.

- 🧩 **UC17 – Spring Boot Integration with REST Services and JPA Persistence :** ← NEW (UC17)
  - Migrates the system to a **Spring Boot REST architecture** while preserving existing domain logic.
  - Introduces `QuantityMeasurementApplication` as the main entry point.
  - Replaces manual JDBC layers with **Spring Data JPA (`JpaRepository`)**.
  - Adds derived query methods and custom queries in the repository.
  - Refactors package structure for better domain clarity.
  - Enhances `QuantityDTO` with validation annotations.
  - Introduces `QuantityMeasurementDTO` and `QuantityInputDTO` for API communication.
  - Adds `OperationType` enum for type-safe operations.
  - Exposes REST endpoints for operations and history tracking.
  - Integrates Swagger/OpenAPI for API documentation.
  - Implements centralized exception handling using `GlobalExceptionHandler`.
  - Introduces `SecurityConfig` (currently permissive).
  - Uses environment-based configurations with profiles.
  - Replaces manual connection pooling with HikariCP.
  - Uses JPA auto-DDL instead of manual schema scripts.
  - Adds Spring Boot Actuator for monitoring.
  - Includes comprehensive testing (controller, service, repository, integration).
  - Demonstrates transition to modern enterprise architecture.


-
🧩 **UC18 – Google Authentication and User Management** : ← NEW (UC18)

- Introduces **secure authentication and user management** using modern industry standards.
- Integrates **OAuth 2.0 with Google Sign-In** for seamless and trusted user authentication.
- Implements **JWT (JSON Web Token)** based authentication for stateless session management.
- Configures **Spring Security** for securing REST APIs and controlling access.
- Adds login and registration flows using external identity providers (Google).
- Generates and validates JWT tokens for authenticated users.
- Secures endpoints using **role-based authorization (RBAC)**.
- Introduces **User Entity, Repository, and Service layers** for managing user data.
- Stores authenticated user details (email, name, provider) in the database.
- Handles authentication success and failure scenarios with proper responses.
- Implements **custom authentication filters** for JWT validation.
- Ensures password-less authentication flow using OAuth providers.
- Supports token expiration, refresh strategy, and secure token handling.
- Enables **cross-origin authentication support (CORS configuration)**.
- Maintains separation of concerns between security, business logic, and controllers.
- Provides scalable authentication design for future providers (Facebook, GitHub, etc.).
- Includes unit and integration testing for authentication flows.

-
  🧩 **UC21- Quantity Measurement Microservices System**

## 📏 TDD | Microservices | Clean Architecture

---

## 🧠 Project Overview

The **Quantity Measurement Application** handles:

- Unit comparison  
- Unit conversion  
- Arithmetic operations  

Built using:

- Test-Driven Development (TDD)  
- Microservices Architecture  
- Clean Code Practices  
- JWT Authentication  

---

## 🧠 Tech Stack

| Layer            | Technology              |
|------------------|------------------------|
| Backend          | Spring Boot            |
| Microservices    | Spring Cloud           |
| Service Registry | Eureka Server          |
| API Gateway      | Spring Cloud Gateway   |
| Security         | JWT                    |
| Communication    | REST APIs              |

---


---

## ⚙️ Services & Ports

| Service        | Port | Role                      |
|----------------|------|---------------------------|
| Eureka Server  | 8761 | Service Registry          |
| API Gateway    | 8081 | Routing + Auth Check      |
| Auth Server    | 8083 | JWT Authentication        |
| QMA Service    | 8082 | Business Logic            |

---

## 🔄 Flow

Client → API Gateway → Service → Response
---

## 🚀 Run Order

```
cd eureka-server && mvn spring-boot:run
cd api-gateway && mvn spring-boot:run
cd auth-server && mvn spring-boot:run
cd qma-service && mvn spring-boot:run
```

### 🔐 Key Concepts Covered

- **Spring Security Core**
- **JWT (JSON Web Token) Authentication**
- **OAuth 2.0 (Google Authentication)**
- **Authentication & Authorization**
- **Role-Based Access Control (RBAC)**
- **Stateless Security Architecture**
- **Security Filters & Configuration**
- **User Management & Persistence**
- **Token Lifecycle Management**
- **CORS & API Security Best Practices**

### 🧰 Tech Stack

- **Java 17+** — primary programming language  
- **Maven** — build and dependency management  

#### 🚀 Backend Framework
- **Spring Boot 3.2.2** — core framework with auto-configuration  
- **Spring Web** — REST APIs  
- **Spring Data JPA** — ORM abstraction  
- **Spring Security** — authentication and security  
- **Spring Validation** — request validation  
- **Spring Boot Actuator** — monitoring  

#### 📄 API Documentation
- **Swagger / OpenAPI** — interactive API documentation  

#### 🗄️ Database
- **H2** — development/testing  
- **MySQL** — production support  

#### ⚙️ Utilities
- **Lombok** — reduces boilerplate  
- **HikariCP** — connection pooling  

#### 🧪 Testing
- **JUnit 5, Mockito, MockMvc** — testing framework  
- **Spring Security Test** — security testing  

---

### ▶️ Build / Run

```bash
mvn clean compile
mvn spring-boot:run
mvn clean test
mvn test -Dtest=QuantityMeasurementServiceIntegrationTest
mvn clean package
java -jar target/quantity-measurement-app-0.0.1-SNAPSHOT.jar
```
