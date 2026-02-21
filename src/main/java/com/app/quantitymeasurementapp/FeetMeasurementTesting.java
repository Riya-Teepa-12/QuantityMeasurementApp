package com.app.quantitymeasurementapp;

import java.util.Objects;

public class QuantityMeasurementApp {
	 public static void main(String[] args) {

	        Feet feet1 = new Feet(5.0);
	        Feet feet2 = new Feet(5.0);

	        boolean result = feet1.equals(feet2);

	        System.out.println("Are both measurements equal? " + result);
	    }
}
