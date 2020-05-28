package model;

import java.util.List;

public class ReferenceList {

    private List<Reference> list;

    public ReferenceList() {
        this.list = list;
    }

    public List<Reference> getList() {
        return list;
    }

    public void setList(List<Reference> list) {
        this.list = list;
    }

    public void add(Reference p){
        this.list.add(p);
    }

}
