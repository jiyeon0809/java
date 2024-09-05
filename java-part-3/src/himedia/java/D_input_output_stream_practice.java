package himedia.java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class D_input_output_stream_practice {
    private String desktopPath;
    private String folderPath;
    private Path myFolder;
    private String today;
    private Path todayFile;

     public D_input_output_stream_practice() {
     this.desktopPath = System.getProperty("user.home")+ File.separator+"Desktop";
     this.folderPath = System.getProperty("user.home")+ File.separator+"테스트";
     this.myFolder= Paths.get(folderPath);
     }


      public void exam1(){
            try{
                if(Files.notExists(myFolder)) {
                    Files.createDirectory(myFolder);
                    System.out.println("테스트 폴더가 생성되었습니다");
                }else{
                    System.out.println("폴더가 이미 존재합니다.");
                }
            }catch(IOException e){
                throw new RuntimeException(e);
            }

      }


      public void exam2(){
             today= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
             todayFile=myFolder.resolve(today+".html");
             if(Files.notExists(todayFile)) {
                 FileOutputStream fos=null;
                 try{
                     fos= new FileOutputStream(todayFile.toFile());
                     String content= "아무거나아무거나";
                     fos.write(content.getBytes());
                 } catch (IOException e) {
                     throw new RuntimeException(e);
                 }finally{
                     if(fos!=null) {
                         try {
                             fos.close();
                         } catch (IOException e) {
                             throw new RuntimeException(e);
                         }
                     }
                 }
             }
      }


      public void exam3(){
          today= LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
          todayFile=myFolder.resolve(today+".html");
          if(Files.notExists(todayFile)) {
              try(FileInputStream fis = new FileInputStream(todayFile.toFile())){
                  int byteData;
                  System.out.println("읽어오기 : "+today+".html");
                  while((byteData=fis.read())!=-1) {
                      System.out.print((char)byteData);
                  }
                  System.out.println();
              } catch (FileNotFoundException e) {
                  throw new RuntimeException(e);
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          }else{
              System.out.println(today+".html 파일이 존재하지 않습니다");
          }
      }


    public static void main(String[] args) {
        D_input_output_stream_practice d=new D_input_output_stream_practice();
        d.exam1();
    }



}
