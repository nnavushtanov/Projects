import com.telerikacademy.set.MyHashSet;
import com.telerikacademy.set.MyHashSetImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SetTests {

    private MyHashSet<String> set;

    @BeforeEach
    public void init() {
        set = new MyHashSetImpl<>();
        set.add("First element");
    }

    @Test
    public void add_should_add_elementToHashSet() {
        // Arrange Act
        boolean contains = set.contains("First element");
        // Assert
        Assertions.assertSame(true , contains);
    }

    @Test
    public void add_should_not_add_existingElementToHashSet() {
        // Arrange
        set.add("First element");
        set.add("First element");
        // Act
        int size = set.size();
        // Assert
        Assertions.assertEquals(1,size);
    }

    @Test
    public void add_should_throw_when_addingToNullHashSet() {
        // Arrange
        set = null;
        // Act Assert
        Assertions.assertThrows(NullPointerException.class , () -> set.add("element"));
    }

    @Test
    public void remove_should_remove_elementFromHashSet() {
        //Arrange
        // "First element is added in the begining"
        // Act
        set.remove("First element");
        boolean contains = set.contains("First element");
        // Assert
        Assertions.assertSame(false , contains);
    }

    @Test
    public void remove_should_throw_when_elementIsNotFound() {
        // Act Assert
        Assertions.assertThrows(IllegalArgumentException.class , () -> set.remove("Non existing"));
    }

    @Test
    public void size_should_return_sizeOfHashSet() {
        // Arrange
        set.add("Second element");
        // Act
        int size = set.size();
        // Assert
        Assertions.assertEquals(2,size);
    }

    @Test
    public void contains_should_return_true_when_elementIsFound() {
        // Arrange
        // "First element" is added in the begining
        // Act
        boolean contains = set.contains("First element");
        // Arrange
        Assertions.assertSame(true , contains);
    }

    @Test
    public void contains_should_return_false_when_elementIsNotFound() {
        // Act
        boolean contains = set.contains("Non existing");
        // Assert
        Assertions.assertSame(false,contains);
    }

    @Test
    public void capacity_should_return_initialCapacityOfHashSet() {
        // Act
        int initialCapacity = set.capacity();
        // Assert
        Assertions.assertEquals(16 , initialCapacity);
    }

    @Test
    public void resize_should_doubleCapacityOfTheHashSet() {
        // Arrange
        MyHashSetImpl<Integer> nums = new MyHashSetImpl<>();
        // Act
        for (int i = 0; i < 12; i++) {
            nums.add(i);
        }
        int capacity = nums.capacity();
        // Assert
        Assertions.assertEquals(32,capacity);
    }

}
