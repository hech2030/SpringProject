package com.Main.Request;

public class FindSubCategoryRequest {
    public FindSubCategoryRequest(long value) {
        this.categoryId = value;
    }

    public long categoryId;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public FindSubCategoryRequest(){}
}
