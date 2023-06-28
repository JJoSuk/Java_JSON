package javatpc_project.project;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javatpc_project.kr.inflearn.BookDTO;

import java.util.ArrayList;
import java.util.List;

public class Project01_A {
    public static void main(String[] args) {
        // Object(BookDTO) -> JSON(String)
        BookDTO dto = new BookDTO("자바", 21000, "한빛", 550);
        Gson g = new Gson();
        String json = g.toJson(dto);
        System.out.println(json); // {"title":"자바","price":21000,"company":"한빛","page":550}

        System.out.println();

        BookDTO bookDTO = g.fromJson(json, BookDTO.class);
        System.out.println(bookDTO);
        System.out.println(bookDTO.getTitle() + "\t" + bookDTO.getPrice());

        System.out.println();

        // Object(List<BookDTO>) -> JSON(String) : [{ }, { }...]
        List<BookDTO> list = new ArrayList<BookDTO>();
        list.add(new BookDTO("자바1", 21000, "한빛", 550));
        list.add(new BookDTO("자바2", 11000, "정빛", 320));
        list.add(new BookDTO("자바3", 27000, "품빛", 700));

        String listJson = g.toJson(list);
        System.out.println(listJson);

        System.out.println();

        // Json(String) -> Object(List<BookDTO>)
        List<BookDTO> lst = g.fromJson(listJson, new TypeToken<List<BookDTO>>(){}.getType());
        for (BookDTO vo : lst) {
            System.out.println(vo);
        }
    }
}
