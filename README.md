
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
### UC4 – Extended Unit Support

- Introduces **Yards** and **Centimeters** to the `LengthUnit` enum along with their respective conversion values  
- Showcases the scalability of the generic design by allowing smooth cross-unit comparisons without adding new classes
- 
### UC5 – Unit-to-Unit Conversion

- Adds explicit conversion capabilities between supported length units using centralized conversion factors defined in the enum  
- Enhances the `Length` API to transform measurements across units while maintaining mathematical accuracy and precision

### UC6 – Length Addition Operation

- Implements addition of length measurements with automatic unit conversion and normalization  
- Produces a new immutable `Length` instance in the unit of the first operand while ensuring mathematical correctness  

 ### UC7 – Addition with Target Unit Specification

- Extends length addition by allowing the caller to explicitly choose the unit of the result  
- Performs automatic normalization and conversion of operands, returning a new immutable `Length` instance in the specified target unit while preserving mathematical accuracy 

###  UC8 – Standalone Unit Enum Refactoring

- Refactors the design by extracting `LengthUnit` into a standalone enum responsible for all unit conversion logic  
- Simplifies the `Length` class to delegate conversions to the unit, improving cohesion, reducing coupling, and enabling scalable support for additional measurement categories while preserving existing functionality  

###  UC9 – Weight Measurement Support

- Introduces a new measurement category for weight with units **Kilogram, Gram, and Pound**, supporting equality checks, unit conversion, and addition operations  
- Mirrors the design patterns used for length measurements, ensuring category type safety, immutability, and scalable architecture while keeping weight and length as independent, non-comparable domains  

### UC10 – Generic Quantity with Interface-Based Multi-Category Support

- Introduces a single, type-safe **generic Quantity<U extends IMeasurable> class** that supports all measurement categories through a common unit interface  
- Eliminates duplicate category-specific Quantity classes and unit enum logic, ensuring DRY compliance and centralized implementation  
- Supports equality checks, unit conversion, and addition operations uniformly across categories (length, weight, etc.)  
- Maintains strict category type safety — quantities from different domains remain non-comparable at compile-time and runtime  
- Simplifies application design by replacing multiple classes and methods with a unified, reusable architecture  
- Enables seamless addition of new measurement categories (volume, temperature, time, etc.) by implementing the interface only  
- Ensures immutability, scalability, and adherence to SOLID principles, especially Single Responsibility and Open-Closed Principles  

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
│   │           └── 📁 app
│   │               └── 📁 quantitymeasurementapp
│   │                   ├── 📄 IMeasurable.java
│   │                   ├── 📄 Quantity.java
│   │                   ├── 📄 LengthUnit.java
│   │                   ├── 📄 WeightUnit.java
│   │                   └── 📄 QuantityMeasurementApp.java
│   │                   
│   │
│   └── 📁 test
│       └── 📁 java
│           └── 📁 com
│               └── 📁 app
│                   └── 📁 quantitymeasurementapp
│                       └── 📄 QuantityMeasurementAppTest.java
│
└── 📘 README.md
```
## ⚙️ Development Approach

This project adopts a step-by-step **Test-Driven Development (TDD)** process:

- Test cases are created first to specify the expected behaviour  
- Production code is then implemented to make those tests pass  
- New functionality is introduced through small, incremental Use Cases  
- Previously implemented features remain stable through ongoing refactoring  
- The design gradually improves into a clean, flexible, and well-tested system  

