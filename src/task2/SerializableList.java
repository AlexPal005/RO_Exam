package task2;

import Train.Train;

import java.io.Serializable;
import java.util.List;

public class SerializableList  implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Train> list;
    public SerializableList(List<Train> list){
        this.list = list;
    }

    public List<Train> getList() {
        return list;
    }
}
