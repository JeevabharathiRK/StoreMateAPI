drop database if exists storematedb;
-- Create the database (if it doesn't exist)
CREATE DATABASE IF NOT EXISTS storematedb;

-- Use the database
USE storematedb;

-- Drop tables if they exist (in correct dependency order)
DROP TABLE IF EXISTS FollowUps;
DROP TABLE IF EXISTS Leads;
DROP TABLE IF EXISTS OrderItems;
DROP TABLE IF EXISTS CustomerOrders;
DROP TABLE IF EXISTS Customers;
DROP TABLE IF EXISTS Products;
DROP TABLE IF EXISTS Categories;
DROP TABLE IF EXISTS Suppliers;
DROP TABLE IF EXISTS Barcode;

-- Create the Suppliers table
CREATE TABLE Suppliers (
    SupplierID INT AUTO_INCREMENT PRIMARY KEY,
    SupplierName VARCHAR(255) NOT NULL,
    SupplierContact VARCHAR(255),
    SupplierAddress VARCHAR(255),
    SupplierEmail VARCHAR(255)
);

-- Create the Categories table
CREATE TABLE Categories (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(255) NOT NULL UNIQUE
);

-- Create the Products table
CREATE TABLE Products (
    ProductID INT AUTO_INCREMENT PRIMARY KEY,
    ProductName VARCHAR(255) NOT NULL,
    ProductDescription TEXT,
    CategoryID INT NOT NULL,
    SupplierID INT NOT NULL,
    ProductPrice DECIMAL(10, 2) NOT NULL,
    ProductStock INT NOT NULL,
    LastStockAt DATE NOT NULL,
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID) ON DELETE RESTRICT,
    FOREIGN KEY (SupplierID) REFERENCES Suppliers(SupplierID) ON DELETE RESTRICT
);

-- Create the Barcode table
CREATE TABLE Barcodes (
	BarcodeID INT AUTO_INCREMENT PRIMARY KEY,
    Barcode BIGINT NOT NULL,
    ProductID INT NOT NULL,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID)  ON DELETE CASCADE
);

-- Create the Customers table
CREATE TABLE Customers (
    CustomerID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerFirstName VARCHAR(255) NOT NULL,
    CustomerLastName VARCHAR(255) NOT NULL,
    CustomerContact VARCHAR(255),
    CustomerEmail VARCHAR(255) UNIQUE,
    CustomerAddress VARCHAR(255),
    CustomerDOB DATE
);

-- Create the CustomerOrders table
CREATE TABLE CustomerOrders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    OrderDate DATETIME DEFAULT CURRENT_TIMESTAMP,
    OrderTotal DECIMAL(10, 2) NOT NULL,
    OrderStatus VARCHAR(50) DEFAULT 'Pending',
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID) ON DELETE CASCADE
);

-- Create the OrderItems table
CREATE TABLE OrderItems (
    OrderItemID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT NOT NULL,
    ProductID INT NULL,
    Something VARCHAR(255) NULL,
    Quantity INT NOT NULL,
    Price DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES CustomerOrders(OrderID) ON DELETE CASCADE,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID) ON DELETE RESTRICT
);

-- Create the Leads table
CREATE TABLE Leads (
    LeadID INT AUTO_INCREMENT PRIMARY KEY,
    LeadName VARCHAR(255),
    Contact VARCHAR(255),
    LeadFrom VARCHAR(100),
    Email VARCHAR(255),
    Status VARCHAR(50),
    CreatedAt DATETIME DEFAULT CURRENT_TIMESTAMP
);

-- Create the FollowUps table
CREATE TABLE FollowUps (
    FollowUpID INT AUTO_INCREMENT PRIMARY KEY,
    CustomerID INT NOT NULL,
    FollowUpDate DATETIME NOT NULL,
    Purpose TEXT,
    Status VARCHAR(50),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID) ON DELETE CASCADE
);