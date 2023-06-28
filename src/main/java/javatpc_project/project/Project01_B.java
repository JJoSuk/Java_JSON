package javatpc_project.project;

import org.json.JSONArray;
import org.json.JSONObject;

public class Project01_B {
    public static void main(String[] args) {
        // JSON-Java(org.json)
        JSONArray students = new JSONArray();

        JSONObject student = new JSONObject();
        student.put("name", "홍길동");
        student.put("phone", "010-1111-1111");
        student.put("address", "서울");
        System.out.println(student); // students = {"address":"서울","phone":"010-1111-1111","name":"홍길동"}
        students.put(student);

        student = new JSONObject();
        student.put("name", "강남콩");
        student.put("phone", "010-1122-2211");
        student.put("address", "부산");

        students.put(student);

        JSONObject object = new JSONObject();
        object.put("students", students);
        System.out.println(object.toString(2));
    }
}
