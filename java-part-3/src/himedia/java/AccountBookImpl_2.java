package himedia.java;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AccountBookImpl_2 implements AccountBook_2 {

    private String desktopPath;
    private String folderPath;
    private Path myFolder;
    private String today;
    private Path todayFile;

    public AccountBookImpl_2() {
        this.desktopPath = System.getProperty("user.home") + File.separator+"Desktop";
        this.folderPath = desktopPath+ File.separator+"Test";
        this.myFolder= Paths.get(folderPath);
    }


    @Override
    public int printMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================================");
        System.out.println("[1]가계부 내역 추가 [2]내역조회 [3]내역삭제 [4] 프로그램 종료");
        System.out.println("========================================================");
        return sc.nextInt();
    }

    @Override
    public void createNewFile() {
        try {
            if ( Files.notExists(myFolder) ) {
                // 폴더 존재 X
                Files.createDirectory(myFolder);
                System.out.println("테스트 폴더가 생성되었습니다.");
            } else {
                System.out.println("폴더가 이미 존재합니다.");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeToFile() {
        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        todayFile = myFolder.resolve(today + ".txt");

        if ( Files.notExists(todayFile) ) {

            try ( FileOutputStream fos = new FileOutputStream(todayFile.toFile()) ) {
                Scanner sc = new Scanner(System.in);
                System.out.println("가계부에 내용을 작성하세요");
                System.out.println("구입한 물건-> ");
                String content = sc.nextLine();
                System.out.println("구입한 물건의 가격-> ");
                int price = Integer.parseInt(sc.nextLine());
                fos.write(("[item name]"+content+"[price]"+price).getBytes());
                System.out.println(today + ".txt 파일을 생성하고 내용을 썼습니다.");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(today + ".txt 파일이 이미 존재합니다.");
        }
    }

    @Override
    public void readFromFile() {
        today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        todayFile = myFolder.resolve(today + ".txt");

        if ( Files.exists(todayFile) ) {
            try (FileInputStream fis = new FileInputStream(todayFile.toFile())) {
                int byteData;
                System.out.println("읽어오기 : " + today + ".txt");

                while ( (byteData = fis.read()) != -1 ) {
                    System.out.print((char) byteData);
                }
                System.out.println(); //줄바꿈
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println(today + ".txt 파일이 존재하지 않습니다.");
        }
    }




    @Override
    public void deleteSomeFiles() {

        // Scanner 객체 생성
        Scanner scanner = new Scanner(System.in);

        // 사용자로부터 파일명 입력 받기
        System.out.print("삭제할 파일의 이름을 입력하세요: ");
        String fileName = scanner.nextLine();

        // 입력받은 파일명으로 파일 객체 생성
     //   File file = new File("C:\\Users\\hi-pc-999\\Desktop\\Test\\"+fileName);

        this.desktopPath = System.getProperty("user.home") + File.separator + "Desktop";
        this.folderPath = desktopPath + File.separator + "Test";
        this.myFolder = Paths.get(folderPath);
        File file = new File(myFolder+"\\"+fileName);

        // 파일이 존재하는지 확인
        if (file.exists()) {
            // 파일 삭제 시도
            if (file.delete()) {
                System.out.println("파일이 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("파일 삭제에 실패하였습니다.");
            }
        } else {
            System.out.println("해당 파일이 존재하지 않습니다.");
        }


    }
}
