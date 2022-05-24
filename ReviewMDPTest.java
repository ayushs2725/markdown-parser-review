import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*;

public class ReviewMDPTest {

    @Test
    public void Snippet1() throws IOException
    {
        ArrayList<String> Snippet_One_Expected = new ArrayList<>();

        Snippet_One_Expected.add("`google.com");
        Snippet_One_Expected.add("google.com");
        Snippet_One_Expected.add("ucsd.edu");

        Path Snippet_One_Path = Path.of("Snippet1.md");
        String Snippet_One = Files.readString(Snippet_One_Path);
        ArrayList<String> Snippet_One_Output = ReviewMDParse.getLinks(Snippet_One);

        assertEquals(Snippet_One_Expected, Snippet_One_Output);
    }

    @Test
    public void Snippet2() throws IOException
    {
        ArrayList<String> Snippet_Two_Expected = new ArrayList<>();

        Snippet_Two_Expected.add("b.com");
        Snippet_Two_Expected.add("a.com(())");
        Snippet_Two_Expected.add("example.com");

        Path Snippet_Two_Path = Path.of("Snippet2.md");
        String Snippet_Two = Files.readString(Snippet_Two_Path);
        ArrayList<String> Snippet_Two_Output = ReviewMDParse.getLinks(Snippet_Two);

        assertEquals(Snippet_Two_Expected, Snippet_Two_Output);
    }

    @Test
    public void Snippet3() throws IOException
    {

        ArrayList<String> Snippet_Three_Expected = new ArrayList<>();

        Snippet_Three_Expected.add("https://www.twitter.com");
        Snippet_Three_Expected.add("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");

        Path Snippet_Three_Path = Path.of("Snippet3.md");
        String Snippet_Three = Files.readString(Snippet_Three_Path);
        ArrayList<String> Snippet_Three_Output = ReviewMDParse.getLinks(Snippet_Three);

        assertEquals(Snippet_Three_Expected, Snippet_Three_Output);
    }

}