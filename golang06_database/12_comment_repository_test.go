package golang06_database

import (
	"context"
	"fmt"
	"golang06_database/repository_pattern/entity"
	"golang06_database/repository_pattern/repository"
	"testing"
)

func TestCommentInsert(t *testing.T) {
	ctx := context.Background()
	comment := entity.Comment{
		Comment: "Ini Komentar",
	}
	commentRepository := repository.CommentRepository(GetConnection())
	res, err := commentRepository.Insert(ctx, comment)
	if err != nil {
		panic(err)
	}
	fmt.Println(res)
}

func TestCommentFindById(t *testing.T) {
	ctx := context.Background()
	comment := entity.Comment{
		Comment: "Ini Komentar",
	}
	commentRepository := repository.CommentRepository(GetConnection())
	comment, err := commentRepository.FindById(ctx, 56)
	if err != nil {
		panic(err)
	}
	fmt.Println(comment)
}

func TestCommentFindAll(t *testing.T) {
	ctx := context.Background()
	commentRepository := repository.CommentRepository(GetConnection())
	comments, err := commentRepository.FindAll(ctx)
	if err != nil {
		panic(err)
	}
	for _, comment := range comments {
		fmt.Println(comment)
	}
}
