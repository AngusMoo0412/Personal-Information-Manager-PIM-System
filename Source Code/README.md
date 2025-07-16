# COMP3211
A command-line-based personal information manager (PIM)

The nature of a command-line-based personal information manager (PIM), it seems like your application could be using the Command design pattern and the Object-Oriented Programming (OOP) paradigm.

## Before Use:

**Normally, you don’t need to set anything other than system rules**

Environment:
```
Java SE JDK 16.0.2
```

Referenced Additional Libraries:
```
Junit 4.10.0  
```

Junit System Rules:
```
<dependencies>
  ...
  <dependency>
    <groupId>org.junit.contrib</groupId>
    <artifactId>system-rules</artifactId>
    <version>1.19.0</version>
    <scope>test</scope>
  </dependency>
  ...
</dependencies>
```

## Project Structure:

```
.
├── lib
│   └── Junit 4.13.2
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pim
│   │   │   │   ├── Controller
│   │   │   │   │   ├── AddController.java
│   │   │   │   │   ├── DeleteController.java
│   │   │   │   │   ├── ImportController.java
│   │   │   │   │   ├── ModifyController.java
│   │   │   │   │   ├── PrintController.java
│   │   │   │   │   └── SearchController.java
│   │   │   │   ├── Model
│   │   │   │   │   ├── Contact.java
│   │   │   │   │   ├── Event.java
│   │   │   │   │   ├── Note.java
│   │   │   │   │   ├── Record.java
│   │   │   │   │   └── Task.java
│   │   │   │   └── PIM.java
│   ├── test
│   │   ├── java
│   │   │   ├── pim
│   │   │   │   └── PIMTest.java
├── .gitignore
├── pom.xml
└── README.md
```
