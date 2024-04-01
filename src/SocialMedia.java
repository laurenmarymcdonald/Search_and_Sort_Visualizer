import static java.lang.String.valueOf;

public class SocialMedia implements Comparable{
    private int iD;
    private int age;
    private String platform;
    private int socialMediaTime;
    private int physicalActivitesTime;
    private boolean isSearched;

    public SocialMedia(int socialMediaTime) {
        this.socialMediaTime = socialMediaTime;
    }
    public SocialMedia(int socialMediaTime, String platform) {
        this.socialMediaTime = socialMediaTime;
        this.platform = platform;
    }
    public SocialMedia(int iD, int age, String platform,int socialMediaTime, int physicalActivitesTime) {
        this.iD = iD;
        this.age = age;
        this.platform = platform;
        this.socialMediaTime = socialMediaTime;
        this.physicalActivitesTime = physicalActivitesTime;
    }
    public String getPlatform() {
        return platform;
    }
    public int getSocialMediaTime() {
        return socialMediaTime;
    }
    public void setIsSearched(boolean searched) {
        isSearched = searched;
    }
    public boolean searched() {
        if(isSearched) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public String toString() {
        return "social media time: " + socialMediaTime;
    }
    @Override
    public int compareTo(Object anotherObject){
        SocialMedia obj2 = (SocialMedia) anotherObject;
        if (this.socialMediaTime < obj2.socialMediaTime){
            return -1;
        } else if (this.socialMediaTime > obj2.socialMediaTime){
            return 1;
        } else {
            return 0;
        }
    }
}
