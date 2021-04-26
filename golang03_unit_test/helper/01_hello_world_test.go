package helper

import "testing"

// running test:
// - go test ./...
// - go test ./folder_name
// - go test -v ./...
// - go test -v ./folder_name
// - go test -v -run=TestName
func TestHelloWorld(t *testing.T) {
	result := HelloWorld("Adninn")
	if result != "Hello Adnin" {
		// panic("Result must be Hello Adnin")
	}
}
