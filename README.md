
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

### UC11 – Volume Measurement Support (Litre, Millilitre, Gallon)

- Introduces a new measurement category for volume with units **Litre (L), Millilitre (mL), and Gallon (gal)** using litre as the base unit  
- Supports equality comparison, unit conversion, and addition operations through the existing generic `Quantity<U extends IMeasurable>` class  
- Validates that volume measurements in different units are equivalent when representing the same quantity (e.g., 1 L = 1000 mL ≈ 0.264172 gal)  
- Maintains strict category isolation — volume measurements are independent and non-comparable with length or weight measurements  
- Requires only a new `VolumeUnit` enum implementing `IMeasurable`; no changes to core classes or application logic  
- Demonstrates seamless scalability of the UC10 architecture to additional measurement domains  
- Preserves immutability, type safety, and consistent behavior across all supported categories 

### UC12 – Subtraction and Division Operations on Quantity Measurements

- Extends the generic `Quantity<U extends IMeasurable>` class with **subtraction** and **division** operations for comprehensive arithmetic support  
- Subtraction computes the difference between two quantities of the same category and returns a new immutable `Quantity<U>` result  
- Division computes the ratio between two quantities and returns a **dimensionless scalar (double)** value  
- Supports cross-unit arithmetic within the same category through automatic conversion to a common base unit  
- Allows implicit result unit (first operand’s unit) or explicit target unit specification for subtraction  
- Preserves strict category isolation — operations across different domains (e.g., length vs weight) are prevented  
- Maintains immutability, validation, and consistent error handling (null checks, finite values, division by zero)  

<<<<<<< HEAD
- Demonstrates scalability of the generic design by adding new operations without modifying existing architecture  

UC13: Add temperature measurement support with selective arithmetic and IMeasurable refactoring
=======
- Demonstrates scalability of the generic design by adding new operations without modifying existing architecture

### UC13: Add temperature measurement support with selective arithmetic and IMeasurable refactoring
>>>>>>> 6d8edcc73aac2872288adb44d2ca27ca67aaddde

- Introduced TemperatureUnit (Celsius, Fahrenheit, Kelvin) with accurate non-linear conversions  
- Refactored IMeasurable to support optional arithmetic via default methods  
- Added SupportsArithmetic functional interface with lambda-based capability checks  
- Disabled arithmetic operations for temperature (add, subtract, divide) with clear exceptions  
- Updated Quantity<U> to validate operation support before execution  
- Preserved full arithmetic support for length, weight, and volume units  
- Ensured strict cross-category type safety and backward compatibility (UC1–UC13)  

### 🌡️ UC14 – Temperature Measurement with Selective Arithmetic Support

- Adds **temperature units (Celsius, Fahrenheit, Kelvin)** with equality and conversion support only  
- Refactors `IMeasurable` to make arithmetic operations optional via default methods  
- Uses precise non-linear formulas for accurate cross-unit conversion  
- Disables arithmetic on absolute temperatures (throws `UnsupportedOperationException`)  
- Ensures type safety and keeps temperature separate from other measurement categories

<<<<<<< HEAD
- Added demonstration cases and comprehensive tests for temperature equality, conversion, and error handling  
=======
- Added demonstration cases and comprehensive tests for temperature equality, conversion, and error handling   
>>>>>>> 6d8edcc73aac2872288adb44d2ca27ca67aaddde
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
│   │               └── 📁 quantitymeasurement
│   │                   ├── 📄 IMeasurable.java
│   │                   ├── 📄 LengthUnit.java
│   │                   ├── 📄 WeightUnit.java
│   │                   ├── 📄 VolumeUnit.java
│   │                   ├── 📄 Quantity.java
│   │                   └── 📄 VolumeUnit.java
│   │                   └──📄 QuantityMeasurementApp.java
│   └── 📁 test
│       └── 📁 java
│           └── 📁 com
│               └── 📁 apps
│                   └── 📁 QuantityMeasurementApp
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

