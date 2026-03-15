package com.app.quantitymeasurementapp.repository;

import com.app.quantitymeasurementapp.entity.QuantityMeasurementEntity;

public interface IQuantityMeasurementRepository {

	void save(QuantityMeasurementEntity entity);

	java.util.List<QuantityMeasurementEntity> getAllMeasurements();

	// Main method for testing purposes
	public static void main(String[] args) {
		System.out.println("Testing IQuantityMeasurementRepository interface");
	}
}