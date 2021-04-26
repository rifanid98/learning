package helper

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

// # Table Test
// - Sebelumnya kita sudah belajar tentang sub test
// - Jika diperhatikan, sebenarnya dengan sub test, kita bisa membuat test
// 	 secara dinamis
// - Dan fitur sub test ini, biasa digunaka oleh programmer Go-Lang untuk
// 	 membuat test dengan konsep table test
// - Table test yaitu dimana kita menyediakan data beruba slice yang berisi
// 	 parameter dan ekspektasi hasil dari unit test
// - Lalu slice tersebut kita iterasi menggunakan sub test

func TestTableTest(t *testing.T) {
	tests := []struct {
		name     string
		request  string
		expected string
	}{
		{
			name:     "HelloWorld(Adnin)",
			request:  "Adnin",
			expected: "Hello Adnin",
		},
		{
			name:     "HelloWorld(Rifandi)",
			request:  "Adnin",
			expected: "Hello Adnin",
		},
		{
			name:     "HelloWorld(Sutanto)",
			request:  "Adnin",
			expected: "Hello Adnin",
		},
	}

	for _, test := range tests {
		t.Run(test.name, func(t *testing.T) {
			result := HelloWorld(test.request)
			assert.Equal(t, test.expected, result)
		})
	}
}
