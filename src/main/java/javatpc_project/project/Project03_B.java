package javatpc_project.project;

import java.io.*;

public class Project03_B {
    public static void main(String[] args) {

        try {
            Workbook wb = new HSSFWorkbook();
            Sheet sheet = wb.createSheet("My Sample Excel");
            InputStream is = new FileInputStream("pic.jpg");
            byte[] bytes=IOUtils.toByteArray(is);
            int pictureIdx=wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
            is.close();

            CreationHelper helper=wb.getCreationHelper();
            Drawing drawing = sheet.createDrawingPatriarch();
            ClientAnchor anchor = helper.createClientAnchor();
            anchor.setCol1(1); // Column B
            anchor.setRow1(2); // Row 3
            anchor.setCol2(2); // Column C
            anchor.setRow2(3); // Row 4

            Picture pict = drawing.createPicture(anchor, pictureIdx);

            Cell cell = sheet.createRow(2).createCell(1);
            // set width to n character widths = count characters * 256
            int w = 20*256;
            sheet.setColumnWidth(1, w);
            // set height to n points in twips = n * 20
            short h = 120*20;
            cell.getRow().setHeight(h);

            FileOutputStream fileOut = new FileOutputStream("myFile.xls");
            wb.write(fileOut);
            fileOut.close();
            System.out.println("이미지 생성 성공");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}