import org.junit.Test;

public class MainTest {

    Main test = new Main();

    @Test
    public void findAlphaTest() throws Exception {

        //Given
        //When
        String look = test.findAlphaCharacters();


        //Then
        System.out.println(look);

    }

    @Test
    public void getListTest() throws Exception {
        String look = test.getList();

        System.out.println(look);

    }


}
