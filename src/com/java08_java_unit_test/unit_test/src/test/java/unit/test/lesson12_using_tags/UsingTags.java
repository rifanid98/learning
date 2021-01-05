package unit.test.lesson12_using_tags;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

/**
 * Menggunakan Tag
 *
 * - Class atau function unit test dapat kita tambahkan tag (tanda)
 *   dengan menggunakan annotation @Tag.
 * - Dengan menambahkan tag ke dalam unit test, kita bisa fleksibel
 *   ketika menjalankan unit test, bisa memilih tag mana yang mau
 *   diinclude atau diexclude.
 * - Jika kita menambahkan tag di class unit test, secara otomatis
 *   semua function unit test di dalam class tersebut akan memiliki
 *   tag tersebut.
 */

/* command: mvn test -Dgroups=tag1,tag2,tagn */
@Tags({
    @Tag("using-tags")
})
public class UsingTags {

    @Test
    public void tags1() {
        //
    }

    @Test
    public void tags2() {
        //
    }
}
