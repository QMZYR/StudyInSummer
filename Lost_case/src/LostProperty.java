import java.util.Comparator;

/**
 *失物对象
 */
public class LostProperty implements Comparator<LostProperty> {
    private String lostTime;//yyyymmddhhmm(格式，最后两位代表分钟)
    private String propertyName;

    //1.构造方法
    public LostProperty(String lostTime,String propertyName) {
        this.setLostTime(lostTime);
        this.setPropertyName(propertyName);
    }

    //2.getter for all the attribute

    public String getLostTime() {
        return lostTime;
    }

    public String getPropertyName() {
        return propertyName;
    }


    //3.setter for all the attribute

    public void setLostTime(String lostTime) {
        this.lostTime = lostTime;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }


    //4.比较
    @Override
    public int compare(LostProperty o1, LostProperty o2) {

        int compare=o1.getLostTime().compareTo(o2.getLostTime());
        return compare;
    }

    //5.输出

    @Override
    public String toString() {
        return "LostProperty{" +
                "lostTime='" + lostTime + '\'' +
                ", propertyName='" + propertyName + '\'' +
                '}';
    }
}

/**
 * 失物子类：一卡通类
 */
class LostCard extends LostProperty {
    private String nameOfCard;//一卡通上的名字
    private int number;//一卡通上的学号


    //1.构造方法
    public LostCard(String lostTime, String propertyName,String name,int number) {
        super(lostTime, propertyName);
        this.setNameOfCard(name);
        this.setNumber(number);
    }


    //2.setter
    public void setNameOfCard(String nameOfCard) {
        this.nameOfCard = nameOfCard;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    //3.getter
    public int getNumber() {
        return number;
    }

    public String getNameOfCard() {
        return nameOfCard;
    }

    //4.格式输出

    @Override
    public String toString() {
        return "LostCard{" +
                "nameOfCard='" + nameOfCard + '\'' +
                ", number=" + number +
                '}';
    }
}



class LostBook extends LostProperty{
    private String bookName;//丢失的书的名字


    //1.构造方法
    public LostBook(String lostTime, String propertyName,String name) {
        super(lostTime, propertyName);
        this.setBookName(name);
    }


    //2.getter and setter
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookName() {
        return bookName;
    }

    //3.输出

    @Override
    public String toString() {
        return "LostBook{" +
                "bookName='" + bookName + '\'' +
                '}';
    }
}
