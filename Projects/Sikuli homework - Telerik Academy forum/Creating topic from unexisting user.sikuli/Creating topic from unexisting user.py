type("s" , Key.WIN)
type("run")
wait(1)
type(Key.ENTER)
rightClick(Pattern("1600113960598.png").targetOffset(76,-2))
click("delete-1.png")
type("chrome -incognito" + Key.ENTER)
wait(2)
click("1600099398860.png")
type("https://stage-forum.telerikacademy.com/" + Key.ENTER)
wait(2)
click("1600099803248.png")
click("1600100185418.png")
type("Testing new topic")
click("1600100049796.png")
type("Testing topic creation" + Key.ENTER + "Second line of topic" + Key.ENTER + "Third line of topic")
click("1600099918810.png")
wait(2)