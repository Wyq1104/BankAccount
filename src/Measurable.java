import java.util.List;

public abstract class Measurable implements Comparable<Measurable>{
    @Override
    public int compareTo(Measurable o) {
        if(getMeasure()>o.getMeasure()){
            return 1;
        }else if(getMeasure()<o.getMeasure()){
            return -1;
        }else {
            return 0;
        }
    }

    static <T extends Measurable>  float average(List<T> items){
        if(items.size()==0){
            return 0.0f;
        }
        float sum=0.0f;
        for(T item: items){
            sum+=item.getMeasure();
        }
        return sum/items.size();
    }

    abstract float getMeasure();
}
