package com.github.moodtodie.sdlc.todolist.list;

import java.util.ArrayList;
import java.util.HashMap;

public class ToDoList {
    private static final HashMap<Long, Task> list = new HashMap<>();
    private static long taskId = 0;

    public static void add(String task){
        list.put(taskId++, new Task(0, task, false));
    }

    public static void getTaskById(long id){

    }

    public static String get(long taskId){
        return list.get(taskId).task();
    }

    public static String[] getList (){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < taskId; i++) {
            list.add(get(i));
        }
        return list.toArray(new String[Math.toIntExact(taskId)]);
    }
}
