package repository

import "golang03_unit_test/entity"

type CategoryRepository interface {
	FindById(id string) *entity.Category
}
