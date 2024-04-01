import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends PApplet {
    public static Main app;
    private ArrayList<SocialMedia> data;
    private int bottom;
    private int top;
    private int valueOfTarget;
    private SocialMedia target;
    private int x;
    private int y;
    private int middleIndex;
    private boolean draw;
    private boolean startScreen;
    private int result;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public Main() {
        startScreen = true;
        app = this;
        draw = true;
        bottom = 0;
        top = 9;
        middleIndex = (top + bottom)/2;
        data = new ArrayList<SocialMedia>();
    }

    public void settings() {
        size(800,600);
    }

    public void setup() {
        Table table = loadTable("EffectsofSocialMedia.csv", "header");
        for (TableRow row : table.rows()) {
            String platform = row.getString("Social Platform"); // obtain platform
            int socialMediaTime = row.getInt("Social Media Time"); // obtain time on social media
            data.add(new SocialMedia(socialMediaTime, platform));
        }
    }

    public void draw() {
        if(draw) {
            if(startScreen) {
                background(255, 184, 213);
                Main.app.fill(0);
                textSize(50);
                Main.app.text("Search and Sort Visualizer", 130, 100);
                textSize(25);
                Main.app.text("Press the enter button to start or view instructions again", 120, 200);
                Main.app.text("Press the s button to start the sort", 220, 250);
                Main.app.text("Press the space button to start the search", 190, 300);
                Main.app.text("Type in a number between 0 to 10 on the keyboard to set your target.", 50, 350);
                Main.app.text("Description:\nThis searches and sorts a data collection containing time people spend on\n social media and which platform they spend the most time on.", 10, 450);
            }
            else{
                background(255);
                Main.app.fill(0);
                textSize(50);
                Main.app.text("Search and Sort Visualizer", 130, 100);
                for (int i = 0; i < data.size(); i++) {
                    if (i == 0) {
                        x = 50;
                        y = 150;
                    }
                    if (i == bottom || i == top) {
                        Main.app.fill(255);
                    } else if (i == middleIndex) {
                        Main.app.fill(163, 255, 188);
                    } else {
                        Main.app.fill(255, 184, 213);
                    }
                    Main.app.rect(x, y, 100, 100);
                    Main.app.fill(0);
                    textSize(30);
                    Main.app.text(data.get(i).getSocialMediaTime(), x + 40, y + 60);
                    textSize(20);
                    Main.app.text(data.get(i).getPlatform(), x+10, y + 120);
                    if (result == middleIndex) {
                        Main.app.fill(0);
                        textSize(50);
                        Main.app.text("Search found at index " + middleIndex + "!", 150, 554);
                        textSize(20);
                        Main.app.text("Input a new target to try again", 260, 590);
                    }
                    if (result == -1 && top != bottom) {
                        Main.app.fill(0);
                        textSize(50);
                        Main.app.text("Search not found yet", 190, 550);
                        textSize(20);
                    }
                    if (result == -1 && top == bottom) {
                        Main.app.fill(0);
                        textSize(50);
                        Main.app.text("Search not found!", 200, 550);
                        textSize(20);
                        Main.app.text("Input a new target to try again", 250, 590);
                    }
                    if (i == (data.size()/2)-1) {
                        y += 200;
                        x = 50;
                    } else {
                        x += 150;
                    }
                }
                draw = false;
            }
        }
    }

    public void reset() {
        bottom = 0;
        top = 9;
        middleIndex = (top + bottom)/2;
        draw = true;
    }

    public void keyPressed() {
        if(key == '0') {
            valueOfTarget = 0;
            reset();
        }
        if(key == '1') {
            valueOfTarget = 1;
            reset();
        }
        if(key == '2') {
            valueOfTarget = 2;
            reset();
        }
        if(key == '3') {
            valueOfTarget = 3;
            reset();
        }
        if(key == '4') {
            valueOfTarget = 4;
            reset();
        }
        if(key == '5') {
            valueOfTarget = 5;
            reset();
        }
        if(key == '6') {
            valueOfTarget = 6;
            reset();
        }
        if(key == '7') {
            valueOfTarget = 7;
            reset();
        }
        if(key == '8') {
            valueOfTarget = 8;
            reset();
        }
        if(key == '9') {
            valueOfTarget = 9;
            reset();
        }
        if(key == ' ') {
            draw = true;
            //result = binarySearchRecursive();
            result = binarySearchIterative();
        }
        if(key == 's') {
            selectionSort(data);
            draw = true;
        }
        if(key == ENTER) {
            if(startScreen) {
                draw = true;
                startScreen = false;
            }
            else {
                draw = true;
                startScreen = true;
            }
        }
    }

    private int findMin(ArrayList<SocialMedia> arr, int startingIndex) {
        int minI = startingIndex;
        for (int i = minI + 1; i < arr.size(); i++) {
            if (arr.get(i).compareTo(arr.get(minI)) < 0) {
                minI = i;
            }
        }
        return minI;
    }

    private void swap(ArrayList<SocialMedia> arr, int x, int y) {
        SocialMedia temp = arr.get(x);
        arr.set(x,arr.get(y));
        arr.set(y,temp);
    }

    private void selectionSort(ArrayList<SocialMedia> array) {
        for(int currentI = 0; currentI < array.size()-1; currentI++) {
            int min = findMin(array,currentI);
            swap(array, currentI, min);
        }
    }

    private int binarySearchIterative() {
        target = new SocialMedia(valueOfTarget);
        if(top>bottom) {
            if(target.compareTo(data.get(middleIndex)) == 0) {
                result = middleIndex;
                return middleIndex;
            }
            if (target.compareTo(data.get(middleIndex)) > 0) {
                bottom = middleIndex;
                middleIndex = (top+bottom)/2;
                result = 0;
            }
            if(target.compareTo(data.get(middleIndex)) < 0) {
                top = middleIndex;
                middleIndex = (top+bottom)/2;
                result = 0;
            }
        }
        return -1;
    }

    private int binarySearchRecursive() {
        target = new SocialMedia(valueOfTarget);
        if(bottom > top) {
            return -1;
        }
        middleIndex = (top + bottom)/2;
        if(target.compareTo(data.get(middleIndex)) == 0) {
            result = middleIndex;
            return middleIndex;
        }
        if (target.compareTo(data.get(middleIndex)) < 0) {
            top = middleIndex-1;
            result = -1;
            return binarySearchRecursive();
        }
        if(target.compareTo(data.get(middleIndex)) > 0) {
            bottom = middleIndex+1;
            result = -1;
            return binarySearchRecursive();
        }
        return -1;
    }
}