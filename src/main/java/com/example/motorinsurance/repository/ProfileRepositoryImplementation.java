package com.example.motorinsurance.repository;

public class ProfileRepositoryImplementation implements ProfileRepositoryCustom {
    private String collectionName = "myCollection";

    @Override
    public String getCollectionName() {
        return collectionName;
    }

    @Override
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }
}
