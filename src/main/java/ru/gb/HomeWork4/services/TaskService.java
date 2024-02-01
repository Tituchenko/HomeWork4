package ru.gb.HomeWork4.services;

import org.springframework.stereotype.Service;
import ru.gb.HomeWork4.models.Task;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class TaskService {
    private List<Task> taskList=new ArrayList<>();
    private int curId=0;

    public void addTask(Task task){
        task.setId(curId++);
        taskList.add(task);
    }

    public List<Task> findAll (){
        return taskList;
    }

    public void delById(int id){
        Iterator<Task> iterator=taskList.iterator();
        while (iterator.hasNext()){
            if (iterator.next().getId()==id) iterator.remove();
        }
    }

    public Task getById(int id){
        Task task=null;
        for (Task t:taskList
             ) {
            if (t.getId()==id) return t;
        }

        return null;
    }
    public void updateById(Task task){
        for (Task t:taskList) {
            if (t.getId()==task.getId()) {
                delById(task.getId());
                addTask(task);
            }
        }
    }



}
