import com.telerikacademy.MyArrayList;
import com.telerikacademy.MyList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyArrayListTests {

    private MyList<Integer> list;

    @BeforeEach
    public void init() {
        //Arrange
        list = new MyArrayList<>();
    }

    @Test
    public void getLast_should_returnLastElement_when_gettingLastElement() {
        //Arrange
        list.add(1);
        list.add(2);

        // Act
        Integer result = list.getLast();

        // Assert
        Assertions.assertEquals(2, result);
    }

    @Test
    public void getLast_should_throw_when_listIsEmpty() {
        // Act Assert
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getLast());
    }

    @Test
    public void getFirst_should_returnFirstElement_when_gettingFirstElement() {
        // Arrange
        list.add(1);

        // Act
        Integer result = list.getFirst();

        // Assert
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getFirst_should_throw_when_listIsEmpty() {
        // Arrange
        // Act Assert
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.getFirst());
    }

    @Test
    public void getSize_should_return_initialSize() {
        // Arrange
        MyArrayList<Integer> myList = new MyArrayList<>();

        // Act
        int size = myList.getSize();

        // Assert
        Assertions.assertEquals(4,size);
    }

    @Test
    public void get_should_returnRightElement_when_IndexIsValid() {
        // Arrange
        list.add(1);

        // Act
        Integer result = list.get(0);

        // Assert
        Assertions.assertEquals(1, result);
    }

    @Test
    public void get_should_throw_when_indexIsBelowZero() {
        // Arrange
        // Act Assert
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> list.get(-1));
    }

    @Test
    public void get_should_throw_when_indexIsAboveTheUpperBound() {
        // Arrange
        // Act Assert
        Assertions.assertThrows(IndexOutOfBoundsException.class,
                () -> list.get(0));
    }

    @Test
    public void findIndexOf_should_returnElement_when_listContainsElement() {
        //Arrange
        list.add(1);

        //Act
        Integer result = list.findIndexOf(1);

        //Assert
        Assertions.assertEquals(0, result);
    }

    @Test
    public void findIndexOf_should_returnErrorCode_when_elementIsNotFound() {
        //Arrange
        list.add(1);

        //Act
        Integer result = list.findIndexOf(2);

        //Assert
        Assertions.assertEquals(-1, result);
    }

    @Test
    public void getUsedPositions_should_return_listSize_when_listIsNotEmpty() {
        // Arrange
        list.add(1);
        list.add(2);

        // Act
        Integer result = list.getUsedPositions();

        //Assert
        Assertions.assertEquals(list.getUsedPositions(), result);
    }

    @Test
    public void set_should_throw_when_indexIsInvalid() {
        // Arrange
        list.add(1);

        // Act Assert
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.set(1, 1));
    }

    @Test
    public void set_should_setElement_when_indexIsValid() {
        // Arrange
        list.add(1);

        // Act
        list.set(0, 2);
        Integer result = list.get(0);

        // Assert
        Assertions.assertEquals(2, result);
    }


}
