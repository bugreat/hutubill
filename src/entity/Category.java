package entity;

public class Category {
    public int id;
    public String name;
    public int recordNumber;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }



    public int getRecordNumber(){
        return recordNumber;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setRecordNumber(int recordNumber){
        this.recordNumber = recordNumber;
    }

    public String toString(){
        return name;
    }
    //这里提供了一个toString方法，在后续JComboBox中显示的时候，会调用此方法，用于显示分类名称
}
