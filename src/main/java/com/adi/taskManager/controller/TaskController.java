package com.adi.taskManager.controller;

import com.adi.taskManager.data.ApiResponse;
import com.adi.taskManager.data.enums.TaskStatus;
import com.adi.taskManager.model.Tasks;
import com.adi.taskManager.service.DailyTaskService;
import com.adi.taskManager.service.TaskHistoryService;
import com.adi.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.simple.JSONObject;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/task")
@CrossOrigin(origins = "http://localhost:3000") // Allow frontend origin
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private DailyTaskService dailyTaskService;

    @Autowired
    private TaskHistoryService taskHistoryService;


    @GetMapping("/get-all-tasks-by-status")
    public ResponseEntity<ApiResponse> getAllTaskByStatus(HttpServletRequest request){
        ApiResponse response = new ApiResponse("Something went wrong!!");
        String status = request.getParameter("status");
        System.out.println(status);
        System.out.println(status.toUpperCase());
        try {
            TaskStatus taskStatus = TaskStatus.valueOf(status.toUpperCase()); // Normalize input

            List<Tasks> taskList = taskService.getAllTaskByStatus(taskStatus);
            JSONObject responseObject = new JSONObject();
            responseObject.put("taskList",taskList);
            return new ResponseEntity<>(new ApiResponse(responseObject,true, "Something went wrong!!"), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ApiResponse(false, "Something went wrong!!"), HttpStatus.OK);
        }
    }
    @GetMapping("/get-task-count-by-status")
    public ResponseEntity<ApiResponse> getTaskCount(HttpServletRequest request){
        ApiResponse response = new ApiResponse("Something went wrong!!");
        String status = request.getParameter("status");
        System.out.println(status);
        System.out.println(status.toUpperCase());
        try {
            TaskStatus taskStatus = TaskStatus.valueOf(status.toUpperCase()); // Normalize input

            int taskCount = taskService.getTaskCount(taskStatus);
            int allCount = taskService.getAllTaskCount();
            JSONObject responseObject = new JSONObject();
            responseObject.put("count",taskCount);
            responseObject.put("allTaskCount",allCount);
            return new ResponseEntity<>(new ApiResponse(responseObject,true, "Something went wrong!!"), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ApiResponse(false, "Something went wrong!!"), HttpStatus.OK);
        }
    }
    public static void main(String args[]){
        System.out.println(TaskStatus.COMPLETED.toString());
    }
}
