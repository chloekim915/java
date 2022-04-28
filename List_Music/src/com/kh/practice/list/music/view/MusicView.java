package com.kh.practice.list.music.view;

import java.util.List;
import java.util.Scanner;

import com.kh.practice.list.music.controller.MusicController;
import com.kh.practice.list.music.model.vo.Music;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	public void mainMenu() { //사용자가 직접 메인 메뉴를 선택할 수 있음. 종료 전까지 반복 실행. 각 메뉴를 누를 시 해당 메소드로 이동
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 마지막 위치에 곡 추가");
			System.out.println("2. 첫 위치에 곡 추가");
			System.out.println("3. 전체 곡 목록 출력");
			System.out.println("4. 특정 곡 검색");
			System.out.println("5. 특정 곡 삭제");
			System.out.println("6. 특정 곡 정보 수정");
			System.out.println("7. 곡명 오름차순 정렬");
			System.out.println("8. 가수명 내림차순 정렬");
			System.out.println("9. 종료");
			System.out.print("메뉴 선택 : ");
			int menuNum = Integer.parseInt(sc.nextLine());
			
			switch(menuNum) {
			case 1: addList(); break;
			case 2: addAtZero(); break;
			case 3: printAll(); break;
			case 4: searchMusic(); break;
			case 5: removeMusic(); break;
			case 6: setMusic(); break;
			case 7: ascTitle(); break;
			case 8: descSinger(); break;
			case 9: System.out.println("종료");
				return;
			default : System.out.println("잘못 입력하셨습니다.");
				continue;
			}
		}	
	}
	
	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		Music music = new Music(title, singer);
		int result = mc.addList(music);
		
		if(result ==1 ) {
			System.out.println("추가 성공");
		} else {
			System.out.println("추가 실패");
		}
	}
	
	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		System.out.print("곡 명 : ");
		String title = sc.nextLine();
		System.out.print("가수 명 : ");
		String singer = sc.nextLine();
		
		Music music = new Music(title, singer);
		int result = mc.addAtZero(music);
		
		if(result == 1) {
			System.out.println("추가 성공");
		}else {
			System.out.println("추가 실패");
		}
	}
	
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		for(int i = 0; i < mc.printAll().size(); i++) {
			System.out.println(mc.printAll().get(i).toString());
		}
	}
	
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명 : ");
		String title = sc.nextLine();
		
		List<Music> musicList = mc.searchMusic(title);
		if(musicList == null || musicList.size() == 0) {
			System.out.println("검색한 곡이 없습니다.");
		} else {
			for(Music music : musicList) {
				System.out.println("검색한 곡은 " + music.getSinger() + " - " + music.getTitle() + "입니다.");
			}
		}
	}
	
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 : ");
		String title = sc.nextLine();
		
		Music music = mc.removeMusic(title); //질문 왜 객체로 안써주는지?
		if(music == null) {
			System.out.println("삭제할 곡이 없습니다.");
		} else {
			System.out.println(music.getSinger() + " - " + music.getTitle() + " 을 삭제했습니다.");
		}
	}
	
	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ******");
		System.out.print("수정될 곡 명 : ");
		String title = sc.nextLine();
		System.out.print("수정할 곡 명 : ");
		String setTitle = sc.nextLine();
		System.out.print("수정할 가수 명 : ");
		String setSinger = sc.nextLine();
		Music music = mc.setMusic(title, new Music(setTitle, setSinger)); //질문
		
		if(music == null) {
			System.out.println("수정할 곡이 없습니다.");
		}else {
			System.out.println(setSinger + " - " + setTitle + " 로 값이 변경되었습니다.");
		}
	}
	
	public void ascTitle() {
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		if(mc.ascTitle() == 1) {
			System.out.println("정렬 성공");
		}else {
			System.out.println("정렬 실패");
		}
	}
	
	public void descSinger() {
		System.out.println("****** 가수 명 내림차순 정렬 ******");
		if(mc.descSinger() == 1) {
			System.out.println("정렬 성공");
		}else {
			System.out.println("정렬 실패");
		}
	}
	

}
