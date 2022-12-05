/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageRegisteredPatients;

import java.util.*;

/**
 *
 * @author Admin
 */
public class RegisteredPatientsManagement {

    List<String> list = new ArrayList<>();
    boolean check = true;

    public RegisteredPatientsManagement() {
    }

    public boolean addRegisters(String Id) {
        if (!list.contains(Id)) {
            list.add(Id);
        } else {
            return false;
        }
        return true;
    }

    public String getElement(int i) {
        return list.get(i);
    }

    public List<String> getList() {
        return list;
    }
    public void getString(){
        for(String id: list){
            System.out.println(id+"----");
        }
    }
}
