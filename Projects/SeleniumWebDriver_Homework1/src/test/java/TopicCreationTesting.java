import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TopicCreationTesting {

    // Buttons and fields
    public final String FORUM_URL = "https://stage-forum.telerikacademy.com";
    public final String NEW_TOPIC_BUTTON = "//button[@id='create-topic']";
    public final String NEW_TITLE_BUTTON = "//input[@id='reply-title']";
    public final String TOPIC_CONTENT_FIELD = "//div[@class='d-editor-container']/div[1]/textarea";
    public final String CREATION_BUTTON = "//div[@class='save-or-cancel']/button";
    public final String LOGIN_BUTTON = "//span[@class='header-buttons']/button";
    public final String USERNAME_FIELD = "//input[@id='Email']";

    // Credentials
    public final String username = "petkoivanov34@mail.bg";
    public final String password = "telerikacademy";

    // Page elements for verifying
    public final String WARNING_MESSAGE_TITLE = "//*[@id=\"reply-control\"]/div[3]/div[1]/div[2]/div[2]";
    public final String WARNING_MESSAGE_CONTENT = "//div[@class='d-editor-container']/div[1]/div[3]";
    public final String TITLE_NAME = "//div[@id='topic-title']";

    // Title and content examples
    public final String EXAMPLE_TITLE = "Title of topic";
    public final String EXAMPLE_CONTENT = "Content of topic";

    private WebDriver driver;

    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void driverInitialization() {
        driver = new ChromeDriver();
        driver.get(FORUM_URL);
    }

    @After
    public void close() {
        waiting(5000L);
        driver.quit();
    }

    @Test
    public void createTopicFromRegisteredUser() {
        login();
        newTopicClick();
        fillTitle(EXAMPLE_TITLE);
        fillContent(EXAMPLE_CONTENT);
        createNewTopic();
        waiting(2000L);
        // Asserts that there is a title of the new topic
        Assert.assertEquals(findElement(TITLE_NAME) , findElement(TITLE_NAME));
    }

    @Test
    public void createTopicWithoutTitleFromRegisteredUser() {
        login();
        newTopicClick();
        fillContent(EXAMPLE_CONTENT);
        createNewTopic();
        waiting(1000L);
        // Asserts if there is warning message, if the test fails a new topic without title will be created
        Assert.assertEquals(findElement(WARNING_MESSAGE_TITLE),
                findElement(WARNING_MESSAGE_TITLE));
    }

    @Test
    public void createTopicWithoutContentFromRegisteredUser() {
        login();
        newTopicClick();
        fillTitle(EXAMPLE_TITLE);
        createNewTopic();
        waiting(1000L);
        // Asserts if there is warning message, if the test fails a new topic without content will be created
        Assert.assertEquals(findElement(WARNING_MESSAGE_CONTENT)
                , findElement(WARNING_MESSAGE_CONTENT));
    }

    @Test
    public void createTopicWithShorterTitle() {
        login();
        newTopicClick();
        fillTitle("Top");
        fillContent(EXAMPLE_CONTENT);
        createNewTopic();
        waiting(1000L);
        // Asserts if there is warning message, if the test fails a new topic with shorter title will be created
        Assert.assertEquals(findElement(WARNING_MESSAGE_TITLE),
                findElement(WARNING_MESSAGE_TITLE));
    }

    @Test
    public void createTopicWithShorterContent() {
        login();
        newTopicClick();
        fillTitle(EXAMPLE_TITLE);
        fillContent("Cont");
        createNewTopic();
        waiting(1000L);
        // Asserts if there is warning message, if the test fails a new topic with shorter content will be created
        Assert.assertEquals(findElement(WARNING_MESSAGE_CONTENT)
                , findElement(WARNING_MESSAGE_CONTENT));
    }

    @Test
    public void createTopicFromUnregisteredUser() {
        // Asserts that there is a "New Topic" button, if the test pass, the unregistered user will create new topic
        Assert.assertEquals(findElement(NEW_TOPIC_BUTTON) , findElement(NEW_TOPIC_BUTTON));
        newTopicClick();
        fillTitle(EXAMPLE_TITLE);
        fillContent(EXAMPLE_CONTENT);
        createNewTopic();
    }

    public void login() {
        WebElement loginButton = findElement(LOGIN_BUTTON);
        loginButton.click();
        WebElement loginForm = findElement(USERNAME_FIELD);
        loginForm.sendKeys(username + Keys.TAB + password + Keys.ENTER);
    }

    public void newTopicClick() {
        WebElement newTopicButton = findElement(NEW_TOPIC_BUTTON);
        newTopicButton.click();
    }

    public void fillTitle(String title) {
        WebElement topicTitle = findElement(NEW_TITLE_BUTTON);
        topicTitle.sendKeys(title);
    }

    public void fillContent(String content) {
        WebElement topicContent = findElement(TOPIC_CONTENT_FIELD);
        topicContent.sendKeys(content);
    }

    public void createNewTopic() {
        WebElement creationButton = findElement(CREATION_BUTTON);
        creationButton.click();
    }

    public WebElement findElement(String element) {
        return driver.findElement(By.xpath(element));
    }

    public void waiting(long waitingPeriod) {
        try {
            Thread.sleep(waitingPeriod);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
