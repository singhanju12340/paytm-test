package com.paytm.qapanel.model;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by anjukumari on 25/12/18
 */
public class DBPermission {
    private static HashMap<String, String[]> dbPermissionPriority;
    enum PermissionType{
        read,update,delete
    }
    static {
        LinkedList<String> map = new LinkedList<>();
        String[] typeOfPermission = {"read","update","delete"};
        String read = "select_show_desc";
        String update = "select_show_desc_update";
        String delete = "select_show_desc_update_delete_drop_create_alter";
        for(int i=0;i<PermissionType.values().length;i++){
            dbPermissionPriority.put(typeOfPermission[i],typeOfPermission[i].split("_"));
        }
    }
}
