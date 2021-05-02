package repository

import (
	"context"
	"database/sql"
	"errors"
	"golang06_database/repository_pattern/entity"
	"strconv"
)

// # Repository Pattern
// - Dalam buku Domain-Driven Design, Eric Evans menjelaskan bahwa
// 	 “repository is a mechanism for encapsulating storage, retrieval,
// 	 and search behavior, which emulates a collection of objects”
// - Pattern Repository ini biasanya digunakan sebagai jembatan antar
// 	 business logic aplikasi kita dengan semua perintah SQL ke database
// - Jadi semua perintah SQL akan ditulis di Repository, sedangkan business
// 	 logic kode program kita hanya cukup menggunakan Repository tersebut

// # Entiti/Model
// - Dalam pemrograman berorientasi object, biasanya sebuah tabel di database
// 	 akan selalu dibuat representasinya sebagai class Entity atau Model,
// 	 namun di Golang, karena tidak mengenal Class, jadi kita akan
// 	 representasikan data dalam bentuk Struct
// - Ini bisa mempermudah ketika membuat kode program
// - Misal ketika kita query ke Repository, dibanding mengembalikan array,
// 	 alangkah baiknya Repository melakukan konversi terlebih dahulu ke struct
// 	 Entity / Model, sehingga kita tinggal menggunakan objectnya saja

// Interface
type ICommentRepository interface {
	Insert(ctx context.Context, comment entity.Comment) (entity.Comment, error)
	FindById(ctx context.Context, id int32) (entity.Comment, error)
	FindAll(ctx context.Context) ([]entity.Comment, error)
}

// Implements CommentRepository Interface
type commentRepository struct {
	DB *sql.DB
}

func CommentRepository(db *sql.DB) ICommentRepository {
	return &commentRepository{DB: db}
}

// Implements CommentRepository Interface's Method
func (repo *commentRepository) Insert(ctx context.Context, comment entity.Comment) (entity.Comment, error) {
	query := "INSERT INTO comments(comment) VALUES(?)"
	res, err := repo.DB.ExecContext(ctx, query, comment.Comment)
	if err != nil {
		panic(err)
	}
	id, err := res.LastInsertId()
	if err != nil {
		panic(err)
	}
	comment.Id = int32(id)
	return comment, nil
}

func (repo *commentRepository) FindById(ctx context.Context, id int32) (entity.Comment, error) {
	query := "SELECT id, comment FROM comments WHERE id = ? LIMIT 1"
	rows, err := repo.DB.QueryContext(ctx, query, id)
	if err != nil {
		panic(err)
	}
	defer rows.Close()
	comment := entity.Comment{}
	if rows.Next() {
		rows.Scan(&comment.Id, &comment.Comment)
		return comment, nil
	} else {
		return comment, errors.New("Id " + strconv.Itoa(int(id)) + " Not Found")
	}
}

func (repo *commentRepository) FindAll(ctx context.Context) ([]entity.Comment, error) {
	query := "SELECT id, comment FROM comments"
	rows, err := repo.DB.QueryContext(ctx, query)
	if err != nil {
		panic(err)
	}
	defer rows.Close()
	var comments []entity.Comment
	for rows.Next() {
		comment := entity.Comment{}
		rows.Scan(&comment.Id, &comment.Comment)
		comments = append(comments, comment)
	}
	return comments, nil
}
