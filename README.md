# 📏 QuantityMeasurementApp

A Java application built using **Test-Driven Development (TDD)** to gradually design and enhance a quantity measurement system. The project focuses on incremental progress, sound object-oriented principles, and continuous refactoring to create a flexible and maintainable domain model over time.

---

## 📖 Overview

- A modular Java project dedicated to modelling quantity measurements  
- Structured around incremental Use Cases to evolve the system design  
- Prioritizes readability, consistency, and long-term maintainability  

---

## ✅ Implemented Features

New features will be documented here as additional Use Cases are completed.

### UC1 – Feet Equality

- Provides value-based comparison for feet measurements by overriding the `equals()` method  
- Serves as the foundation for implementing comparisons between different measurement units  
### UC2 – Inches Equality

- Introduces value-based equality for inch measurements through a dedicated `Inches` class  
- Preserves independent validation for the unit while strengthening consistent equality behaviour across measurement types

### UC3 – Generic Length

- Refactors separate unit-specific classes into a single `Length` abstraction using a `LengthUnit` enum  
- Removes duplicated logic by following the DRY principle and supports equality comparison across different units  
---

## 🧰 Tech Stack

- **Java 17+** — Primary programming language  
- **Maven** — Tool for build automation and dependency management  
- **JUnit 5** — Testing framework used to support the TDD process  

---

## ▶️ Build / Run

### 🔨 Build the project

```
mvn clean install
```
-Run tests:
```
mvn test
```
### Project Structure

```
📦 QuantityMeasurementApp
│
├── 📁 src
│   ├── 📁 main
│   │   └── 📁 java
│   │       └── 📁 com
│   │           └── 📁 apps
│   │               └── 📁 quantitymeasurementapp
│   │                     └──📄LengthUnit.java
│   │                      └──📄QuantityLength.java
│   └── 📁 test             └──📄QuantityMeasurementApp.java
│       └── 📁 java
│           └── 📁 com
│               └── 📁 apps
│                   └── 📁 quantitymeasurementapp
│                       └── 📄QuantityMeasurementAppTest.java
│                        
|
|── 📘 README.md
```
## ⚙️ Development Approach

This project adopts a step-by-step **Test-Driven Development (TDD)** process:

- Test cases are created first to specify the expected behaviour  
- Production code is then implemented to make those tests pass  
- New functionality is introduced through small, incremental Use Cases  
- Previously implemented features remain stable through ongoing refactoring  
- The design gradually improves into a clean, flexible, and well-tested system  

