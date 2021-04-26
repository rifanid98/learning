package service

import (
	"golang03_unit_test/entity"
	"golang03_unit_test/repository"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/mock"
)

var categoryRepository = &repository.CategoryRepositoryMock{Mock: mock.Mock{}}
var categoryService = CategoryService{Repository: categoryRepository}

func TestCategoryService_GetNotFound(t *testing.T) {
	// program mocknya
	categoryRepository.Mock.On("FindById", "1").Return(nil)

	result, err := categoryService.Get("1")
	assert.Nil(t, result)
	assert.NotNil(t, err)
}

func TestCategoryService_GetSuccess(t *testing.T) {
	// program mocknya
	category := entity.Category{
		Id:   "2",
		Name: "Handphone",
	}
	categoryRepository.Mock.On("FindById", "2").Return(category)

	result, err := categoryService.Get("2")
	assert.NotNil(t, result)
	assert.Nil(t, err)
	assert.Equal(t, category.Id, result.Id)
	assert.Equal(t, category.Name, result.Name)
}
